package com.lxhf.service;

import java.util.List;

import com.lxhf.bean.Category;

public interface CategoryService {

	/**
	 * ��ѯ���з�����Ϣ
	 * @return ���з�����Ϣ
	 */
	public List<Category> findCategoryAll();
	
	/**
	 * ���������Ϣ
	 * @param category
	 * @return
	 */
	public void addCategory(Category category);
	
	/**
	 * ɾ��������Ϣ
	 * @param id
	 * @return
	 */
	public void deleteCategory(Integer id);
	
	/**
	 * ���·�����Ϣ
	 * @param category ���º��category����
	 */
	public void updateCategory(Category category);
	
	/**
	 * ����id����ָ������
	 * @param id
	 * @return
	 */
	public Category getCategoryById(Integer id);

	public List<Category> findCategoryByAll(String all);

	public List<Category> findCategoryByName(String name);

	public List<Category> findCategoryByDesc(String desc);
}
