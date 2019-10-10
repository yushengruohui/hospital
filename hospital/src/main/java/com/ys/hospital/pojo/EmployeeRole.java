package com.ys.hospital.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * (EmployeeRole)实体类
 *
 * @author yusheng
 * @since 2019-10-10 08:09:39
 */
@Data
public class EmployeeRole implements Serializable {
    private static final long serialVersionUID = 1L;
    //员工角色表的id
    private Integer employeeRoleId;
    //外键：角色id
    private Integer roleId;
    //外键：员工id
    private Integer employeeId;
    
}