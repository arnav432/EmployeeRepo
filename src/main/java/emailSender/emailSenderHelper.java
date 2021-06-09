package emailSender;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class emailSenderHelper {

	public static Logger logger = LoggerFactory.getLogger(emailSenderHelper.class);

	public static final String RECIPIENT = "arnavmalhotra338@gmail.com";
	
	static String accountEmail = getEmail();
	
	static String password = getPassword();
	
	private static Properties properties = getProperties();
	
	
	static Session session = Session.getInstance(properties, new Authenticator() {
		
		@Override
		protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(accountEmail, password);
		}
	});

	public static void sendPriceDropMail(String LINK, float currentPrice, float lastObservedPrice)
			throws MessagingException {

		logger.info("Preparing to send messsage...");

		Message message = preparePriceDropMessage(session, accountEmail, LINK, currentPrice, lastObservedPrice);
		
		sendMail(message);

	}

	private static Message preparePriceDropMessage(Session session, String accountEmail, String LINK,
			float currentPrice, float lastObservedPrice) {
		Message message = new MimeMessage(session);
		
		try {
			message.setFrom(new InternetAddress(accountEmail));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(RECIPIENT));
			message.setSubject("Order Tracker");
			message.setText("Price for " + LINK + " has changed from " + lastObservedPrice + " to "
					+ currentPrice);
			return message;
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}

		return null;
	}

	
	public static void sendStockStatusMessage(String LINK, float currentPrice) {
		logger.info("Sending product stock status message...");
		Message message = new MimeMessage(session);
		
		try {
			message.setFrom(new InternetAddress(accountEmail));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(RECIPIENT));
			message.setSubject("Order Tracker - Status Message");
			message.setText("BINGO !!!! Product came back in stock..  "+LINK+" with price of "+currentPrice);
			sendMail(message);
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
	}

	
	
	public void sendVaccineAvailibilityMessage() {
		
		logger.info("Sending vaccine availablity message...");
		Message message = new MimeMessage(session);
		
		try {
			message.setFrom(new InternetAddress(accountEmail));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(RECIPIENT));
			message.setSubject("Vaccine Slot Available");
			message.setText("!!!!!!!!!!!!!Vaccine is available!!!!!!!!!!");
			sendMail(message);
			
			message.setFrom(new InternetAddress(accountEmail));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress("Arnav.Malhotra@lntinfotech.com"));
			message.setSubject("Vaccine Slot Available");
			message.setText("!!!!!!!!!!!!!Vaccine is available!!!!!!!!!!");
			sendMail(message);
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
	}

	
	public void sendApplicationStopMessage() {
		logger.info("Sending aplication stopping message...");
		Message message = new MimeMessage(session);
		
		try {
			message.setFrom(new InternetAddress(accountEmail));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(RECIPIENT));
			message.setSubject("Order Tracker - application stopped");
			message.setText("!!!!!!!!!!!!!Application has been stopped !!!");
			sendMail(message);
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
	}
	
	public void sendStopTrackingMessage() {
		logger.info("Sending stop tracking message...");
		Message message = new MimeMessage(session);
		
		try {
			message.setFrom(new InternetAddress(accountEmail));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(RECIPIENT));
			message.setSubject("Order Tracker - order tracking stopped");
			message.setText("!!!!!!!!!!!!!Order tracking has been stopped !!!");
			sendMail(message);
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void sendMail(Message message) {
		try {
			Transport.send(message);
			logger.info("!!!!!!!!!!!!!!!!!!!!!Message sent successfully!!!!!!!!!!!!!!!!!!!!!");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
	}
	
	private static Properties getProperties()  {
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		//properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		//properties.put("mail.smtp.starttls.enable", "true");
		return properties;
	}
	
	public static String getEmail() {
		return "myriadprojects123@gmail.com";
	}
	
	public static String getPassword() {
		return "Arnav@123";
	}

	

	
	

	

}
