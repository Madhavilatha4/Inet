package com.inetbanking.utilites;

import java.io.File;
import java.io.FileInputStream;

import java.util.Properties;

public class Readconfig {
Properties pro;
public Readconfig()  {
	try {
	File src=new File("./configuaration/config.properties");
    FileInputStream input=new FileInputStream(src);
    pro=new Properties();
    pro.load(input);
}catch (Exception e) {
	System.out.println("Exception is "+e.getMessage());
}}
	public String geturl() {
		String url=pro.getProperty("url");
		return url;
	}
	
	public String getusername() {
		String username=pro.getProperty("username");
		return username;
	}
	
	public String getpassword() {
		String password=pro.getProperty("password");
		return password;
	}
	
	
	
	}


