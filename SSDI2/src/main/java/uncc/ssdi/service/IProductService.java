package uncc.ssdi.service;

import java.util.List;

import uncc.ssdi.model.IProduct;
import uncc.ssdi.model.Product;

public interface IProductService {

	public List<Product> getAllProducts();
	public void test(long abc);
	public Product addProduct(Product product);
}
