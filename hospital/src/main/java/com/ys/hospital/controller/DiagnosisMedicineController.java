package com.ys.hospital.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ys.hospital.pojo.DiagnosisMedicine;
import com.ys.hospital.pojo.Employee;
import com.ys.hospital.pojo.Work;
import com.ys.hospital.service.DiagnosisMedicineService;
import com.ys.hospital.tools.MyPageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * (DiagnosisMedicine)表控制层
 *
 * @author yusheng
 * @since 2019-10-10 08:09:39
 */
@Controller
@RequestMapping("/diagnosisMedicine")
public class DiagnosisMedicineController {
    private static final Logger logger = LoggerFactory.getLogger(DiagnosisMedicineController.class);

    @Resource
    private DiagnosisMedicineService diagnosisMedicineService;

    @GetMapping("/diagnosisMedicines")
    @ResponseBody
    //查询所有未处理的取药信息
    public MyPageInfo<DiagnosisMedicine> getDiagnosisMedicines(MyPageInfo<DiagnosisMedicine> myPageInfo) {
        PageHelper.startPage(myPageInfo.getPage(), myPageInfo.getLimit());
        //查询所有未处理的发药记录
        List<DiagnosisMedicine> diagnosisMedicines = diagnosisMedicineService.getDiagnosisMedicinesByStatus(0);
        //将记录存放到分页中去
        myPageInfo.setData(diagnosisMedicines);
        PageInfo page = new PageInfo(myPageInfo.getData());
        myPageInfo.setCode("0");
        myPageInfo.setCount(page.getPageSize());
        return myPageInfo;
    }

    @PutMapping("/diagnosisMedicine")
    @ResponseBody
    //修改取药状态、支付状态、处理人信息
    public void updateDiagnosisMedicine(HttpSession session, DiagnosisMedicine diagnosisMedicine) {
        System.out.println("我进来了");
        //获取取药医师Id
        Employee employee = (Employee) session.getAttribute("employee");
        Integer employeeId = employee.getEmployeeId();
        diagnosisMedicine.setEmployeeId(employeeId);
        int flag = diagnosisMedicineService.updateDiagnosisMedicine(diagnosisMedicine);
    }

    @GetMapping("/unTreatDiagnosisMedicines")
    @ResponseBody
    //查询已处理的取药记录
    public MyPageInfo<DiagnosisMedicine> getunTreatDiagnosisMedicines(MyPageInfo<DiagnosisMedicine> myPageInfo) {
        PageHelper.startPage(myPageInfo.getPage(), myPageInfo.getLimit());
        //查询所有已处理的发药记录
        List<DiagnosisMedicine> diagnosisMedicines = diagnosisMedicineService.getDiagnosisMedicinesByStatus(1);
        //将记录存放到分页中去
        myPageInfo.setData(diagnosisMedicines);
        PageInfo page = new PageInfo(myPageInfo.getData());
        myPageInfo.setCode("0");
        myPageInfo.setCount(page.getPageSize());
        return myPageInfo;
    }

}