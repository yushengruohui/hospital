package com.ys.hospital.controller;

import com.ys.hospital.pojo.OperationNotify;
import com.ys.hospital.service.OperationNotifyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * (OperationNotify)表控制层
 *
 * @author yusheng
 * @since 2019-10-10 08:09:40
 */
@Controller
@RequestMapping("/operationNotify")
public class OperationNotifyController {
    private static final Logger logger = LoggerFactory.getLogger(OperationNotifyController.class);

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
    @RequestMapping("/findoperationNotify")
    public ModelAndView findoperatioNotifyn() {
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("operation/findOperationNotify");
        return modelAndView;
    }
    /**
     * 查找所有手术通知
     * @return ModelAndView
     */
    @RequestMapping("/queryAllOperationNotify")
    @ResponseBody
    public List<OperationNotify> queryAllOperationNotify() {
        List<OperationNotify> operationNotifys = operationNotifyService.queryAllOperationNotify();
        return operationNotifys;
    }
}