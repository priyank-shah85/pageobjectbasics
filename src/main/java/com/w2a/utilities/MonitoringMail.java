package com.w2a.utilities;
import java.util.Date;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;



public class MonitoringMail
{
	//public static void sendMail(String mailServer, String from,String username, String password,String port, String[] to, String subject, String messageBody, String attachmentPath, String attachmentName) throws MessagingException, AddressException
	public void sendMail(String mailServer, String from, String[] to, String subject, String messageBody) throws MessagingException, AddressException
	{
//		boolean debug = false;
//		Properties props = new Properties();
//		
//        props.put("mail.smtp.user", from);
//        props.put("mail.smtp.password", "uwzfcsxsxkutjyfm");
//
//        
//		props.put("mail.smtp.starttls.enable", "true");
////		props.put("mail.smtp.EnableSSL.enable","true");
//		props.put("mail.smtp.auth", "true");
//
//		props.put("mail.smtp.host", mailServer); 
////		props.put("mail.debug", "true");
////		props.put("mail.smtp.ssl.trust", mailServer);
//		
////	    props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");   
////	    props.setProperty("mail.smtp.socketFactory.fallback", "false");   
//	    props.setProperty("mail.smtp.port", "587");   
////	    props.setProperty("mail.smtp.socketFactory.port", "587");
//		
//	    Authenticator auth = new SMTPAuthenticator();
//	    Session session = Session.getDefaultInstance(props, auth);
//		session.setDebug(debug);
//		
//		try
//		{
//			/*
//			 * Transport bus = session.getTransport("smtp");
//			 * System.out.println("Bus"+bus.isConnected());
//			 * 
//			 * bus.connect();
//			 */
//            Message message = new MimeMessage(session);
//        
//             message.addHeader("X-Priority", "1");
//             //System.out.println("Before setting from address");
//             message.setFrom(new InternetAddress(from));
//             System.out.println("After setting from address");
//             InternetAddress[] addressTo = new InternetAddress[to.length];
//             for (int i = 0; i < to.length; i++)
//      		 addressTo[i] = new InternetAddress(to[i]);
//             message.setRecipients(Message.RecipientType .TO, addressTo);
//             message.setSubject(subject);
//                               
//             BodyPart body = new MimeBodyPart();
//
//            // body.setText(messageBody);
//            body.setContent(messageBody,"text/html");
//
//             //BodyPart attachment = new MimeBodyPart();
//             //DataSource source = new FileDataSource(attachmentPath);
//            // attachment.setDataHandler(new DataHandler(source));
//             //attachment.setFileName(attachmentName);
//             MimeMultipart multipart = new MimeMultipart();
//             multipart.addBodyPart(body);
//            // multipart.addBodyPart(attachment);
//             message.setContent(multipart);
//             System.out.println("Before sending mail");
//             Transport.send(message);
//             System.out.println("After sending mail");
//             System.out.println("Sucessfully Sent mail to All Users");
//         	 //bus.close();
// 			System.out.println("In Finish6");

//		}
//		catch (MessagingException mex)
//		{
//			System.out.println("mextest"+mex);
//            mex.printStackTrace();
//        }
//		catch (Exception ex)
//		{
//			System.out.println("test"+ex);
//            ex.printStackTrace();
//        }
		
		Properties props = new Properties();
		props.put("mail.smtp.starttls.enable", "true");
	    props.put("mail.smtp.host", "smtp.gmail.com");
	    Session session = Session.getInstance(props, null);
	    try {
	        MimeMessage msg = new MimeMessage(session);
	        msg.setFrom("shahpriyank1985@gmail.com");
	        msg.setRecipients(Message.RecipientType.TO,"shahpriyank1985@gmail.com");
	        msg.setSubject("JavaMail hello world example");
	        msg.setSentDate(new Date());
	        msg.setText("Hello, world!\n");
	        
	        Transport.send(msg, "shahpriyank1985@gmail.com", "Prince19@08");
	    } catch (MessagingException mex) {
	        System.out.println("send failed, exception: " + mex);
	    }
	    finally {
	    }
	} 
	
	private class SMTPAuthenticator extends javax.mail.Authenticator
	{

	    public PasswordAuthentication getPasswordAuthentication()
	    {
	        String username = TestConfig.from;
	        String password = TestConfig.password;
	        return new PasswordAuthentication(username, password);
	    }
	}
	
}
