package com.visa.prj.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.annotations.Cascade;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.visa.prj.entity.Product;

@Controller
@SessionAttributes("user") // tells spring the attribute should be in session scope not in request scope
public class LoginController {
	
	@RequestMapping("login.do")
	public String doLogin(@RequestParam("email") String email, @RequestParam("pwd") String pwd, Model m){
	// validation	
	m.addAttribute("user",email);
	return "listproducts.do";
	}

	@RequestMapping("signout.do")
	public String doLogin(HttpServletRequest req) {
		HttpSession ses = req.getSession(false);
		ses.removeAttribute("user");
		ses.invalidate();
		return "redirect:login.html"; //client-side redirection ... by default it is server side redirection
	}
	
	
}
