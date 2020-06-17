package com.gqzdev.cache.redis.service;


import com.gqzdev.cache.redis.bean.Department;

/**
 * @ClassName DeptService
 * @Description
 * @Author ganquanzhong
 * @Date2019/10/16 22:42
 * @Version
 **/


public interface DeptService {
    public Department getDeptById(Integer id);
}
