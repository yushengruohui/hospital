package com.ys.hospital.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.ys.hospital.pojo.Bed;
import com.ys.hospital.service.BedService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @RequestMapping("/test")
    public String testDome() {
        logger.info("testDome success");
        return "redirect:/";
    }

    /*
    查询所有bed信息
     */
    @RequestMapping("/queryAllBed")
    public String queryAllBed(Model model){
        List<Bed> beds=bedService.queryAllBed();
        model.addAttribute("beds",beds);
        logger.info("queryAllBed success!");

        return "/nurse/bed_list";
    }

    /*
    根据实体类Bed的相关属性查询实体类Bed
     */
    @RequestMapping("/queryBedByParam")
    public String queryBedByParam(Bed bed,Model model){
        List<Bed> beds=bedService.queryBedByParam(bed) ;
        model.addAttribute("beds",beds);
        logger.info("queryBedByParam success!");

        return "/nurse/bed_list";
    }

    /**
     * 转移到添加页面
     * @return
     */
    @RequestMapping("/toInsertBed")
    public String toInsertBed(){
        return "/nurse/bed_insert";
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
            return "redirect:/nurse/bed_list";
        }
        logger.info("insertBed success!");
        return "redirect:/nurse/bed_insert";
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

        return "/nurse/bed_update";
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
        return "redirect:/nurse/bed_update";
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
        return "/nurse/inpatient_insert";
    }*/
}