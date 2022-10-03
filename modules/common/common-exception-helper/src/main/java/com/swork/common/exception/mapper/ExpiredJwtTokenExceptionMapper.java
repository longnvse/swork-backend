package com.swork.common.exception.mapper;

import com.liferay.portal.vulcan.jaxrs.exception.mapper.BaseExceptionMapper;
import com.liferay.portal.vulcan.jaxrs.exception.mapper.Problem;
import com.swork.common.exception.model.ExceptionType;
import io.jsonwebtoken.ExpiredJwtException;
import org.osgi.service.component.annotations.Component;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

@Component(
        property = {
                "osgi.jaxrs.application.select=(osgi.jaxrs.name=*)",
                "osgi.jaxrs.extension=true",
                "osgi.jaxrs.name=Swork.Common.Exception.ExpiredJwtException"
        },
        service = ExceptionMapper.class,
        immediate = true
)
public class ExpiredJwtTokenExceptionMapper
        extends BaseExceptionMapper<ExpiredJwtException> {

    private final String TITLE_MSG = "[SW] - Expired Jwt Exception";

    @Override
    protected Problem getProblem(ExpiredJwtException exception) {

        return new Problem(exception.getMessage(),
                Response.Status.UNAUTHORIZED,
                TITLE_MSG,
                ExceptionType.Status.AUTH.name());
    }
}
