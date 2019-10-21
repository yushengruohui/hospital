package com.ys.hospital.pojo;

import java.io.Serializable;

import lombok.Data;

/**
 * (Title)实体类
 *
 * @author yusheng
 * @since 2019-10-10 08:09:40
 */
@Data
public class Title implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer titleId;
    //职称
    private String titleName;

}