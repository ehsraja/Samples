package com.rhl;


import org.springframework.stereotype.Service;

@Service("configService")
public class ConfigService {
	
	 public Config[] getAllConfig(){
		 Config [] configs = new Config[3];
		 configs[0] = new Config ("common", "name", "rhl");
		 configs[1] =	new Config ("common", "region", "NY");	 
		 configs[2] =	new Config ("common", "lan", "EN");	 
		 return configs;
		 
	 }
	

}
