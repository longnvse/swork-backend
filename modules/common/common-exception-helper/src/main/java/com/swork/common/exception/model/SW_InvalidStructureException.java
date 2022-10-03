package com.swork.common.exception.model;

import com.liferay.portal.kernel.exception.PortalException;

public class SW_InvalidStructureException extends PortalException {
    public SW_InvalidStructureException() {
    }

    public SW_InvalidStructureException(String msg) {
        super(msg);
    }

    public SW_InvalidStructureException(String msg, Throwable throwable) {
        super(msg, throwable);
    }

    public SW_InvalidStructureException(Throwable throwable) {
        super(throwable);
    }

}
