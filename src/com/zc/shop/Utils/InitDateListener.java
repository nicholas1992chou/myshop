package com.zc.shop.Utils;

import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class InitDateListener implements ServletContextListener {

	private MyTimerTask myTimerTask;
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		//从内置对象application中获取context，获取bean。
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(arg0.getServletContext());
		myTimerTask = (MyTimerTask) context.getBean("myTimerTask");
		//将servletcontext注入mytimertask
		myTimerTask.setServletContext(arg0.getServletContext());
		//创建定时器，定时更新首页数据
		new Timer(true).schedule(myTimerTask, 0, 1000 * 60 * 60);
	}

}
