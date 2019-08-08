package com.dbs.springmvcapp.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dbs.springmvcapp.model.Tweet;
import com.dbs.springmvcapp.model.User;
import com.dbs.springmvcapp.service.UserService;
import com.dbs.springmvcapp.service.UserServiceImpl;

@Controller
public class UserController {
	
	@Autowired
	public UserService userService;
	
	
	
	@RequestMapping("/")
	public String  dashboard(Model model)
	{
		model.addAttribute("comingFirst",true);
		//List<User> listOfAllUsers  = UserService.listAll();
       // listOfAllUsers.forEach(User ->  System.out.println(User));
		
		return "dashboard";
		
	}
	
	@RequestMapping("/loginPage")
	public String loginPage(Model model)
	{
		return "login";
	}
	
	@RequestMapping("/login")
	@PostMapping
    public String loginUser(
    		@RequestParam("name")String username, 
    		@RequestParam("password") String password,
    		Model model){
		
        System.out.println("Inside the POST method of login user");
        System.out.println("Username is "+username + " password is "+ password);
        
        if(username.equals(password))
        {
        	model.addAttribute("user",username);
        	return "success";
        }
        model.addAttribute("comingFirst",false);	
        return "login";
    }
	
	@RequestMapping("/listAll")
	public String listAll(Model model)
	{	
		List<User> listOfAllUsers  = userService.listAll();
		listOfAllUsers.forEach(user ->  System.out.println(user));
		//List<String> emp_list = Arrays.asList("ajay","vijay","Ramesh");
		model.addAttribute("list",listOfAllUsers);
		return "list";
	}
	@RequestMapping("/delUser")
	public String showDelUserPage()
	{
		return "delUser";
	}
	
	@RequestMapping("/delById")
	public String delById(HttpServletRequest req)
	{
		userService.deleteUser(Integer.parseInt(req.getParameter("id")));
		return "dashboard";
	}
	
	@RequestMapping("/register")
    public String showRegistrationForm(Model model){
        model.addAttribute("User", new User());
        return "register2";
    }
	@RequestMapping("/registerUser")
    public String registerUser( @Valid @ModelAttribute("User") User user,
                                BindingResult bindingResult) throws IOException {
        if(bindingResult.hasErrors()){
            System.out.println("Error "+bindingResult.toString());
           // return "register";
            //throw  new ArithmeticException("Exception occurred");
				throw new IOException("Exception while registering User");
        }

        this.userService.saveUser(user);
        return "dashboard";
    }
	
//	@RequestMapping("/register")
//	public String register(Model model)
//	{
//		return "register";
//	}
//	
//	@RequestMapping("/registerUser")
//	public String registerUser(HttpServletRequest req)
//	{
//		
//		String name = req.getParameter("name");
//		String password = req.getParameter("password");
//		String city = req.getParameter("city");
//		String state= req.getParameter("state");
//		
//		User user = new User();
//		user.setName(name);
//		user.setPassword(password);
//		user.setCity(city);
//		user.setState(state);
//		this.userService.saveUser(user);
//		
//		return "dashboard";
//	}
	@RequestMapping("/updatePage")
	public String updatePage()
	{
		return "update";
	}
	
	@RequestMapping("/updateUser")
	public String updateUser(HttpServletRequest req)
	{
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		String city = req.getParameter("city");
		String state= req.getParameter("state");
		
		User user = new User();
		user.setName(name);
		user.setPassword(password);
		user.setCity(city);
		user.setState(state);
		
		this.userService.saveUser(user);
		return "dashboard";
	}
	
	@RequestMapping("/addTweet")
	public String showTweetPage()
	{
		return "addTweet";
	}
	@RequestMapping("/addTweetToUserId")
	public String addTweetUserId(HttpServletRequest req)
	{
		int id = Integer.parseInt(req.getParameter("id"));
		User user = this.userService.findById(id);
		Set<Tweet> list = user.getTweetSet();
		Tweet tweet =  new Tweet();
		tweet.setMessage(req.getParameter("message"));
		list.add(tweet);
		user.setTweetSet(list);
		tweet.setUser(user);
		this.userService.saveUser(user);
		return "dashboard";
	}
	
	@ExceptionHandler(IOException.class)
	public String handleException(HttpServletRequest request,Exception ex) {return "login";}
	

}
