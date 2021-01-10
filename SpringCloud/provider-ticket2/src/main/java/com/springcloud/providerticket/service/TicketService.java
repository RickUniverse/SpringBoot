package com.springcloud.providerticket.service;

import org.springframework.stereotype.Service;

/**
 * @author lijichen
 * @date 2021/1/10 - 19:18
 */
@Service
public class TicketService {


    public Object getTicket() {
        return "你获得了飞往马来西亚的机票";
    }
}
