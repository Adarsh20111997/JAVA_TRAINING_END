package com.visa.prj.client;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.visa.prj.entity.Product;
import com.visa.prj.service.OrderService;

public class ProductClient {

	public static void main(String[] args) {
		//create Spring container
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		//ApplicationContext ctx = new ClassPathXmlApplicationContext("app.xml");
		/*
		 * app.xml
		 * <bean id="a" class="com.visa.prj.dao.ProductDaoJpaImpl" />
		 * <bean id="b" class="com.visa.prj.service.OrderService" auto-wire="byType" />
		 * ctx.getBean("b",OrderService.class);
		 * */
		
		ctx.scan("com.visa.prj");
		ctx.refresh();
		
		OrderService os = ctx.getBean("orderService", OrderService.class);
		// spring container always creates an object same as classname but first letter is lowercase
		/*
		Product p = new Product(0,"MS Mouse","Computer",45.00, 10);
		os.insertProduct(p);
		System.out.println("Inserted:" + p.getId());
		p = os.getById(1);
		System.out.println(p.getName() + "," + p.getCategory() + "," + p.getPrice());
		*/
		List<Product> list = os.fetchProducts();
		for (Product p : list) {
			System.out.println(p.getName() + "," + p.getPrice());
		}
	
	}

}
