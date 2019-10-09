package com.ys.hospital.controller;

import com.ys.hospital.pojo.Employee;
import com.ys.hospital.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * (Employee)表控制层
 *
 * @author yusheng
 * @since 2019-10-09 09:00:06
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Resource
    private EmployeeService employeeService;
    @Resource
    private RedisTemplate redisTemplate;

    @Cacheable(cacheNames = {"employee"})
    @RequestMapping("/login")
    public String login(Employee employee) {
        logger.info("testDome success");
        if (employee.equals(null)) {
            redisTemplate.opsForValue().append("msg", "请输入账号和密码");
            return "pages/login";
        }

        return "redirect:/";
    }


}