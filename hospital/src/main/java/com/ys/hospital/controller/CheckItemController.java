package com.ys.hospital.controller;

import com.ys.hospital.pojo.CheckItem;
import com.ys.hospital.service.CheckItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * (CheckItem)表控制层
 *
 * @author yusheng
 * @since 2019-10-10 08:09:39
 */
@RestController
public class CheckItemController {
    private static final Logger logger = LoggerFactory.getLogger(CheckItemController.class);

    @Resource
    private CheckItemService checkItemService;

    @GetMapping("/checkItem/checkItems")
    public String getCheckItems(HttpSession session) {
        List<CheckItem> checkItems = checkItemService.queryAllCheckItem();
        session.setAttribute("checkItems", checkItems);
        return "success";
    }


}