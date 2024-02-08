package com.example.Lalan.Repos;


import com.example.Lalan.Entity.CustomerRegistrationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.sun.corba.se.impl.oa.poa.ActiveObjectMap;
import org.hibernate.mapping.Value;
import java.util.List;
import java.util.Map;

public interface CustomerRegistrationRepo extends JpaRepository<CustomerRegistrationEntity, Integer> {

    @Query(value = "select l.cus_id , l.customer_name from customer_reg l ", nativeQuery = true)
    public List<Map<ActiveObjectMap.Key, Value>> getAllCusDetails();

}
