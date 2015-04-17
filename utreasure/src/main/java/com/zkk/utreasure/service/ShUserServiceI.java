package com.zkk.utreasure.service;
import javax.mail.MessagingException;

import  com.zkk.utreasure.dto.RegisterUser;
import com.zkk.utreasure.entity.ShUser;



public interface ShUserServiceI {

	int RegisterUser(ShUser shUser);

	ShUser validateRepeatName(String loginName, String loginName2);

	boolean sendEmail(String email, RegisterUser registerUser) throws MessagingException;
	
}
