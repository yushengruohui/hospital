package com.ys.hospital.controller;

import com.ys.hospital.pojo.Employee;
import com.ys.hospital.pojo.EmployeeDetail;
import com.ys.hospital.service.EmployeeDetailService;
import com.ys.hospital.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

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
    private EmployeeService employeeService;
    @Resource
    private EmployeeDetailService employeeDetailService;

    @RequestMapping("/login")
    public String login(Employee employee) {
        //根据员工id和员工密码查询该用户是否存在
        System.out.println("1111");
        Employee loginEmployee = employeeService.verifyLogin(employee);
        //获取该员工的详细信息
        EmployeeDetail employeeDetail = employeeDetailService.findEmployeeById(loginEmployee.getEmployeeId());

        //根据员工的不同职称，跳转到相应的界面
        if (employeeDetail.getTitleId().equals(2) || employeeDetail.getTitleId().equals(1)) {
            return "diagnosis/index";
        }
        return "redirect:/";
    }


}