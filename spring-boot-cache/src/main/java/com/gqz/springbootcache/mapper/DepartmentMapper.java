package com.gqz.springbootcache.mapper;

import com.gqz.springbootcache.bean.Department;
import org.apache.ibatis.annotations.Mapper;
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
