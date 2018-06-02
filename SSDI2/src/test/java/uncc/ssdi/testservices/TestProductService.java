package uncc.ssdi.testservices;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import uncc.ssdi.dao.ProductRepository;
import uncc.ssdi.dao.UserRepository;
import uncc.ssdi.model.Product;
import uncc.ssdi.model.User;
import uncc.ssdi.service.ProductService;
import uncc.ssdi.service.UserService;

@RunWith(MockitoJUnitRunner.class)
public class TestProductService {

	
	@Mock
	ProductRepository productRepository;
	
	
	
	
	@InjectMocks
	ProductService productService;
	
	//Product dummyProd = new Product(6, "Apple Watch", "Apple Watch", 200.0, 169.0, 10, 
			//"https://www.att.com/catalog/en/skus/Apple/Apple%20Watch%20Series%203/overview/326626-PDP-watch-S2-img1@2x.jpg", 2);
	
	
	@Test	
	public void testAddProduct() {
		
		
		Product p=new Product();
		p.setName("watch");
		p.setDescription("old watch");
		p.setImageurl("abc@xyz.com");
		
		Mockito.when(productRepository.save(p)).thenReturn(p);
		Product p1=new Product();
		p1=productService.addProduct(p);
		
		
		assertEquals(p.getName(),p1.getName());
		assertEquals(p.getDescription(),p1.getDescription());
		assertEquals(p.getImageurl(),p1.getImageurl());
		//assertEquals(u.getPassword(),p1.getPassword());
		
		Mockito.verify(productRepository).save(p);
		
	}
	
	
	@SuppressWarnings("unchecked")
	@Test	
	public void testgetAllProducts() {
		
		List<Product> ProductList = new ArrayList<Product>();
		Product p=new Product();
		p.setName("watch");
		p.setDescription("old watch");
		p.setImageurl("abc@xyz.com");
		
		Product p1=new Product();
		p1.setName("watch");
		p1.setDescription("old watch");
		p1.setImageurl("abc@xyz.com");
		ProductList.add(p);
		ProductList.add(p1);
		
		//Given
		List<Product> dummyProductList = new ArrayList<Product>();
		dummyProductList.add(p);
		Mockito.when(productRepository.findAll()).thenReturn(ProductList);
		
		//When
		List<Product> returnedproductList = productService.getAllProducts();
		
		//Then
		assertThat(returnedproductList, is(ProductList));
		
		//verify
		verify(productRepository).findAll();
	}
}
