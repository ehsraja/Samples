package com.rhl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



@Controller
public class ConfigRestController {

	@Autowired
	ConfigService configService ;
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/config", method=RequestMethod.GET, produces="application/json")
	@ResponseBody
	 public Config[] getAllConfigs(){
		 return configService.getAllConfig();
	 }
	
	
}
