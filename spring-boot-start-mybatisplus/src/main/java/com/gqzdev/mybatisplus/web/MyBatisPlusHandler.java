package com.gqzdev.mybatisplus.web;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @ClassName MyBatisPlusHandler
 * @Description 处理MP自动填充
 *
 *      实现元对象处理器接口：com.baomidou.mybatisplus.core.handlers.MetaObjectHandler
 *      注解填充字段 @TableField(.. fill = FieldFill.INSERT) 生成器策略部分也可以配置！
 *
 * @Author ganquanzhong
 * @Date2020/9/13 17:21
 * @Version
 **/

@Component
public class MyBatisPlusHandler implements MetaObjectHandler {

    private static  Logger logger = LoggerFactory.getLogger(MyBatisPlusHandler.class);

    @Override
    public void insertFill(MetaObject metaObject) {
        logger.info("------insertFill-----");
        metaObject.setValue("creator","ganquanzhong");
        metaObject.setValue("create_time",System.currentTimeMillis());
        metaObject.setValue("is_deleted","0");
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        logger.info("-----updateFill-----");
        metaObject.setValue("updator","gqzdev");
        metaObject.setValue("update_time",System.currentTimeMillis());
    }
}
