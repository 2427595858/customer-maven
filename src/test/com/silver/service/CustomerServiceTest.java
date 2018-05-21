package com.silver.service;

import com.silver.entity.Customer;
import com.silver.entity.PageBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml",
                        "classpath:spring/spring-service.xml"})
public class CustomerServiceTest {

    @Autowired
    private CustomerService customerService;

    @Test
    public void allList() throws Exception{
        PageBean<Customer> pageBean = customerService.allList(0, 8);    // 设置每页8条记录
        System.out.println(pageBean);
    }

    @Test
    public void getById() throws Exception{
        long id = 1L;
        Customer customer = customerService.getById(id);
        System.out.println(customer);
    }

    @Test
    public void insert() throws Exception{
        Customer customer = new Customer();
        customer.setName("吕布");
        customer.setGender("男");
        customer.setPhone("15823232333");
        customerService.insert(customer);
    }

    @Test
    public void delete() throws Exception{
        long id = 7L;
        customerService.delete(id);
    }

    @Test
    public void update() throws Exception{
        long id = 1L;
        Customer customer = customerService.getById(id);
        customer.setDescription("我是小明");
        customerService.update(id,customer);
        System.out.println(customer);
    }

    @Test
    public void queryList() throws Exception{
        int offset = 0;
        int pageRecord = 8;
        Customer customer = new Customer();
        customer.setName("小");
        PageBean<Customer> pageBean = customerService.queryList(offset, pageRecord, customer);
        System.out.println(pageBean);
    }
}