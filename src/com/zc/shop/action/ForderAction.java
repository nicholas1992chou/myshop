package com.zc.shop.action;

import com.zc.shop.entities.Customer;
import com.zc.shop.entities.Forder;
import com.zc.shop.entities.Status;

public class ForderAction extends BaseAction<Forder>{
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public Forder getModel() {
		// 从session里取出存有集合sorder的forder赋给model。
		//model 再获得从前端传来的forder的其他字段的数据。
		//保证了集合sorder实体里的forder引用为当前存入的forder，不然save的时候会出现异常
		//因为如果两个forder不一样，sorder实体里面的forder为transient 对象。
		model = (Forder) session.get("forder");
		return model;
	}
	//---------提交订单----------
	public String save(){
		model.setCustomer((Customer) session.get("user"));
		model.setStatus(new Status(1));
		
		//forderService.save(model);
		return "check out";
	}
}
