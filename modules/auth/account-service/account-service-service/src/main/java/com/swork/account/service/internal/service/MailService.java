package com.swork.account.service.internal.service;

import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.petra.string.StringPool;
import com.swork.account.service.model.AccountEntry;
import org.osgi.service.component.annotations.Component;

import javax.mail.internet.InternetAddress;

@Component(
        immediate = true,
        service = MailService.class
)
public class MailService {
    private final String SUBJECT = "[Swork] - THƯ XÁC NHẬN NGƯỜI DÙNG";
    private final String BASE_URI_TEMPLATE_EMAIL = "asset/mail/template/index.html";

    private final String[] OLD_SUBS = {"$name$", "$product$", "$companyName$"};

    public void sendMail(AccountEntry entry) {
        try {
            InternetAddress fromAddress = new InternetAddress("no-reply@swork.vn");
            InternetAddress toAddress = new InternetAddress(entry.getEmail());
            MailMessage mailMessage = new MailMessage();
            mailMessage.setTo(toAddress);
            mailMessage.setFrom(fromAddress);
            mailMessage.setSubject(SUBJECT);

//            String mailRegistration = StringUtil.read(getClass().getClassLoader(), BASE_URI_TEMPLATE_EMAIL);
//
//            mailRegistration = StringUtil.replace(
//                    mailRegistration,
//                    OLD_SUBS,
//                    new String[]{entry.getName(), languageService.getProductName(entry.getProduct()), entry.getCompanyName()});
//
//
//            mailMessage.setBody(mailRegistration);
            mailMessage.setBody(entry.getEmail() + StringPool.PIPE + entry.getPassword());
//            mailMessage.setHTMLFormat(true);

            MailServiceUtil.sendEmail(mailMessage);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
