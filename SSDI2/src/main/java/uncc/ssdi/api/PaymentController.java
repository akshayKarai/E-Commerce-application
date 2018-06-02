package uncc.ssdi.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import uncc.ssdi.model.Payment;
import uncc.ssdi.model.Product;
import uncc.ssdi.model.QuoteAndId;
import uncc.ssdi.service.IPaymentService;
import uncc.ssdi.service.PaymentService;

@RestController
@RequestMapping("/pay")
public class PaymentController {

	@Autowired
	private IPaymentService paymentService;

	public PaymentController() {
		paymentService = new PaymentService();
	}
	
	/*@RequestMapping(value = "/sendEmail", method = RequestMethod.POST)
	public ModelAndView sendEmail( @ModelAttribute("payment")Payment payModel) {
		paymentService.sendEmailWithLink(payModel.getUserEmail());
		ModelAndView mav = new ModelAndView("emailSuccess");
		return mav;
	}*/
	
	@RequestMapping(value = "/sendEmail", method = RequestMethod.POST)
	public ModelAndView sendEmail(@ModelAttribute("quoteandid")QuoteAndId quotedId) {
		//Payment payModel=new Payment();
		//payModel.setUserEmail(quotedId.getBuyerEmail());
		//paymentService.sendEmailWithLink(payModel.getUserEmail());
		System.out.println(quotedId.getProductId());
		System.out.println(quotedId.getQuotedPrice());
		System.out.println(quotedId.getBuyerEmail());
		paymentService.saveQuoteAndId(quotedId);
		ModelAndView mav = new ModelAndView("emailSuccess");
		return mav;
	}
	@RequestMapping(value = "/sendLink", method = RequestMethod.POST)
	public ModelAndView sendLink(@RequestParam("id")int productId, @RequestParam("email")String email) {
		Payment payModel=new Payment();
		
		System.out.println(productId);
		System.out.println(email);
		paymentService.sendEmailWithLink(email);
		paymentService.deleteQuotes(productId);
		//paymentService.saveQuoteAndId(quotedId);
		ModelAndView mav = new ModelAndView("loginSuccess");
		return mav;
	}
	
	@RequestMapping(value = "/details", method = RequestMethod.GET)
	public ModelAndView addPaymentDetails(@RequestParam("e2") String email) {
		ModelAndView mav = new ModelAndView("payRegister");
		Payment payModel = new Payment();
		payModel.setUserEmail(email);
		mav.addObject("payment",payModel);
		return mav;
	}
	
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView savePaymentDetails( @ModelAttribute("payment")Payment payModel) {
		paymentService.addPaymentDetails(payModel);
		ModelAndView mav = new ModelAndView("emailSuccess");
		return mav;
	}
    
	
	
	
}
