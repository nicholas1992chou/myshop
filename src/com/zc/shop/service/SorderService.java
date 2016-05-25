package com.zc.shop.service;

import com.zc.shop.entities.Forder;
import com.zc.shop.entities.Product;
import com.zc.shop.entities.Sorder;

public interface SorderService extends BaseService<Sorder> {
	// 向forder添加sorder 并处理重复商品项。
	public Forder addSorder(Forder forder, Product product, Integer amount) ;
	//将前端product转换为sorder；
	public Sorder productToSorder(Product product, Integer amount);
	
	public Forder updateSorder(Forder forder, Product product, Integer amount);
}
