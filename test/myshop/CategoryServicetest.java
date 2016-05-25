package myshop;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zc.shop.entities.Account;
import com.zc.shop.entities.Category;
import com.zc.shop.service.CategoryService;

public class CategoryServicetest {
	ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext*.xml");
	CategoryService categoryService = (CategoryService) applicationContext.getBean("categoryService");
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
		Category category = new Category("boy", true);
		Account account = new Account("admid", "admin123");
		category.setAccount(null);
		categoryService.save(category);
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
		List<Category> list = (List<Category>) categoryService.query();
		for(Category c : list){
			System.out.println(c.getId());
		}
	}
	@Test
	public void testDeleteAll(){
		String ids = "1,2,3";
		categoryService.deleteAll(ids);
	}
	@Test
	public void testQueryJoinAccount(){
		for(Category c:categoryService.queryJoinAccount("", 1, 10)){
			System.out.println(c);
		}
	}
	@Test
	public void testQueryHot(){
		for(Category c:categoryService.queryHot()){
			System.out.println(c.getId());
		}
	}
}
