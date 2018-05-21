package com.silver.entity;

/**
 * 封装客户信息（id，姓名，性别，电话，邮箱，个人描述）的pojo类
 * @author 光玉
 * @create 2018-05-16 22:36
 **/
public class Customer {
    private long id;
    private String name;
    private String gender;
    private String phone;
    private String email;           // 不是必填项
    private String description;     // 不是必填项

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean isNull(){    // 判断除id外的属性是否为空，用于后面编写controller模糊查询时的判断
        if(this.name == null && this.gender == null &&  this.phone == null
                && this.email == null && this.description == null){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
