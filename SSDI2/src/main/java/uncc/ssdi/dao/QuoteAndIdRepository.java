package uncc.ssdi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import uncc.ssdi.model.Product;
import uncc.ssdi.model.QuoteAndId;
//This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
//CRUD refers Create, Read, Update, Delete
@Repository
public interface QuoteAndIdRepository extends JpaRepository<QuoteAndId, Long> {

	void deleteById(int id);

}
