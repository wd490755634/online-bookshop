package com.lxhf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lxhf.bean.CarItem;
import com.lxhf.mapper.CarMapper;
import com.lxhf.service.CarService;


@Transactional(rollbackFor = Exception.class)
@Service
public class CarServiceImpl implements CarService {

	@Autowired
	CarMapper carMapper;
	
	//query caritem in caritem
	@Override
	public CarItem findCarItemByIdandCustomerId(Integer id,Integer customerid) {
		
		return carMapper.findCarItemByBookIdandCustomerId(id,customerid);
	}

	//insert in caritem
	@Override
	public void insertCarItem(CarItem caritem) {
		carMapper.insertOneCarItem(caritem);
		
	}

	//update caritem's num and money
	@Override
	public void updateCarItemNumandMoney(Integer id,float money ,int num) {
		
		carMapper.updateNumandMoney(id,money,num);
	}

	//find CarItem By CustomerId
	@Override
	public List<CarItem> findCarItemByCustomerId(Integer customerid) {
		List<CarItem> list= carMapper.findCarItemByCustomerId(customerid);
		if(list!=null)
			return list;
		return null;
	}

	
	//delete CarItem By CustomerId
	@Override
	public void deleteCarItemByCustomerId(Integer customerid) {
		carMapper.deleteByCustomerId(customerid);
	}

	@Override
	public void deleteCarItemById(Integer id) {
		carMapper.deleteById(id);
		
	}


}
