package com.ys.hospital.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * (WorkTime)实体类
 *
 * @author yusheng
 * @since 2019-10-10 08:09:40
 */
@Data
public class WorkTime implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Integer workTimeId;
    //8:00
    private Integer workTime1;
    //8:30
    private Integer workTime2;
    //9:00
    private Integer workTime3;
    //9:30
    private Integer workTime4;
    //10:00
    private Integer workTime5;
    //10:30
    private Integer workTime6;
    //11:00
    private Integer workTime7;
    //11:30
    private Integer workTime8;
    //14:00
    private Integer workTime9;
    //14:30
    private Integer workTime10;
    //15:00
    private Integer workTime11;
    //15:30
    private Integer workTime12;
    //16:00
    private Integer workTime13;
    //16:30
    private Integer workTime14;
    //所属工作表
    private Integer workId;
    
}