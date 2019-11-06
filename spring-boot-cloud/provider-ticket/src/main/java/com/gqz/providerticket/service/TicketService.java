package com.gqz.providerticket.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * 售票服务
 * @ClassName: TicketService
 * @author: ganquanzhong
 * @date: 2019/11/5 17:46
 */

@Service
public class TicketService {

    @Value("${server.port}")
    private String port;

    public String getTicket(String name){
        System.out.println("调用服务:"+port);
        return name+"订购了《厉害了，我的国》";
    }
}
