package com.example.Lalan.Repos;

import com.example.Lalan.Entity.JobRegistrationEntity;
import com.example.Lalan.Entity.ParameterDeviceMachineEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;

import com.sun.corba.se.impl.oa.poa.ActiveObjectMap;
import org.hibernate.mapping.Value;

import java.util.Map;
import java.util.List;
public interface JobRegistrationRepo extends JpaRepository<JobRegistrationEntity, String> {


}
