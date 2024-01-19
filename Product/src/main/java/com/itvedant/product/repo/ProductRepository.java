package com.itvedant.product.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.itvedant.product.entities.Product;

@Repository
public interface ProductRepository  extends JpaRepository<Product, Integer>{
	
	List<Product> findByProductName(String productname);
	
	@Query(value = "select * from product order by product_name",nativeQuery = true )
	List<Product> sortByName();

}
