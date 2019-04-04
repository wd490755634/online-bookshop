package com.lxhf.service;

import java.util.List;

import com.lxhf.bean.CarItem;

public interface CarService {
	
	public CarItem findCarItemByIdandCustomerId(Integer id,Integer customerid);

	public void insertCarItem(CarItem caritem);
	
	public void updateCarItemNumandMoney(Integer id,float money,int num);
	
	public List<CarItem> findCarItemByCustomerId(Integer customerid);
	
	public void deleteCarItemByCustomerId(Integer customerid);

	public void deleteCarItemById(Integer id);
}
