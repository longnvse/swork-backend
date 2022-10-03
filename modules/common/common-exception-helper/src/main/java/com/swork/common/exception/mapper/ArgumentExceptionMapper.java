package com.swork.common.exception.mapper;

import com.liferay.portal.vulcan.jaxrs.exception.mapper.BaseExceptionMapper;
import com.liferay.portal.vulcan.jaxrs.exception.mapper.Problem;
import com.swork.common.exception.model.ExceptionType;
import org.osgi.service.component.annotations.Component;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import java.util.logging.Logger;

@Component(
        property = {
                "osgi.jaxrs.application.select=(osgi.jaxrs.name=*)",
                "osgi.jaxrs.extension=true",
                "osgi.jaxrs.name=Swork.Common.Exception.IllegalArgumentException"
        },
        service = ExceptionMapper.class
)
public class ArgumentExceptionMapper
        extends BaseExceptionMapper<IllegalArgumentException> {

    private static final Logger _logger = Logger.getLogger(
            ArgumentExceptionMapper.class.getName());

    private final String TITLE_MSG = "Illegal Argument Exceptionn XXXXX";

    @Override
    protected Problem getProblem(IllegalArgumentException exception) {

        exception.printStackTrace();

        return new Problem(exception.getLocalizedMessage(),
                Response.Status.BAD_REQUEST,
                TITLE_MSG,
                ExceptionType.Status.BAD_REQUEST.name());
    }
}
