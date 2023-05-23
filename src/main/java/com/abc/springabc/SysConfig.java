package com.abc.springabc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Configuration
public class SysConfig {
	
	@Value("${java.home}")
	public String m_java_home;
	
	
	public String m_user_dir;
	
	public String m_sys_path;
	
	
	
	Environment m_env;
	
	@Autowired
	public SysConfig(Environment env) {
		m_env=env;
		
		m_user_dir=m_env.getProperty("user.dir");
		
		m_sys_path=System.getenv("PATH");
		
	}

}
