package com.ys.hospital.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
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
 * (Check)表控制层
 *
 * @author yusheng
 * @since 2019-10-10 08:09:39
 */
@RestController
public class CheckController {
    private static final Logger logger = LoggerFactory.getLogger(CheckController.class);

    @Resource
    private CheckService checkService;
    
    @Resource
    private DiagnosisService diagnosisService;
    
    @Resource
    private AppointmentService appointmentService;
    
    @Resource
    private PatientService patientService;
    
    @Resource
    private CheckDetailService checkDetailService;
    
    @Resource
    private CheckItemService checkItemService;
    
    @Resource
    private RoomService roomService;
    
    @Resource
    private EmployeeService employeeService;

    @GetMapping("/check/unchecks")
    public MyPageInfo<Check> checks(MyPageInfo<Check> myPageInfo, HttpSession session){
		//获取护士信息
    	Employee employee = (Employee) session.getAttribute("employee");
    	//查询未处理检查记录
    	List<Check> checks = checkService.findUntreatedCheck();
    	
    	//没有检查记录，返回空
    	if(checks.isEmpty()) {
    		PageHelper.startPage(myPageInfo.getPage(), myPageInfo.getLimit());
    		//处理分页信息
    		myPageInfo.setData(checks);
    		//将用户数据封装到PageInfo中
    		PageInfo page = new PageInfo(myPageInfo.getData());
    		//设置成功代码
    		myPageInfo.setCode("0");
    		//设置数据数量
    		myPageInfo.setCount(0);
    		return myPageInfo;
    	}
    	//开启分页
    	PageHelper.startPage(myPageInfo.getPage(), myPageInfo.getLimit());
    	//获取检查记录所有相关属性
    	for(int i = 0; i < checks.size(); i++) {
    		//遍历每一个未处理的预约记录
    		Check check = checks.get(i);
    		
    		//所有未处理预约归当前护士管理
    		check.setEmployee(employee);
    		
    		//通过诊断单获取预约信息，取得患者信息
    		Diagnosis diagnosis = new Diagnosis();
    		diagnosis.setDiagnosisId(check.getDiagnosisId());
    		diagnosis = diagnosisService.queryDiagnosisListByParam(diagnosis).get(0);
    		check.setDiagnosis(diagnosis);
    		
    		Appointment appointment = new Appointment();
    		appointment.setAppointmentId(diagnosis.getAppointmentId());
    		appointment = appointmentService.queryAppointmentByParam(appointment).get(0);
    		check.setAppointment(appointment);
    		
    		Employee employee1 = employeeService.getEmployeeByEmployeeId(appointment.getEmployeeId());
    		check.setDoctor(employee1.getEmployeeName());
    		
    		Patient patient = new Patient();
    		patient.setPatientId(appointment.getPatientId());
    		patient = patientService.queryPatientByParam(patient).get(0);
    		check.setPatient(patient);
    		
    		CheckDetail checkDetail = new CheckDetail();
    		checkDetail.setCheckId(check.getCheckId());
    		checkDetail = checkDetailService.queryCheckDetailByParam(checkDetail).get(0);
    		check.setCheckDetail(checkDetail);
    		
    		CheckItem checkItem = new CheckItem();
    		checkItem.setCheckItemId(checkDetail.getCheckItemId());
    		checkItem = checkItemService.queryCheckItemByParam(checkItem).get(0);
    		check.setCheckItem(checkItem);
    		
    		Room room = new Room();
    		room.setRoomId(checkItem.getRoomId());
    		room = roomService.queryRoomByParam(room).get(0);
    		check.setRoom(room);
    		
    		
    		
//    		System.out.println(patient.getPatientName());
    	}
    	
    	//处理分页信息
		myPageInfo.setData(checks);
		//将用户数据封装到PageInfo中
		PageInfo page = new PageInfo(myPageInfo.getData());
		//设置成功代码
		myPageInfo.setCode("0");
		
    	return myPageInfo;
    	
    }
    
    @GetMapping("/check/ischecks")
    public MyPageInfo<Check> checks1(MyPageInfo<Check> myPageInfo, HttpSession session){
		//获取护士信息
    	Employee employee = (Employee) session.getAttribute("employee");
    	//查询未处理检查记录
    	List<Check> checks1 = checkService.findtreatedCheck();
    	
    	//没有检查记录，返回空
    	if(checks1.isEmpty()) {
    		PageHelper.startPage(myPageInfo.getPage(), myPageInfo.getLimit());
    		//处理分页信息
    		myPageInfo.setData(checks1);
    		//将用户数据封装到PageInfo中
    		PageInfo page = new PageInfo(myPageInfo.getData());
    		//设置成功代码
    		myPageInfo.setCode("0");
    		//设置数据数量
    		myPageInfo.setCount(0);
    		return myPageInfo;
    	}
    	//开启分页
    	PageHelper.startPage(myPageInfo.getPage(), myPageInfo.getLimit());
    	//获取检查记录所有相关属性
    	for(int i = 0; i < checks1.size(); i++) {
    		//遍历每一个未处理的预约记录
    		Check check = checks1.get(i);
    		
    		//所有未处理预约归当前护士管理
    		check.setEmployee(employee);
    		
    		//通过诊断单获取预约信息，取得患者信息
    		Diagnosis diagnosis = new Diagnosis();
    		diagnosis.setDiagnosisId(check.getDiagnosisId());
    		diagnosis = diagnosisService.queryDiagnosisListByParam(diagnosis).get(0);
    		check.setDiagnosis(diagnosis);
    		
    		Appointment appointment = new Appointment();
    		appointment.setAppointmentId(diagnosis.getAppointmentId());
    		appointment = appointmentService.queryAppointmentByParam(appointment).get(0);
    		check.setAppointment(appointment);
    		
    		Employee employee1 = employeeService.getEmployeeByEmployeeId(appointment.getEmployeeId());
    		check.setDoctor(employee1.getEmployeeName());
    		
    		Patient patient = new Patient();
    		patient.setPatientId(appointment.getPatientId());
    		patient = patientService.queryPatientByParam(patient).get(0);
    		check.setPatient(patient);
    		
    		CheckDetail checkDetail = new CheckDetail();
    		checkDetail.setCheckId(check.getCheckId());
    		checkDetail = checkDetailService.queryCheckDetailByParam(checkDetail).get(0);
    		check.setCheckDetail(checkDetail);
    		
    		CheckItem checkItem = new CheckItem();
    		checkItem.setCheckItemId(checkDetail.getCheckItemId());
    		checkItem = checkItemService.queryCheckItemByParam(checkItem).get(0);
    		check.setCheckItem(checkItem);
    		
    		Room room = new Room();
    		room.setRoomId(checkItem.getRoomId());
    		room = roomService.queryRoomByParam(room).get(0);
    		check.setRoom(room);
    		
    		
    		
//    		System.out.println(patient.getPatientName());
    	}
    	
    	//处理分页信息
		myPageInfo.setData(checks1);
		//将用户数据封装到PageInfo中
		PageInfo page = new PageInfo(myPageInfo.getData());
		//设置成功代码
		myPageInfo.setCode("0");
		
    	return myPageInfo;
    	
    }
    
    @PutMapping("/check")
    public String updateCheck(Check check) {
    	if(check != null && check.getCheckId() != null) {
    		check.setCheckStatus(1);
    		checkService.updateCheck(check);
    		return "success";
    	}
    	return "error";
    }

}