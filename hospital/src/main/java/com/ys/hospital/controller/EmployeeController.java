package com.ys.hospital.controller;

import com.ys.hospital.pojo.Employee;
import com.ys.hospital.service.EmployeeDetailService;
import com.ys.hospital.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * (Employee)表控制层
 *
 * @author yusheng
 * @since 2019-10-10 08:09:39
 */

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Resource
    private RedisTemplate redisTemplate;
    @Resource
    private EmployeeService employeeService;
    @Resource
    private EmployeeDetailService employeeDetailService;


    @GetMapping
    @ResponseBody
    public Employee test(HttpSession session) {
        Object employee = session.getAttribute("employee");
        return (Employee) employee;
    }
}