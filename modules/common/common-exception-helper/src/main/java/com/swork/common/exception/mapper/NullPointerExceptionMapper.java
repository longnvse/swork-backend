package com.swork.common.exception.mapper;

import com.liferay.portal.vulcan.jaxrs.exception.mapper.BaseExceptionMapper;
import com.liferay.portal.vulcan.jaxrs.exception.mapper.Problem;
import com.swork.common.exception.model.ExceptionType;

import javax.ws.rs.core.Response;

public class NullPointerExceptionMapper
        extends BaseExceptionMapper<NullPointerException> {

    private final String TITLE_MSG = "Null Pointer Exception";

    @Override
    protected Problem getProblem(NullPointerException exception) {

        return new Problem(exception.getMessage(),
                Response.Status.BAD_REQUEST,
                TITLE_MSG,
                ExceptionType.Status.BAD_REQUEST.name());
    }
}
