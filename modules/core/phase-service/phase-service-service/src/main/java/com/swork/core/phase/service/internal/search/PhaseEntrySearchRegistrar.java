package com.swork.core.phase.service.internal.search;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.registrar.ModelSearchRegistrarHelper;
import com.swork.core.phase.service.constant.ClassIndex;
import com.swork.core.phase.service.model.PhaseEntry;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        service = {PhaseEntrySearchRegistrar.class}
)
public class PhaseEntrySearchRegistrar {

    @Activate
    protected void activate(BundleContext bundleContext) {
        _serviceRegistration = modelSearchRegistrarHelper.register(
                PhaseEntry.class, bundleContext,
                modelSearchDefinition -> {
                    modelSearchDefinition.setDefaultSelectedFieldNames(
                            Field.COMPANY_ID, Field.ENTRY_CLASS_NAME,
                            Field.ENTRY_CLASS_PK, Field.UID);

                    modelSearchDefinition.setModelIndexWriteContributor(
                            modelIndexWriterContributor);
                    modelSearchDefinition.setSearchResultPermissionFilterSuppressed(true);
                });
    }

    @Deactivate
    protected void deactivate() {
        _serviceRegistration.unregister();
    }

    @Reference(
            target = StringPool.OPEN_PARENTHESIS
                    + ClassIndex.PHASE_INDEXER_CLASS
                    + StringPool.CLOSE_PARENTHESIS
    )
    protected ModelIndexerWriterContributor<PhaseEntry>
            modelIndexWriterContributor;

    @Reference
    protected ModelSearchRegistrarHelper modelSearchRegistrarHelper;

    private ServiceRegistration<?> _serviceRegistration;

}
