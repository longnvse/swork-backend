package com.swork.common.util.api;

import org.osgi.annotation.versioning.ProviderType;

import java.util.Date;

@ProviderType
public interface CommonUtil {
    String vnNormalize(String value);

    Date getEndOfDate(Date date);
    Date getStartOfDate(Date date);

}