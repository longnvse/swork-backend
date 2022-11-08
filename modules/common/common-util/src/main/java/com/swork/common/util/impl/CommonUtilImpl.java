package com.swork.common.util.impl;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.swork.common.util.api.CommonUtil;
import org.osgi.service.component.annotations.Component;

import java.text.Normalizer;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.regex.Pattern;

@Component(
        immediate = true, service = CommonUtil.class
)
public class CommonUtilImpl implements CommonUtil {

    @Override
    public String vnNormalize(String value) {
        char d_VN = '\u0111';
        char D_VN = '\u0110';

        if (Validator.isNull(value)) {
            return StringPool.BLANK;
        }

        try {
            String temp = Normalizer.normalize(value, Normalizer.Form.NFD);
            Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
            return pattern.matcher(temp)
                    .replaceAll("")
                    .replace(d_VN, 'd')
                    .replace(D_VN, 'D');

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return StringPool.BLANK;
    }

    @Override
    public Date getEndOfDate(Date date) {
        LocalDate dateTime = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        LocalDateTime endOfDay = LocalDateTime.of(dateTime, LocalTime.MAX);

        return Date.from(endOfDay.atZone(ZoneId.systemDefault()).toInstant());
    }

    @Override
    public Date getStartOfDate(Date date) {
        LocalDate dateTime = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        LocalDateTime startOdDay = LocalDateTime.of(dateTime, LocalTime.MIN);

        return Date.from(startOdDay.atZone(ZoneId.systemDefault()).toInstant());
    }

}
