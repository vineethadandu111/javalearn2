package com.vineetha.v.demo.controllers;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class MainController {
	@Autowired
	private JavaMailSender sender;
	
	@RequestMapping("/")
    @ResponseBody
    public String home() {
        return "Hello World!";
    }
	
	@RequestMapping("/sendMail")
	public String sendMail() {
	MimeMessage message =sender.createMimeMessage();
	MimeMessageHelper helper = new MimeMessageHelper(message);
	String returnMessage=""; 
	try {
         helper.setTo("vineethadandu111@gmail.com");
         helper.setText("Greetings :)");
         helper.setSubject("Mail From Spring Boot");
     } catch (Exception e) {
         //e.printStackTrace();  
         returnMessage = "Error in sending email ... ";
     }
	sender.send(message);
	returnMessage= "MAil sent successfully !!";
	return returnMessage;
	
	
	}
}
