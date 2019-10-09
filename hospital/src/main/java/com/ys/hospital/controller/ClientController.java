package com.ys.hospital.controller;

import com.ys.hospital.pojo.Client;
import com.ys.hospital.service.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Client)表控制层
 *
 * @author yusheng
 * @since 2019-10-09 09:00:06
 */
@Controller
@RequestMapping("/client")
public class ClientController {
    private static final Logger logger = LoggerFactory.getLogger(ClientController.class);
    
    @Resource
    private ClientService clientService;
    
    @RequestMapping("/test")
    public String testDome() {
        logger.info("testDome success");
        return "redirect:/";
    }
    
    
}