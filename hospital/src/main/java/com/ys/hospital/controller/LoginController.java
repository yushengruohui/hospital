package com.ys.hospital.controller;

import com.ys.hospital.pojo.Employee;
import com.ys.hospital.service.EmployeeDetailService;
import com.ys.hospital.service.EmployeeService;
import com.ys.hospital.tools.RedisTool;
import org.springframework.security.core.context.SecurityContextHolder;
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

    @RequestMapping("/")
    public String index() {
        return "redirect:/page/index";
    }

    @RequestMapping("/login")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("/page/index")
    // @Cacheable(cacheNames = "employee", keyGenerator = "myKeyGenerator")
    // @CachePut(cacheNames = "employee")
    public String login(HttpSession session) {

        String employeeId = SecurityContextHolder.getContext().getAuthentication().getName();

        Employee employee = new Employee();
        employee.setEmployeeId(Integer.valueOf(employeeId));
        // 根据员工id和员工密码查询该用户是否存在
        employee = employeeService.verifyLogin(employee);


        // 获取该员工的详细信息
        employee.setEmployeeDetail(employeeDetailService.findEmployeeById(employee.getEmployeeId()));
        session.setAttribute("employee", employee);

        RedisTool.set("employee:" + employee.getEmployeeId(), employee, (long) 3600);
        // 根据员工的不同职称，跳转到相应的界面
        if (employee.getEmployeeDetail().getTitleId().equals(2) || employee.getEmployeeDetail().getTitleId().equals(1)) {
            // 主治医师
            return "appointment/index";
        } else if (employee.getEmployeeDetail().getTitleId().equals(8)) {
            // 院长登录
            return "admin/employee_report";
        } else if (employee.getEmployeeDetail().getTitleId().equals(3)) {
            // 主刀医师登录
            return "redirect:/page/operation/index";
        }
        //发药药师界面
        if (employee.getEmployeeDetail().getTitleId().equals(4)) {
            return "dispensing/index";
        }


        //住院护士界面
        if (employee.getEmployeeDetail().getTitleId().equals(7)) {
            return "redirect:/page/inpatient/index";
        }else if(employee.getEmployeeDetail().getTitleId().equals(6)) {
        	return "check/index";
        }
        return "redirect:/";
    }
}
