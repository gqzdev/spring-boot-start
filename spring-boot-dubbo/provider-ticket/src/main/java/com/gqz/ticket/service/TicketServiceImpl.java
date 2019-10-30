package com.gqz.ticket.service;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

/**
 * @ClassName: TicketServiceImpl
 * @author: ganquanzhong
 * @date: 2019/10/30 9:43
 */


@Component
@Service(version = "1.0.0")  //Dubbo的注解，将服务发布出去
public class TicketServiceImpl implements TicketService {

    @Override
    public String getTicket(String name) {
        return name+"成功订购《银河补习班》电影票";
    }
}
