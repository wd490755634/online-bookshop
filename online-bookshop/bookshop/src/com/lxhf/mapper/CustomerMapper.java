package com.lxhf.mapper;

import org.apache.ibatis.annotations.Param;

import com.lxhf.bean.Customer;

public interface CustomerMapper {
	public Customer findCustomerByUsernameAndPassword(@Param("username")String username,@Param("password")String password);

	public Boolean updateCustomerStatusById(@Param("id")Integer id,@Param("status")Boolean status);

	public Customer findCustomerById(Integer id);

	public void addOneCustomer(Customer customer);

	public Customer findByUsername(@Param("username")String username);

	public String findCharacter(@Param("id")Integer characterid);
}
