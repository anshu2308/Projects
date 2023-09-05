package com.nagarro.training;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class HomeController {

	
	@Autowired
    private ServiceImp service;
	
	@Autowired
	private ClientService s;
	
	@RequestMapping("/login")
	public String login() {
		System.gc();
		return "login";
	}

	@RequestMapping(value = "/verify", method = RequestMethod.POST)
	public String verify(@ModelAttribute("user") User u, ModelMap m) {
		if (u.getUname().equalsIgnoreCase("Anshu") && u.getPassword().equalsIgnoreCase("12345")) {
			List<Book> books=s.getbooks();
			m.addAttribute("books", books);
		
			return "home";
		} else {
			m.addAttribute("error", "**Enter a valid Username/Password");

			return "login";
		}
	}
	
	@RequestMapping(value = "/deletebooks", method = RequestMethod.POST)
	public String deletebooks(@RequestParam("Id") int code, ModelMap m) {
//		ModelAndView mv=new ModelAndView();
//				mv.setViewName("home");
//				System.out.println(code);
//               List<Book> books=s.getbooks();
//               s.getbook();
//               s.postbook();
               s.deletebook(code);
//				mv.addObject("books",books);
			
				return "verify";
				
	}
	
	@RequestMapping(value = "/postBooks", method = RequestMethod.POST)
	public String postBooks() {
//		s.postbook();
		return "edit";
	}
	@RequestMapping(value = "/addBook", method = RequestMethod.POST)
	public String addBooks(@ModelAttribute("book") Book b,Model m) {
		LocalDate date=LocalDate.now();
		m.addAttribute("addedDate",date);
//		System.out.println(d);
		s.postbook(b);
		return "edit";
	}
	
	
}
