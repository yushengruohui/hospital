package com.ys.hospital.service.impl;

import com.ys.hospital.pojo.Client;
import com.ys.hospital.dao.ClientMapper;
import com.ys.hospital.service.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Client)表服务实现类
 *
 * @author yusheng
 * @since 2019-10-09 09:00:06
 */
@Service("clientService")
public class ClientServiceImpl implements ClientService {
    private static final Logger logger = LoggerFactory.getLogger(ClientServiceImpl.class);
    
    @Resource
    private ClientMapper clientMapper;

    /**
     * 查询所有Client信息
     *
     * @return 对象Client列表
     */
    @Override
    public List<Client> queryAllClient() {
        return this.clientMapper.queryAllClient();
    }

    /**
     * 新增Client数据
     *
     * @param client 实例对象
     * @return 是否成功(1：成功|0：失败)
     */
    @Override
    public int insertClient(Client client) {
        return this.clientMapper.insertClient(client);
    }

    /**
     * 修改Client数据
     *
     * @param client 实例对象
     * @return 是否成功(1：成功|0：失败)
     */
    @Override
    public int updateClient(Client client) {
        return this.clientMapper.updateClient(client);
    }

    /**
     * 通过主键删除Client数据
     *
     * @param clientId 主键
     * @return 是否成功(1：成功|0：失败)
     */
    @Override
    public int deleteClientById(Integer clientId) {
        return this.clientMapper.deleteClientById(clientId);
    }
}