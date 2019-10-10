package com.gqz.springboot.dao;

import com.gqz.springboot.entities.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


@Repository
public class DepartmentDao {

    private static Map<Integer, Department> departments = null;

    static {
        departments = new HashMap<Integer, Department>();

        departments.put(101, new Department(101, "D-AA101"));
        departments.put(102, new Department(102, "D-BB102"));
        departments.put(103, new Department(103, "D-CC103"));
        departments.put(104, new Department(104, "D-DD104"));
        departments.put(105, new Department(105, "D-EE105"));
    }

    public Collection<Department> getDepartments() {
        return departments.values();
    }

    public Department getDepartment(Integer id) {
        return departments.get(id);
    }

}
