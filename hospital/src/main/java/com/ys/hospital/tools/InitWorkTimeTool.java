package com.ys.hospital.tools;

import com.ys.hospital.pojo.Employee;
import com.ys.hospital.pojo.Room;
import com.ys.hospital.pojo.Work;
import com.ys.hospital.pojo.WorkTime;
import com.ys.hospital.service.EmployeeService;
import com.ys.hospital.service.RoomService;
import com.ys.hospital.service.WorkService;
import com.ys.hospital.service.WorkTimeService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

//初始化员工的值班信息
@Component("initWorkTimeTool")
public class InitWorkTimeTool {


    //    @SuppressWarnings("rawtypes")
    @Resource
    private EmployeeService employeeService;
    //    @SuppressWarnings("rawtypes")
    @Resource
    private RoomService roomService;
    //    @SuppressWarnings("rawtypes")
    @Resource
    private WorkService workService;
    //    @SuppressWarnings("rawtypes")
    @Resource
    private WorkTimeService workTimeService;

    /**
     * 初始化医师七天的值班时间安排
     *
     * @param employeeId（医师Id）
     * @return （0：失败；1：成功）
     */
//    @SuppressWarnings("unchecked")
    public int initWorkTime(Integer employeeId) {
        //根据员工Id判断其职位
        Employee employee = employeeService.getEmployeeByEmployeeId(employeeId);
        //如果职位为主治医师/主任医师，初始化工作安排表
        if (employee.getEmployeeDetail().getTitleId() == 1 || employee.getEmployeeDetail().getTitleId() == 2) {
            //实例化工作安排表
            Work work = new Work();
            WorkTime workTime = new WorkTime();
            //获取诊室列表
            Room room = new Room();
            room.setBranchId(employee.getEmployeeDetail().getBranchId());
            //获取科目下面的诊室列表
            List<Room> rooms = roomService.getConsultingRooms(room.getBranchId());
            //获取一周星期与日期
            //获取今天日期和星期几
            Calendar calendar = Calendar.getInstance();
            String[] weekDays = {"7", "1", "2", "3", "4", "5", "6"};
            //插入7条数据
            for (int i = 0; i < 7; i++) {
                Calendar workDate = Calendar.getInstance();
                workDate.add(Calendar.DATE, i);
                //时间
                work.setWorkDate(workDate.getTime());
                Calendar week = Calendar.getInstance();
                week.setTime(workDate.getTime());
                //星期
                work.setWorkWeek(week.get(Calendar.DAY_OF_WEEK) - 1);
                //医师id
                work.setEmployeeId(employee.getEmployeeId());
                //上下午值班
                work.setWorkMorning(1);
                work.setWorkAfternoon(1);
                work.setWorkDeal(28);
                //随机分配房间
                work.setRoomId(rooms.get(new Random().nextInt(rooms.size())).getRoomId());
                int flag = workService.insertWork(work);
                if (flag < 1) {
                    System.out.println("插入值班安排失败");
                } else {
                    //给时间段信息赋值
                    workTime.setWorkTime1(2);
                    workTime.setWorkTime2(2);
                    workTime.setWorkTime3(2);
                    workTime.setWorkTime4(2);
                    workTime.setWorkTime5(2);
                    workTime.setWorkTime6(2);
                    workTime.setWorkTime7(2);
                    workTime.setWorkTime8(2);
                    workTime.setWorkTime9(2);
                    workTime.setWorkTime10(2);
                    workTime.setWorkTime11(2);
                    workTime.setWorkTime12(2);
                    workTime.setWorkTime13(2);
                    workTime.setWorkTime14(2);
                    workTime.setWorkId(work.getWorkId());
                    workTime.setWorkId(work.getWorkId());
                    //添加值班时间段信息
                    int success = workTimeService.insertWorkTime(workTime);
                    if (success < 1) {
                        System.out.println("===== 添加值班时间段信息 =====");
                    } else {
                        System.out.println("===== 值班信息更新完成 =====");
                    }
                }
            }
            return 1;
        } else {
            System.out.println("兄弟你错了，插入失败了");
            return 0;
        }
    }
}
