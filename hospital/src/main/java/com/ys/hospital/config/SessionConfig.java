package com.ys.hospital.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @Description: 配置http中session的存在时间限制，默认30分钟失效
 * @author: yusheng
 * @create-date: 2019-10-16 13:32
 **/
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 3600)
public class SessionConfig {
}
