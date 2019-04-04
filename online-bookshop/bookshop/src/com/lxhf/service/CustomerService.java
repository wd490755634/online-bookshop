package com.lxhf.service;

import com.lxhf.bean.Customer;

public interface CustomerService {
	public Customer findOneCustomer(String username,String password);
	
	public Boolean updateCustomerStatus(Customer customer,Boolean status) throws Exception;
	
	public Customer findCustomer(Integer id);
	
	public void addCustomer(Customer customer) throws Exception;
	
	public Customer findCustomerByUserName(String username);
	
	public String findCustomerCharacter(Integer characterid);
}
