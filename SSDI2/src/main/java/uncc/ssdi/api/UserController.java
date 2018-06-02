package uncc.ssdi.api;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import uncc.ssdi.model.Payment;
import uncc.ssdi.model.Product;
import uncc.ssdi.model.QuoteAndId;
import uncc.ssdi.model.User;
import uncc.ssdi.service.IPaymentService;
import uncc.ssdi.service.IProductService;
import uncc.ssdi.service.IUserService;
import uncc.ssdi.service.PaymentService;
import uncc.ssdi.service.UserService;

@RestController
@SessionAttributes({"uname","id"})
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService userService;
	
	@Autowired
	private IProductService productService;
	
	@Autowired
	private IPaymentService paymentService;


	@RequestMapping("/register")
	public ModelAndView register() {
		ModelAndView mav = new ModelAndView("register");
		mav.addObject("user", new User());
		return mav;
	}
	
	@RequestMapping("/registerBuyer")
	public ModelAndView registerBuyer(@RequestParam("e2") String email) {
		ModelAndView mav = new ModelAndView("registerBuyer");
		User user = new User();
		user.setEmailid(email);
		mav.addObject("user",user );
		return mav;
	}
	
	@RequestMapping(value = "/compRegisterBuyer", method = RequestMethod.POST)
	public ModelAndView compRegisterBuyer( @ModelAttribute("user")User user) {
		userService.addUser(user);
		ModelAndView mav = new ModelAndView("payRegister");
		Payment payment = new Payment();
		payment.setUserEmail(user.getEmailid());
		mav.addObject("payment",payment);
		return mav;
	}
	
	@RequestMapping(value = "/compRegister", method = RequestMethod.POST)
	public ModelAndView compRegister( @ModelAttribute("user")User user) {
		
		userService.addUser(user);
		ModelAndView mav = new ModelAndView("regSuccess");
		return mav;
	}
	
	@RequestMapping("/login")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("user", new User());
		return mav;
	}
	
	@RequestMapping(value = "/compLogin", method = RequestMethod.POST)
	public ModelAndView compLogin( @ModelAttribute("user")User user) {
		User u=new User();
		u=userService.checkUser(user);
		if(u.getEmailid()=="invalid") {
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("error", "Wrong credentials please try again");
		return mav;
		}
		else {
			
			ModelAndView mav = new ModelAndView("loginSuccess");
			mav.addObject("uname", u.getFirstname());
			mav.addObject("id", u.getId());
			return mav;
		}
	}
	@RequestMapping(value = "/logout")
	public ModelAndView logout(@ModelAttribute("uname")String username,SessionStatus status) {
		status.setComplete();
		ModelAndView mav = new ModelAndView("logout");
		return mav;
	}
	
	@RequestMapping(value = "/dashboard")
	public ModelAndView userDashboard(@SessionAttribute("id")int userid) {
		List<Product> usersProducts = new ArrayList<Product>();
		List<Product> requiredProducts = new ArrayList<Product>();
		List<Product> productList = productService.getAllProducts();
		List<QuoteAndId> quotes = paymentService.getAllQuotes();
		List<QuoteAndId> requiredQuotes = new ArrayList<QuoteAndId>();
		for(int i=0;i<productList.size();i++) {
			Product p=new Product();
			p=productList.get(i);
			if(p.getSellerid()==userid) {
				usersProducts.add(p);
			}
		}
		for(int i=0; i<usersProducts.size();i++) {
			for(int j=0;j<quotes.size();j++) {
				Product p1=new Product();
				QuoteAndId q=new QuoteAndId();
				p1=usersProducts.get(i);
				q=quotes.get(j);
				if(p1.getId()==q.getProductId()) {
					requiredQuotes.add(q);
					
				}
			}
		}
		for(int i=0;i<requiredQuotes.size();i++) {
			QuoteAndId q=new QuoteAndId();
			q=quotes.get(i);
			System.out.println(q.getQuotedPrice());
		}
		ModelAndView mav = new ModelAndView("dashboard");
		mav.addObject("quotes",requiredQuotes);
		mav.addObject("products",productList);
		return mav;
	}
	

}
