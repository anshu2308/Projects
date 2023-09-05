package com.nagarro.training.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.training.model.Author;
import com.nagarro.training.model.Book;
import com.nagarro.training.model.User;
import com.nagarro.training.service.AuthorDao;
import com.nagarro.training.service.ClientService;
import com.nagarro.training.service.userDao;

@Controller
public class HomeController {

	@Autowired
	userDao dao;

	@Autowired
	AuthorDao auDao;

	@Autowired
	private ClientService s;

	List<Book> books;

	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/verify", method = RequestMethod.POST)
	public String verify(@ModelAttribute("user") User u, ModelMap m) {
		List<User> users = dao.getAll();
		for (User user : users) {
			if (user.getUname().equalsIgnoreCase(u.getUname())
					&& user.getPassword().equalsIgnoreCase(u.getPassword())) {
				List<Book> books = s.getbooks();
				m.addAttribute("books", books);
				return "home";

			}
		}
		m.addAttribute("error", "**Enter a valid Username/Password");
		return "login";
	}

	@RequestMapping(value = "/deletebooks", method = RequestMethod.POST)
	public ModelAndView deletebooks(@RequestParam("Id") int code, ModelMap m) {
		s.deletebook(code);
		ModelAndView mv = new ModelAndView();
		books = s.getbooks();
		mv.setViewName("home");
		mv.addObject("books", books);
		return mv;
	}

	@RequestMapping(value = "/newBook", method = RequestMethod.POST)
	public String postBooks(Model m) {
		m.addAttribute("page", "ADD");
		m.addAttribute("baddedDate", LocalDate.now().toString());

		return "add";
	}

	@RequestMapping(value = "/addBook", method = RequestMethod.POST)
	public ModelAndView addBooks(@ModelAttribute("book") Book b) {
		ModelAndView mv = new ModelAndView();
		b.setAddedDate(LocalDate.now().toString());
		s.postbook(b);

		books = s.getbooks();
		mv.setViewName("home");
		mv.addObject("books", books);
		return mv;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String editDetails(@RequestParam("bId") int code, Model m) {
		Book book = s.getbook(code);
		System.out.println(book);
		m.addAttribute("page", "EDIT");
		m.addAttribute("bCode", book.getbCode());
		m.addAttribute("bName", book.getbName());
		m.addAttribute("bAuthor", book.getbAuthor());
		m.addAttribute("baddedDate", book.getAddedDate());
		return "add";
	}

	@RequestMapping(value = "/newUser", method = RequestMethod.POST)
	public String newUser() {
		return "newUser";
	}

	@RequestMapping(value = "/adduser", method = RequestMethod.POST)
	public ModelAndView addUser(@ModelAttribute("user") User u, @RequestParam("password2") String p2) {
		ModelAndView mv = new ModelAndView();
		System.out.println(p2);
		System.out.println(u.getPassword());
		if (!p2.equals(u.getPassword())) {
			mv.setViewName("newUser");
			mv.addObject("error", "***Password Mismatch");
		} else {
			dao.save(u);
			mv.setViewName("login");
			mv.addObject("success", "Account Created");
		}
		return mv;
	}

	@RequestMapping(value = "/editBook", method = RequestMethod.POST)
	public String editBook(@ModelAttribute("book") Book b) {
		System.out.print(b);
		return "home";
	}

	@ModelAttribute("authorList")
	public List<Author> getNumbersList() {
		List<Author> li = auDao.getAll();
		return li;
	}
}
