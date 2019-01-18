package com.nt.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.nt.command.RegisterCommand;

public class RegisterCommandValidator implements Validator {
	
	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(RegisterCommand.class);
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		RegisterCommand cmd=null;
		//type casting
		cmd=(RegisterCommand)target;
		if(cmd.getName().equals("") || cmd.getName().length()==0 || cmd.getName()==null)
			 errors.rejectValue("name", "name.required", "name must be typed");
	}
	
	

}
