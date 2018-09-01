package com.hand.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hand.dto.Customer;
import com.hand.dto.Msg;
import com.hand.service.CustomerService;
import com.hand.service.PayMentService;
import com.hand.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * 处理员工CRUD请求
 * 
 * @author lfy
 * 
 */


@Controller
public class CustomerController {

	@Autowired
	CustomerService customerService;
    @Autowired
    RentalService rentalService;
    @Autowired
    PayMentService payMentService;


	@RequestMapping("/emps")
	@ResponseBody
	public Msg getEmpsWithJson(
			@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
		// 这不是一个分页查询
		// 引入PageHelper分页插件
		// 在查询之前只需要调用，传入页码，以及每页的大小

		PageHelper.startPage(pn,5);
		// startPage后面紧跟的这个查询就是一个分页查询
		List<Customer> emps = customerService.getAll();
		// 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
		// 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
		PageInfo page = new PageInfo(emps, 5);
		return Msg.success().add("pageInfo", page);
	}

	@RequestMapping(value = "/Save")
	@ResponseBody
	public Msg save(@RequestParam("firstName")String firstName,
					@RequestParam("lastName")String lastName,
					@RequestParam("email")String email,
					@RequestParam("AddDizhi")String AddDizhi
					){
	//	System.out.print("成功进入保存后端");
		System.out.print(firstName+" "+lastName+" "+email+" "+AddDizhi);
		int AddId = Integer.valueOf(AddDizhi);
		Customer customer = new Customer() ;
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setEmail(email);
		customer.setActive(true);
		customer.setAddressId((short)AddId);
		customer.setStoreId((byte) 1);
		java.util.Date utilDate=new Date();
		customer.setCreateDate(utilDate);
		customer.setLastUpdate(utilDate);
        customerService.saveEmp(customer);
		return Msg.success();
	}

	@ResponseBody
	@RequestMapping(value="/Delete/{ids}")
	public Msg deleteEmp(@PathVariable("ids")String ids){

    //	    System.out.print("成功进入删除！"+ids);
			Integer id = Integer.parseInt(ids);
			payMentService.deleteEmp(id);//先删除关联表payment中的数据
			rentalService.deleteEmp(id);//删除关联表rentalt中的数据

			customerService.deleteEmp(id);

		return Msg.success();
	}


    @RequestMapping(value = "/gengxi" )
    @ResponseBody
	public Msg gengxin(
			@RequestParam("firstName")String firstName,
			@RequestParam("lastName")String lastName,
			@RequestParam("email")String email,
			@RequestParam("UpdateDizhi")String AddDizhi,
			@RequestParam("id")String id
	){
    System.out.print(firstName+" "+lastName+" "+email+" "+AddDizhi+" "+id);
	int AddId = Integer.valueOf(AddDizhi);
	int CutId  = Integer.valueOf(id);
    Customer customer =new Customer();
    customer.setFirstName(firstName);
	customer.setLastName(lastName);
	customer.setEmail(email);
	customer.setCustomerId((short)CutId);
	customer.setAddressId((short)AddId);
	//    System.out.print("成功了！");
		customerService.updateEmp(customer);
	    return Msg.success();
    }

}
