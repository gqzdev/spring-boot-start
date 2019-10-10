package com.gqz.mybatis.bean;

/**
 * @ClassName: Employee
 * @author: ganquanzhong
 * @date: 2019/9/30 16:44
 */
public class Employee {

    private Integer id;
    private String lastName;
    private Integer gender;
    private String email;
    private Integer dId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }



    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                ", dId=" + dId +
                '}';
    }
}
