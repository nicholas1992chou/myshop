package myshop;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zc.shop.entities.Category;
import com.zc.shop.entities.Product;
import com.zc.shop.service.ProductService;

public class ProcuctServicetest {
	ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext*.xml");
	ProductService productService = (ProductService) applicationContext.getBean("productService");
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
		
	}

	@Test
	public void testUpdate() {
		Product p = new Product();
		p.setId(25);
		p.setName("aaaa");
		Category category = new Category();
		category.setId(12);
		category.setAccount(null);
		p.setCategory(category);
		productService.update(p);
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
		
	}
	@Test
	public void testDeleteAll(){
		
	}
	@Test
	public void testQueryByPages(){
		List<Product> productList = productService.queryByPages("", 1, 10);
		for(Product p:productList){
			System.out.println(p.getName());
		}
	}
	@Test
	public void testQueryHot(){
		for(Product p: productService.queryCommend(12)){
			System.out.println(p.getName() + ","  + p.getId());
		}
	}
}
