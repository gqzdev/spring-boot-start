package com.gqzdev.cache.redis.mapper;


import com.gqzdev.cache.redis.bean.Employee;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @ClassName: EmployeeMapper
 * @author: ganquanzhong
 * @date: 2019/10/10 15:14
 */

public interface EmployeeMapper {

    @Select("select * from employee where id =#{id}")
    public Employee getEmpById(Integer id);

    @Update("update employee set lastName=#{lastName},email=#{email},gender=#{gender}," +
            "d_id=#{dId} where id = #{id}")
    public void updateEmp(Employee employee);


    @Delete("delete from employee where id =#{id}")
    public void deleteEmpById(Integer id);

    @Insert("INSERT into employee(lastName,email,gender,d_id) values(#{lastName}," +
            "#{email},#{gender},#{dId})")
    public void insertEmployee(Employee employee);

    @Select("select * from employee where lastName=#{lastName}")
    public Employee getEmpByLastName(String lastName);
}
