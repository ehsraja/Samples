package com.rhl;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




@Controller
public class MainController {
	
	  @RequestMapping(value="/use",method = RequestMethod.GET)
	    public String homepage(){
	    	System.out.println("in Method");
	        return "homeServiceRest";
	    }
	  
	 
	  
	  

}
