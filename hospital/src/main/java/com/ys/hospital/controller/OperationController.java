package com.ys.hospital.controller;

import com.ys.hospital.pojo.Operation;
import com.ys.hospital.pojo.OperationNotify;
import com.ys.hospital.service.OperationNotifyService;
import com.ys.hospital.service.OperationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
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
    @RequestMapping(value="/findAllOperation",method= RequestMethod.GET)
    @ResponseBody
    public List<Operation> findAllOperation() {
        List<Operation> operations = operationService.queryAllOperations();
        return operations;
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

//    /**
//     *更新该手术
//     * @param operation
//     * @return String
//     */
//    @RequestMapping("/updateOperation")
//    @ResponseBody
//    public String updateOperation(Operation operation) {
//        operationService.updateOperation(operation);
//        return  "success";
//
//    }

    /**
     * 添加手术
     * @param operation
     * @return String
     */
    @PostMapping("/addOperation")
    @ResponseBody
    public String addOperation(@RequestBody Operation operation) {
    operation.setOperationPayStatus(1);
    Integer operationNotifyId=operation.getOperationNotifyId();
    operationService.insertOperation(operation);
    OperationNotify operationNotify=new OperationNotify();
    operationNotify.setOperationNotifyId(operationNotifyId);
    List<OperationNotify> operationNotifies = operationNotifyService.queryOperationNotifyByParam(operationNotify);
    operationNotifies.get(0).setOperationNotifyStatus(1);
    operationNotifyService.updateOperationNotify(operationNotifies.get(0));
    return  "true";
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