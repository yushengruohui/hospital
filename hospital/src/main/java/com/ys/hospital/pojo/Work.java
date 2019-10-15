package com.ys.hospital.pojo;

import java.util.Date;
import java.io.Serializable;
import lombok.Data;

/**
 * (Work)实体类
 *
 * @author yusheng
 * @since 2019-10-13 12:13:44
 */
@Data
public class Work implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Integer workId;
    //1-7:代表星期一到星期日
    private Integer workWeek;
    //上班员工id
    private Integer employeeId;
    //1：上班；0：不上班
    private Integer workMorning;
    //1：上班；0：不上班
    private Integer workAfternoon;
    //所在科室id
    private Integer roomId;
    //可预约人数
    private Integer workDeal;
    //工作日期
    private Date workDate;
    //所在的就诊室
    private Room room;
    //所拥有的时间段
    private WorkTime workTime;
}