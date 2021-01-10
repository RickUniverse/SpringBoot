package com.dubbo.user.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dubbo.providerticket.service.TicketService;
import org.springframework.stereotype.Service;

@Service//springioc 注解
public class UserService {

    @Reference
    TicketService ticketService;

    public void hello() {
        Object o = ticketService.makeTicket();
        System.out.println(o);
    }
}
