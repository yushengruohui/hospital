package com.ys.hospital.config;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;

/**
 * @Description:
 * @author: yusheng
 * @create-date: 2019-10-16 13:58
 **/
@Configuration
public class MyCacheConfig extends CachingConfigurerSupport {
    public KeyGenerator keyGenerator() {
        return new KeyGenerator() {
            @Override
            public Object generate(Object o, Method method, Object... objects) {
                StringBuilder sb = new StringBuilder();
                sb.append(o.getClass().getName())
                        .append(".")
                        .append(method.getName());
                sb.append("[");
                if (objects != null) {
                    for (int i = 0; i < objects.length; i++) {
                        Object param = objects[i];
                        if (param instanceof HttpSession || param instanceof HttpServletRequest || param instanceof HttpServletResponse) {
                            param = null;
                        }
                        if (param != null) {
                            sb.append(param).append(",");
                        }
                    }
                }
                sb.deleteCharAt(sb.lastIndexOf(","));
                sb.append("]");
                // System.out.println("=====" + sb.toString() + "=====");

                return sb.toString();
            }
        };
    }
}
