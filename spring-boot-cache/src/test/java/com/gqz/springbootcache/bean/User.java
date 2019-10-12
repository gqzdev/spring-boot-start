package com.gqz.springbootcache.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @ClassName: User
 * @author: ganquanzhong
 * @date: 2019/10/11 13:45
 */

@Configuration
//@ConfigurationProperties(prefix="gqz")
@PropertySource("classpath:user.properties")
@ConfigurationProperties(prefix = "user")
public class User {

    private Integer uid;
    private String username;
    private String password;

    public User() {
    }


    public User(Integer uid, String username, String password) {
        this.uid = uid;
        this.username = username;
        this.password = password;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Bean
    public User user2(){
        return new User(12,"w","w");
    }
}
