package uncc.ssdi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uncc.ssdi.dao.ProductRepository;
import uncc.ssdi.dao.UserRepository;
import uncc.ssdi.model.Product;
import uncc.ssdi.model.User;

@Service
public class UserService implements IUserService {

	
	@Autowired
	private UserRepository userRepository;
	
	
	public User addUser(User u) {
		System.out.println("Entered service");
		User u1=new User();
		u1=userRepository.save(u);
		return u1;
	}
	
	public User checkUser(User u) {
		
		User ux=new User();
		ux=userRepository.findByEmailid(u.getEmailid());
		
		
		if(ux != null && ux.getPassword().equals(u.getPassword())) {
			System.out.println("Found the user");
			return ux;
		}else {
			System.out.println("User not found");
			ux = new User();
			ux.setEmailid("invalid");
		}
		
		return ux;
	

}
	
	
}
