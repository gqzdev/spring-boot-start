package com.gqz.providerticket.controller;


import com.gqz.providerticket.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: TicketController
 * @author: ganquanzhong
 * @date: 2019/11/5 17:48
*/

@RestController
public class TicketController {

    @Autowired
    TicketService ticketService;

    @GetMapping("/order")
    public String getTicket(String name){
        return  ticketService.getTicket(name);
    }
}
