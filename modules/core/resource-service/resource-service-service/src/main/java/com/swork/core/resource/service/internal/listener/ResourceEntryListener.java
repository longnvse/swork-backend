package com.swork.core.resource.service.internal.listener;

import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.swork.core.phase.service.model.PhaseEntry;
import com.swork.core.phase.service.service.PhaseEntryLocalService;
import com.swork.core.resource.service.model.ResourceEntry;
import com.swork.core.resource.service.service.TeamEntryLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        service = ModelListener.class
)
public class ResourceEntryListener extends BaseModelListener<ResourceEntry> {

    @Override
    public void onAfterCreate(ResourceEntry model) throws ModelListenerException {
        addIncomingOrSpending(model, model.getTotalAmount());
        reindexPhase(model);
    }

    @Override
    public void onAfterRemove(ResourceEntry model) throws ModelListenerException {
        addIncomingOrSpending(model, -model.getTotalAmount());
        reindexPhase(model);
    }

    @Override
    public void onAfterUpdate(ResourceEntry originalModel, ResourceEntry model) throws ModelListenerException {
        addIncomingOrSpending(originalModel, -originalModel.getTotalAmount());
        addIncomingOrSpending(model, model.getTotalAmount());
        reindexPhase(model);
    }

    private void addIncomingOrSpending(ResourceEntry model, Long money) {
        if (model.getResourceTypeName().equals("Thu")) {
            teamEntryLocalService.addTotalIncoming(model.getTeamId(), GetterUtil.getLong(money));
            return;
        }

        teamEntryLocalService.addTotalSpending(model.getTeamId(), GetterUtil.getLong(money));
    }

    private void reindexPhase(ResourceEntry model) {
        if (Validator.isNotNull(model.getPhaseId())) {
            PhaseEntry phaseEntry =
                    phaseEntryLocalService.fetchPhaseEntry(model.getPhaseId());

            Indexer<PhaseEntry> indexer = IndexerRegistryUtil.getIndexer(PhaseEntry.class.getName());

            if (Validator.isNotNull(phaseEntry)) {
                try {
                    indexer.reindex(phaseEntry);
                } catch (SearchException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Reference
    private TeamEntryLocalService teamEntryLocalService;
    @Reference
    private PhaseEntryLocalService phaseEntryLocalService;
}
