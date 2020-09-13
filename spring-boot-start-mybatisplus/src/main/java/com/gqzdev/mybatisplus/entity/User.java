package com.gqzdev.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @ClassName User
 * @Description
 * @Author ganquanzhong
 * @Date2020/9/12 23:42
 * @Version
 **/
@TableName("user")
public class User {
    /**
     * 主键
     */
    @TableField("id")
    private Long id;

    /**
     *  用户名
     */
    private String name;

    /**
     *  年龄
     */
    private Integer age;

    /**
     *  右键
     */
    private String email;

    /**
     *  创建人
     */
    private String creator;

    /**
     *  创建时间
     */
    @TableField("create_time")
    private String creatTime;

    /**
     *  更新者
     */
    private String updator;

    /**
     *  更新时间
     */
    @TableField(value = "update_time",fill = FieldFill.UPDATE)
    private String updateTime;

    /**
     *  删除标识
     */
    @TableLogic
    private Integer IsDeleted;

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(String creatTime) {
        this.creatTime = creatTime;
    }

    public String getUpdator() {
        return updator;
    }

    public void setUpdator(String updator) {
        this.updator = updator;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getIsDeleted() {
        return IsDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        IsDeleted = isDeleted;
    }

    public User() {
    }

    public User(Long id, String name, Integer age, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", age=" + age +
            ", email='" + email + '\'' +
            '}';
    }
}
