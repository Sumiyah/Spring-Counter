package com.sumiyah.counter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
    public String index(HttpSession session) {
        return "Home.jsp";
    }
	
	@GetMapping("/counter")
	public String counter(HttpSession session) {
        Integer count = (Integer) session.getAttribute("count");
        if (count == null) {
        	session.setAttribute("count", 0);
        	count = 0;
        }
        count++;
        session.setAttribute("count", count);
		return "Counter.jsp";
	}

}
