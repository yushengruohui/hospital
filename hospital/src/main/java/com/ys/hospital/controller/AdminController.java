package com.ys.hospital.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ys.hospital.pojo.Employee;
import com.ys.hospital.pojo.EmployeeDetail;
import com.ys.hospital.pojo.Title;
import com.ys.hospital.pojo.vo.EmployeeInfoVO;
import com.ys.hospital.service.EmployeeService;
import com.ys.hospital.tools.BeanTool;
import com.ys.hospital.tools.MyPageInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * (Admin)表控制层
 *
 * @author yusheng
 * @since 2019-10-10 08:09:39
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Resource
    private EmployeeService employeeService;

    @GetMapping("/employee")
    public EmployeeInfoVO searchEmployee(Integer employeeId) {
        // 获取某个员工
        Employee employeeDTO = employeeService.getEmployeeByEmployeeId(employeeId);
        EmployeeDetail employeeDetail = employeeDTO.getEmployeeDetail();
        Title title = employeeDetail.getTitle();


        EmployeeInfoVO employeeInfoVO = new EmployeeInfoVO();
        BeanTool.copy(employeeDTO, employeeInfoVO);
        BeanTool.copy(employeeDetail, employeeInfoVO);
        BeanTool.copy(title, employeeInfoVO);

        return employeeInfoVO;
    }

    @GetMapping("/employee/online")
    public MyPageInfo<EmployeeInfoVO> searchOnlineEmployees(MyPageInfo<EmployeeInfoVO> myPageInfo) {
        // 获取所有在线的员工
        PageHelper.startPage(myPageInfo.getPage(), myPageInfo.getLimit());

        List<EmployeeInfoVO> employeeInfoVOs = new ArrayList<>();
        List<Employee> employees = employeeService.queryEmployeeByStatus(1);
        for (int i = 0; i < employees.size(); i++) {
            Employee employee = employees.get(i);
            EmployeeDetail employeeDetail = employee.getEmployeeDetail();
            Title title = employeeDetail.getTitle();
            EmployeeInfoVO employeeInfoVO = new EmployeeInfoVO();
            BeanTool.copy(employee, employeeInfoVO);
            BeanTool.copy(employeeDetail, employeeInfoVO);
            BeanTool.copy(title, employeeInfoVO);
            employeeInfoVOs.add(employeeInfoVO);
        }


        //处理分页信息
        myPageInfo.setData(employeeInfoVOs);
        //将用户数据封装到PageInfo 中
        PageInfo page = new PageInfo(myPageInfo.getData());
        //设置数据数量
        myPageInfo.setCount(page.getPageSize());
        //设置成功代码
        myPageInfo.setCode("0");
        return myPageInfo;
    }

    @GetMapping("/employee/offline")
    public String searchOfflineEmployees() {
        // 获取所有离线的员工

        return "success";
    }


}