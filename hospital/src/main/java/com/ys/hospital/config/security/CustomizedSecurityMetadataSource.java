package com.ys.hospital.config.security;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by yangyibo on 17/1/19.
 */
@Component
public class CustomizedSecurityMetadataSource implements
        FilterInvocationSecurityMetadataSource {

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        // 用户的请求 request
        final HttpServletRequest request = ((FilterInvocation) object).getRequest();

        Set<ConfigAttribute> allAttributes = new HashSet<>();

        // 通过所需权限
        ConfigAttribute configAttribute = new CustomizedConfigAttribute(request);

        //当前为空，即拦截所有请求，让 AccessDecisionManager 进行访问抉择
        allAttributes.add(configAttribute);
        return allAttributes;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
