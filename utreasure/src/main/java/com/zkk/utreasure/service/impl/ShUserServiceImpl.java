package com.zkk.utreasure.service.impl;



import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zkk.utreasure.dao.ShUserMapper;
import com.zkk.utreasure.entity.ShUser;
import com.zkk.utreasure.mail.MailSenderInfo;
import com.zkk.utreasure.mail.SimpleMailSender;
import com.zkk.utreasure.service.ShUserServiceI;
import com.zkk.utreasure.service.basic.BaseServiceImpl;
import  com.zkk.utreasure.dto.RegisterUser;


@Service
public class ShUserServiceImpl extends  BaseServiceImpl<ShUser> implements ShUserServiceI {
	
	
	private Logger log = Logger.getLogger(ShUserServiceImpl.class); 
	
	@Autowired
	private ShUserMapper shUserMapper;

	

	public int RegisterUser(ShUser shUser) {
		return shUserMapper.insertSelective(shUser);
	}



	public ShUser validateRepeatName(String fieldName,String fieldValue) {
		//使用map封装对象的值
		Map   paramMap =new HashMap<String,String>();
		paramMap.put("fieldName", fieldName);
		paramMap.put("fieldValue", fieldValue);
		
		//根据字段名，自动获取对象
		return shUserMapper.getByName(paramMap);
	}


	/**
	 * 发送电子
	 */

	public boolean sendEmail(String email,RegisterUser registerUser) throws  MessagingException {
		 boolean isSendOK=false;
		if(email==null)  return isSendOK;
		
		MailSenderInfo mailInfo = new MailSenderInfo();
		//smtp.126.com
		mailInfo.setMailServerHost("smtp.126.com");
		mailInfo.setMailServerPort("25");
		mailInfo.setValidate(true);
		//zhangkang65@126.com
		mailInfo.setUserName("zhangkang65@126.com");
		mailInfo.setPassword("zkk6167489");// 您的邮箱密码
		mailInfo.setFromAddress("zhangkang65@126.com");
		mailInfo.setToAddress(email);
		mailInfo.setSubject("show treasure");
		mailInfo.setContent("欢迎注册二手宝，您的用户名是："+registerUser.getLoginName()+"，密码是:"+registerUser.getPassword()+
				  "<br>"+"请妥善保管您的账号。<br/>"+
				"<a href=\"http://localhost:8080/utreasure/\">直接登录</a>");
		// 这个类主要来发送邮件
		SimpleMailSender sms = new SimpleMailSender();
		//sms.sendTextMail(mailInfo);// 发送文体格式
		isSendOK=sms.sendHtmlMail(mailInfo);// 
		return isSendOK;
	}

		
}



	