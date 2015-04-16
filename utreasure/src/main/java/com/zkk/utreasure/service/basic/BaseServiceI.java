package com.zkk.utreasure.service.basic;

import java.util.List;
import java.util.Map;

public interface BaseServiceI<T> {
	/**
	 * ��ѯ����
	 * 
	 */
	T get(Long id);

	/**
	 * �������������б�ĸ���
	 * 
	 */
	int findListCount(Map<String, Object> params);

	/**
	 * �������������б�
	 * 
	 */
	List<T> findList(Map<String, Object> params);

	/**
	 * ���
	 */
	int add(T t);

	/**
	 * �޸�
	
	 */
	void modify(T t);
	
	/**
	 * ɾ��
	 */
	void remove(Long id);
	
	
	

}
