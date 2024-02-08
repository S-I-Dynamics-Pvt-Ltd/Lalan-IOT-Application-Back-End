package com.example.Lalan.Repos;

import com.example.Lalan.Entity.LineRegistrationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.sun.corba.se.impl.oa.poa.ActiveObjectMap;
import org.hibernate.mapping.Value;
import java.util.List;
import java.util.Map;
public interface LineRegistrationRepo extends JpaRepository<LineRegistrationEntity, String> {
    
    @Query(value = "select l.line_id as lineId,l.line_name as lineName from line_reg l", nativeQuery = true)
    public List<Map<ActiveObjectMap.Key, Value>> getAllLineAndId();
}
