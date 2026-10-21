package org.example.designpatternslab.filters;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.logging.Logger;

@Component
public class RequestLoggingFilter implements Filter {

    private static final Logger logger =
            Logger.getLogger(RequestLoggingFilter.class.getName());

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest =
                (HttpServletRequest) request;

        logger.info("Before request: "
                + httpRequest.getMethod()
                + " "
                + httpRequest.getRequestURI());

        chain.doFilter(request, response);

        logger.info("After request: "
                + httpRequest.getMethod()
                + " "
                + httpRequest.getRequestURI());
    }
}