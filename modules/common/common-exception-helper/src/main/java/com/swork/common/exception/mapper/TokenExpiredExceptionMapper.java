package com.swork.common.exception.mapper;

import com.liferay.portal.vulcan.jaxrs.exception.mapper.BaseExceptionMapper;
import com.liferay.portal.vulcan.jaxrs.exception.mapper.Problem;
import com.swork.common.exception.model.ExceptionType;
import com.swork.common.exception.model.SW_TokenExpiredException;
import org.osgi.service.component.annotations.Component;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

@Component(
        property = {
                "osgi.jaxrs.application.select=(osgi.jaxrs.name=*)",
                "osgi.jaxrs.extension=true",
                "osgi.jaxrs.name=Swork.Common.Exception.SW_TokenExpiredException"
        },
        service = ExceptionMapper.class
)
public class TokenExpiredExceptionMapper
        extends BaseExceptionMapper<SW_TokenExpiredException> {

    private final String TITLE_MSG = "[SW] - Token Expired Exception";

    @Override
    protected Problem getProblem(SW_TokenExpiredException exception) {

        return new Problem(exception.getMessage(),
                Response.Status.BAD_REQUEST,
                TITLE_MSG,
                ExceptionType.Status.BAD_REQUEST.name());
    }
}
