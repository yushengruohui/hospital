package com.ys.hospital.config.security;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;


@Service
public class CustomizedAccessDecisionManager implements AccessDecisionManager {
	//抉择器，是否拦截当前用户点击的url
    @Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
        // HttpServletRequest 当前用户点击的url
		HttpServletRequest request = ((FilterInvocation) object).getHttpRequest();
        String url, method;
		
		// authentication 当前用户的认证信息
        if ("anonymousUser".equals(authentication.getPrincipal())
                || matchers("/images/**", request)
                || matchers("/**/*.js", request)
                || matchers("/**/*.css", request)
                || matchers("/fonts/**", request)
                || matchers("/", request)
                || matchers("/favicon.ico", request)
                || matchers("/login", request)) {
			
			// 放行
            return;
        } else {
            for (GrantedAuthority ga : authentication.getAuthorities()) {
                if (ga instanceof CustomizedGrantedAuthority) {
					
					// 转换成自定义的权限信息
                    CustomizedGrantedAuthority customizedGrantedAuthority = (CustomizedGrantedAuthority) ga;
                    url = customizedGrantedAuthority.getPermissionUrl();
                    method = customizedGrantedAuthority.getMethod();
					
					// 如果当前用户的请求url具有权限，则放行
                    if (matchers(url, request)) {
                        if (method.equals(request.getMethod()) || "ALL".equals(method)) {
                            return;
                        }
                    }
                }
            }
        }
		// 不符合以上要求，拦截
        throw new AccessDeniedException("no right");
    }


    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }


    private boolean matchers(String url, HttpServletRequest request) {
        AntPathRequestMatcher matcher = new AntPathRequestMatcher(url);
        return matcher.matches(request);
    }
}
