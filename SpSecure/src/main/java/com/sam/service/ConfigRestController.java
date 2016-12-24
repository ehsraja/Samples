package com.sam.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.sam.domain.Config;



@RestController
public class ConfigRestController {

	 private static final Logger logger = LoggerFactory.getLogger(ConfigRestController.class);
	
	@Autowired
	ConfigService configService ;
	@RequestMapping(value="/config", method=RequestMethod.GET, produces="application/json")
	 public Config[] getAllConfigs(){
		logger.info("Listing config");
		Config[] configs =  configService.getAllConfig();
		return configs ;
	 }
	
	
	
	@RequestMapping(value="/addConfig", method=RequestMethod.POST)
	public void addConfig(@RequestBody Config config){
		logger.info("Adding config");
		  configService.addConfig(config);
	 }
	
	@RequestMapping(value="/deletConfig/{profile}/{key}", method=RequestMethod.DELETE)
	@ResponseBody
	 public void removeConfig(@PathVariable("profile") String profile, @PathVariable String key){
		logger.info("removing config");  
		configService.removeConfig(profile, key);
	 }
	
	
}
