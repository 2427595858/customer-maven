package com.silver.controller;

import com.silver.entity.Customer;
import com.silver.entity.PageBean;
import com.silver.service.CustomerService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 编写控制器，用来和前端页面进行交互
 * @author 光玉
 * @create 2018-05-18 15:40
 **/
@Controller
@RequestMapping("/customer")        // 相当于模块化，这个模块下的请求格式为“/customer/**”
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    private Customer myCustomer;       // 用来保存模糊查询的客户信息

    // 这里设置了只能使用get方法传递url
    @RequestMapping(value = "/frame", method = RequestMethod.GET)
    public String mainFrame(){
        // 显示主界面
        return "frame";
    }

    @RequestMapping(value = "/allCustomerList/{pageNum}", method = RequestMethod.GET)
    public String allCustomerList(@PathVariable("pageNum") Integer pageNum,Model model) throws Exception{
        // 显示所有客户列表
        // 获取从前端传过来的当前页数，并进行分页操作，显示列表
        if(pageNum == null){
            pageNum = 1;                    // 空则当前页面设置为1
        }
        int pageRecord = 8;                 // 设置每页8条记录
        PageBean<Customer> pb = customerService.allList((pageNum-1)*pageRecord, pageRecord);
        myCustomer = new Customer();        // 实例化myCustomer对象（如果之前有进行模糊查询操作，则相当于清除保存在myCustomer对象中的信息）
        model.addAttribute("pb",pb);    // 将pb对象传到前端页面中
        return "list";
    }

    @RequestMapping(value = "/add",method = RequestMethod.GET)      // 设置传递的url以及设置访问方式
    public String addCustomer() throws Exception{
        return "add";               // 返回添加客户的jsp页面
    }

    @RequestMapping(value = "/addCustomerSubmit",method = RequestMethod.POST)
    public String addCustomerSuccess(Customer customer) throws Exception{
        // 进行添加客户操作
        customerService.insert(customer);
        return "redirect:allCustomerList/1";         // 重定向到列表页面，显示第一页
    }

    @RequestMapping(value = "/edit/{id}",method = RequestMethod.GET)
    public String editCustomer(@PathVariable("id") Long id, Model model)throws Exception{
        // 到要修改客户的信息页
        Customer customer = customerService.getById(id);
        model.addAttribute("customer",customer);
        return "edit";
    }

    @RequestMapping(value = "/editCustomerSubmit",method = RequestMethod.POST)
    public String editCustomerSubmit(@Param("id") Long id,@Param("customer") Customer customer) throws Exception{
        // 传入id和要修改的相关客户信息，执行更新操作
        customerService.update(id,customer);
        return "redirect:allCustomerList/1";
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    public void deleteCustomer(@PathVariable("id") Long id, HttpServletRequest request, HttpServletResponse response)throws Exception{
        // 删除客户信息
        customerService.delete(id);
        String url = request.getRequestURL().toString();                // 获取当前请求的url
        String newUrl = url.substring(0,url.lastIndexOf("delete"))
                                + "allCustomerList/1";                  // 重新拼接url

        response.sendRedirect(newUrl);    // 重定向回客户列表的第一页
    }

    @RequestMapping(value = "/query",method = RequestMethod.GET)
    public String queryList(){
        // 进入模糊查询页面
        return "query";
    }

    // 由于模糊查询需要使用post提交表单，这里设置了可以使用get和post方法传递url
    @RequestMapping(value = "/list/{pageNum}", method = {RequestMethod.GET, RequestMethod.POST})
    public String queryCustomerList(@PathVariable("pageNum") Integer pageNum,Customer customer, Model model) throws Exception{
        // 获取从前端传过来的当前页数，并进行分页操作，显示列表，具有模糊查询的功能
        if(pageNum == null){
            pageNum = 1;                 // 空则当前页面设置为1
        }
        int pageRecord = 8;             // 设置每页记录数为8
        if(!customer.isNull()){         // 如果模糊查询中有设置查询信息，则将信息保存到myCustomer对象中
            myCustomer = customer;
        }
        PageBean<Customer> pb = customerService.queryList((pageNum-1)*pageRecord, pageRecord,myCustomer);
        model.addAttribute("pb",pb);

        return "list";
    }

    @RequestMapping(value = "/DevelopDoc",method = RequestMethod.GET)
    public String developDoc(){
        // 显示开发日志页面
        return "DevelopDoc";
    }

}
