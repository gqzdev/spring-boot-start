# spring-boot-start-orm-mybatis

> Spring Boot 如何与原生的 mybatis 整合，使用了 mybatis 官方提供的脚手架 `mybatis-spring-boot-starter `可以很容易的和 Spring Boot 整合。

## pom.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <artifactId>spring-boot-start-orm-mybatis</artifactId>
    <version>1.0.0-SNAPSHOT</version>
    <packaging>jar</packaging>

    <name>spring-boot-start-orm-mybatis</name>
    <description>Demo project for Spring Boot</description>

    <parent>
        <groupId>com.gqzdev</groupId>
        <artifactId>spring-boot-start</artifactId>
        <version>1.0.0-SNAPSHOT</version>
    </parent>

    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
        <java.version>1.8</java.version>
        <mybatis.version>1.3.2</mybatis.version>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.mybatis.spring.boot</groupId>
            <artifactId>mybatis-spring-boot-starter</artifactId>
            <version>${mybatis.version}</version>
        </dependency>

        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
        </dependency>

        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>

        <dependency>
            <groupId>cn.hutool</groupId>
            <artifactId>hutool-all</artifactId>
        </dependency>

        <dependency>
            <groupId>com.google.guava</groupId>
            <artifactId>guava</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <finalName>spring-boot-demo-orm-mybatis</finalName>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>

</project>
```

## SpringBootDemoOrmMybatisApplication.java

```java
/**
 *
 * Spring Boot整合MyBatis
 *      在application.properties或yml中配置mybatis的映射文件mapper.xml ，别名，等
 *      添加@MapperScan注解，扫描mapper接口
 *
 * @Author: ganquanzhong
 * @Date:  2020/6/17 18:01
 */

@MapperScan(basePackages = {"com.gqzdev.orm.mybatis.mapper"})
@SpringBootApplication
public class OrmMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrmMybatisApplication.class, args);
    }
}
```

## application.yml

```yaml
spring:
  datasource:
    url: jdbc:mysql://127.0.0.1:3306/spring-boot-start?useUnicode=true&characterEncoding=UTF-8&useSSL=false&autoReconnect=true&failOverReadOnly=false&serverTimezone=GMT%2B8
    username: root
    password: root
    driver-class-name: com.mysql.cj.jdbc.Driver
    type: com.zaxxer.hikari.HikariDataSource
    initialization-mode: always
    continue-on-error: true
    schema:
    - "classpath:db/schema.sql"
    data:
    - "classpath:db/data.sql"
    hikari:
      minimum-idle: 5
      connection-test-query: SELECT 1 FROM DUAL
      maximum-pool-size: 20
      auto-commit: true
      idle-timeout: 30000
      pool-name: SpringBootDemoHikariCP
      max-lifetime: 60000
      connection-timeout: 30000
logging:
  level:
    com.gqzdev: debug
    com.gqzdev.orm.mybatis.mapper: trace
mybatis:
  configuration:
    # 下划线转驼峰
    map-underscore-to-camel-case: true
  # mapper文件
  mapper-locations: classpath:mappers/*.xml
  # 配置别名
  type-aliases-package: com.gqzdev.orm.mybatis.entity

```

## UserMapper.java

```java
/**
 *   UserMapper   接口 动态代理
 * 
 *   可以使用注解的形式
 *       使用Mapper xml文件
 * @Author: ganquanzhong
 * @Date:  2020/6/17 18:05 
 */  
  
@Mapper
@Component
public interface UserMapper {

    /**
     * 查询所有用户
     *
     * @return 用户列表
     */
    @Select("SELECT * FROM orm_user")
    List<User> selectAllUser();

    /**
     * 根据id查询用户
     *
     * @param id 主键id
     * @return 当前id的用户，不存在则是 {@code null}
     */
    @Select("SELECT * FROM orm_user WHERE id = #{id}")
    User selectUserById(@Param("id") Long id);

    /**
     * 保存用户
     *
     * @param user 用户
     * @return 成功 - {@code 1} 失败 - {@code 0}
     */
    int saveUser(@Param("user") User user);

    /**
     * 删除用户
     *
     * @param id 主键id
     * @return 成功 - {@code 1} 失败 - {@code 0}
     */
    int deleteById(@Param("id") Long id);
}
```

## UserMapper.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.gqzdev.orm.mybatis.mapper.UserMapper">

    <insert id="saveUser">
        INSERT INTO `orm_user` (`name`,
                                `password`,
                                `salt`,
                                `email`,
                                `phone_number`,
                                `status`,
                                `create_time`,
                                `last_login_time`,
                                `last_update_time`)
        VALUES (#{user.name},
                #{user.password},
                #{user.salt},
                #{user.email},
                #{user.phoneNumber},
                #{user.status},
                #{user.createTime},
                #{user.lastLoginTime},
                #{user.lastUpdateTime})
    </insert>

    <delete id="deleteById">
        DELETE
        FROM `orm_user`
        WHERE `id` = #{id}
    </delete>
</mapper>

```

## UserMapperTest.java

```java
/**
 *
 * UserMapper 测试类
 */
@Slf4j
public class UserMapperTest extends OrmMybatisApplicationTests {
    @Autowired
    private UserMapper userMapper;

    /**
     * 测试查询所有
     */
    @Test
    public void selectAllUser() {
        List<User> userList = userMapper.selectAllUser();
        Assert.assertTrue(CollUtil.isNotEmpty(userList));
        log.debug("【userList】= {}", userList);
    }

    /**
     * 测试根据主键查询单个
     */
    @Test
    public void selectUserById() {
        User user = userMapper.selectUserById(1L);
        Assert.assertNotNull(user);
        log.debug("【user】= {}", user);
    }

    /**
     * 测试保存
     */
    @Test
    public void saveUser() {
        String salt = IdUtil.fastSimpleUUID();
        User user = User.builder().name("testSave3").password(SecureUtil.md5("123456" + salt)).salt(salt).email("testSave3@xkcoding.com").phoneNumber("17300000003").status(1).lastLoginTime(new DateTime()).createTime(new DateTime()).lastUpdateTime(new DateTime()).build();
        int i = userMapper.saveUser(user);
        Assert.assertEquals(1, i);
    }

    /**
     * 测试根据主键删除
     */
    @Test
    public void deleteById() {
        int i = userMapper.deleteById(1L);
        Assert.assertEquals(1, i);
    }
}
```

## 参考

- Mybatis官方文档：http://www.mybatis.org/mybatis-3/zh/index.html

- Mybatis官方脚手架文档：http://www.mybatis.org/spring-boot-starter/mybatis-spring-boot-autoconfigure/

- Mybatis整合Spring Boot官方demo：https://github.com/mybatis/spring-boot-starter/tree/master/mybatis-spring-boot-samples
