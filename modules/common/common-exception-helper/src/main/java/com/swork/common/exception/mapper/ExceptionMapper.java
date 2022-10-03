package com.swork.common.exception.mapper;

import com.liferay.portal.vulcan.jaxrs.exception.mapper.BaseExceptionMapper;
import com.liferay.portal.vulcan.jaxrs.exception.mapper.Problem;
import com.swork.common.exception.model.ExceptionType;

import javax.ws.rs.core.Response;

public class ExceptionMapper
        extends BaseExceptionMapper<Exception> {

    private final String TITLE_MSG = "[SW] - Common Exception";

    @Override
    protected Problem getProblem(Exception exception) {

        return new Problem(exception.getMessage(),
                Response.Status.INTERNAL_SERVER_ERROR,
                TITLE_MSG,
                ExceptionType.Status.COMMON.name());
    }
}
