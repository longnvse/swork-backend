package com.swork.account.service.internal.listener;

import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.swork.account.service.service.AccountEntryLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        service = ModelListener.class
)
public class UserListener extends BaseModelListener<User> {
    @Override
    public void onAfterCreate(User model) throws ModelListenerException {
        ServiceContext serviceContext = new ServiceContext();
        serviceContext.setCompanyId(model.getCompanyId());

        accountEntryLocalService.addAccountSuperAdmin(
                model.getScreenName(),
                model.getEmailAddress(),
                model.getPasswordUnencrypted(),
                serviceContext
        );
    }

    @Reference
    private AccountEntryLocalService accountEntryLocalService;
}
