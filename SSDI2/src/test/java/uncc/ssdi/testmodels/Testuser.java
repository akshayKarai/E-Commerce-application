package uncc.ssdi.testmodels;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import uncc.ssdi.model.User;

public class Testuser {
	
	User u=new User();
	
	@Test
	@SuppressWarnings("deprecation")
	public void testGettersAndSetters() {
		u.setFirstname("john");
		u.setLastname("wick");
		u.setEmailid("abc@def.com");
		u.setPassword("abcdef");
		
		assertEquals("john",u.getFirstname());
		assertEquals("wick",u.getLastname());
		assertEquals("abc@def.com",u.getEmailid());
		assertEquals("abcdef",u.getPassword());
	}

}
