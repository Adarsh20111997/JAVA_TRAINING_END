package com.visa.prj.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.visa.prj.entity.Customer;
import com.visa.prj.entity.Item;
import com.visa.prj.entity.Order;
import com.visa.prj.entity.Product;
import com.visa.prj.service.OrderService;

@Controller
public class ProductController {
	@Autowired // it is managed by spring container so autowired is used else ctx.getBean
	private OrderService os;
	
	@Autowired
	private ProductValidator validator;
	
	@RequestMapping("listproducts.do")
	public ModelAndView getProducts() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("list.jsp");
		mav.addObject("products",os.fetchProducts());  // list name in list.jsp
		return mav;
	}
	@RequestMapping("productform.do")
	public ModelAndView getProductForm() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("form.jsp");
		mav.addObject("product", new Product());
		return mav;
	}
	@RequestMapping("addProduct.do")
	public String addProduct(@ModelAttribute("product") Product p,BindingResult errors,  Model m) {
		validator.validate(p, errors);
		if(errors.hasErrors()) {
			return "form.jsp";
		}
		else {
			os.insertProduct(p);
			m.addAttribute("msg","Product added successfully!!");
			return "index.jsp";
		}
		
	}
	
	
	@RequestMapping("cart.do")
	public String addToCart(HttpServletRequest req) {	
		String[] prds = req.getParameterValues("prds"); // only product ids
		String email = req.getSession().getAttribute("user").toString();
		
		os.createOrder(prds,email);
		return "index.jsp";
	}
}