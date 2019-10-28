package com.ys.hospital.config.security;

import org.springframework.security.access.ConfigAttribute;

import javax.servlet.http.HttpServletRequest;


public class CustomizedConfigAttribute implements ConfigAttribute {

    private final HttpServletRequest httpServletRequest;

    public CustomizedConfigAttribute(HttpServletRequest httpServletRequest) {
        this.httpServletRequest = httpServletRequest;
    }


    @Override
    public String getAttribute() {
        return null;
    }

    public HttpServletRequest getHttpServletRequest() {
        return httpServletRequest;
    }
}