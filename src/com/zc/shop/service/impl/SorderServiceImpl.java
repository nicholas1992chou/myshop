package com.zc.shop.service.impl;

import com.zc.shop.entities.Forder;
import com.zc.shop.entities.Product;
import com.zc.shop.entities.Sorder;
import com.zc.shop.service.SorderService;

public class SorderServiceImpl extends BaseServiceImpl<Sorder> implements SorderService{
	// 向forder添加sorder 并处理重复商品项。
	public Forder addSorder(Forder forder, Product product, Integer amount) {
		boolean flag = false;
		Sorder sorder = productToSorder(product, amount);
		//用sorder去判断集合中是否有产品id跟其产品id相同的 id为Integer，故用equals
		for(Sorder old:forder.getSorderSet()){
			if(old.getProduct().getId().equals(sorder.getProduct().getId())){
				//遍历时，old代表集合的该元素，改变old 及改变集合内对象的值。
				old.setAmount(old.getAmount()+sorder.getAmount());
				flag = true;
				break;
			}
		}
		if(!flag){
			sorder.setForder(forder);
			forder.getSorderSet().add(sorder);
		}
		return forder;
	}
	//将前端product转换为sorder；
	public Sorder productToSorder(Product product, Integer amount) {
		Sorder sorder = new Sorder();
		sorder.setName(product.getName());
		sorder.setPrice(product.getPrice());
		sorder.setAmount(amount);
		sorder.setProduct(product);
		return sorder;
	}
	public Forder updateSorder(Forder forder, Product product, Integer amount){
		Sorder sorder = productToSorder(product, amount);
		for(Sorder temp:forder.getSorderSet()){
			if(temp.getProduct().getId().equals(sorder.getProduct().getId())){
				temp.setAmount(sorder.getAmount());
			}
		}
		return forder;
	}
}
