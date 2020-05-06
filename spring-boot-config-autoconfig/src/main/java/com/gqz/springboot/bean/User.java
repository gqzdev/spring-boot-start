package com.gqz.springboot.bean;

/**
 * @ClassName User
 * @Description
 * @Author ganquanzhong
 * @Date2020/1/3 0:17
 * @Version
 **/
public class User {
    private int uid;
    private String name;
    private String addr;
    private String status;

    public User() {
    }

    public User(int uid, String name, String addr, String status) {
        this.uid = uid;
        this.name = name;
        this.addr = addr;
        this.status = status;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", addr='" + addr + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
