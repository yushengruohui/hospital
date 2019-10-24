package com.ys.hospital.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ys.hospital.pojo.Employee;
import com.ys.hospital.pojo.Operation;
import com.ys.hospital.pojo.OperationNotify;
import com.ys.hospital.pojo.Room;
import com.ys.hospital.service.OperationNotifyService;
import com.ys.hospital.service.OperationService;
import com.ys.hospital.service.RoomService;
import com.ys.hospital.tools.MyPageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * (Operation)表控制层
 *
 * @author yusheng
 * @since 2019-10-10 08:09:40
 */
@Controller
@RequestMapping("/operation")
public class OperationController {
    private static final Logger logger = LoggerFactory.getLogger(OperationController.class);

    @Resource
    private OperationService operationService;
	 @Resource
    private OperationNotifyService operationNotifyService;
    @Resource
    private RoomService roomService;

    @RequestMapping("/test")
    public String testDome() {
        logger.info("testDome success");
        return "redirect:/";
    }
/**
     * 页面跳转
     * @return ModelAndView
     */
    @RequestMapping("/findoperation")
    public ModelAndView findoperation() {
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("operation/findOperation");
        return modelAndView;
    }
    /**
     * 查询所有手术
     * @return ModelAndView
     */
    @RequestMapping("/findAllOperation")
    @ResponseBody
    public MyPageInfo<Operation> findAllOperation(HttpSession session, MyPageInfo<Operation> myPageInfo) {
        PageHelper.startPage(myPageInfo.getPage(), myPageInfo.getLimit());
        Employee employee= (Employee) session.getAttribute("employee");
        List<Operation> operations = operationService.queryAllOperations(employee.getEmployeeId());
        for (Operation operation : operations) {
            Room room=new Room();
            room.setRoomId(operation.getRoomId());
            List<Room> rooms = roomService.queryRoomByParam(room);
            operation.setRoom(rooms.get(0));
        }
        myPageInfo.setData(operations);
        PageInfo page = new PageInfo(myPageInfo.getData());
        myPageInfo.setCode("0");
        myPageInfo.setCount(page.getPageSize());
        return myPageInfo;
    }

    /**
     * 根据状态查找手术
     * @return
     */
    @RequestMapping("/findOperationByStatus")
    @ResponseBody
    public List<Operation> findOperationByStatus(Operation operation) {
        List<Operation> operations = operationService.queryOperationsByParam(operation);
        return operations;
    }

    /**
     *查找一个手术详情通过id
     * @param operation
     * @return
     */
    @RequestMapping("/findOperationById")
    @ResponseBody
    public Operation findOperationById(Operation operation) {
         Operation  operationDetail= operationService.queryOperationById(operation);
        return operationDetail;
    }

    /**
     *更新该手术
     * @param operation
     * @return String
     */
    @PostMapping("/updateOperation")
    @ResponseBody
    public String updateOperation(Operation operation,HttpSession session) {
        //设置支付状态
        operation.setOperationPayStatus(1);
        //设置手术通知
        Operation operation1= (Operation) session.getAttribute("operation1");
        operation.setOperationId(operation1.getOperationId());
        Integer operationNotifyId=operation.getOperationNotifyId();
        operation.setOperationStatus(1);
        operation.setOperationPayStatus(1);
        operationService.updateOperation(operation);
        OperationNotify operationNotify=new OperationNotify();
        operationNotify.setOperationNotifyId(operationNotifyId);
        //修改手术通知处理状态
        List<OperationNotify> operationNotifies = operationNotifyService.queryOperationNotifyByParam(operationNotify);
        Employee employee= (Employee) session.getAttribute("employee");
        //添加当前登陆医师
        operationNotifies.get(0).setEmployeeId(employee.getEmployeeId());
        operationNotifies.get(0).setOperationNotifyStatus(1);
        operationNotifyService.updateOperationNotify(operationNotifies.get(0));
        return  "成功";

    }

    /**
     * 添加手术
     * @param operation
     * @return String
     */
    @PostMapping("/addOperation")
    @ResponseBody
    public String addOperation(Operation operation) {
    operation.setOperationPayStatus(1);
    Integer operationNotifyId=operation.getOperationNotifyId();
    operationService.insertOperation(operation);
    OperationNotify operationNotify=new OperationNotify();
    operationNotify.setOperationNotifyId(operationNotifyId);
    List<OperationNotify> operationNotifies = operationNotifyService.queryOperationNotifyByParam(operationNotify);
    operationNotifies.get(0).setOperationNotifyStatus(1);
    operationNotifyService.updateOperationNotify(operationNotifies.get(0));
    return  "添加成功";
    }

//    /**
//     * 支付手术费用
//     * @param operation
//     * @return String
//     */
//    @RequestMapping("/payOperation")
//    @ResponseBody
//    public String payOperation(Operation operation) {
//        operation.setOperationPayTime(new Date());
//        operation.setOperationPayStatus(1);
//        operationService.updateOperation(operation);
//        return  "success";
//    }


}