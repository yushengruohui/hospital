package com.ys.hospital.service;

import com.ys.hospital.pojo.Client;
import java.util.List;

/**
 * (Client)表服务接口
 *
 * @author yusheng
 * @since 2019-10-10 08:09:39
 */
public interface ClientService {

    /**
     * 查询所有Client信息
     *
     * @return 实例对象
     */
    List<Client> queryAllClient();

    /**
     * 新增数据
     *
     * @param client 实例对象
     * @return 实例对象
     */
    int insertClient(Client client);

    /**
     * 修改数据
     *
     * @param client 实例对象
     * @return 实例对象
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