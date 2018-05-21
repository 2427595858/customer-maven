package com.silver.dao;

import com.silver.entity.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
// 配置文件路径
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class CustomerDaoTest {

    // 注入依赖
    @Resource
    private CustomerDao customerDao;

    @Test
    public void findAll() {
        int pageNum = 1;            // 当前页数
        int pageRecord = 10;        // 每页记录数
        List<Customer> customers = customerDao.findAll((pageNum - 1) * pageRecord, pageRecord);
        for (Customer c : customers) {
            System.out.println(c);
        }
    }


    @Test
    public void findById() throws Exception {
        // 根据id查找对应客户
        long id = 3L;
        Customer customer = customerDao.findById(id);
        System.out.println(customer);
    }

    @Test
    public void addCustomer() throws Exception {
        // 添加客户
        Customer customer = new Customer();
        customer.setName("曹操");
        customer.setGender("男");
        customer.setPhone("13245987562");
        //customer.setEmail(null);
        customer.setDescription("我是曹操");
        customerDao.addCustomer(customer);
    }

    @Test
    public void deleteCustomer() throws Exception {
        // 通过id删除客户
        long id = 4L;
        customerDao.deleteCustomer(id);
    }

    @Test
    public void editCustomer() throws Exception {
        // 修改客户信息
        long id = 1L;
        Customer customer = customerDao.findById(id);
        customer.setDescription("小明同学");            // 修改id为1的客户的个人描述
        customerDao.editCustomer(id,customer);
        System.out.println(customerDao.findById(id));   // 输出修改后的信息
    }

    @Test
    public void countCustomers() throws Exception{
        // 查找客户总记录数
        Customer customer = new Customer();         // 进行模糊查询所要传入的客户信息
        customer.setName("小");
        int count = customerDao.countCustomers(customer);
        System.out.println("客户数量："+count);
    }

    @Test
    public void queryAll() throws Exception {
        // 分页显示客户列表，并且有模糊查询的功能
        int pageNum = 1;                            // 页数
        int pageRecord = 10;                        // 每页记录数
        Customer customer = new Customer();         // 设置要模糊查询的客户信息
        customer.setName("小");                     // 按照名字模糊查询
        List<Customer> customers = customerDao.queryAll((pageNum - 1) * pageRecord, pageRecord, customer);
        for (Customer c : customers) {
            System.out.println(c);
        }
    }
}