package com.ys.hospital.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description:
 * @author: yusheng
 * @create-date: 2019-09-26 17:19
 **/
public class MyMethodInterceptor implements HandlerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(MyMethodInterceptor.class);
    long startTime = 0;
    long endTime = 0;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        logger.info("请求url： " + requestURI + " 已到达");
        startTime = System.currentTimeMillis();
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        endTime = System.currentTimeMillis();
        String requestURI = request.getRequestURI();
        logger.info("请求url： " + requestURI + " 已完成");
        long useTime = endTime - startTime;
        if (useTime < 1000) {
            logger.info("请求url： " + requestURI + " 正常，耗时为：" + useTime + "ms");
        } else {
            logger.error("请求url： " + requestURI + " 异常，耗时为：" + useTime + "ms");
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
