package myshop;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zc.shop.entities.Customer;
import com.zc.shop.service.CategoryService;
import com.zc.shop.service.CustomerService;

public class CustomerServiceTest {
	ApplicationContext applicationContext=null;
	CustomerService categoryService=null;
	@Before
	public void setUp() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext("applicationContext*.xml");
		categoryService = (CustomerService) applicationContext.getBean("customerService");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Customer customer = new Customer();
		customer.setName("user1");
		customer.setPassword("123");
		System.out.println(categoryService.login(customer));
	}

}
