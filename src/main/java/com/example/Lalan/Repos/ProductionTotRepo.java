package com.example.Lalan.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.Lalan.Entity.BatchEntity;
import com.example.Lalan.Entity.ProductionTotEntity;
import com.sun.corba.se.impl.oa.poa.ActiveObjectMap;
import org.hibernate.mapping.Value;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.QueryLookupStrategy;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface ProductionTotRepo extends JpaRepository<ProductionTotEntity, Integer> {
    ProductionTotEntity findByAdminId(Integer adminId);
}
