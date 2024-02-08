package com.example.Lalan.Controller;

import com.example.Lalan.DTO.UserAllocationDTO;
import com.example.Lalan.DTO.ResponseDTO;
import com.example.Lalan.Services.UserAllcationServices;
import com.example.Lalan.Util.VarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.hibernate.mapping.Value;
import com.sun.corba.se.impl.oa.poa.ActiveObjectMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/userallocation")
public class UserAllocationController {
    @Autowired
    private UserAllcationServices userAllcationServices;

    @Autowired
    private ResponseDTO responseDTO;

     @GetMapping("/getUserAllocationsAccording/{user_id}")
    // public ResponseEntity getUserAllocationsAccordingUserID(@PathVariable String user_id) {
        // try {
        //     List<UserAllocationDTO> UserAllocationDTO = userAllcationServices.getUserAllocationsAccordingUserID();
        //     responseDTO.setCode(VarList.RSP_SUCCESS);
        //     responseDTO.setMessage("getting Success");
        //     responseDTO.setContent(UserAllocationDTO);
        //     return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);

        // } catch (Exception ex) {
        //     responseDTO.setCode(VarList.RSP_ERROR);
        //     responseDTO.setMessage(ex.getMessage());
        //     responseDTO.setContent(null);
        //     return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);

        // }
    //     try {
    //         List<String> batchIDs = userAllcationServices.getUserAllocationsAccordingUserID(user_id);

    //         if (!batchIDs.isEmpty()) {
    //             responseDTO.setCode(VarList.RSP_SUCCESS);
    //             responseDTO.setMessage("Success");
    //             responseDTO.setContent(batchIDs);
    //             return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
    //         } else {
    //             responseDTO.setCode(VarList.RSP_NO_DATA_FOUND);
    //             responseDTO.setMessage("No batch IDs Available For this job ID");
    //             responseDTO.setContent(null);
    //             return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
    //         }
    //     } catch (Exception e) {
    //         responseDTO.setCode(VarList.RSP_ERROR);
    //         responseDTO.setMessage(e.getMessage());
    //         responseDTO.setContent(e);
    //         return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
    //     }

    // }

    public ResponseEntity getUserAllocationsAccordingUserID(@PathVariable String user_id) {
        try {
            List<UserAllocationDTO> userAllocationDTOs = userAllcationServices.getUserAllocationWithDetails(user_id);
    
            if (!userAllocationDTOs.isEmpty()) {
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Success");
                responseDTO.setContent(userAllocationDTOs);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
            } else {
                responseDTO.setCode(VarList.RSP_NO_DATA_FOUND);
                responseDTO.setMessage("No User Allocations Available for this user ID");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            responseDTO.setCode(VarList.RSP_ERROR);
            responseDTO.setMessage(e.getMessage());
            responseDTO.setContent(e);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
