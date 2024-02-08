package com.example.Lalan.Services;

import com.example.Lalan.DTO.ProductionTotDTO;
import com.example.Lalan.DTO.WastageDTO;
import com.example.Lalan.Entity.ProductionTotEntity;
import com.example.Lalan.Entity.WastageEntity;
import com.example.Lalan.Repos.ProductionTotRepo;
import com.example.Lalan.Repos.WastageRepo;
import java.util.Optional;
import org.springframework.data.domain.Sort;
import com.example.Lalan.Util.VarList;
import com.sun.corba.se.impl.oa.poa.ActiveObjectMap;
import org.hibernate.mapping.Value;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.QueryLookupStrategy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class WastageService {
    @Autowired
    private WastageRepo wastageRepo;

    @Autowired
    private ProductionTotRepo productionTotRepo;

    @Autowired
    private ModelMapper modelMapper;

    public Map<ActiveObjectMap.Key, Value> getProductionWastage(Integer admin_id) {
        return wastageRepo.getProductionWastage(admin_id);
    }

    public List<Map<ActiveObjectMap.Key, Value>> getWastageOrNot(Integer admin_id, Integer hisID, Integer oparation,
            Integer sysLength) {
        return wastageRepo.getWastageOrNot(admin_id, hisID, oparation, sysLength);
    }

    public List<ProductionTotDTO> getAllWastages() {
        Sort sort = Sort.by(Sort.Direction.DESC, "totId");
        List<ProductionTotEntity> wastageList = productionTotRepo.findAll(sort);
        return modelMapper.map(wastageList, new TypeToken<ArrayList<ProductionTotDTO>>() {

        }.getType());
    }

    public ProductionTotDTO searchWastage(Integer adminId) {

        ProductionTotEntity wastage = productionTotRepo.findByAdminId(adminId);
        return modelMapper.map(wastage, ProductionTotDTO.class);

    }

    public String deleteWastage(Integer totId) {
        // checked , the batch already in there
        if (productionTotRepo.existsById(totId)) {
            // if the batch is exit delete the batch by batch id
            productionTotRepo.deleteById(totId);
            // and return a success massage
            return VarList.RSP_SUCCESS;
        } else {
            // if not return an error message
            return VarList.RSP_NO_DATA_FOUND;
        }
    }

    public String updateAllWastage(ProductionTotDTO productionTotDTO) {
        // Check if the batch already exists
        ProductionTotEntity existingEntity = productionTotRepo.findByAdminId(productionTotDTO.getAdminId());

        if (existingEntity != null) {
            // If the batch is already there, update the data
            existingEntity.setTot_system_wastage(productionTotDTO.getTot_system_wastage());
            existingEntity.setTot_actual_wastage(productionTotDTO.getTot_actual_wastage());

            // Save and flush the updated entity
            existingEntity = productionTotRepo.saveAndFlush(existingEntity);

            return VarList.RSP_SUCCESS;
        } else {
            
            return VarList.RSP_NO_DATA_FOUND;
        }
    }

    public String updateWastageActualValue(ProductionTotDTO productionTotDTO) {
        // Check if the batch already exists
        ProductionTotEntity existingEntity = productionTotRepo.findByAdminId(productionTotDTO.getAdminId());

        if (existingEntity != null) {
            // If the batch is already there, update the data
            existingEntity.setTot_actual_wastage(productionTotDTO.getTot_actual_wastage());

            // Save and flush the updated entity
            existingEntity = productionTotRepo.saveAndFlush(existingEntity);

            return VarList.RSP_SUCCESS;
        } else {
            // If the batch is not already there, return an error
            return VarList.RSP_NO_DATA_FOUND;
        }
    }
}
