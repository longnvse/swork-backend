package com.swork.common.exception.mapper;

import com.swork.common.exception.model.SW_BadRequestException;
import com.swork.common.exception.model.ExceptionType;
import com.liferay.portal.vulcan.jaxrs.exception.mapper.BaseExceptionMapper;
import com.liferay.portal.vulcan.jaxrs.exception.mapper.Problem;

import javax.ws.rs.core.Response;

public class BadRequestExceptionMapper
        extends BaseExceptionMapper<SW_BadRequestException> {

    private final String TITLE_MSG = "[SW] - Bad Request Exception";

    @Override
    protected Problem getProblem(SW_BadRequestException exception) {

        return new Problem(exception.getMessage(),
                Response.Status.BAD_REQUEST,
                TITLE_MSG,
                ExceptionType.Status.BAD_REQUEST.name());
    }
}
