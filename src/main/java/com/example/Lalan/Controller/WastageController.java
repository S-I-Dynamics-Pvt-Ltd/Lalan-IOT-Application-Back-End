package com.example.Lalan.Controller;

import com.example.Lalan.DTO.WastageDTO;
import com.example.Lalan.Entity.WastageEntity;
import com.example.Lalan.DTO.AdminDTO;
import com.example.Lalan.DTO.MaterialDTO;
import com.example.Lalan.DTO.ProductionTotDTO;
import com.example.Lalan.DTO.ResponseDTO;
import com.example.Lalan.Services.WastageService;
import com.example.Lalan.Util.VarList;
import com.sun.corba.se.impl.oa.poa.ActiveObjectMap;
import org.hibernate.mapping.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/wastage")
public class WastageController {
    @Autowired
    private WastageService wastageService;

    @Autowired
    private ResponseDTO responseDTO;

    @GetMapping("/getProductionWastage/{admin_id}")
    public Map<ActiveObjectMap.Key, Value> getProductionWastage(@PathVariable Integer admin_id) {
        return wastageService.getProductionWastage(admin_id);
    }

    @GetMapping("/getWastageOrNot/{admin_id}/{hisID}/{oparation}/{sysLength}")
    public List<Map<ActiveObjectMap.Key, Value>> getWastageOrNot(@PathVariable Integer admin_id, @PathVariable Integer hisID, @PathVariable Integer oparation, @PathVariable Integer sysLength) {
        return wastageService.getWastageOrNot(admin_id, hisID, oparation, sysLength);
    }

    @GetMapping("/getAllWastages")
    public ResponseEntity getAllWastages() {
        try {
            List<ProductionTotDTO> wastageDTOList = wastageService.getAllWastages();
            responseDTO.setCode(VarList.RSP_SUCCESS);
            responseDTO.setMessage("getting Success");
            responseDTO.setContent(wastageDTOList);
            return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            responseDTO.setCode(VarList.RSP_ERROR);
            responseDTO.setMessage(ex.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

     @GetMapping("/searchWastage/{adminId}")
    public ResponseEntity searchWastage(@PathVariable int adminId){
        try {
            ProductionTotDTO wastageDTO = wastageService.searchWastage(adminId);
            if (wastageDTO !=null) {
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Success");
                responseDTO.setContent(wastageDTO);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
            } else {
                responseDTO.setCode(VarList.RSP_NO_DATA_FOUND);
                responseDTO.setMessage("No wastage is available For this ID");
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

    @DeleteMapping("/deleteWastage/{totId}")
    public ResponseEntity deleteWastage(@PathVariable int totId){
        try {
            String res = wastageService.deleteWastage(totId);
            if (res.equals("00")) {
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Delete Success");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
            } else {
                responseDTO.setCode(VarList.RSP_NO_DATA_FOUND);
                responseDTO.setMessage("No wastage Available For this  id");
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

    @PutMapping(value = "/updateWastage/{admin_id}")
    public ResponseEntity updateWastage(@RequestBody ProductionTotDTO wastageDTO){

        try{
            String res = wastageService.updateAllWastage(wastageDTO);
            if(res.equals("00")){
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Update Success");
                responseDTO.setContent(wastageDTO);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);

            }else if(res.equals("01")){
                responseDTO.setCode(VarList.RSP_DUPLICATED);
                responseDTO.setMessage(" Added state not found");
                responseDTO.setContent(wastageDTO);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);

            }else{
                responseDTO.setCode(VarList.RSP_FAIL);
                responseDTO.setMessage("Error Occurred");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);

            }
        }catch(Exception ex){
            responseDTO.setCode(VarList.RSP_ERROR);
            responseDTO.setMessage(ex.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

     // Update Actual_value by Id
    @PutMapping(value = "/updateWastageActualValue/{admin_id}")
    public ResponseEntity updateWastageActualValue(@RequestBody ProductionTotDTO wastageDTO) {
        try {
            String res = wastageService.updateWastageActualValue(wastageDTO);
            if (res.equals("00")) {
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Update Success");
                responseDTO.setContent(wastageDTO);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);

            } else if (res.equals("01")) {
                responseDTO.setCode(VarList.RSP_DUPLICATED);
                responseDTO.setMessage(" Registered state not found");
                responseDTO.setContent(wastageDTO);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);

            } else {
                responseDTO.setCode(VarList.RSP_FAIL);
                responseDTO.setMessage("Error Occurred");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);

            }
        } catch (Exception ex) {
            responseDTO.setCode(VarList.RSP_ERROR);
            responseDTO.setMessage(ex.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
