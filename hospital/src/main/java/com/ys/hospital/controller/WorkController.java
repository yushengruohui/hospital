package com.ys.hospital.controller;

import com.ys.hospital.pojo.Employee;
import com.ys.hospital.pojo.Room;
import com.ys.hospital.pojo.Work;
import com.ys.hospital.pojo.WorkTime;
import com.ys.hospital.service.RoomService;
import com.ys.hospital.service.WorkService;
import com.ys.hospital.service.WorkTimeService;
import org.apache.ibatis.javassist.expr.NewExpr;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * (Work)表控制层
 *
 * @author yusheng
 * @since 2019-10-13 12:13:44
 */
@Controller
@RequestMapping("/work")
public class WorkController {
    private static final Logger logger = LoggerFactory.getLogger(WorkController.class);

    @Resource
    private WorkService workService;
    @Resource
    private WorkTimeService workTimeService;
    @Resource
    private RoomService roomService;

    @RequestMapping("/test")
    public String testDome() {
        logger.info("testDome success");
        return "redirect:/";
    }

    /**
     * 根据workId修改一天可预约人数
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/updateWorkDetailByWorkId")
    public String updateWorkDetailByWorkId(Work work) {
        work.setWorkId(1);
        //根据workId查询work信息
        List<Work> works = workService.queryWorkByParam(work);
        //设置要安排预约的人数，只能是14的倍数
        work.setWorkDeal(14);
        //将要修改的预约人数平均分为14个时间段
        int workTimeNum = work.getWorkDeal() / 14;
        //原本每个时间段能预约多少人
        int oldTimeNum = works.get(0).getWorkDeal() / 14;
        //如果要设置的参数比原本的大，直接修改
        if (work.getWorkDeal() > works.get(0).getWorkDeal()) {
            //修改预约人数
            int flag = workService.updateWork(work);
            if (flag > 0) {
                //根据workId查询workTime数据
                WorkTime workTime = new WorkTime();
                workTime.setWorkId(work.getWorkId());
                List<WorkTime> workTimes = workTimeService.queryWorkTimeByParam(workTime);
                if (workTimes.isEmpty()) {
                    return "对应的值班时间段没数据";
                } else {
                    //每个时间段可以增加几个预约源
                    int addNum = workTimeNum - oldTimeNum;
                    //修改预约时间详情表各个时间段的数据
                    workTime.setWorkTimeId(workTimes.get(0).getWorkTimeId());
                    workTime.setWorkTime1(workTimes.get(0).getWorkTime1() + addNum);
                    workTime.setWorkTime2(workTimes.get(0).getWorkTime2() + addNum);
                    workTime.setWorkTime3(workTimes.get(0).getWorkTime3() + addNum);
                    workTime.setWorkTime4(workTimes.get(0).getWorkTime4() + addNum);
                    workTime.setWorkTime5(workTimes.get(0).getWorkTime5() + addNum);
                    workTime.setWorkTime6(workTimes.get(0).getWorkTime6() + addNum);
                    workTime.setWorkTime7(workTimes.get(0).getWorkTime7() + addNum);
                    workTime.setWorkTime8(workTimes.get(0).getWorkTime8() + addNum);
                    workTime.setWorkTime9(workTimes.get(0).getWorkTime9() + addNum);
                    workTime.setWorkTime10(workTimes.get(0).getWorkTime10() + addNum);
                    workTime.setWorkTime11(workTimes.get(0).getWorkTime11() + addNum);
                    workTime.setWorkTime12(workTimes.get(0).getWorkTime12() + addNum);
                    workTime.setWorkTime13(workTimes.get(0).getWorkTime13() + addNum);
                    workTime.setWorkTime14(workTimes.get(0).getWorkTime14() + addNum);
                    //修改预约时间详情表
                    int updateSuccess = workTimeService.updateWorkTime(workTime);
                    if (updateSuccess > 0) {
                        //修改成功，返回页面
                        return "修改成功";
                    } else {
                        return "修改失败，请稍后再试";
                    }
                }
            } else {
                return "修改失败，请稍后再试";
            }
        } else if (work.getWorkDeal() == works.get(0).getWorkDeal()) {
            //如果传入的预约源与原本的相同
            return "修改成功";
        } else {
            //如果传入的预约源比原本的小
            int reduceWorkTime = oldTimeNum - workTimeNum;
            WorkTime updateWorkTime = new WorkTime();
            updateWorkTime.setWorkId(work.getWorkId());
            //根据workId查询预约时间段详情表信息
            WorkTime oldWorkTime = workTimeService.queryWorkTimeByParam(updateWorkTime).get(0);
            //判断原本的每一个预约时间段的预约源-要减少的预约原（>=0，修改;<0 不修改）
            int resultWorkTime1 = oldWorkTime.getWorkTime1() - reduceWorkTime;
            int resultWorkTime2 = oldWorkTime.getWorkTime2() - reduceWorkTime;
            int resultWorkTime3 = oldWorkTime.getWorkTime3() - reduceWorkTime;
            int resultWorkTime4 = oldWorkTime.getWorkTime4() - reduceWorkTime;
            int resultWorkTime5 = oldWorkTime.getWorkTime5() - reduceWorkTime;
            int resultWorkTime6 = oldWorkTime.getWorkTime6() - reduceWorkTime;
            int resultWorkTime7 = oldWorkTime.getWorkTime7() - reduceWorkTime;
            int resultWorkTime8 = oldWorkTime.getWorkTime8() - reduceWorkTime;
            int resultWorkTime9 = oldWorkTime.getWorkTime9() - reduceWorkTime;
            int resultWorkTime10 = oldWorkTime.getWorkTime10() - reduceWorkTime;
            int resultWorkTime11 = oldWorkTime.getWorkTime11() - reduceWorkTime;
            int resultWorkTime12 = oldWorkTime.getWorkTime12() - reduceWorkTime;
            int resultWorkTime13 = oldWorkTime.getWorkTime13() - reduceWorkTime;
            int resultWorkTime14 = oldWorkTime.getWorkTime14() - reduceWorkTime;
            if (resultWorkTime1 >= 0 && resultWorkTime2 >= 0 && resultWorkTime3 >= 0 && resultWorkTime4 >= 0 && resultWorkTime5 >= 0 && resultWorkTime6 >= 0 && resultWorkTime7 >= 0 && resultWorkTime8 >= 0 && resultWorkTime9 >= 0 && resultWorkTime10 >= 0 && resultWorkTime11 >= 0 && resultWorkTime12 >= 0 && resultWorkTime13 >= 0 && resultWorkTime14 >= 0) {
                //修改预约时间详情表
                updateWorkTime.setWorkTime1(resultWorkTime1);
                updateWorkTime.setWorkTime2(resultWorkTime2);
                updateWorkTime.setWorkTime3(resultWorkTime3);
                updateWorkTime.setWorkTime4(resultWorkTime4);
                updateWorkTime.setWorkTime5(resultWorkTime5);
                updateWorkTime.setWorkTime6(resultWorkTime6);
                updateWorkTime.setWorkTime7(resultWorkTime7);
                updateWorkTime.setWorkTime8(resultWorkTime8);
                updateWorkTime.setWorkTime9(resultWorkTime9);
                updateWorkTime.setWorkTime10(resultWorkTime10);
                updateWorkTime.setWorkTime11(resultWorkTime11);
                updateWorkTime.setWorkTime12(resultWorkTime12);
                updateWorkTime.setWorkTime13(resultWorkTime13);
                updateWorkTime.setWorkTime14(resultWorkTime14);
                updateWorkTime.setWorkTimeId(oldWorkTime.getWorkTimeId());
                //修改
                int updateSuccess = workTimeService.updateWorkTime(updateWorkTime);
                if (updateSuccess > 0) {
                    //修改work表
                    Work work1 = new Work();
                    work1.setWorkId(work.getWorkId());
                    Work updateWork = workService.queryWorkByParam(work1).get(0);
                    updateWork.setWorkDeal(work.getWorkDeal());
                    int updateResult = workService.updateWork(updateWork);
                    if (updateResult > 0) {
                        return "修改成功";
                    } else {
                        return "修改失败，请稍后再试";
                    }
                } else {
                    return "修改失败，请稍后再试";
                }
            } else {
                return "当天预约人数较多，无法减少预约源";
            }
        }
    }

    /**
     * 根据员工Id获取其从现在到以后七天的工作安排表
     *
     * @return 值班安排列表
     */
    @ResponseBody
    @GetMapping("/works")
    public List<Work> getWorkList(HttpSession session) {
        //获取登录医师的Id
        Employee employee = (Employee) session.getAttribute("employee");
        //根据医师Id查询值班安排
        List<Work> works = workService.findWorkListByEmployeeId(2019009);
        int roomId;
        Room room = new Room();
        //根据所在roomId查询room信息
        for (int i = 0; i < works.size(); i++) {
            roomId = works.get(i).getRoomId();
            room.setRoomId(roomId);
            //获取诊室信息将其注入值班安排中
            works.get(i).setRoom(roomService.queryRoomByParam(room).get(0));
        }
        return works;
    }

    /**
     * 根据workId查询workTime信息
     *
     * @param workId
     * @return 时间段详情
     */
    public WorkTime getWorkTimeByWorkId(Integer workId) {
        WorkTime workTime = new WorkTime();
        workTime.setWorkId(workId);
        workTime = workTimeService.queryWorkTimeByParam(workTime).get(0);

        return workTime;
    }


}