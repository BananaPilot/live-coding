package com.pasqualehorse.livecoding.configuration.Security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
@Component
public class FilterLogging extends OncePerRequestFilter{

    private static final Logger logger = LoggerFactory.getLogger(FilterLogging.class);
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHead = request.getHeader("authStran");

        if (authHead != null && request.getHeader("authStran").equals("AAA")){
            filterChain.doFilter(request,response);
            logger.info("status: " + response.getStatus() + " endpoint: " + request.getRequestURI());
        } else{
            response.sendError(403, " richiesta fa brutto");
        }


    }
}
