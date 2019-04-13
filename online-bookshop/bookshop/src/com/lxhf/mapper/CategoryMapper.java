package com.lxhf.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lxhf.bean.Category;

public interface CategoryMapper {


	public List<Category> findCategoryAll();
	

	public void addCategory(Category category);
	

	public void deleteCategory(Integer id);
	

	public void updateCategory(Category category);
	

	public Category getCategoryById(Integer id);


	public List<Category> findCategoryByAll(@Param("all")String all);


	public List<Category> findCategoryByName(@Param("name")String name);


	public List<Category> findCategoryByDesc(@Param("desc")String desc);
}
