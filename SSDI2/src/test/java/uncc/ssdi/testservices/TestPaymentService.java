package uncc.ssdi.testservices;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Properties;

import javax.mail.Session;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import uncc.ssdi.dao.PaymentRepository;
import uncc.ssdi.model.Payment;
import uncc.ssdi.service.PaymentService;
import uncc.ssdi.utilities.EmailUtil;

@RunWith(MockitoJUnitRunner.class)
public class TestPaymentService {
	
	@Mock
	EmailUtil emailUtil;
	
	@InjectMocks
	PaymentService paymentService;
	
	@Mock
	PaymentRepository paymentRepository;
	
	
	
	@Test
	public void testSendEmailWithLink() {
		ArgumentCaptor<Session> capturedSession = ArgumentCaptor.forClass(Session.class);
		ArgumentCaptor<String> capturedEmailId = ArgumentCaptor.forClass(String.class);
		ArgumentCaptor<String> capturedSubject = ArgumentCaptor.forClass(String.class);
		ArgumentCaptor<String> capturedBody = ArgumentCaptor.forClass(String.class);
		
		String emailId = "abc@gmail.com";
		String smtpHostServer = "smtp.gmail.com";
		String subject = "Your recent purchase on E-Commerce";
		String mailBody = "Greetings! \n Please click on below link to create an account and get the deal. \n"
				+"Please note the link will expire in 2 business days."
				+ "\n <a href='http://localhost:8080/user/registerBuyer?e2="+emailId+"'>E-Commerce.com</a>";
		Mockito.doNothing().when(emailUtil).sendEmail(capturedSession.capture(), capturedEmailId.capture(), capturedSubject.capture(), capturedBody.capture());
		paymentService.sendEmailWithLink(emailId);
		Mockito.verify(emailUtil).sendEmail(capturedSession.capture(), capturedEmailId.capture(), capturedSubject.capture(), capturedBody.capture());
		Session session = capturedSession.getValue();
		Properties props = session.getProperties();
		
		assertEquals(emailId, capturedEmailId.getValue());
		assertEquals(subject, capturedSubject.getValue());
		assertEquals(mailBody,capturedBody.getValue());
		
		assertEquals(smtpHostServer,(String)props.get("mail.smtp.host"));
		assertEquals("true",(String)props.get("mail.smtps.auth"));
		assertEquals("javax.net.ssl.SSLSocketFactory",(String)props.get("mail.smtp.socketFactory.class"));
		
		
	}
	
	@Test
	public void testAddPaymentDetails() {
		Payment payment = new Payment();
		Mockito.when(paymentRepository.save(payment)).thenReturn(payment);
		paymentService.addPaymentDetails(payment);
		Mockito.verify(paymentRepository).save(payment);
	}

}
