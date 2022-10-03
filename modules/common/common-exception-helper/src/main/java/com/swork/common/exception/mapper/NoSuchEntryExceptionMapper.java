package com.swork.common.exception.mapper;

import com.liferay.portal.vulcan.jaxrs.exception.mapper.BaseExceptionMapper;
import com.liferay.portal.vulcan.jaxrs.exception.mapper.Problem;
import com.swork.common.exception.model.ExceptionType;
import com.swork.common.exception.model.SW_NoSuchEntryException;
import org.osgi.service.component.annotations.Component;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

@Component(
        property = {
                "osgi.jaxrs.application.select=(osgi.jaxrs.name=*)",
                "osgi.jaxrs.extension=true",
                "osgi.jaxrs.name=Swork.Common.Exception.SW_NoSuchEntryException"
        },
        service = ExceptionMapper.class
)
public class NoSuchEntryExceptionMapper
        extends BaseExceptionMapper<SW_NoSuchEntryException> {

    private final String TITLE_MSG = "[SW] - No Such Entry Exception";

    @Override
    protected Problem getProblem(SW_NoSuchEntryException exception) {

        return new Problem(exception.getMessage(),
                Response.Status.NOT_FOUND,
                TITLE_MSG,
                ExceptionType.Status.RESOURCE.name());
    }
}
