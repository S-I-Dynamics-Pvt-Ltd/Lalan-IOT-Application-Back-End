package com.example.Lalan.Services;

import com.example.Lalan.DTO.DeviceDTO;
import com.example.Lalan.DTO.MaterialDTO;
import com.example.Lalan.Entity.DeviceEntity;
import com.example.Lalan.Entity.MaterialEntity;
import com.example.Lalan.Repos.MaterialRepo;
import com.example.Lalan.Util.VarList;
import org.modelmapper.ModelMapper;
import org.hibernate.mapping.Value;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sun.corba.se.impl.oa.poa.ActiveObjectMap;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class MaterialService {

    @Autowired
    private MaterialRepo materialRepo;

    @Autowired
    private ModelMapper modelMapper;

    public String saveMaterial(MaterialDTO materialDTO) {
        materialRepo.save(modelMapper.map(materialDTO, MaterialEntity.class));
        return VarList.RSP_SUCCESS;
    }

    public List<MaterialDTO> getAllMaterial() {
        List<MaterialEntity> materialList = materialRepo.findAll();
        return modelMapper.map(materialList, new TypeToken<ArrayList<MaterialDTO>>() {

        }.getType());
    }

    public String updateMaterial(MaterialDTO materialDTO) {
        // should be checked the device is already exit
        if (materialRepo.existsById(materialDTO.getMaterial_id())) {
            // if the device is already there update the data
            materialRepo.save(modelMapper.map(materialDTO, MaterialEntity.class));
            return VarList.RSP_SUCCESS;
        } else {
            // if the user is not already there return error
            return VarList.RSP_NO_DATA_FOUND;
        }
    }

    public String updateMaterialActualValue(MaterialDTO materialDTO) {
        // should be checked the device is already exit
        if (materialRepo.existsById(materialDTO.getMaterial_id())) {
            MaterialEntity materialEntity = materialRepo.findById(materialDTO.getMaterial_id()).orElse(null);

            if (materialEntity != null) {
                // Update the actual_value
                materialEntity.setActual_value(materialDTO.getActual_value());

                // Save the updated MaterialEntity
                materialRepo.save(materialEntity);

                return VarList.RSP_SUCCESS;
            } else {
                return VarList.RSP_NO_DATA_FOUND;
            }
        } else {
            // if the user is not already there return error
            return VarList.RSP_NO_DATA_FOUND;
        }
    }

    public String deleteMaterial(Integer material_id) {
        // checked , the device already in there
        if (materialRepo.existsById(material_id)) {
            // if the device is exit delete the device by using id
            materialRepo.deleteById(material_id);
            // and return a success massage
            return VarList.RSP_SUCCESS;
        } else {
            // if not return an error message
            return VarList.RSP_NO_DATA_FOUND;
        }
    }

    public MaterialDTO searchMaterial(Integer material_id) {
        if (materialRepo.existsById(material_id)) {
            MaterialEntity material = materialRepo.findById(material_id).orElse(null);
            return modelMapper.map(material, MaterialDTO.class);
        } else {
            return null;
        }
    }
}
