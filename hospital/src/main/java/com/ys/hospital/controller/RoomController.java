package com.ys.hospital.controller;

import com.ys.hospital.pojo.Room;
import com.ys.hospital.service.RoomService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Room)表控制层
 *
 * @author yusheng
 * @since 2019-10-10 08:09:40
 */
@Controller
@RequestMapping("/room")
public class RoomController {
    private static final Logger logger = LoggerFactory.getLogger(RoomController.class);

    @Resource
    private RoomService roomService;

    @RequestMapping("/test")
    public String testDome() {
        logger.info("testDome success");
        return "redirect:/";
    }

	/**
     * 查找所有病房
     * @return
     */
    @RequestMapping("/findAllRoom")
    @ResponseBody
    public List<Room> findOperationByStatus() {
        List<Room> rooms = roomService.queryAllRoom();
        return rooms;
    }
    
}