package com.visa.prj.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.visa.prj.entity.Booking;

@Controller
@SessionAttributes("user")
public class LoginController {
	@RequestMapping("log.do")
	public String doLogin(Model m) {
		m.addAttribute("booking",new Booking());
		//m.addAttribute("user",b.getUser());
		return "userLoginForm.jsp";
	}
	@RequestMapping("login.do")
	public String doLogin(@RequestParam("email") String email,Model m) {
		m.addAttribute("user",email);
		//System.out.println(b.getUser().getEmail());
		return "index.jsp";
	}
	@RequestMapping("signout.do")
	public String doLogin(HttpServletRequest req) {
		HttpSession ses = req.getSession(false); // dont create a session, work with the existing session
		ses.removeAttribute("user");
		ses.invalidate();
		return "redirect:userLoginForm.jsp";
	}
}
