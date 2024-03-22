package com.example.Lalan.Repos;
import java.util.List;
import java.util.Map;
import org.hibernate.mapping.Value;

import com.example.Lalan.Entity.ProductTypeTempsEntity;
import com.sun.corba.se.impl.oa.poa.ActiveObjectMap;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ProductTypeTempsRepo extends JpaRepository<ProductTypeTempsEntity, String>{
    @Modifying
    @Query("DELETE FROM ProductTypeTempsEntity p WHERE p.deviceid_dvc_reg = :deviceID")
    void deleteByDeviceID(String deviceID);
    @Query("SELECT CASE WHEN COUNT(p) > 0 THEN true ELSE false END FROM ProductTypeTempsEntity p WHERE p.deviceid_dvc_reg = :deviceID")
    boolean existsByDeviceIDDvcReg(String deviceID);
}
