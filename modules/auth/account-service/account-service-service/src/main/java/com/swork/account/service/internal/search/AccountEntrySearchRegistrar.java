package com.swork.account.service.internal.search;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.registrar.ModelSearchRegistrarHelper;
import com.swork.account.service.constant.SearchFields;
import com.swork.account.service.model.AccountEntry;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        service = AccountEntrySearchRegistrar.class
)
public class AccountEntrySearchRegistrar {

    @Activate
    protected void activate(BundleContext bundleContext) {
        _serviceRegistration = modelSearchRegistrarHelper.register(
                AccountEntry.class, bundleContext,
                modelSearchDefinition -> {
                    modelSearchDefinition.setDefaultSelectedFieldNames(
                            Field.COMPANY_ID, Field.ENTRY_CLASS_NAME,
                            Field.ENTRY_CLASS_PK, Field.UID);

                    modelSearchDefinition.setModelIndexWriteContributor(
                            modelIndexWriterContributor);
                    modelSearchDefinition.setSearchResultPermissionFilterSuppressed(
                            true);
                });
    }

    @Deactivate
    protected void deactivate() {
        _serviceRegistration.unregister();
    }

    @Reference(
            target = StringPool.OPEN_PARENTHESIS
                    + SearchFields.ACCOUNT_INDEXER_CLASS
                    + StringPool.CLOSE_PARENTHESIS
    )
    protected ModelIndexerWriterContributor<AccountEntry>
            modelIndexWriterContributor;

    @Reference
    protected ModelSearchRegistrarHelper modelSearchRegistrarHelper;

    private ServiceRegistration<?> _serviceRegistration;

}
