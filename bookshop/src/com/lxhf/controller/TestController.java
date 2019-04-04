package com.lxhf.controller;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.*;

import com.lxhf.bean.Customer;
import com.lxhf.service.CustomerService;

@Controller
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( locations = "classpath:applicationContext.xml")
public class TestController {

	@Autowired 
	CustomerService customerService;
	
	@Test
	public void test1() throws Exception {
		Customer customer1 = new Customer();
		customer1.setUsername("username");
		customer1.setPassword("password");
		customer1.setNickname("nickname");
		customer1.setPhonenum("12345678910");
		customer1.setEmail("email");
		customer1.setAddress("address");
		customer1.setStatus(false);
		customerService.addCustomer(customer1);
	}
}
