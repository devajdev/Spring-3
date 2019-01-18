package com.nt.locator;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.nt.extComp.ICCScoreComp;
import com.nt.extComp.ICCScoreCompImpl;

@Component("iccLocator")
public class ICCScoreCompServiceLocator implements FactoryBean<ICCScoreComp> {
	@Value("icc")
	private String jndiName;
	private Map<String,ICCScoreComp> cacheMap=new HashMap();

	

	
	
	public ICCScoreComp getObject() throws Exception {
		ICCScoreComp iccComp=null;
		if(!cacheMap.containsKey(jndiName)){
		  iccComp=new ICCScoreCompImpl(); //Actually we should it through jndi lookup operation
		  cacheMap.put(jndiName,iccComp);
		}
		return cacheMap.get(jndiName);
		  
	}

	public Class<?> getObjectType() {
		return ICCScoreComp.class;
	}
	
	public boolean isSingleton() {
		return true;
	}
	

}
