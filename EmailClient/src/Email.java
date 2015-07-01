import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.activation.CommandMap;
import javax.activation.MailcapCommandMap;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import net.fortuna.ical4j.data.CalendarBuilder;
import net.fortuna.ical4j.data.CalendarOutputter;
import net.fortuna.ical4j.data.ParserException;
import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.model.ContentBuilder;
import net.fortuna.ical4j.model.ValidationException;

import org.apache.commons.mail.ByteArrayDataSource;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;


public class Email {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Test");
		try {
			//sendCalendarEvent("doviettrung1802@gmail.com", "trung.do@axonactive.vn");
			sendMail();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void sendCalendarEvent(
			final String mailTo, final String mailFrom) throws Exception {
		FileInputStream fin = new FileInputStream("D:/mycalendar.ics");

		CalendarBuilder builder = new CalendarBuilder();

		Calendar calendar = builder.build(fin);

		byte[] attachmentData = calendarAsByteArray(calendar);
		MailcapCommandMap mc = (MailcapCommandMap) CommandMap.getDefaultCommandMap();
        mc.addMailcap("text/html;; x-java-content-handler=com.sun.mail.handlers.text_html");
        mc.addMailcap("text/xml;; x-java-content-handler=com.sun.mail.handlers.text_xml");
        mc.addMailcap("text/plain;; x-java-content-handler=com.sun.mail.handlers.text_plain");
        mc.addMailcap("text/calendar;; x-java-content-handler=com.sun.mail.handlers.text_plain");
        mc.addMailcap("multipart/*;; x-java-content-handler=com.sun.mail.handlers.multipart_mixed");
        mc.addMailcap("message/rfc822;; x-java-content-handler=com.sun.mail.handlers.message_rfc822");
        CommandMap.setDefaultCommandMap(mc);
		MultiPartEmail email = new MultiPartEmail();
		email.setHostName("axonvn-msvr2.teledata.local");
		email.setSmtpPort(25);
		try {
		email.addTo(mailTo);
		email.setFrom(mailFrom);
		email.setSubject("test mail");
		//email.setMsg("2222222222222");
		String name = "FullDay" + ".ics";
		String contentType = String.format("text/calendar; method=REQUEST;charset='UTF-8';name='%s'", name);
		email.attach(new ByteArrayDataSource(attachmentData, contentType),
		      name, "", EmailAttachment.ATTACHMENT);
		
      
        email.send();
		} catch (EmailException e) {
		}
	}
	public static void sendMail() throws MessagingException, IOException, Exception {
		FileInputStream fin = new FileInputStream("D:/mycalendar.ics");
		CalendarBuilder builder = new CalendarBuilder();

		Calendar calendar = builder.build(fin);

		String to = "trung.do@axonactive.vn";
	    String subject = "subject";
	    String msg ="email text....";
	    final String from ="doviettrung1802@gmail.com";
	    final  String password ="gumiquito89";


	    Properties props = new Properties();  
	    props.setProperty("mail.transport.protocol", "smtp");     
	    props.setProperty("mail.host", "smtp.gmail.com");  
	    props.setProperty("mail.smtp.auth", "true"); 
	    props.put("mail.smtp.port", "465");  
	    props.put("mail.debug", "true");  
	    props.put("mail.smtp.socketFactory.port", "465");  
	    props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");  
	    props.put("mail.smtp.socketFactory.fallback", "false");
	    //Ivy.log().info("000");
	    Session session = Session.getInstance(props,
	    		
	    new javax.mail.Authenticator() {
	    	
	       protected PasswordAuthentication getPasswordAuthentication() {
	    	   //Ivy.log().info("111");
	       return new PasswordAuthentication(from,password);  
	       }  
	    });  
	    //Ivy.log().info("222");
	   //session.setDebug(true);  
	   Transport transport = session.getTransport();  
	   InternetAddress addressFrom = new InternetAddress(from);  

	   MimeMessage message = new MimeMessage(session);  
	   
	   message.setSender(addressFrom);  
	   message.setSubject(subject);  
	   message.setContent(msg, "text/plain");  
	   message.setHeader("Content-type", "text/calendar");
       message.addHeader("method", "REQUEST");
       message.addHeader("charset", "UTF-8");
       
	   message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
	   message.addHeaderLine("BEGIN:VCALENDAR");
	   message.addHeaderLine("VERSION:2.0");
	   message.addHeaderLine("METHOD:PUBLISH");
	   message.addHeaderLine("BEGIN:VEVENT");
	   message.addHeaderLine("CREATED:20140120T124321Z");
	   message.addHeaderLine("DTEND;VALUE=DATE:20140123");
	   message.addHeaderLine("UID:Xpert.Absence-1");
	   message.addHeaderLine("DTSTAMP:20140120T124321Z");
	   message.addHeaderLine("DTSTART;VALUE=DATE:20140122");
	   message.addHeaderLine("SEQUENCE:0");
	   message.addHeaderLine("SUMMARY:Absence Category23432423");
	   message.addHeaderLine("X-MICROSOFT-CDO-BUSYSTATUS:OOF");
	   message.addHeaderLine("ORGANIZER:noreply@soreco.ch");
	   message.addHeaderLine("END:VEVENT");
	   message.addHeaderLine("END:VCALENDAR");

	  /* MimeBodyPart messageBodyPart1 = new MimeBodyPart();
       messageBodyPart1.attachFile("D:/mycalendar.ics");
       messageBodyPart1.setHeader("Content-type", "text/calendar");
       messageBodyPart1.addHeader("method", "REQUEST");
       messageBodyPart1.addHeader("charset", "UTF-8");
       MimeMultipart multipart = new MimeMultipart("mixed");
       multipart.addBodyPart(messageBodyPart1);
       message.setContent(multipart);*/
       
       message.saveChanges();
	   transport.connect();  
	   Transport.send(message);  
	   transport.close();
	 
	   
	}
	public static byte[] calendarAsByteArray(final  net.fortuna.ical4j.model.Calendar iCalendar) throws Exception {
	    byte[] bytes;
	    try {
	        ByteArrayOutputStream output;
	        output = new ByteArrayOutputStream();
	        CalendarOutputter outputter = new CalendarOutputter();
	        outputter.output(iCalendar, output);
	        bytes = output.toByteArray();
	    } catch (ValidationException e) {
	        throw e;
	    } catch (IOException e) {
	        throw  e;
	    }
	    return bytes;
	}
}
