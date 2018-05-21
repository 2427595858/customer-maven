package com.silver.dao;

import com.silver.entity.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 客户信息dao层编写（增，删，查，改操作）
 * @author 光玉
 * @create 2018-05-16 22:49
 **/
public interface CustomerDao {
    /**
     * 由于有多个形参，在spring中形参是以arg0，arg1...的形式传递的，需要使用@Param设置对应的名字
     * 分页查询客户
     * @param offset            偏移量
     * @param pageRecord        每页记录数
     * @return
     */
    public List<Customer> findAll(@Param("offset") int offset,@Param("pageRecord") int pageRecord);

    /**
     * 通过id查找应客户信息
     * @param id
     * @return
     */
    public Customer findById(long id) throws Exception;

    /**
     * 通过传入的customer对象获取对应客户信息，并将其插入数据库
     * @param customer
     */
    public void addCustomer(Customer customer) throws Exception;

    /**
     * 通过id来删除对应的客户
     * @param id
     */
    public void deleteCustomer(long id) throws Exception;

    /**
     * 根据id修改信息，传入要修改的信息
     * @param id
     * @param customer
     * @throws Exception
     */
    public void editCustomer(@Param("id") long id,@Param("customer") Customer customer)throws Exception;

    /**
     * 返回客户列表的总记录数（模糊查询时，返回模糊查询总记录数）
     * @param customer
     * @return
     * @throws Exception
     */
    public int countCustomers(@Param("customer") Customer customer)throws Exception;

    /**
     * 分页查询客户，并且有模糊查询功能
     * @param offset
     * @param pageRecord
     * @param customer
     * @return
     * @throws Exception
     */
    public List<Customer> queryAll(@Param("offset") int offset,@Param("pageRecord") int pageRecord,@Param("customer") Customer customer) throws Exception;

}
