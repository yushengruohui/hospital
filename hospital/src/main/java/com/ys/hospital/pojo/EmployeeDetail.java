package com.ys.hospital.pojo;

import java.util.Date;
import java.io.Serializable;
import lombok.Data;

/**
 * (EmployeeDetail)实体类
 *
 * @author yusheng
 * @since 2019-09-26 10:43:45
 */
@Data
public class EmployeeDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Integer employeeDetailId;
    
    private String employeeDetailGender;
    
    private Date employeeDetailBirthday;
    
    private String employeeDetailAddress;
    
    private String employeeDetailPhone;
    
    private String employeeDetailIdentity;
    
    private Date employeeDetailEntryTime;
    
    private String employeeDetailEmail;
    
    private String employeeDetailDescript;
    //1:在职；0：离职
    private Integer employeeDetailStatus;
    //职称
    private String employeeDetailTitle;
    
    private Integer employeeId;
    
    private Integer positionId;
    
    private Integer branchId;
    
}