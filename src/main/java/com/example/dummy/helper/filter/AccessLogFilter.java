package com.example.dummy.helper.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.filter.OncePerRequestFilter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class AccessLogFilter extends OncePerRequestFilter {

    Logger log = LoggerFactory.getLogger(AccessLogFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, 
                                    HttpServletResponse response, 
                                    FilterChain filterChain) throws ServletException, IOException {

     if (request.getRequestURI().toLowerCase().contains("/api")) {

         long time = System.currentTimeMillis();
         try {
             filterChain.doFilter(request, response);
         }
         finally {
             time = System.currentTimeMillis() - time;

             String remoteIpAddress = request.getHeader("X-FORWARDED-FOR");

             if (remoteIpAddress == null || remoteIpAddress.isEmpty()) {
                 remoteIpAddress = request.getRemoteAddr();
             }

             log.info("{} {} {} {} {} {}ms",
                        remoteIpAddress, 
                        request.getMethod(), 
                        request.getRequestURI(), 
                        response.getContentType(),
                        response.getStatus(), 
                        time);
         }
     }
     else {
         filterChain.doFilter(request, response);
     }

    }
    
}
