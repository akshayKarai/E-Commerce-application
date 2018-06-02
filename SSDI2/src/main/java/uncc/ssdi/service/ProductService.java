package uncc.ssdi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uncc.ssdi.dao.ProductDao;
import uncc.ssdi.dao.ProductRepository;
import uncc.ssdi.model.IProduct;
import uncc.ssdi.model.Product;
import uncc.ssdi.model.User;

@Service
public class ProductService implements IProductService {

	@Autowired
	private ProductRepository ProductRepository;
	
	/*public Iterable<Product> getProducts(){
		productDao=new ProductDao();
		Iterable<Product> productList=new Iterable<Product>();
		productList=productDao.getAllProducts();
		return  productList;
		}*/
	
	
	
	public List<Product> getAllProducts(){		
		List<Product> list = new ArrayList<>();
		ProductRepository.findAll().forEach(e -> list.add(e));
		return list;
	}
	public void test(long lg) {
		System.out.println("**********inside test in service");
		boolean present = ProductRepository.existsById(lg);
		 System.out.println("**************8"+present);
		
	}
	public Product addProduct(Product p) {
		//ProductRepository.save(p);
		Product p1=new Product();
		p1=ProductRepository.save(p);
		return p1;
	}
	
}
