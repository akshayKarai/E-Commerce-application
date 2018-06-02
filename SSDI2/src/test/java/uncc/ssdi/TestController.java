package uncc.ssdi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties.View;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import uncc.ssdi.api.ProductController;
import uncc.ssdi.model.Product;
import uncc.ssdi.service.*;

@RunWith(MockitoJUnitRunner.class)
//@WebMvcTest(value = ProductController.class, secure = false)
public class TestController {
	
	private MockMvc mockMvc;
	
	@Mock
    ProductService productService;
	
	
	@InjectMocks
	private ProductController productController;
	
	
	
	@Before
	public void setUp() throws Exception{
		
		//MockitoAnnotations.initMocks(this);
		
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/webapp");
        viewResolver.setSuffix(".jsp");
		mockMvc = MockMvcBuilders.standaloneSetup(productController).setViewResolvers(viewResolver)
                .build();
	}
	
	@Test
	public void testController() throws Exception{
		ArrayList<Product> products = new ArrayList<Product>();
		Product product1 = new Product();
		product1.setDescription("Sample Description 1");
		Product product2 = new Product();
		product2.setDescription("Sample Description 2");
		products.add(product1);
		products.add(product2);
		Mockito.when(productService.getAllProducts()).thenReturn(products);
		ModelAndView mav = productController.displayProducts();
		
		ArrayList<Product> productsreturned = new ArrayList<Product>();
		productsreturned=(ArrayList<Product>)mav.getModel().get("productList");
		assertEquals(2,productsreturned.size());
		assertEquals("Sample Description 1",productsreturned.get(0).getDescription());
		assertEquals("Sample Description 2",productsreturned.get(1).getDescription());
		
		Mockito.verify(productService).getAllProducts();
	}
	
	@Test
	public void testGetAllProductsUrl() throws Exception {
		
		this.mockMvc.perform(get("/api/displayProducts"))
        .andExpect(status().isOk());

	}
	
	@Test
	public void testAddProducts() throws Exception {
		
		ModelAndView mav = productController.addProduct();
		assertNotEquals(null,mav.getModelMap().get("product"));
		
	}
	
	@Test
	public void testAddProductsUrl() throws Exception {
		this.mockMvc.perform(get("/api/addproduct"))
        .andExpect(status().isOk());
	}
	
	@Test
	public void testAddProductSuccess() throws Exception{
		Product p=new Product();
		p.setName("watch");
		Mockito.when(productService.addProduct(p)).thenReturn(p);
		//Mockito.when(productService).addProduct(p).;
		//Check if a non null object is returned
		assertNotNull(productController.addProductSuccess(p, 10));
		//Check if the seller id is being set or not
		assertEquals(10, p.getSellerid());
		
		Mockito.verify(productService).addProduct(p);
	}
	
	@Test
	public void testAddProductSuccessUrl() throws Exception {
		this.mockMvc.perform(post("/api/addproductsuccess").param("product", new Product().toString()).sessionAttr("id", "10")).andExpect(status().isOk());
	}
	
	@Test
	public void testBuyProduct() {
		Product product1 = new Product();
		product1.setId(1);
		Product product2 = new Product();
		product2.setId(2);
		ArrayList<Product> productList = new ArrayList<Product>();
		productList.add(product1);
		productList.add(product2);
		
		Mockito.when(productService.getAllProducts()).thenReturn(productList);
		
		ModelAndView result = productController.buyProduct(1, 64);
		
		assertEquals(1,((ArrayList<Product>) result.getModel().get("productList")).get(0).getId());
		assertEquals(64.0,result.getModel().get("quotedPrice"));
		assertNotNull(result.getModel().get("payment"));
		Mockito.verify(productService).getAllProducts();
	}
	
	@Test
	public void testBuyproductRequestMapping() throws Exception {
		this.mockMvc.perform(get("/api/buyProduct").param("prodId","1").param("quote", "64.0"))
        .andExpect(status().isOk());
	}
	
	

}
