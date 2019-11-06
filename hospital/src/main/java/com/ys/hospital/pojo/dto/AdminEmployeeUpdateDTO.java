package com.ys.hospital.pojo.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: yusheng
 * @create-time 2019-11-05 09:08
 **/
@Data
public class AdminEmployeeUpdateDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer employeeId;

    private String employeeName;

    private String roleName;

    private String titleName;

    private String branchName;

}
