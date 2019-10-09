package com.ys.hospital.dao;

import com.ys.hospital.pojo.Client;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Client)表数据库访问层
 *
 * @author yusheng
 * @since 2019-10-09 09:00:06
 */
public interface ClientMapper {

    /**
     * 查询所有Client信息
     *
     * @return 对象Client列表
     */
    List<Client> queryAllClient();


    /**
     * 根据实体类Client的相关属性查询实体类Client
     *
     * @param client 实例对象
     * @return 对象Client列表
     */
    List<Client> queryClientByParam(Client client);

    /**
     * 新增Client数据
     *
     * @param client 实例对象
     * @return 是否成功(1：成功|0：失败)
     */
    int insertClient(Client client);

    /**
     * 修改Client数据
     *
     * @param client 实例对象
     * @return 是否成功(1：成功|0：失败)
     */
    int updateClient(Client client);

    /**
     * 通过主键删除数据
     *
     * @param clientId 主键
     * @return 是否成功(1：成功|0：失败)
     */
    int deleteClientById(Integer clientId);

}