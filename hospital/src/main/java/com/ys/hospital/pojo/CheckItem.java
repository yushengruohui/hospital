package com.ys.hospital.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * (CheckItem)实体类
 *
 * @author yusheng
 * @since 2019-10-10 08:09:39
 */
@Data
public class CheckItem implements Serializable {
    private static final long serialVersionUID = 1L;
    //固定的检查项目
    private Integer checkItemId;
    //检查项目名
    private String checkItemName;
    //检查项目价格
    private Double checkItemPrice;
    //对应检查室
    private Integer roomId;
    
}