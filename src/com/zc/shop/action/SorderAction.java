package com.zc.shop.action;

import com.zc.shop.entities.Sorder;

import java.io.ByteArrayInputStream;
import com.zc.shop.entities.Forder;
import com.zc.shop.entities.Product;

public class SorderAction extends BaseAction<Sorder> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String addSorder(){
		Product product = productService.get(model.getProduct().getId());
		model.setAmount(1);
		Forder forder = null;
		if(session.get("forder") == null)
			{
				forder = new Forder();
			}
		else{
			
			forder= (Forder) session.get("forder");
		}
		forder = sorderService.addSorder(forder, product, model.getAmount());
		forder.setTotalAmount(forderService.calculate(forder));
		session.put("forder", forder);
		return "showCar";
	}
	public String updateSorder(){
		Product product = productService.get(model.getProduct().getId());
		Forder forder = (Forder) session.get("forder");
		forder = sorderService.updateSorder(forder, product, model.getAmount());
		forder.setTotalAmount(forderService.calculate(forder));
		session.put("forder", forder);
		inputStream = new ByteArrayInputStream(forder.getTotalAmount().toString().getBytes());
		return "stream";
	}
}
