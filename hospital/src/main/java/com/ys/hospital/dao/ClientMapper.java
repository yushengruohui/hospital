package com.ys.hospital.dao;

import com.ys.hospital.pojo.Client;

import java.util.List;

/**
 * (Client)表数据库访问层
 *
 * @author makejava
 * @since 2019-10-03 14:02:15
 */
public interface ClientMapper {
    /**
     * 查询所有用户信息
     *
     * @return
     */
    public List<Client> findAllClient();

    /**
     * 根据用户信息查询用户
     *
     * @param client
     * @return
     */
    public Client findClientByClient(Client client);

    /**
     * 将用户信息存入数据库，并且返回存入的id
     *
     * @param client
     * @return
     */
    public int insertClient(Client client);

    /**
     * 根据用户信息修改用户
     * @param client
     * @return
     */
    public int updateClient(Client client);
}