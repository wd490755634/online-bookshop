package com.lxhf.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lxhf.bean.Customer;
import com.lxhf.mapper.CustomerMapper;
import com.lxhf.service.CustomerService;


@Transactional(rollbackFor = Exception.class)
@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerMapper customerMapper;
	

	@Override
	public Customer findOneCustomer(String username ,String password) {
		Customer customer = customerMapper.findCustomerByUsernameAndPassword(username, password);
		if(customer!=null)
			return customer;
		return null;
	}
	
	
	@Override
	public Boolean updateCustomerStatus(Customer customer,Boolean status) throws Exception{
		if (customerMapper.updateCustomerStatusById(customer.getId(),status) == true) {
			int i = 1/0;
			return true;
		}
		return false;
	}
	
	@Override
	public Customer findCustomer(Integer id) {
		Customer customer = customerMapper.findCustomerById(id);
		if(customer!=null)
			return customer;
		return null;
	}


	@Override
	public void addCustomer(Customer customer) throws Exception{
		customerMapper.addOneCustomer(customer);
	}


	@Override
	public Customer findCustomerByUserName(String username) {
		return customerMapper.findByUsername(username);
		
	}


	@Override
	public String findCustomerCharacter(Integer characterid) {
		return customerMapper.findCharacter(characterid);
	}

}
