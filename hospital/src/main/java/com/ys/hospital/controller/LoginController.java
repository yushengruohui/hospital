package com.ys.hospital.controller;

import com.ys.hospital.pojo.Employee;
import com.ys.hospital.service.EmployeeDetailService;
import com.ys.hospital.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @Description:
 * @author: yusheng
 * @create-date: 2019-10-10 14:52
 **/
@Controller
public class LoginController {
    @Resource
    private EmployeeService employeeService;
    @Resource
    private EmployeeDetailService employeeDetailService;

    @RequestMapping("")
    public String initLogin() {
        return "login";
    }

    @RequestMapping("/employee/out")
    public String out(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @RequestMapping("/page/login")
    //@Cacheable(cacheNames = "employee", keyGenerator = "myKeyGenerator")
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

        //redisTemplate.opsForValue().set("employee:" + employee.getEmployeeId(), employee);
        //根据员工的不同职称，跳转到相应的界面
        if (employee.getEmployeeDetail().getTitleId().equals(2) || employee.getEmployeeDetail().getTitleId().equals(1)) {
            return "appointment/index";
        }else if(employee.getEmployeeDetail().getTitleId().equals(6)) {
        	return "check/index";
        }
        return "redirect:/";
    }
}
