package com.luv2code.springdemo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")  //this is parent mapping at controller level 
public class HelloWorldController {
	//Need a controller method to show the initial HTML  form
	
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	
	}
    	
	//Need a controller method to process the HTML form
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	//add new controller method to read form data and to add data to the model
	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request,Model model) {
		
		//read the request parameter from html form
		String theName=request.getParameter("studentName");
		//convert into all upper case
		theName=theName.toUpperCase();
		//create the message
		String result ="Yo! "+theName;
		//add message to the Model
		model.addAttribute("message", result);
		
		return "helloworld";
	}
	
	//add new controller method to read form data and to add data to the model
		@RequestMapping("/processFormVersionThree")
		public String processFormVersionThree(
				@RequestParam("studentName") String theName,
				Model model) {
			
			//convert into all upper case
			theName=theName.toUpperCase();
			//create the message
			String result ="Hey My Friend from v3 "+theName;
			//add message to the Model
			model.addAttribute("message", result);
			
			return "helloworld";
		}
}
