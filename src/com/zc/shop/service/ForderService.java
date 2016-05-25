package com.zc.shop.service;

import java.math.BigDecimal;

import com.zc.shop.entities.Forder;

public interface ForderService extends BaseService<Forder> {
	public BigDecimal calculate(Forder forder);
}
