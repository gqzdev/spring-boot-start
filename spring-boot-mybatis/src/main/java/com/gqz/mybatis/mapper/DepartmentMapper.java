package com.gqz.mybatis.mapper;

import com.gqz.mybatis.bean.Department;
import org.apache.ibatis.annotations.*;

/**
 * @ClassName: DepartmentMapper
 * @author: ganquanzhong
 * @date: 2019/9/30 16:48
 */

//指定这是一个操作数据的mapper
//使用MapperScan批量扫描
//@Mapper
public interface DepartmentMapper {

    //使用注解完成对department的CRUD

    @Select("select * from department where id = #{id}")
    public Department getDeptById(Integer id);


    @Delete("delete from department where id = #{id}")
    public int deleteDeptById(Integer id);

    //返回自增主键  使用userGeneratedKeys属性
    /* *
     使用驼峰式命名法，注解版  添加MyBatisConfig  Customerizer
     */

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into department(departmentName) values(#{departmentName})")
    public int insertDept(Department department);

    @Update("update department set departmentName = #{departmentName} where id =#{id}")
    public int updateDept(Department department);
}
