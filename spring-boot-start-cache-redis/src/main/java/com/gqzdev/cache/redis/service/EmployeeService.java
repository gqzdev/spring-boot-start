package com.gqzdev.cache.redis.service;


import com.gqzdev.cache.redis.bean.Employee;

/**
 * @ClassName: EmployeeService
 * @author: ganquanzhong
 * @date: 2019/10/10 15:28
 */

public interface EmployeeService {

    public Employee getEmp(Integer id);


    public Employee updateEmp(Employee employee);


    public void deleteEmp(Integer id);


    public Employee getEmpByLastName(String lastName);

}
