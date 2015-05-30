package logic;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.mockito.Matchers.isNotNull;

import java.io.IOException;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.AddressException;

import org.hamcrest.core.IsNot;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class EmailValidatorTest {

	private EmailValidator emailValidator;

	@Before
	public void init() {
		emailValidator = new EmailValidator();
	}

	@Test
	public void shouldHaveSetAllSmtpPortProperties() throws AddressException,
			MessagingException {
		emailValidator.setMailServerProperties();
		assertThat(emailValidator.getMailServerProperties(),
				hasEntry("mail.smtp.port", "587"));
		assertThat(emailValidator.getMailServerProperties(),
				hasEntry("mail.smtp.auth", "true"));
		assertThat(emailValidator.getMailServerProperties(),
				hasEntry("mail.smtp.starttls.enable", "true"));
	}

	@Test
	public void shouldSetMailSession() throws AddressException,
			MessagingException {
		emailValidator.setMailServerProperties();
		emailValidator.setMailSession();
		assertThat(emailValidator.getMailSession().toString().length(),
				greaterThan(0));
	}

	@Test
	public void shoulHaveValidMessageFields() throws AddressException, MessagingException, IOException{
		emailValidator.setMailServerProperties();
		emailValidator.setMailSession();
		emailValidator.composeMessage("igor.avz@gmail.com", "testToken");
	
		assertThat(emailValidator.getGenerateMailMessage().getSubject(),is("BANKING APP VALIDATION TOKEN"));
		assertThat(emailValidator.getGenerateMailMessage().getRecipients(Message.RecipientType.TO)[0].toString(),is("igor.avz@gmail.com"));
		assertThat(emailValidator.getGenerateMailMessage().getContent().toString(),containsString("This is your login verification token: "));
	}
	@Test
	public void testSendVerificationEmail() throws AddressException,
			MessagingException {
		emailValidator.setMailServerProperties();
		emailValidator.sendVerificationEmail("igor.avz@gmail.com", "testToken");
	}

}
