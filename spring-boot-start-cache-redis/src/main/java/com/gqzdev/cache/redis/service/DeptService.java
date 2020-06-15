package com.gqzdev.cache.redis.service;


import com.gqzdev.cache.redis.bean.Department;
import com.gqzdev.cache.redis.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @ClassName DeptService
 * @Description
 * @Author ganquanzhong
 * @Date2019/10/16 22:42
 * @Version
 **/

@CacheConfig(cacheNames = "dept")
@Service
public class DeptService {

    @Autowired
    DepartmentMapper departmentMapper;

    @Cacheable(cacheNames = "dept")
    public Department getDeptById(Integer id){
        System.out.println("查询部门"+id);
        Department department = departmentMapper.getDeptById(id);
        return department;
    }
}
