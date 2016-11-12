package com.rhl;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

@Service("configService")
public class ConfigService {
	
	List <Config> configList = new ArrayList<Config>();
	

	
	 public Config[] getAllConfig(){
		// configList.add(new Config("common","name","rhl"));
		 Config[] configs =  configList.toArray(new Config [configList.size()] );
		 return configs ;
		 
	 }
	 
	 public void addConfig(Config config){
		 System.out.println(" config Added");
		 configList.add(config);	 
	 }
	
	 
	 public void ediConfig(Config config){
		 for(Config c : configList)	 {
			 if(c.getProfile().equals(config.getProfile()) &&  c.getKey().equals(c.getKey())){
				 c.setValue(config.getValue());
			 }
		 }
	 }
	 
	 public void removeConfig(String profile, String key ){
		 Iterator <Config> iterator = configList.iterator();
		 while(iterator.hasNext()){
			 Config c = iterator.next();
			 if(c.getProfile().equals(profile) &&  c.getKey().equals(key)){
				 iterator.remove();
			 }
		 }
		
	 }

}
