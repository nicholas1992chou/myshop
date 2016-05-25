package com.zc.shop.action;

import java.io.ByteArrayInputStream;
import java.util.List;

import com.zc.shop.entities.Product;

public class ProductAction extends BaseAction<Product>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String save(){
		String picture = fileUploadUtil.copy(srcFile, srcFileFileName);
		model.setPicture(picture);
		productService.save(model);
		inputStream = new ByteArrayInputStream("true".getBytes());
		
		return "stream";
	}
	
	public String update(){
		
		String picture = fileUploadUtil.copy(srcFile, srcFileFileName);
		System.out.println(picture);
		model.setPicture(picture);
		productService.update(model);
		inputStream = new ByteArrayInputStream("true".getBytes());
		return "stream";
	}
	public String delete(){
		productService.delete(model);
		return "stream";
	}
	
	public String query(){
		jsonList = productService.query();
		
		return "jsonList";
	}
	public String execute(){
		return "stream";
	}
	public String queryByPages() {
		
		List<Product> productList = productService.queryByPages(model.getName(), page, rows);
		
		total = productService.getTotal(model.getName());
		// 将分页数据封装到map里，以json形式传输。
		//使用datagrid分页时，json数据键规定为total与rows。否则出现异常
		pageMap.put("total", total);
		pageMap.put("rows", productList);

		return "jsonMap";
	}
	public String deleteAll(){
		productService.deleteAll(ids);
		inputStream = new ByteArrayInputStream("true".getBytes());
		return "stream";
	}
	public String get(){
		request.put("model", productService.get(model.getId()));
		return "detail";
	}
}
