package ua.igororlov92.chessapp.services;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	private static final Logger logger = LoggerFactory.getLogger(EmailService.class);
	
	@Autowired
	private JavaMailSenderImpl googleMailSender;
	
	@Value("#{chessappConfig['email.gmail.username']}")
	private String username;
	
	@Value("#{chessappConfig['email.gmail.personal']}")
	private String personal;
	
	/**
	 * Send email with default Gmail parameters.
	 */
	public void sendEmail(String toEmail, String subject, String message) {
		sendEmail(new String[]{ toEmail }, username, personal, subject, message);
	}
	
	public void sendEmail(String[] toEmails, String fromEmail, String fromPersonal, 
			String subject, String message) {
		
		MimeMessage mimeMessage = googleMailSender.createMimeMessage();
		
		if (toEmails.length == 0) {
			throw new IllegalArgumentException("No target email was specified!");
		}
		
		try {
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
			
			helper.setFrom(fromEmail, fromPersonal);
			helper.setTo(toEmails);
			
			helper.setText(message);
			helper.setSubject(subject);
			
		} catch (MessagingException | UnsupportedEncodingException e) {
			throw new IllegalArgumentException("Incorrect data. Unable to create email message.");
		}

		googleMailSender.send(mimeMessage);
		logger.debug("Email successfully sent.");
	}
	
	
}
