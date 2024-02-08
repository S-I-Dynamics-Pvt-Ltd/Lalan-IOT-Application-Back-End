package com.example.Lalan.Repos;

import com.example.Lalan.Entity.BatchEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BatchRepo extends JpaRepository<BatchEntity, String> {
    // Optional<BatchEntity> findByJobID_bch(String jobIDBch);
    List<BatchEntity> findByJobIDBch(String jobIDBch);
}
