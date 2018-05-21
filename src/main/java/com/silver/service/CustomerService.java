package com.silver.service;

import com.silver.entity.Customer;
import com.silver.entity.PageBean;

import java.util.List;

/**
 * 业务层，编写业务逻辑，调用Dao层
 * @author 光玉
 * @create 2018-05-17 16:07
 **/
public interface CustomerService {
    /**
     * 分页查询
     * @param offset
     * @param pageRecord
     * @return
     */
    public PageBean<Customer> allList(int offset, int pageRecord) throws Exception;

    /**
     * 通过id查找客户
     * @param id
     * @return
     * @throws Exception
     */
    public Customer getById(long id)throws Exception;

    /**
     * 添加客户
     * @param customer
     * @throws Exception
     */
    public void insert(Customer customer)throws Exception;

    /**
     * 通过id删除客户
     * @param id
     * @throws Exception
     */
    public void delete(long id)throws Exception;

    /**
     * 修改客户信息
     * @param id
     * @param customer
     * @throws Exception
     */
    public void update(long id,Customer customer)throws Exception;

    /**
     * 分页查询，模糊查询，还需要在Service实现类中编写一些业务逻辑
     * @param offset
     * @param pageRecord
     * @param customer
     * @return
     * @throws Exception
     */
    public PageBean<Customer> queryList(int offset, int pageRecord, Customer customer)throws Exception;

}
