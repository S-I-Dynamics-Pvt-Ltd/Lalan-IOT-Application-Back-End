package com.example.Lalan.Repos;

import com.example.Lalan.Entity.ProductRegistrationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.hibernate.mapping.Value;
import com.sun.corba.se.impl.oa.poa.ActiveObjectMap;
import java.util.List;
import java.util.Map;
public interface ProductRegistrationRepo extends JpaRepository<ProductRegistrationEntity, String> {

    @Query(value = "select l.product_id as productId , l.product_name as productname from product_reg l", nativeQuery = true)
    public List<Map<ActiveObjectMap.Key, Value>> getAllProductsNameAndIds();
}
