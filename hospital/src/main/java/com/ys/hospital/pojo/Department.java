package com.ys.hospital.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * (Department)实体类
 *
 * @author yusheng
 * @since 2019-10-10 08:09:39
 */
@Data
public class Department implements Serializable {
    private static final long serialVersionUID = 1L;
    //科id
    private Integer departmentId;
    //科名
    private String departmentName;

    private List<Branch> branches;
}