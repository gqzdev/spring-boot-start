package com.gqz.user.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.gqz.ticket.service.TicketService;
import org.springframework.stereotype.Service;

/**
 * 调用远程RPC  Remote Procedure Call
 * 调用com.gqz.ticket.service.TicketService中的服务
 *
 * @ClassName: UserService
 * @author: ganquanzhong
 * @date: 2019/10/30 9:48
 */

@Service
public class UserService {

    /**
     * @Reference注解 通过 @Reference 注入TicketService
     *  是通过全类名引用
     */
    @Reference(version = "1.0.0", url = "dubbo://127.0.0.1:12345")
    TicketService ticketService;

    //调用远程接口的服务
    public void orderTicket(String name){
        System.out.println(ticketService.getTicket(name));
    }

}
