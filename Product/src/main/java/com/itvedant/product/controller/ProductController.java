package com.itvedant.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itvedant.product.dao.AddProductDao;
import com.itvedant.product.dao.UpdateProductDao;
import com.itvedant.product.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	 private ProductService productSevice;
	
	@PostMapping("")
	 public ResponseEntity<?> create(@RequestBody AddProductDao addProductDao){
		 return ResponseEntity.ok(this.productSevice.createProduct(addProductDao));
	 }
	
	@GetMapping("")
	public ResponseEntity<?> getAllProduct(){
		return ResponseEntity.ok(this.productSevice.getAllProduct());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable Integer id){
		return ResponseEntity.ok(this.productSevice.getProductById(id));
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable Integer id){
		this.productSevice.deleteProduct(id);
		return "Product has been Deleted";
		
		}
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id,@RequestBody UpdateProductDao updateProductDao){
		return ResponseEntity.ok(this.productSevice.updateProduct(id, updateProductDao));
	}
	
	
	@GetMapping("/search/findbyproductname")
	public ResponseEntity<?> findByName(@RequestParam String productname){
		return ResponseEntity.ok(this.productSevice.getByProductName(productname));
	}
	
	@GetMapping("/search/sortbyname")
	public ResponseEntity<?> sortName(){
		return ResponseEntity.ok(this.productSevice.sortByProductName());
	}
	}
