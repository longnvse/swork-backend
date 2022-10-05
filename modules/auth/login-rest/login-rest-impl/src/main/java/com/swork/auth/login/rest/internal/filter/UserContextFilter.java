package com.swork.auth.login.rest.internal.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.liferay.portal.kernel.util.Validator;
import com.swork.common.exception.model.ExceptionType;
import com.swork.common.token.service.JwtService;
import com.swork.common.token.util.TokenKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component(
        immediate = true,
        property = {
                "servlet-context-name=",
                "servlet-filter-name=Swork User Context Filter",
                "url-pattern=/o/swork/*"
        },
        service = Filter.class
)
public class UserContextFilter implements Filter {

    private static final String ERROR_TITLE = "User context is required";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;

        String userContext = httpRequest.getHeader(TokenKeys.USER_CONTEXT);

        if (Validator.isNull(userContext)) {
            buildErrorResponse(
                    response
            );
        }

        boolean tokenValid;

        try {
            tokenValid = jwtService.validateJwtToken(userContext);
        } catch (Exception e) {
            tokenValid = false;
        }

        if (tokenValid) {
            chain.doFilter(request, response);
        } else {
            buildErrorResponse(
                    response
            );
        }

    }

    private void buildErrorResponse(ServletResponse response)
            throws IOException {

        ObjectMapper mapper = new ObjectMapper();

        FilterErrorMessage object = new FilterErrorMessage();

        object.setTitle(ERROR_TITLE);
        object.setStatus(Integer.toString(HttpServletResponse.SC_UNAUTHORIZED));
        object.setType(ExceptionType.Status.AUTH.name());
        object.setDetail(UserContextFilter.ERROR_TITLE);

        HttpServletResponse httpResp = (HttpServletResponse) response;
        httpResp.reset();
        httpResp.setHeader("Content-Type", "application/json;charset=UTF-8");
        httpResp.addHeader("Access-Control-Allow-Origin", "*");
        httpResp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        String json = mapper.writeValueAsString(object);
        response.getWriter().write(json);
    }


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //default
    }

    @Override
    public void destroy() {
        //default
    }

    @Reference
    private JwtService jwtService;
}
