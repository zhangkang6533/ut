package com.zkk.utreasure.mail;

  

import java.util.Date;    
import java.util.Properties;   
import javax.mail.Address;    
import javax.mail.BodyPart;    
import javax.mail.Message;    
import javax.mail.MessagingException;    
import javax.mail.Multipart;    
import javax.mail.Session;    
import javax.mail.Transport;    
import javax.mail.internet.InternetAddress;    
import javax.mail.internet.MimeBodyPart;    
import javax.mail.internet.MimeMessage;    
import javax.mail.internet.MimeMultipart;    
  
/**   
* �?��邮件（不带附件的邮件）发送器   
http://www.bt285.cn BT下载
*/    
public class SimpleMailSender  {    
/**   
  * 以文本格式发送邮�?  
  * @param mailInfo 待发送的邮件的信�?  
  */    
    public boolean sendTextMail(MailSenderInfo mailInfo) {    
      // 判断是否�?��身份认证    
      MyAuthenticator authenticator = null;    
      Properties pro = mailInfo.getProperties();   
      if (mailInfo.isValidate()) {    
      // 如果�?��身份认证，则创建�?��密码验证�?   
        authenticator = new MyAuthenticator(mailInfo.getUserName(), mailInfo.getPassword());    
      }   
      // 根据邮件会话属�?和密码验证器构�?�?��发�?邮件的session    
      Session sendMailSession = Session.getDefaultInstance(pro,authenticator);    
      try {    
      // 根据session创建�?��邮件消息    
      Message mailMessage = new MimeMessage(sendMailSession);    
      // 创建邮件发�?者地�?   
      Address from = new InternetAddress(mailInfo.getFromAddress());    
      // 设置邮件消息的发送�?    
      mailMessage.setFrom(from);    
      // 创建邮件的接收�?地址，并设置到邮件消息中    
      Address to = new InternetAddress(mailInfo.getToAddress());    
      mailMessage.setRecipient(Message.RecipientType.TO,to);    
      // 设置邮件消息的主�?   
      mailMessage.setSubject(mailInfo.getSubject());    
      // 设置邮件消息发�?的时�?   
      mailMessage.setSentDate(new Date());    
      // 设置邮件消息的主要内�?   
      String mailContent = mailInfo.getContent();    
      mailMessage.setText(mailContent);    
      // 发�?邮件    
      Transport.send(mailMessage);   
      return true;    
      } catch (MessagingException ex) {    
          ex.printStackTrace();    
      }    
      return false;    
    }    
       
    /**   
      * 以HTML格式发�?邮件   
      * @param mailInfo 待发送的邮件信息   
      */    
    public static boolean sendHtmlMail(MailSenderInfo mailInfo){    
      // 判断是身份认证    
      MyAuthenticator authenticator = null;   
      Properties pro = mailInfo.getProperties();   
      //如果密码验证   
      if (mailInfo.isValidate()) {    
        authenticator = new MyAuthenticator(mailInfo.getUserName(), mailInfo.getPassword());   
      }    
      // 根据邮件会话属session    
      Session sendMailSession = Session.getDefaultInstance(pro,authenticator);    
      try {    
      // 根据session创建
      Message mailMessage = new MimeMessage(sendMailSession);    
      // 创建邮件发
      Address from = new InternetAddress(mailInfo.getFromAddress());    
      // 设置邮件消息的发送   
      mailMessage.setFrom(from);    
      // 创建邮件的接收  
      Address to = new InternetAddress(mailInfo.getToAddress());    
      // Message.RecipientType.T
      mailMessage.setRecipient(Message.RecipientType.TO,to);    
      // 设置邮件消息的
      mailMessage.setSubject(mailInfo.getSubject());    
      // 设置邮件消息发
      mailMessage.setSentDate(new Date());    
      // MiniMultipart类是
      Multipart mainPart = new MimeMultipart();    
      // 包含HTML内容的MimeBodyPart    
      BodyPart html = new MimeBodyPart();    
      // 设置HTML内容    
      html.setContent(mailInfo.getContent(), "text/html; charset=utf-8");    
      mainPart.addBodyPart(html);    
      // 将MiniMultipart对象设置为邮件
      mailMessage.setContent(mainPart);    
      // 
      Transport.send(mailMessage);    
      return true;    
      } catch (MessagingException ex) {    
          ex.printStackTrace();    
      }    
      return false;    
    }    
}   