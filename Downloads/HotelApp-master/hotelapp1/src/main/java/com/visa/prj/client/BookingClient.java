package com.visa.prj.client;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.visa.prj.entity.Hotel;
import com.visa.prj.service.BookingService;

public class BookingClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		
		ctx.scan("com.visa.prj");
		ctx.refresh();
		BookingService bs = ctx.getBean("bookingService",BookingService.class);
		
		Hotel h = bs.getHotelById(20);
		System.out.println(h.getName()+ "," + h.getPrice());
		System.out.println(bs.getUser("a@visa.com","aaaa").getName());
		System.out.println(bs.findHotels("10011:200").toString());
		ctx.close();
		
	}

}
