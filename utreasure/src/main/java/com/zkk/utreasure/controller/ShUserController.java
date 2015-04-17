package com.zkk.utreasure.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zkk.utreasure.dto.RegisterUser;
import com.zkk.utreasure.entity.ShUser;
import com.zkk.utreasure.service.ShUserServiceI;
import com.zkk.utreasure.utils.UtilCommon;

@Controller
@RequestMapping("/user")
public class ShUserController {
	
	
	private Logger log = Logger.getLogger(ShUserController.class); 
	
	@Autowired
	private  ShUserServiceI  shUserServicei;

	
	
	/**
	 * ��ת��ע�����
	 * @return
	 * @since  2015-4-16 15:44:25
	 */
	@RequestMapping(value="/toRegister")
	public ModelAndView toRegister(){
		return new ModelAndView("register");
	}
	
	
	
	/**
	 * ע�����
	 * @return
	 * @since  2015-4-16 15:44:09
	 */
	@RequestMapping(value="/doRegister")
	public ModelAndView   doRegister(RegisterUser  registerUser){
		//��������  ���ܲ���
		ShUser  shUser=new ShUser();
		//������� 
		//BeanUtils.copyProperties(registerUser, shUser);
		shUser.setEmail(registerUser.getEmail());
		shUser.setLoginName(registerUser.getLoginName());
		shUser.setPassword(UtilCommon.md5Encryption(registerUser.getPassword()));
		shUser.setCreateTime(new Date(System.currentTimeMillis()));
		shUser.setUpdateTime(new Date(System.currentTimeMillis()));
	
		//�쳣��Υ��������Ψһ��������
		try {
			int count=shUserServicei.RegisterUser(shUser);
			if(count!=0){ //ע��ɹ� �����ʼ� 
				//SendEmailThread
				Thread  thread=new Thread(new SendEmailThread(registerUser.getEmail(),registerUser));
				thread.start();	
			}
		} catch (Exception e) {
			log.error("doRegister",e);
		}
		
		//��ȡ�û���Ϣ
		//System.out.println("the count is:"+count+",getid is:"+shUser.getId());
		//��ת����½ҳ�� 
		return new ModelAndView("mainPage");
	}
	
	
	
	/**
	 * �ڲ��෢���ʼ����߳� 
	 * @author Administrator
	 *
	 */
	class  SendEmailThread  implements  Runnable{
		private  String  email;
		private  RegisterUser registerUser;
		//�޲ι���
		public SendEmailThread() {}

		public SendEmailThread(String email, RegisterUser registerUser) {
			this.email=email;
			this.registerUser=registerUser;
		}
		
		public void run() {
			boolean isSend=false;
			try {
				isSend = shUserServicei.sendEmail(email,registerUser);
				if(isSend){
					log.info("�����ʼ��ɹ�");
				}
			} catch (Exception e) {
				log.error("sendemail",e);
				e.printStackTrace();
			}
			
		}
		
	}
	
	/**
	 * ��ȡ�û����Ƿ����
	 * @param request
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value="/getUserName")
	public void getUserName(HttpServletRequest  request,HttpServletResponse  response) throws IOException {
		boolean  flag=false;
		PrintWriter  writer=response.getWriter();
		String loginName=request.getParameter("loginName");
		ShUser  shUser=shUserServicei.validateRepeatName("loginName",loginName);
		//�������
		if(shUser==null) flag=true;
		else  flag=false;	
		writer.println(flag);	
	}
}
