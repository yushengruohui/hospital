package com.ys.hospital.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * (Work)实体类
 *
 * @author yusheng
 * @since 2019-09-26 10:43:46
 */
@Data
public class Work implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Integer workId;
    //1-7:代表星期一到星期日
    private Integer workWeek;
    
    private Integer employeeId;
    //1：上班；0：不上班
    private Integer workMorning;
    //1：上班；0：不上班
    private Integer workAfternoon;
    
    private Integer roomId;
    //可预约人数
    private Integer workDeal;
    
}