package com.ys.hospital.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ys.hospital.pojo.Employee;
import com.ys.hospital.pojo.InpatientNotify;
import com.ys.hospital.service.InpatientNotifyService;
import com.ys.hospital.tools.MyPageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * (InpatientNotify)表控制层
 *
 * @author yusheng
 * @since 2019-10-10 08:09:39
 */
@Controller
@RequestMapping("/inpatientNotify")
public class InpatientNotifyController {
    private static final Logger logger = LoggerFactory.getLogger(InpatientNotifyController.class);
    
    @Resource
    private InpatientNotifyService inpatientNotifyService;

    @RequestMapping("/queryInpatientNotifyByParam")
    public String queryInpatientNotifyByParam(InpatientNotify inpatientNotify,Model model){
        List<InpatientNotify> inpatientNotifies=inpatientNotifyService.queryInpatientNotifyByParam(inpatientNotify);
        model.addAttribute("inpatientNotifies", inpatientNotifies);
        return "/inpatient/inpatientNotify_list";
    }

    @GetMapping("/queryInpatientNotifyByStatus")
    @ResponseBody
    public MyPageInfo<InpatientNotify> inpatientNotifies(MyPageInfo<InpatientNotify> myPageInfo,Integer inpatientNotifyStatus){
        List<InpatientNotify> inpatientNotifies=inpatientNotifyService.queryInpatientNotifyByStatus(inpatientNotifyStatus);

        //开启分页
        PageHelper.startPage(myPageInfo.getPage(), myPageInfo.getLimit());

        //处理分页信息
        myPageInfo.setData(inpatientNotifies);
        //将用户数据封装到PageInfo 中
        PageInfo page = new PageInfo(myPageInfo.getData());
        //设置数据数量
        myPageInfo.setCount(page.getPageSize());
        //设置成功代码
        myPageInfo.setCode("0");

        return myPageInfo;
    }

    @GetMapping("/queryAllInpatientNotify")
    @ResponseBody
    public MyPageInfo<InpatientNotify> inpatientNotifies(MyPageInfo<InpatientNotify> myPageInfo){
        List<InpatientNotify> inpatientNotifies=inpatientNotifyService.queryAllInpatientNotify();
        //开启分页
        PageHelper.startPage(myPageInfo.getPage(), myPageInfo.getLimit());

        //处理分页信息
        myPageInfo.setData(inpatientNotifies);
        //将用户数据封装到PageInfo 中
        PageInfo page = new PageInfo(myPageInfo.getData());
        //设置数据数量
        myPageInfo.setCount(page.getPageSize());
        //设置成功代码
        myPageInfo.setCode("0");

        return myPageInfo;
    }
}