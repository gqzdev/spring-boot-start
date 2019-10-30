package com.gqz.ticket.service;

/**
 * @ClassName: TicketService
 * @author: ganquanzhong
 * @date: 2019/10/30 9:40
 */
public interface TicketService {

    /**  dubbo中的公共api
     * 获取票
     */
    public String getTicket(String name);
}
