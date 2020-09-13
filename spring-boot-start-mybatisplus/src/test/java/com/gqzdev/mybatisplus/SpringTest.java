package com.gqzdev.mybatisplus;

import com.gqzdev.mybatisplus.entity.User;
import com.gqzdev.mybatisplus.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @ClassName SpringTest
 * @Description
 * @Author ganquanzhong
 * @Date2020/9/13 0:00
 * @Version
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
//        Assert.assertEquals(7, userList.size());
        userList.forEach(System.out::println);
    }



}
