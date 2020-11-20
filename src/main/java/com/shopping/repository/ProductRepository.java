
package com.shopping.repository;

import com.shopping.model.Product;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{
   
    
  
}
