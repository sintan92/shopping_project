
package com.shopping.repository;

import com.shopping.model.Product;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{
   
    @Query("select p from Product p where p.name like %:n%")
    public List<Product> findbynamehaving(@Param("n") String name);
  
}
