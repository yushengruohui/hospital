package com.ys.hospital.tools;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Description:该类用于layui的分页
 * @author: yusheng
 * @create-date: 2019-10-12 16:44
 **/
@Data
public class MyPageInfo<T> implements Serializable {
    int page;//起始页
    int limit;//页数大小
    int count;//数据数量
    String code;//代码
    String msg;//信息
    List<T> data;//返回数据
    T example;//任何类型条件
}
