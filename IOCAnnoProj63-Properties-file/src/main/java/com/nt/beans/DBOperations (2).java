package com.nt.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("dbo")
public class DBOperations {
	@Value("${jdbc.driver}")
	private String driver;
	
	@Value("${jdbc.url}")
	private String url;
	@Value("${jdbc.user}")
	private String username;
	@Value("${jdbc.pwd}")
	private String pwd;
	@Value("${os.name}")
	private String os;
	
	@Override
	public String toString() {
		return "DBOperations [driver=" + driver + ", url=" + url + ", username=" + username + ", pwd=" + pwd + ", os="
				+ os + "]";
	}
	
	

}
