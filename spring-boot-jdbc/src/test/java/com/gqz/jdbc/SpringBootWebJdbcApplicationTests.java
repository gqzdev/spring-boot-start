package com.gqz.jdbc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootWebJdbcApplicationTests {

    @Autowired
    DataSource dataSource;

    @Test
    public void contextLoads() throws SQLException {
        //Spring Boot2.0默认使用com.zaxxer.hikari.HikariDataSource作为dataSource
        System.out.println(dataSource.getClass());

        Connection connection = dataSource.getConnection();

        System.out.println(connection);
        connection.close();
    }

}
