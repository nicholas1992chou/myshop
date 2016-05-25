package com.zc.shop.Utils;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MessageUtil {
	public void sendMessage(String address, String id){
		//创建java.mail.session
				Properties props = new Properties();
				props.setProperty("mail.transport.protocol", "smtp");
				Session session = Session.getDefaultInstance(props);
				session.setDebug(true);
				//create a java.mail.Message instance
				Message message = new MimeMessage(session);
				//transport
				Transport transport = null;
				//writing message
				try {
					//subject
					message.setSubject("order number");
					//content
					message.setContent(id,"text/html;charset=utf-8");
					//sender
					message.setFrom(new InternetAddress("zhouchuan199211@sina.com"));
					//connect sina sever
					transport = session.getTransport();
					transport.connect("smtp.sina.com","zhouchuan199211@sina.com", "zhouchuan");
					//sending message to dest.
					transport.sendMessage(message, new Address[]{new InternetAddress(address)});
					
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					throw new RuntimeException(e);
				}finally{
					try {
						transport.close();
					} catch (MessagingException e) {
						// TODO Auto-generated catch block
						throw new RuntimeException(e);
					}
				}
	}
	
}
