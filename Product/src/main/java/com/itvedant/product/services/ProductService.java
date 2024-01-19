package com.itvedant.product.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.itvedant.product.dao.AddProductDao;
import com.itvedant.product.dao.UpdateProductDao;
import com.itvedant.product.entities.Product;
import com.itvedant.product.repo.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	
	// to add product inside MySQL
	private ProductRepository productRepository ;
	
	public Product createProduct(AddProductDao addProductDao) {
		
		Product product = new Product();
		
		product.setProductName(addProductDao.getProductName());
		product.setPrice(addProductDao.getPrice());
		product.setDescription(addProductDao.getDescription());
		
		productRepository.save(product);
		return product;
	}
	// To get all products from my sql
	public Iterable<Product> getAllProduct(){
		return this.productRepository.findAll();
		
	}
	
	// To get specific product from MySQl
	
	public Product getProductById(Integer id) {
		
		Product product = this.productRepository.findById(id).orElse(null);
		
		if(product == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product Does not Exist");
		}
		
		return product;
	}
	
	// To delete the specfic product  from mYsql
	public void deleteProduct(Integer id) {

		Product product = this.productRepository.findById(id).orElse(null);
		
		if(product == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product Does not Exist");
		}
		
		this.productRepository.delete(product);
	}
	
	//to update the product from MySQL
	public Product updateProduct(Integer id, UpdateProductDao updateProductDao) {
		Product product = this.getProductById(id);
		
		if(updateProductDao.getProductName() != null) {
			product.setProductName(updateProductDao.getProductName());
		}
		if(updateProductDao.getDescription() != null) {
			product.setDescription(updateProductDao.getDescription());
		}
		if(updateProductDao.getPrice() != null) {
			product.setPrice(updateProductDao.getPrice());
		}
		
		this.productRepository.save(product);
		
		return product;
	}
	
	// to find the product by Product Name
	public List<Product> getByProductName(String productName){
		return this.productRepository.findByProductName(productName);
	}
		
	// to sort the product by name
	public List<Product> sortByProductName(){
		return this.productRepository.sortByName();
	}
	}
