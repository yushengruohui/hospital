package com.ys.hospital.pojo.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: yusheng
 * @create-time 2019-11-04 23:19
 **/
@Data
public class EmployeeReportVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private int employeeOnlineNumber;

    private int OnlineNumber;

    private int employeeTotalNumber;

    private int diagnosisNumber;

    private int appointmentNumber;

}
