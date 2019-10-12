package com.ys.hospital.service;


import com.ys.hospital.pojo.Client;

import java.util.List;

/**
 * (Client)表服务接口
 *
 * @author makejava
 * @since 2019-10-03 14:02:15
 */
public interface ClientService {

    //查询所有用户信息
    public List<Client> findAllClient();

    /**
     * 根据用户信息查询用户
     *
     * @param client
     * @return
     */
    public Client findClientByClient(Client client);

    /**
     * 将用户信息存入数据库，并且返回存入的信息
     * @param client
     * @return
     */
    public Client insertClient(Client client);
}