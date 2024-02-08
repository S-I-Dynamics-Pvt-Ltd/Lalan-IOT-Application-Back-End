package com.example.Lalan.Services;

import com.example.Lalan.DTO.UserAllocationDTO;
import com.example.Lalan.Entity.BatchEntity;
import com.example.Lalan.Entity.UserAllocationEntity;
import com.example.Lalan.Repos.UserAllocationRepos;
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
public class UserAllcationServices {
    @Autowired
    private UserAllocationRepos userAllocationRepos;

    @Autowired
    private ModelMapper modelMapper;

    // public List<String> getUserAllocationsAccordingUserID(String user_id) {
    //     // List<UserAllocationEntity> userAllocationList =
    //     // userAllocationRepos.findAll();
    //     // return modelMapper.map(userAllocationList, new
    //     // TypeToken<ArrayList<UserAllocationDTO>>() {

    //     // }.getType());
    //     List<UserAllocationEntity> userAllocationEntities = userAllocationRepos.findByUserId(user_id);
    //     List<String> userAllocationList = new ArrayList<>();

    //     for (UserAllocationEntity userAllocation : userAllocationEntities) {
    //         userAllocationList.add(userAllocation.getUserId());
    //     }

    //     return userAllocationList;
    // }

    public List<UserAllocationDTO> getUserAllocationWithDetails(String user_id) {
        List<UserAllocationEntity> userAllocationEntities = userAllocationRepos.findByUserId(user_id);
        List<UserAllocationDTO> userAllocationList = new ArrayList<>();
    
        for (UserAllocationEntity userAllocation : userAllocationEntities) {
            UserAllocationDTO userAllocationDTO = new UserAllocationDTO();
            userAllocationDTO.setUser_allocation_id(userAllocation.getUser_allocation_id());
            userAllocationDTO.setUserId(userAllocation.getUserId());
            userAllocationDTO.setPage_id(userAllocation.getPage_id());
            userAllocationDTO.setStatus(userAllocation.getStatus());
    
            userAllocationList.add(userAllocationDTO);
        }
    
        return userAllocationList;
    }
}
