package com.example.Library.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.Library.model.admin;
import com.example.Library.model.user;
import com.example.Library.repository.AdminRepository;
import com.example.Library.repository.BookRepository;
import com.example.Library.repository.IssuedRepository;
import com.example.Library.repository.RequestRepository;
import com.example.Library.repository.UserRepository;

import com.example.Library.model.book;
import com.example.Library.model.issuedbooks;
import com.example.Library.model.request;

@Controller
public class MyController {
	@Autowired
	private UserRepository userrepo; 
	
	@Autowired
	private BookRepository bookrepo;
	
	@Autowired
	private AdminRepository adminrepo;
	
	@Autowired
	private RequestRepository requestrepo;
	
	@Autowired
	private IssuedRepository issuedrepo;
	
	@GetMapping(path = "/main")
	public String getMain() {
		return "main";
	}
	
	@GetMapping(path = "/login")
	public String getlogin() {
		return "login";
	}
	
	@GetMapping(path = "/addbook")
	public String getAddBook() {
		return "addbook";
	}
	
	@GetMapping(path = "/signup")
	public String getSignup() {
		return "signup";
	}
	
	@GetMapping(path = "/admin/login")
	public String getAdmin() {
		return "adminlogin";
	}
	
	@PostMapping(path = "/adminlogin")
	public ResponseEntity<admin> adminlogin(@RequestBody admin admin){
		admin temp=adminrepo.adminexists(admin.getEmail(), admin.getPassword());
		if(temp==null) {
		    return null;
		}
		return new ResponseEntity<admin>(temp, HttpStatus.OK);
	}
	@GetMapping(path = "/admin/login/dash")
	public String getadmindashboard(Model model) {
    	model.addAttribute("books",bookrepo.findAll());
    	model.addAttribute("requests",requestrepo.findAll());
    	
    	return "admindashboard";
	}
	
	
	@PostMapping(path = "/addbook")
	public ResponseEntity<book> addbook(@RequestBody book book){
			//System.out.println("User "+user.getEmail()+" dont exists");
			bookrepo.save(book);
			return new ResponseEntity<book>(book, HttpStatus.OK);
	}
	@PostMapping(path = "/addrequest")
	public ResponseEntity<request> addrequest(@RequestBody request req){
		requestrepo.save(req);
		return new ResponseEntity<request>(req, HttpStatus.OK);
	}
	@PostMapping(path = "/updaterequest/{id}")
	public ResponseEntity<request> updaterequest(@PathVariable int id,@RequestBody request req){
		if(req.getStatus()==1) {
		user user =userrepo.findById(req.getUser_id()).orElse(null);
		book book =bookrepo.findById(req.getBook_id()).orElse(null);
		issuedbooks issued =new issuedbooks();
		issued.setUser_id(req.getUser_id());
		issued.setUser_name(user.getFirst_name());
		issued.setBook_id(req.getBook_id());
		issued.setBook_name(book.getBook_name());
		
		issuedrepo.save(issued);
		requestrepo.deleteById(id);
		return new ResponseEntity<request>(req, HttpStatus.OK);
		}
		
		else {
			requestrepo.deleteById(id);
			return new ResponseEntity<request>(req, HttpStatus.OK);
		}
	}
	
	
	@PostMapping(path = "/signup")
	public ResponseEntity<user> adduser(@RequestBody user user){
		if(userrepo.userexists(user.getEmail())==false) {
			//System.out.println("User "+user.getEmail()+" dont exists");
			userrepo.save(user);
			return new ResponseEntity<user>(user, HttpStatus.OK);
		}
		return null;
	}
	
	@PostMapping(path = "/login")
	public ResponseEntity<user> loginuser(@RequestBody user user){
		user temp=userrepo.userexists(user.getEmail(), user.getPassword());
		if(temp==null) {
		    return null;
		}
		return new ResponseEntity<user>(temp, HttpStatus.OK);
	}
	
	@PostMapping(path = "/profile/{id}")
	public ResponseEntity<user> updateuser(@PathVariable int id,@RequestBody user user){
		//System.out.println(user.getEmail());
		if(userrepo.userexists(user.getEmail())==false) {
			//System.out.println("User "+user.getEmail()+" dont exists");
			
			user user1 = userrepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
			//System.out.println(user1.getEmail());
			user1.setFirst_name(user.getFirst_name());
			user1.setLast_name(user.getLast_name());
			user1.setAge(user.getAge());
			user1.setEmail(user.getEmail());
			userrepo.save(user1);
			return new ResponseEntity<user>(user, HttpStatus.OK);
		}
		return null;
	}
	
	@GetMapping(path = "/dash/{id}")
	public String getdashboard(@PathVariable int id,Model model) {
		user user = userrepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
    	model.addAttribute("user",user);
    	model.addAttribute("books",bookrepo.findAll());
    	
    	return "dashboard";
	}
	
	@GetMapping("/deletebook/{id}")
	public String deletebook(@PathVariable("id") int id ) {        
	    bookrepo.deleteById(id);
	    return "redirect:/admin/login/dash";
	}
	
	@GetMapping(path = "/updatebook/{id}")
	public String updatebook(@PathVariable int id,Model model) {
		book book = bookrepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + id));
	    model.addAttribute("book", book);
	    return "updatebook";
		
	}
	@PostMapping(path = "/updatebook/{id}")
	public ResponseEntity<book> updatebook(@PathVariable int id,@RequestBody book book){
		//System.out.println(user.getEmail());
	
			
			book book1 = bookrepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + id));
			//System.out.println(user1.getEmail());
			book1.setBook_name(book.getBook_name());
			book1.setAuthor_name(book.getAuthor_name());
			book1.setPublishyear(book.getPublishyear());
			bookrepo.save(book1);
			return new ResponseEntity<book>(book1, HttpStatus.OK);
		
	}
	
	
	@GetMapping(path = "/profile/{id}")
	public String getProfile(@PathVariable int id,Model model) {
		user user = userrepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
    	model.addAttribute("user",user);
    	return "profile";
	}
	
	@GetMapping(path = "/yourbooks/{id}")
	public String getBooks(@PathVariable int id,Model model) {
		user user = userrepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
    	model.addAttribute("user",user);
    	model.addAttribute("issue",issuedrepo.getallbooks(id));
    	return "yourbooks";
	}

}
