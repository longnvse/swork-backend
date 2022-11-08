package com.swork.account.service.internal.listener;

import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
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
        serviceContext.setUserId(model.getUserId());


        accountEntryLocalService.addAccountEntry(
                GetterUtil.DEFAULT_LONG,
                GetterUtil.DEFAULT_LONG,
                model.getScreenName(),
                model.getPasswordUnencrypted(),
                "Super Admin",
                null,
                model.getEmailAddress(),
                null,
                null,
                serviceContext
        );
    }

    @Reference
    private AccountEntryLocalService accountEntryLocalService;
}
