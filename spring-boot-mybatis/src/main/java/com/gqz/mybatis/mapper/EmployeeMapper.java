package com.gqz.mybatis.mapper;

import com.gqz.mybatis.bean.Employee;

/**
 * @ClassName: EmployeeMapper
 * @author: ganquanzhong
 * @date: 2019/9/30 17:24
 */

//@Mapper 或者 @MapperScan 将接口扫描装配到容器中
public interface EmployeeMapper {

    //使用配置文件的方式   SQL映射文件

    public Employee getEmpById(Integer id);

    public void insertEmp(Employee employee);
}
