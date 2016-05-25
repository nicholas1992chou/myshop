package com.zc.shop.service.impl;

import java.math.BigDecimal;

import com.zc.shop.entities.Forder;
import com.zc.shop.entities.Sorder;
import com.zc.shop.service.ForderService;

public class ForderServiceImpl extends BaseServiceImpl<Forder> implements ForderService{
	public BigDecimal calculate(Forder forder){
		BigDecimal total = new BigDecimal(0.00);
		for(Sorder sorder:forder.getSorderSet()){
			total = total.add(sorder.getPrice().multiply(new BigDecimal(sorder.getAmount())));
		}
		return total;
	}
}
