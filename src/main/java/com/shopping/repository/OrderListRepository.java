
package com.shopping.repository;

import com.shopping.model.OrderList;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderListRepository extends CrudRepository<OrderList, Long>{
    
    public List<OrderList> findByUserId(long id);
}
