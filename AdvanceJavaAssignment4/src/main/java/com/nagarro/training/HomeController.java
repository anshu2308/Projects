package com.nagarro.training;

import javax.servlet.ServletContext;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.training.Model.Size;

@Controller
public class HomeController {

	@Autowired
	ServletContext context;

	@Autowired
	TodoDao todoDao;

	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/verify", method = RequestMethod.POST)
	public String verify(@ModelAttribute("uname") String name, @ModelAttribute("password") String pass) {
		if (name.equalsIgnoreCase("Anshu") && pass.equalsIgnoreCase("12345")) {
			return "home";
		}
		return "login";
	}

	@RequestMapping("/home")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView();
		Size[] size = Size.values();
		System.out.println(size.length);
		mv.setViewName("home");

		return mv;
	}

	@RequestMapping("/checkInput")
	public String checkInput(@ModelAttribute("size") String size, @ModelAttribute("gender") String gender, Model m) {
		if (gender.equals("") || size.equals("NONE")) {
			if (gender.equals("")) {
				String msg1 = "Invalid size";
				System.out.println(msg1);
				m.addAttribute("error1", "Invalid size");
			}
			if (size.equals("NONE")) {
				m.addAttribute("error2", "Choose a gender");
				
			}
			return "home";
		} else {
			System.out.print(gender + " " + size);
			return "result";
		}
	}

}
