package com.ys.hospital.controller;

import com.ys.hospital.pojo.Role;
import com.ys.hospital.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Role)表控制层
 *
 * @author yusheng
 * @since 2019-10-10 08:09:40
 */
@Controller
@RequestMapping("/role")
public class RoleController {
    private static final Logger logger = LoggerFactory.getLogger(RoleController.class);

    @Resource
    private RoleService roleService;

    @RequestMapping("/test")
    public String testDome() {
        logger.info("testDome success");
        return "redirect:/";
    }


}