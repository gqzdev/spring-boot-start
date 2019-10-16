package com.gqz.springbootcache;

import com.gqz.springbootcache.bean.Employee;
import com.gqz.springbootcache.bean.User;
import com.gqz.springbootcache.mapper.EmployeeMapper;
import com.gqz.springbootcache.utils.SpringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootCacheDemoApplicationTests {

    @Autowired
    EmployeeMapper employeeMapper;


    /*
     * 导入Redis的template操作redis数据库
     *
   */
    @Autowired
    RedisTemplate redisTemplate; //k-v 都是对象

    //注入已经改变默认序列化的redisTemplate
    @Autowired
    RedisTemplate empRedisTemplate;

    @Autowired
    StringRedisTemplate stringRedisTemplate; //操作k-v 都是字符串

    /*  Redis常见的五大数据类型
    *  String(字符串)、List(列表)、Set(集合)、Hash(散列)、ZSet(有序集合)
    *  stringRedisTemplate.opsForValue()  操作String字符串
    *  stringRedisTemplate.opsForList()  操作List列表
    *  stringRedisTemplate.opsForSet()  操作Set集合
    *  stringRedisTemplate.opsForHash()  操作Hash散列
    *  stringRedisTemplate.opsForZSet()  操作ZSet有序集合
    *
    * */


    @Test
    public void testRedis(){
        //给redis中保存数据
        // stringRedisTemplate.opsForValue().append("name","gqzdev");
        String name = stringRedisTemplate.opsForValue().get("name");
        System.out.println(name);
    }

    @Test
    public void testRedisAddObject(){
        //给redis中保存对象数据 使用RedisTemplate
        Employee employee = employeeMapper.getEmpById(1);
        //序列化的问题
        /*
         *  1.将数据以JSON的方式存入
         *      （1）自己将对象转换为json格式，使用json工具
         *      （2）redisTemplate默认的序列化规则（jdk的序列化规则）；JdkSerializationRedisSerializer
         *              改变为对象的序列化
         */
        //redisTemplate.opsForValue().set("emp-01",employee);
        //使用Json序列化的RedisTemplate
        empRedisTemplate.opsForValue().set("emp_"+1,employee);

    }

    @Test
    public void contextLoads() {

        Employee employee = employeeMapper.getEmpById(1);
        System.out.println(employee.toString());

    }

    @Test
    public void getUser(){
        ApplicationContext applicationContext = SpringUtils.getApplicationContext();
        User user = (User) applicationContext.getBean("user");
        System.out.println(user.toString());
    }

    @Test
    public void getUser1(){
        System.out.println(((User) SpringUtils.getObject("user")).toString());
    }

    @Test
    public void getUser2(){

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(User.class);
        System.out.println("spring上下文"+applicationContext);
        String[] names = applicationContext.getBeanDefinitionNames();
        for (String name:names) {
            System.out.println(name);
        }


    }




}
