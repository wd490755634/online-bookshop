package com.lxhf.bean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;



public class Car {
	private int totalNum;
	private float totalMoney;
	private List<CarItem> carItems;
	
	public int getTotalNum() {
		this.totalNum = 0;
		for (CarItem carItem : carItems) {
			totalNum +=carItem.getNum();
		}
		
		return totalNum;
	}
	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}
	public float getTotalMoney() {
		this.totalMoney = 0;
		for (CarItem carItem : carItems) {
			//得到每一项对象
			totalMoney += carItem.getMoney();
		}
		
		return totalMoney;
	}
	public void setTotalMoney(float totalMoney) {
		this.totalMoney = totalMoney;
	}
	
	public List<CarItem> getCarItems() {
		return carItems;
	}
	public void setCarItems(List<CarItem> carItems) {
		this.carItems = carItems;
	}
	@Override
	public String toString() {
		return "Car [totalNum=" + totalNum + ", totalMoney=" + totalMoney + ", carItems=" + carItems + "]";
	}
	
}
