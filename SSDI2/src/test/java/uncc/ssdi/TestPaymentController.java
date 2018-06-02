package uncc.ssdi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import uncc.ssdi.api.PaymentController;
import uncc.ssdi.model.Payment;
import uncc.ssdi.model.User;
import uncc.ssdi.service.PaymentService;

@RunWith(MockitoJUnitRunner.class)
public class TestPaymentController {

	private MockMvc mockMvc;

	@Mock
	PaymentService paymentService;

	@InjectMocks
	private PaymentController paymentController;

	@Before
	public void setUp() throws Exception {

		// MockitoAnnotations.initMocks(this);

		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/webapp");
		viewResolver.setSuffix(".jsp");
		mockMvc = MockMvcBuilders.standaloneSetup(paymentController).setViewResolvers(viewResolver).build();
	}

	/*@Test
	public void testSendEmail() {
		Payment pay = new Payment();
		pay.setUserEmail("abc@gmail.com");
		Mockito.doNothing().when(paymentService).sendEmailWithLink(pay.getUserEmail());
		// ModelAndView mav = paymentController.sendEmail(pay);
		assertNotNull(paymentController.sendEmail(pay));
		Mockito.verify(paymentService).sendEmailWithLink(pay.getUserEmail());
		;
	}*/

	@Test
	public void testSendEmailUrl() throws Exception {
		this.mockMvc.perform(post("/pay/sendEmail").param("payment", new Payment().toString()))
				.andExpect(status().isOk());
	}

	@Test
	public void testAddPaymentDetails() {
		String email = "abc.def@gmail.com";
		ModelAndView result = paymentController.addPaymentDetails(email);
		Payment payment = (Payment) result.getModel().get("payment");
		assertEquals(email, payment.getUserEmail());
	}

	@Test
	public void testAddPaymentDetailsRequestMapping() throws Exception {
		this.mockMvc.perform(get("/pay/details").param("e2", "abc.def@gmakl.com")).andExpect(status().isOk());
	}
	
	
	@Test
	public void tetSavePaymentDetails() {
		Payment payment = new Payment();
		Mockito.doNothing().when(paymentService).addPaymentDetails(payment);
		assertNotNull(paymentController.savePaymentDetails(payment));
		Mockito.verify(paymentService).addPaymentDetails(payment);
	}
	
	@Test
	public void testSavePaymentDetailsRequestMapping() throws Exception {
		this.mockMvc.perform(post("/pay/save").param("payment", new Payment().toString()))
		.andExpect(status().isOk());
	}
}
