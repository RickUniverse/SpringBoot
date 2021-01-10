package com.dubbo.providerticket.service;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

/**
 * @author lijichen
 * @date 2021/1/10 - 17:12
 */
@Component//放入ioc容器中
@Service//将服务发布出去
public class TicketServiceImp implements TicketService{
    @Override
    public Object makeTicket() {
        return "获取票，远程调用成功了！！！！！";
    }
}
