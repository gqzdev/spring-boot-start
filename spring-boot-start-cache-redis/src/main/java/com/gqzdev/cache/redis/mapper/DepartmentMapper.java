package com.gqzdev.cache.redis.mapper;


import com.gqzdev.cache.redis.bean.Department;
import org.apache.ibatis.annotations.Select;

/**
 * @ClassName: DepartmentMapper
 * @author: ganquanzhong
 * @date: 2019/10/10 15:13
 */

public interface DepartmentMapper {

    @Select("SELECT * FROM department WHERE id =#{id}")
    Department getDeptById(Integer id);
}
