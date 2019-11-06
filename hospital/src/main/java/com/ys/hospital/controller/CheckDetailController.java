package com.ys.hospital.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.ys.hospital.pojo.Appointment;
import com.ys.hospital.pojo.Check;
import com.ys.hospital.pojo.CheckDetail;
import com.ys.hospital.pojo.CheckItem;
import com.ys.hospital.pojo.Diagnosis;
import com.ys.hospital.pojo.Employee;
import com.ys.hospital.pojo.Patient;
import com.ys.hospital.pojo.Room;
import com.ys.hospital.service.AppointmentService;
import com.ys.hospital.service.CheckDetailService;
import com.ys.hospital.service.CheckItemService;
import com.ys.hospital.service.CheckService;
import com.ys.hospital.service.DiagnosisService;
import com.ys.hospital.service.EmployeeService;
import com.ys.hospital.service.PatientService;
import com.ys.hospital.service.RoomService;
import com.ys.hospital.tools.MyPageInfo;

/**
 * (CheckDetail)表控制层
 *
 * @author yusheng
 * @since 2019-10-10 08:09:39
 */
@RestController
public class CheckDetailController {
    private static final Logger logger = LoggerFactory.getLogger(CheckDetailController.class);

    @Resource
    private CheckDetailService checkDetailService;
    
    @Resource
    private DiagnosisService diagnosisService;
    
    @Resource
    private AppointmentService appointmentService;
    
    @Resource
    private PatientService patientService;
    
    @Resource
    private CheckItemService checkItemService;
    
    @Resource
    private RoomService roomService;
    
    @Resource
    private EmployeeService employeeService;
    
    @Resource
    private CheckService checkService;

    @GetMapping("/checkDetail/indexready")
    public MyPageInfo<CheckDetail> checkDetails(MyPageInfo<CheckDetail> myPageInfo, HttpSession session,Check check){
    	Employee employee = (Employee) session.getAttribute("employee");
    	//获取检查信息
    	
//    	Check check = (Check) session.getAttribute("check");
//    	System.out.println(check.getCheckId()+"-----------------------------------------");
    	CheckDetail checkDetail = new CheckDetail();
    	checkDetail.setCheckId(check.getCheckId());
    	List<CheckDetail> checkDetails = checkDetailService.queryCheckDetailByParam(checkDetail);
    	
    	//获取所有检查详情信息
    	for(int i = 0; i < checkDetails.size(); i++) {
    		//遍历每一条检查详情
    		checkDetail = checkDetails.get(i);
    		
    		checkDetail.setEmployee(employee);
    		
    		//通过诊断单获取预约信息，取得患者信息
    		Diagnosis diagnosis = new Diagnosis();
    		diagnosis.setDiagnosisId(check.getDiagnosisId());
    		diagnosis = diagnosisService.queryDiagnosisListByParam(diagnosis).get(0);
    		checkDetail.setDiagnosis(diagnosis);
    		
    		Appointment appointment = new Appointment();
    		appointment.setAppointmentId(diagnosis.getAppointmentId());
    		appointment = appointmentService.queryAppointmentByParam(appointment).get(0);
    		checkDetail.setAppointment(appointment);
    		
    		Patient patient = new Patient();
    		patient.setPatientId(appointment.getPatientId());
    		patient = patientService.queryPatientByParam(patient).get(0);
    		checkDetail.setPatient(patient);
    		
    		CheckItem checkItem = new CheckItem();
    		checkItem.setCheckItemId(checkDetail.getCheckItemId());
    		checkItem = checkItemService.queryCheckItemByParam(checkItem).get(0);
    		checkDetail.setCheckItem(checkItem);
    		
    		Room room = new Room();
    		room.setRoomId(checkItem.getRoomId());
    		room = roomService.queryRoomByParam(room).get(0);
    		checkDetail.setRoom(room);
    	}
    	//处理分页信息
    	myPageInfo.setData(checkDetails);
    	//将数据封装到PageInfo中
    	PageInfo page = new PageInfo(myPageInfo.getData());
    	//设置成功代码
    	myPageInfo.setCode("0");
    	session.setAttribute("myPageInfoCheckDetail", myPageInfo);
    	return myPageInfo;
    	
    }
    
    @RequestMapping("/checkDetail/showCheckDetail")
    public MyPageInfo<CheckDetail> getCheckDetails(MyPageInfo<CheckDetail> myPageInfo,HttpSession session){
    	myPageInfo=(MyPageInfo<CheckDetail>)session.getAttribute("myPageInfoCheckDetail");
    	//将数据封装到PageInfo中
    	PageInfo page = new PageInfo(myPageInfo.getData());
    	//设置成功代码
    	myPageInfo.setCode("0");
    	return myPageInfo;
    }
    
    @PostMapping("/checkDetail/writeit")
    public String insertWrite(CheckDetail checkDetail, HttpSession session) {
		
    	//根据支付状态决定是否添加支付时间
    	if(checkDetail.getCheckDetailPayStatus() == 1) {
    		checkDetail.setCheckDetailPayTime(new Date());
    	}
    	
    	//检查是否更新成功
    	int flag = checkDetailService.updateCheckDetail(checkDetail);
    	
    	//计算总检测费用
    	double sum = 0;
    	
    	
    	CheckDetail checkDetail2 = new CheckDetail();
    	checkDetail2.setCheckDetailId(checkDetail.getCheckDetailId());
    	
    	checkDetail = checkDetailService.queryCheckDetailByParam(checkDetail2).get(0);
//    	System.out.println(checkDetail);
    	
    	if(flag == 1) {
    		//判断是否所有检查项目都已完成，若都已完成，则修改检查表的处理状态
    		//先创建一个只有checkid的检查详情
    		CheckDetail checkDetail1 = new CheckDetail();
    		checkDetail1.setCheckId(checkDetail.getCheckId());
//    		System.out.println(checkDetail.getCheckId()+"----------------------------");
    		List<CheckDetail> checkDetails = checkDetailService.queryCheckDetailByParam(checkDetail1);
    		int judge = 1;
    		for(int i = 0; i < checkDetails.size(); i ++) {
    			checkDetail1 = checkDetails.get(i);
    			sum = sum + checkDetail1.getCheckDetailPayPrice();
    			if(checkDetail1.getCheckDetailPayStatus() == 0) {
    				judge = 0;
    			}
//    			System.out.println(checkDetail1.getCheckDetailPayStatus()+"----------------------");
    		}
    		if(judge == 1) {
//    			System.out.println("here I am----------------------------");
    			Check check = new Check();
    			Employee employee = (Employee) session.getAttribute("employee");
    			check.setCheckId(checkDetail.getCheckId());
    			check = checkService.queryCheckByParam(check).get(0);
//    			System.out.println(check.getCheckId()+"-------------------------");
    			System.out.println(sum+"------------------------");
    			check.setCheckPrice(sum);
    			check.setCheckStatus(1);
    			check.setEmployeeId(employee.getEmployeeId());
    			System.out.println(check);
    			checkService.updateCheck(check);
    		}
    	}
    	return null;
    	
    }


}