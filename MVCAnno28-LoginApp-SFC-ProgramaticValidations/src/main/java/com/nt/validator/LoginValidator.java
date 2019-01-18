package com.nt.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.nt.command.UserCommand;

@Component
public class LoginValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(UserCommand.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserCommand cmd=null;
		//type casting
		cmd=(UserCommand)target;
		//server side form validation logic
		if(cmd.getUsername().length()==0 || cmd.getUsername()==null ||cmd.getUsername().equals(""))
			errors.rejectValue("username","username.required");
		else if(cmd.getUsername().length()<3)
			errors.rejectValue("username","username.length");
		
		if(cmd.getPassword().length()==0 || cmd.getPassword()==null ||cmd.getPassword().equals(""))
			errors.rejectValue("password","password.required");
		else if(cmd.getPassword().length()<3)
			errors.rejectValue("password","password.length");
		
		
		
		
		
	}

}
