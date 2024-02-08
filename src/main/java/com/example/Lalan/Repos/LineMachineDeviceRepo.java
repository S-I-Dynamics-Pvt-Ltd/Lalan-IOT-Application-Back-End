package com.example.Lalan.Repos;

import com.example.Lalan.Entity.BatchEntity;
import com.example.Lalan.Entity.LineMachineDeviceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import com.sun.corba.se.impl.oa.poa.ActiveObjectMap;
import org.hibernate.mapping.Value;
import java.util.List;
import java.util.Map;
public interface LineMachineDeviceRepo extends JpaRepository<LineMachineDeviceEntity, String> {
   // List<LineMachineDeviceEntity> deleteByLineId(String lineId);
   //@Modifying
    //@Query("DELETE FROM LineMachineDeviceEntity l WHERE l.lineId = ?1")
   // void deleteByLineId(String lineId);
    
}
