package com.ys.hospital.pojo;

import java.io.Serializable;

import lombok.Data;

/**
 * (Position)实体类
 *
 * @author yusheng
 * @since 2019-10-10 08:09:40
 */
@Data
public class Position implements Serializable {
    private static final long serialVersionUID = 1L;
    //职位id
    private Integer positionId;
    //职位名称
    private String positionName;

}