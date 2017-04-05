package org.thappo.service.interceptor;


import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoggerInterceptor
    extends HandlerInterceptorAdapter {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggerInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        LOGGER.info("--------------------------------------");
        String queryString = request.getQueryString() == null ? "" : "?" + request.getQueryString();
        LOGGER.info("[CONTROLLER] " + request.getMethod() + " to path: " + request.getRequestURI() + queryString
            + " (from address " + request.getRemoteAddr() + ")");
        LOGGER.info("[CONTROLLER] Request headers: " + this.getHeadersMap(request));

        return super.preHandle(request, response, handler);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
        throws Exception {
        LOGGER.info("[CONTROLLER] Status code: " + response.getStatus());
        super.afterCompletion(request, response, handler, ex);
    }

    private Map<String, String> getHeadersMap(HttpServletRequest request) {
        Map<String, String> result = new HashMap<String, String>();

        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = headerNames.nextElement();
            String value = request.getHeader(key);
            result.put(key, value);
        }
        return result;
    }

//    private String convertStreamToString(java.io.InputStream is) {
//        Scanner s = new Scanner(is);
//        s.useDelimiter("\\A");
//        return s.hasNext() ? s.next() : null;
//    }

}
