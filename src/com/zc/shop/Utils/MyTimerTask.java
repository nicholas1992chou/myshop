package com.zc.shop.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

import javax.servlet.ServletContext;

import com.zc.shop.entities.Category;
import com.zc.shop.entities.Product;
import com.zc.shop.service.CategoryService;
import com.zc.shop.service.ProductService;

public class MyTimerTask extends TimerTask {
	private ServletContext servletContext = null;
	private CategoryService categoryService;
	private ProductService productService;
	
	public MyTimerTask(){
		super();
	}
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		ArrayList<List<Product>> bigList = new ArrayList<List<Product>>();
		for(Category category: categoryService.queryHot()){
			
			bigList.add(productService.queryCommend(category.getId())) ;
		}
		servletContext.setAttribute("bigList", bigList);
	}
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}
	

}
