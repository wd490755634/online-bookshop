package com.lxhf.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lxhf.bean.Book;
import com.lxhf.bean.CarItem;

public interface CarMapper {

	public CarItem findCarItemByBookIdandCustomerId(@Param("bookid")Integer bookid,@Param("customerid")Integer customerid);

	public void insertOneCarItem(CarItem caritem);

	public void updateNumandMoney(@Param("id")Integer id,@Param("money")float money,@Param("num")int num);

	public List<CarItem> findCarItemByCustomerId(Integer customerid);

	public void deleteByCustomerId(Integer customerid);

	public void deleteById(Integer id);

}
