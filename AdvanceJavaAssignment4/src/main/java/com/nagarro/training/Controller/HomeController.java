package com.nagarro.training.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nagarro.training.InputOutput.Input;
import com.nagarro.training.Model.Size;
import com.nagarro.training.Model.Tshirt;
import com.nagarro.training.Model.User;
import com.nagarro.training.Model.UserInput;
import com.nagarro.training.service.TshirtDao;

@Controller
public class HomeController {

	@Autowired
	TshirtDao dao;

	@RequestMapping("/login")
	public String login(Model m) {
		return "login";
	}

	@RequestMapping(value = "/verify", method = RequestMethod.POST)
	public String verify(@ModelAttribute("user") User u, Model m) {
		System.out.println(u);
		if (u.getUname().equalsIgnoreCase("Anshu") && u.getPassword().equalsIgnoreCase("12345")) {
			return "home";
		} else {
			m.addAttribute("error", "**Enter a valid Username/Password");
			return "login";
		}
	}

	@RequestMapping(value = "/addUserInput", method = RequestMethod.POST)
	public String addUserInput(@ModelAttribute("userInput") UserInput input, ModelMap m) {
		String message = Input.checkValid(input);
		if (message == "valid") {
			List<Tshirt> list = dao.search(input);
			m.addAttribute("list", list);
		} else {
			m.addAttribute("message", message);
		}
		return "home";
	}

	@ModelAttribute("PreferenceList")
	public List<String> PreferenceList() {
		List<String> PreferenceList = new ArrayList<String>();
		PreferenceList.add("1");
		PreferenceList.add("2");
		return PreferenceList;
	}

	@ModelAttribute("sizeList")
	public Size[] getNumbersList() {
		Size[] sizeList = Size.values();
		return sizeList;
	}
}