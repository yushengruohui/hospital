package com.ys.hospital.service.impl;

import com.ys.hospital.dao.ClientMapper;
import com.ys.hospital.pojo.Client;
import com.ys.hospital.service.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Client)表服务实现类
 *
 * @author makejava
 * @since 2019-10-03 14:02:15
 */
@Service("clientService")
public class ClientServiceImpl implements ClientService {
    private static final Logger logger = LoggerFactory.getLogger(ClientServiceImpl.class);

    @Resource
    private ClientMapper clientMapper;

    @Override
    public List<Client> findAllClient() {
        return clientMapper.findAllClient();
    }

    @Override
    public Client findClientByClient(Client client) {
        return clientMapper.findClientByClient(client);
    }

    @Override
    public Client insertClient(Client client) {
        //获取插入的id
        clientMapper.insertClient(client);
        return client;
    }


}