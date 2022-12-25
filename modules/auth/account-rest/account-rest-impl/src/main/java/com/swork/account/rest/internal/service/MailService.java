package com.swork.account.rest.internal.service;

import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.swork.account.service.model.AccountEntry;
import org.osgi.service.component.annotations.Component;

import javax.mail.internet.InternetAddress;
import java.util.ResourceBundle;

@Component(
        immediate = true,
        service = MailService.class
)
public class MailService {
    private final String BASE_URI_TEMPLATE_EMAIL = "asset/mail/template/index.html";

    private final String[] OLD_SUBS = {"$username$", "$password$"};

    private static final ResourceBundle resourceBundle = ResourceBundle.getBundle("/content/mail");

    public void sendMail(AccountEntry entry) {
        try {
            String SUBJECT = resourceBundle.getString("subject");

            InternetAddress fromAddress = new InternetAddress("no-reply@swork-fu.com");
            InternetAddress toAddress = new InternetAddress(entry.getEmail());
            MailMessage mailMessage = new MailMessage();
            mailMessage.setTo(toAddress);
            mailMessage.setFrom(fromAddress);
            mailMessage.setSubject(SUBJECT);

            String mailRegistration = StringUtil.read(getClass().getClassLoader(), BASE_URI_TEMPLATE_EMAIL);

            mailRegistration = StringUtil.replace(
                    mailRegistration,
                    OLD_SUBS,
                    new String[]{entry.getEmail(), entry.getPassword()});

            mailMessage.setBody(mailRegistration);
            mailMessage.setHTMLFormat(true);

            MailServiceUtil.sendEmail(mailMessage);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
