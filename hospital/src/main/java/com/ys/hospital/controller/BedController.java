package com.ys.hospital.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ys.hospital.pojo.Bed;
import com.ys.hospital.service.BedService;
import com.ys.hospital.tools.MyPageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Bed)表控制层
 *
 * @author yusheng
 * @since 2019-10-10 08:09:39
 */
@Controller
@RequestMapping("/bed")
public class BedController {
    private static final Logger logger = LoggerFactory.getLogger(BedController.class);
    
    @Resource
    private BedService bedService;

    @GetMapping("/queryAllBed")
    @ResponseBody
    public MyPageInfo<Bed> beds(MyPageInfo<Bed> myPageInfo){
        List<Bed> beds=bedService.queryAllBed();
        //开启分页
        PageHelper.startPage(myPageInfo.getPage(), myPageInfo.getLimit());

        //处理分页信息
        myPageInfo.setData(beds);
        //将用户数据封装到PageInfo 中
        PageInfo page = new PageInfo(myPageInfo.getData());
        //设置数据数量
        myPageInfo.setCount(page.getPageSize());
        //设置成功代码
        myPageInfo.setCode("0");

        return myPageInfo;
    }

    @GetMapping("/queryBedByStatus")
    @ResponseBody
    public MyPageInfo<Bed> beds(MyPageInfo<Bed> myPageInfo,Integer bedStatus){
        List<Bed> beds=bedService.queryBedByStatus(bedStatus);
        //开启分页
        PageHelper.startPage(myPageInfo.getPage(), myPageInfo.getLimit());

        //处理分页信息
        myPageInfo.setData(beds);
        //将用户数据封装到PageInfo 中
        PageInfo page = new PageInfo(myPageInfo.getData());
        //设置数据数量
        myPageInfo.setCount(page.getPageSize());
        //设置成功代码
        myPageInfo.setCode("0");

        return myPageInfo;
    }

    @RequestMapping("/queryBedByStatu")
    @ResponseBody
    public List<Bed> queryBedByStatu(Integer bedStatus){
        List<Bed> beds=bedService.queryBedByStatus(bedStatus);
        return beds;
    }
    /*
    根据实体类Bed的相关属性查询实体类Bed
     */
    @RequestMapping("/queryBedByParam")
    public String queryBedByParam(Bed bed,Model model){
        List<Bed> beds=bedService.queryBedByParam(bed) ;
        model.addAttribute("beds",beds);
        logger.info("queryBedByParam success!");

        return "/inpatient/bed_list";
    }

    /**
     * 转移到添加页面
     * @return
     */
    @RequestMapping("/toInsertBed")
    public String toInsertBed(){
        return "/inpatient/bed_insert";
    }

    /**
     * 添加床位信息
     * @param bed
     * @return
     */
    @RequestMapping("/insertBed")
    public String insertBed(Bed bed){
        int count=bedService.insertBed(bed);
        if(count>0){
            return "redirect:/inpatient/bed_list";
        }
        logger.info("insertBed success!");
        return "redirect:/inpatient/bed_insert";
    }
    /*
    根据bedID查询床位信息，返回修改界面
     */
    @RequestMapping("/toUpdateBed")
    public String toUpdateBed(int bedId,Model model){
        List<Bed> beds=bedService.findBedById(bedId);
//        System.out.println(bedId);
        model.addAttribute("beds",beds);
        logger.info("findBedById success!");

        return "/inpatient/bed_update";
    }
    /*
    修改Bed数据
     */
    @RequestMapping("/updateBed")
    public String updateBed(Bed bed){
        int count=bedService.updateBed(bed);
        logger.info("updateBed success!");
        if(count>0){
            return "redirect:/bed/queryAllBed";
        }
        return "redirect:/inpatient/bed_update";
    }

    @RequestMapping("/deleteBed")
    public String deleteBedById(Integer bedId){
        int count=bedService.deleteBedById(bedId);
        if(count>0){
            return "redirect:/bed/queryAllBed";
        }
        logger.info("deleteBedById success!");
        return "redirect:/bed/queryAllBed";
    }

    /**
     * 获取所有空闲状态病床
     * @param bedStatus
     * @return
     */
    /*@RequestMapping("/queryBedByStatus")
    public String queryBedByStatus(Integer bedStatus,Model model){
        List<Bed> beds=bedService.queryBedByStatus(bedStatus);
        model.addAttribute("beds",beds);
        return "/inpatient/inpatient_insert";
    }*/
}