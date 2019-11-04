package com.ys.hospital.controller;

import com.ys.hospital.pojo.Employee;
import com.ys.hospital.pojo.EmployeeDetail;
import com.ys.hospital.pojo.dto.EmployeeOnUpdateDTO;
import com.ys.hospital.service.EmployeeDetailService;
import com.ys.hospital.service.EmployeeService;
import com.ys.hospital.tools.BeanTool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.sql.SQLOutput;

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
    public Employee getEmployee(String Id) {
        Employee employee = new Employee();
        employee.setEmployeeId(Integer.valueOf(Id));
        return employee;
    }

    @PostMapping
    public String updateEmployee(EmployeeOnUpdateDTO employeeOnUpdateDTO) {
        String employeeIdString = SecurityContextHolder.getContext().getAuthentication().getName();
        Integer employeeId = Integer.valueOf(employeeIdString);
        employeeOnUpdateDTO.setEmployeeId(employeeId);

        Employee employeeDTO = new Employee();
        EmployeeDetail employeeDetailDTO = new EmployeeDetail();

        BeanTool.copy(employeeOnUpdateDTO, employeeDTO);

        BeanTool.copy(employeeOnUpdateDTO, employeeDetailDTO);

        employeeDTO.setEmployeeDetail(employeeDetailDTO);

        //更新用户基本信息
        employeeService.updateEmployee(employeeDTO);

        employeeDetailService.updateEmployeeDetailByEmployeeId(employeeDetailDTO);

        return "redirect:/page/employee/index";
    }

    //修改发药药师个人信息
    @RequestMapping("/updateDispensingEmployee")
    public String updateDispensingEmployee(EmployeeOnUpdateDTO employeeOnUpdateDTO) {
        String employeeIdString = SecurityContextHolder.getContext().getAuthentication().getName();
        Integer employeeId = Integer.valueOf(employeeIdString);
        employeeOnUpdateDTO.setEmployeeId(employeeId);

        Employee employeeDTO = new Employee();
        EmployeeDetail employeeDetailDTO = new EmployeeDetail();

        BeanTool.copy(employeeOnUpdateDTO, employeeDTO);

        BeanTool.copy(employeeOnUpdateDTO, employeeDetailDTO);

        employeeDTO.setEmployeeDetail(employeeDetailDTO);

        //更新用户基本信息
        employeeService.updateEmployee(employeeDTO);

        employeeDetailService.updateEmployeeDetailByEmployeeId(employeeDetailDTO);

        return "redirect:/page/dispensing/employee/index";
    }
}