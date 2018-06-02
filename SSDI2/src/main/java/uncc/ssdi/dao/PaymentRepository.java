package uncc.ssdi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uncc.ssdi.model.Payment;
import uncc.ssdi.model.Product;
//This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
//CRUD refers Create, Read, Update, Delete
@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
	
}
