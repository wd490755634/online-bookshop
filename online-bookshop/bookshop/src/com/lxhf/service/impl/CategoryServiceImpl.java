package com.lxhf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lxhf.bean.Category;
import com.lxhf.mapper.CategoryMapper;
import com.lxhf.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryMapper categoryMapper;
	
	@Override
	public List<Category> findCategoryAll() {

		return categoryMapper.findCategoryAll();
	}

	@Override
	public void addCategory(Category category) {

		categoryMapper.addCategory(category);
	}

	@Override
	public void deleteCategory(Integer id) {

		categoryMapper.deleteCategory(id);
	}

	@Override
	public void updateCategory(Category category) {

		categoryMapper.updateCategory(category);
		
	}

	@Override
	public Category getCategoryById(Integer id) {

		return categoryMapper.getCategoryById(id);
	}
	
	@Override
	public List<Category> findCategoryByAll(String all) {
		return categoryMapper.findCategoryByAll(all);
	}
	
	@Override
	public List<Category> findCategoryByName(String name) {
		return categoryMapper.findCategoryByName(name);
	}
	
	@Override
	public List<Category> findCategoryByDesc(String desc) {
		return categoryMapper.findCategoryByDesc(desc);
	}
}
