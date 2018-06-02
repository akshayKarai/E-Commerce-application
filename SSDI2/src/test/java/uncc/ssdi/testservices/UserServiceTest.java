/**
 * 
 */
package uncc.ssdi.testservices;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import uncc.ssdi.dao.UserRepository;
import uncc.ssdi.model.User;
import uncc.ssdi.service.UserService;

/**
 * @author sabarish
 *
 */

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

	
	@Mock
	UserRepository userRepository;
	
	
	
	
	@InjectMocks
	UserService userService;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		
		
	}

	/**
	 * Test method for {@link uncc.ssdi.service.UserService#addUser(uncc.ssdi.model.User)}.
	 */
	
	@Test
	public void testAddUser() {
		
		User u=new User();
		u.setEmailid("jacktravis@gmail.com");
		u.setFirstname("jack");
		u.setLastname("travis");
		u.setPassword("johntravis");
		Mockito.when(userRepository.save(u)).thenReturn(u);
		User u1=new User();
		u1=userService.addUser(u);
		
		
		assertEquals(u.getEmailid(),u1.getEmailid());
		assertEquals(u.getFirstname(),u1.getFirstname());
		assertEquals(u.getLastname(),u1.getLastname());
		assertEquals(u.getPassword(),u1.getPassword());
		
		Mockito.verify(userRepository).save(u);
		//fail("Not yet implemented");
		
	}
	
	

	/**
	 * Test method for {@link uncc.ssdi.service.UserService#checkUser(uncc.ssdi.model.User)}.
	 * Test for password is matching
	 */
	@Test
	public void testCheckUserCase1() {
		User u=new User();
		u.setEmailid("jacktravis@gmail.com");
		u.setFirstname("jack");
		u.setLastname("travis");
		u.setPassword("johntravis");
		
		Mockito.when(userRepository.findByEmailid(u.getEmailid())).thenReturn(u);
		User u1=new User();
		u1=userService.checkUser(u);
		assertEquals(u.getEmailid(),u1.getEmailid());
		assertEquals(u.getFirstname(),u1.getFirstname());
		assertEquals(u.getLastname(),u1.getLastname());
		assertEquals(u.getPassword(),u1.getPassword());
		
		Mockito.verify(userRepository).findByEmailid(u.getEmailid());
		userService.checkUser(u);
		
		//fail("Not yet implemented");
	}
	
	@Test
	public void testCheckUserCase2() {
		User u=new User();
		u.setEmailid("jacktravis@gmail.com");
		u.setFirstname("jack");
		u.setLastname("travis");
		u.setPassword("johntravis");
		
		User u1=new User();
		u1.setEmailid("jacktravis@gmail.com");
		u1.setFirstname("jack");
		u1.setLastname("travis");
		u1.setPassword("johntravi");
		
		Mockito.when(userRepository.findByEmailid(u.getEmailid())).thenReturn(u1);
		User u2=new User();
		u2=userService.checkUser(u);
		assertEquals("invalid",u2.getEmailid());
		
		
		Mockito.verify(userRepository).findByEmailid(u.getEmailid());
		userService.checkUser(u);
		
		//fail("Not yet implemented");
	}
	
	@Test
	public void testCheckUserCase3() {
		User u=new User();
		u.setEmailid("jacktravis@gmail.com");
		u.setFirstname("jack");
		u.setLastname("travis");
		u.setPassword("johntravis");
		
		User u1=new User();
		u1=null;
		
		Mockito.when(userRepository.findByEmailid(u.getEmailid())).thenReturn(u1);
		User u2=new User();
		u2=userService.checkUser(u);
		assertEquals("invalid",u2.getEmailid());
		
		
		Mockito.verify(userRepository).findByEmailid(u.getEmailid());
		userService.checkUser(u);
		
		//fail("Not yet implemented");
	}

	

}
