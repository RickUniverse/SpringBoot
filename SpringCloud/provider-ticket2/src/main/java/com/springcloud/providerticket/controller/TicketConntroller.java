package com.springcloud.providerticket.controller;

import com.springcloud.providerticket.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lijichen
 * @date 2021/1/10 - 19:19
 */
@RestController
public class TicketConntroller {

    @Autowired
    private TicketService ticketService;

    @GetMapping("/getTicket")
    public Object getTicket() {
        return ticketService.getTicket();
    }

}
