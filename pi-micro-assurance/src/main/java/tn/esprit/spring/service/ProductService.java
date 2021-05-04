package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.dao.entities.Product;

public interface ProductService {
	Product saveProduct(Product p);
	Product updateProduct(Product p);
	void deleteProduct(Product p);
	void deleteProductById(Long id);
	Product getProduct(Long id);
	List<Product> getAllProducts();

}
