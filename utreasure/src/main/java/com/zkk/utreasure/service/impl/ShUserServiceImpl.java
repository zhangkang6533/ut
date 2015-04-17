package com.zkk.utreasure.service.impl;



import java.util.HashMap;
import java.util.Map;

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
		//ʹ��map��װ�����ֵ
		Map   paramMap =new HashMap<String,String>();
		paramMap.put("fieldName", fieldName);
		paramMap.put("fieldValue", fieldValue);
		
		//�����ֶ������Զ���ȡ����
		return shUserMapper.getByName(paramMap);
	}


	/**
	 * ���͵���
	 */

	public boolean sendEmail(String email,RegisterUser registerUser) {
		if(email==null)  return false;
		
		try {
		MailSenderInfo mailInfo = new MailSenderInfo();
		mailInfo.setMailServerHost("smtp.126.com");
		mailInfo.setMailServerPort("25");
		mailInfo.setValidate(true);
		mailInfo.setUserName("zhangkang65@126.com");
		mailInfo.setPassword("zkk6167489");// ������������
		mailInfo.setFromAddress("zhangkang65@126.com");
		mailInfo.setToAddress(email);
		mailInfo.setSubject("show treasure");
		mailInfo.setContent("��ӭע����ֱ��������û����ǣ�"+registerUser.getLoginName()+"��������:"+registerUser.getPassword()+
				  "<br>"+"�����Ʊ��������˺š�<br/>"+
				"<a href=\"http://localhost:8080/utreasure/\">ֱ�ӵ�¼</a>");
		// �������Ҫ�������ʼ�
		SimpleMailSender sms = new SimpleMailSender();
		//sms.sendTextMail(mailInfo);// ���������ʽ
		sms.sendHtmlMail(mailInfo);// ����html��ʽ
		}catch(Exception e){
			log.error("sendEmail",e);
			e.printStackTrace();
		}
		return true;
	}

		
		private ShUser getUserByEmail(String email) {
			
			return null;
		}



		



}



	