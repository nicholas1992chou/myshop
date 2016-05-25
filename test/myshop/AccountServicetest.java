package myshop;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zc.shop.entities.Account;
import com.zc.shop.service.AccountService;

public class AccountServicetest {
	ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext*.xml");
	AccountService accountService = (AccountService) applicationContext.getBean("accountService");
	@Test
	public void testBaseService() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetSessionFactory() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSession() {
		fail("Not yet implemented");
	}

	@Test
	public void testSave() {
		accountService.save(new Account("admid", "admin123"));
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testGet() {
		fail("Not yet implemented");
	}

	@Test
	public void testQuery() {
		List<Account> list = (List<Account>) accountService.query();
		for(Account a : list){
			System.out.println(a.getId());
		}
	}

}
