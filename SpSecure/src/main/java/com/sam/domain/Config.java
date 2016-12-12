package com.sam.domain;

public class Config {
	
  private String profile ;
  private String key ;
  private String value ;
  
  public Config(){
  }
  
  
public Config(String profile, String key, String value) {
	super();
	this.profile = profile;
	this.key = key;
	this.value = value;
}

public String getProfile() {
	return profile;
}
public void setProfile(String profile) {
	this.profile = profile;
}
public String getKey() {
	return key;
}
public void setKey(String key) {
	this.key = key;
}
public String getValue() {
	return value;
}
public void setValue(String value) {
	this.value = value;
}
	

}
