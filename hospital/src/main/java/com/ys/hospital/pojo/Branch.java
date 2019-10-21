package com.ys.hospital.pojo;

import java.io.Serializable;

import lombok.Data;

/**
 * (Branch)实体类
 *
 * @author yusheng
 * @since 2019-10-10 08:09:39
 */
@Data
public class Branch implements Serializable {
    private static final long serialVersionUID = 1L;
    //室id
    private Integer branchId;
    //室名
    private String branchName;
    //所属科
    private Integer departmentId;

}