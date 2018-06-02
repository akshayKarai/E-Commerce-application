package uncc.ssdi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
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
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import uncc.ssdi.api.UserController;
import uncc.ssdi.model.Product;
import uncc.ssdi.model.User;
import uncc.ssdi.service.UserService;

@RunWith(MockitoJUnitRunner.class)
public class TestUserController {
	
	private MockMvc mockMvc;
	
	@Mock
	UserService userservice;
	
	@InjectMocks
	UserController userController;
	
	@Before
	public void setUp() throws Exception{
		
		
		
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/webapp");
        viewResolver.setSuffix(".jsp");
		mockMvc = MockMvcBuilders.standaloneSetup(userController).setViewResolvers(viewResolver)
                .build();
	}
	
	
	@Test
	public void testRegister() throws Exception {
		
		ModelAndView mav = userController.register();
		assertNotEquals(null,mav.getModelMap().get("user"));
		
	}
	
	@Test
	public void testRegisterUrl() throws Exception {
		this.mockMvc.perform(get("/user/register"))
        .andExpect(status().isOk());
	}
	
	@Test
	public void testCompRegister() throws Exception{
		User u=new User();
		u.setFirstname("Jack");
		Mockito.when(userservice.addUser(u)).thenReturn(u);
		//Check if a non null object is returned
		assertNotNull(userController.compRegister(u));
		//assertTrue((userController.compRegister(u)) instanceof ModelAndView);
		Mockito.verify(userservice).addUser(u);
	}
	
	@Test
	public void testCompRegisterUrl() throws Exception {
		this.mockMvc.perform(post("/user/compRegister").param("user", new User().toString())).andExpect(status().isOk());
	}
	
	@Test
	public void testLogin() throws Exception {
		
		ModelAndView mav = userController.login();
		assertNotEquals(null,mav.getModelMap().get("user"));
		
	}
	
	@Test
	public void testLoginUrl() throws Exception {
		this.mockMvc.perform(get("/user/login"))
        .andExpect(status().isOk());
	}
	
	
	//Test for else case
	@Test
	public void testCompLoginValid() throws Exception{
		
		User u=new User();
		u.setFirstname("John");
		u.setLastname("Travis");
		u.setEmailid("john@gmail.com");
		u.setPassword("johntravis");
		
		Mockito.when(userservice.checkUser(u)).thenReturn(u);
		ModelAndView mav=userController.compLogin(u);
		
		String firstname=(String)(mav.getModel().get("uname"));
		assertEquals("John",firstname);
		Mockito.verify(userservice).checkUser(u);
	}
	
	//Test for if case
	@Test
	public void testCompLoginInvalid() throws Exception{
		
		User u=new User();
		u.setEmailid("invalid");
		
		Mockito.when(userservice.checkUser(u)).thenReturn(u);
		ModelAndView mav=userController.compLogin(u);
		
		String errormsg=(String)(mav.getModel().get("error"));
		assertEquals("Wrong credentials please try again",errormsg);
		Mockito.verify(userservice).checkUser(u);
	}
	
	@Test
	public void testCompLoginUrl() throws Exception {
		
		User u=new User();
		u.setEmailid("invalid");
		
		Mockito.when(userservice.checkUser((User)Mockito.any())).thenReturn(u);
		this.mockMvc.perform(post("/user/compLogin").param("user", new User().toString())).andExpect(status().isOk());
		Mockito.verify(userservice).checkUser((User)Mockito.any());
		
	}
	
	@Test
	public void testLogout() {
		SessionStatus sessionStatusMock = Mockito.mock(SessionStatus.class);
		Mockito.doNothing().when(sessionStatusMock).setComplete();
		assertNotNull(userController.logout("Sabarish", sessionStatusMock));
		Mockito.verify(sessionStatusMock).setComplete();
	}
	
	@Test
	public void testLogoutUrl() throws Exception {
		
		this.mockMvc.perform(post("/user/logout").sessionAttr("uname", "Sabarish")).andExpect(status().isOk());
	}

}
