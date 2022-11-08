package com.swork.account.service.internal.listener;

import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;
import com.swork.account.service.internal.service.MailService;
import com.swork.account.service.model.AccountEntry;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        service = ModelListener.class
)
public class AccountListener extends BaseModelListener<AccountEntry> {

    @Override
    public void onAfterCreate(AccountEntry model) throws ModelListenerException {
        mailService.sendMail(model);
    }

    @Reference
    private MailService mailService;
}
