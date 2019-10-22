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


    @RequestMapping("/login")
    @Cacheable(cacheNames = "employee")
    //@CachePut(cacheNames = "employee")
    public String login(Employee employee, HttpSession session) {
        //根据员工id和员工密码查询该用户是否存在
        employee = employeeService.verifyLogin(employee);

        //用户不存在
        if (employee == null) {
            //返回到登录错误界面
            return "error/login_error";
        }
        session.setAttribute("employee", employee);
        //获取该员工的详细信息
        employee.setEmployeeDetail(employeeDetailService.findEmployeeById(employee.getEmployeeId()));

        //保存缓存
        redisTemplate.opsForValue().set(employee.getEmployeeId(), employee);

        //根据员工的不同职称，跳转到相应的界面
        if (employee.getEmployeeDetail().getTitleId().equals(2) || employee.getEmployeeDetail().getTitleId().equals(1)) {
            return "appointment/index";
        }else if(employee.getEmployeeDetail().getTitleId().equals(6)) {
        	return "check/index";
        }
        return "redirect:/";

    }
}