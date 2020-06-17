package com.gqzdev.cache.redis.service.impl;


import com.gqzdev.cache.redis.bean.Department;
import com.gqzdev.cache.redis.mapper.DepartmentMapper;
import com.gqzdev.cache.redis.service.DeptService;
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
public class DeptServiceImpl implements DeptService {

    @Autowired
    DepartmentMapper departmentMapper;

    @Override
    @Cacheable(cacheNames = "dept")
    public Department getDeptById(Integer id){
        System.out.println("查询部门"+id);
        Department department = departmentMapper.getDeptById(id);
        return department;
    }
}
