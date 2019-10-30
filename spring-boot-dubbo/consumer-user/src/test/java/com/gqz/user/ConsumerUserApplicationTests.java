package com.gqz.user;

import com.gqz.user.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ConsumerUserApplicationTests {

    @Autowired
    UserService userService;

    @Test
    void testRPC() {
        System.out.println("调用RPC provider中的订票业务");
        userService.orderTicket("甘全中-陈蓉-... ");
    }

}
