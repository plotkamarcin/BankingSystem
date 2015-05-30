package logic;

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
import javax.mail.internet.MimeMessage.RecipientType;

public class EmailValidator {

	private Properties mailServerProperties;
	private Session mailSession;
	private MimeMessage generateMailMessage;

	public Properties getMailServerProperties() {
		return mailServerProperties;
	}

	public Session getMailSession() {
		return mailSession;
	}

	public MimeMessage getGenerateMailMessage() {
		return generateMailMessage;
	}

	public EmailValidator() {

	}

	public EmailValidator(Properties props, Session session) {
		this.mailServerProperties = props;
		this.mailSession = session;
	}

	public void composeMessage(String recipient, String token)
			throws MessagingException, AddressException {
		generateMailMessage = new MimeMessage(mailSession);
		generateMailMessage.addRecipient(Message.RecipientType.TO,
				new InternetAddress(recipient));
		generateMailMessage.setSubject("BANKING APP VALIDATION TOKEN");
		String emailBody = "This is your login verification token: " + token;
		generateMailMessage.setContent(emailBody, "text/html");
	}

	public void setMailServerProperties() throws AddressException,
			MessagingException {
		mailServerProperties = System.getProperties();
		mailServerProperties.put("mail.smtp.port", "587");
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.starttls.enable", "true");
		setMailSession();
	}

	public void setMailSession() throws AddressException, MessagingException {
		mailSession = Session.getDefaultInstance(mailServerProperties, null);

	}

	private void prepareTransportSession() throws MessagingException {
		Transport transport = mailSession.getTransport("smtp");
		transport.connect("smtp.gmail.com", "thebankingapp2015@gmail.com",
				"testowaJAVA");
		transport.sendMessage(generateMailMessage,
				generateMailMessage.getAllRecipients());
		transport.close();
	}

	public void sendVerificationEmail(String recipient, String token)
			throws AddressException, MessagingException {
		composeMessage(recipient, token);
		prepareTransportSession();

	}

}
