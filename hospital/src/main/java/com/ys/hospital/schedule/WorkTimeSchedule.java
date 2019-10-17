package com.ys.hospital.schedule;

import com.ys.hospital.pojo.Employee;
import com.ys.hospital.pojo.Room;
import com.ys.hospital.pojo.Work;
import com.ys.hospital.pojo.WorkTime;
import com.ys.hospital.service.EmployeeService;
import com.ys.hospital.service.RoomService;
import com.ys.hospital.service.WorkService;
import com.ys.hospital.service.WorkTimeService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.*;

/**
 * 定时任务，每天更新每位医师的值班信息
 *
 * @Description:
 * @author: yusheng
 * @create-date: 2019-10-12 11:21
 **/
@Component
public class WorkTimeSchedule {
    @Resource
    private EmployeeService employeeService;
    @Resource
    private RoomService roomService;
    @Resource
    private WorkService workService;
    @Resource
    private WorkTimeService workTimeService;

    @Scheduled(cron = ("0 0 0 * * 1-7"))
    public void work() {

        System.out.println("我不懂");
        //查出医院所有在职的医师
        List<Employee> employees = employeeService.getDoctorEmployees();
        //如果查询出来的数据为空
        if (employees.size() < 1) {
            System.out.println("===== 没有相关医师信息 =====");
        } else {
            //新建一个值班信息,值班时间段,诊室列表,诊室实例
            Work work = new Work();
            WorkTime workTime = new WorkTime();
            List<Room> rooms = new ArrayList<>();
            Room room = new Room();
            //获取今天日期和星期几
            Calendar workDate = Calendar.getInstance();
//            SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
            workDate.add(Calendar.DATE, 6);
//            String workDate = sdf2.format(calendar2.getTime());
            String[] weekDays = {"7", "1", "2", "3", "4", "5", "6"};
            Calendar calendar = Calendar.getInstance();
            for (int i = 0; i < employees.size(); i++) {
                //给值班信息赋值
                work.setWorkWeek(Integer.valueOf(weekDays[calendar.get(Calendar.DAY_OF_WEEK) - 2]));
                work.setEmployeeId(employees.get(i).getEmployeeId());
                //根据医师所在branch查询其所属的roomId
                room.setBranchId(employees.get(i).getEmployeeDetail().getBranchId());
                rooms = roomService.queryRoomByParam(room);
                //如果没有诊室信息
                if (rooms.size() < 1) {
                    System.out.println("===== 我这种情况不可能出现的 =====");
                } else {
                    //随机分配房间
                    work.setRoomId(rooms.get(new Random().nextInt(rooms.size())).getRoomId());
                }
                work.setWorkAfternoon(1);
                work.setWorkMorning(1);
                work.setWorkDeal(28);
                work.setWorkDate(workDate.getTime());
                //添加值班表信息
                int flag = workService.insertWork(work);
                //添加值班信息失败
                if (flag < 1) {
                    System.out.println("===== 添加值班信息失败 =====");
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
                    //添加值班时间段信息
                    int success = workTimeService.insertWorkTime(workTime);
                    if (success < 1) {
                        System.out.println("===== 添加值班时间段信息 =====");
                    } else {
                        System.out.println("===== 值班信息更新完成 =====");

                    }
                }
            }

        }

    }
}
