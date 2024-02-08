package com.example.Lalan.Repos;

import com.example.Lalan.Entity.UserAllocationEntity;

import java.util.List;
import java.util.Map;
import org.hibernate.mapping.Value;
import com.sun.corba.se.impl.oa.poa.ActiveObjectMap;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserAllocationRepos extends JpaRepository<UserAllocationEntity, Integer> {
    List<UserAllocationEntity> findByUserId(String user_id);
    
}
