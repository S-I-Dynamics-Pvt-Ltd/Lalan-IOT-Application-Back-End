package com.example.Lalan.Services;

import com.example.Lalan.DTO.AdminDTO;
import com.example.Lalan.DTO.BatchDTO;
import com.example.Lalan.Entity.AdminEntity;
import com.example.Lalan.Entity.BatchEntity;
import com.example.Lalan.Repos.AdminRepo;
import com.example.Lalan.DTO.LineRegistrationDTO;
import com.example.Lalan.DTO.ResponseDTO;
import com.example.Lalan.Entity.LineRegistrationEntity;

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
public class AdminService {

    @Autowired
    private AdminRepo adminRepo;

    @Autowired
    private ModelMapper modelMapper;

    // call repo query to get all batch ids when select job id
    public List<Object[]> getallbatches(String job_id_ad) {
        return adminRepo.getallbactchidssbyprocedure(job_id_ad);
    }

    public List<Map<ActiveObjectMap.Key, Value>> getLineByDate(String lineID) {
        return adminRepo.getLineByDate(lineID);
    }

    // get Get Customer Details By Date And LineId
    public List<Map<ActiveObjectMap.Key, Value>> GetDetailsByDateAndLineId(Date predicted_date, String LineId) {
        return adminRepo.GetDetailsByDateAndLineId(predicted_date, LineId);
    }

    // get Get machine Details By Date And LineId and POrder
    public List<Map<ActiveObjectMap.Key, Value>> GetDetailsByDateAndLineIdAndPOrder(Date predicted_date, String LineId,
            int pOrder) {
        return adminRepo.GetDetailsByDateAndLineIdAndPOrder(predicted_date, LineId, pOrder);
    }

    // get Get Perameters By Date And LineId and pOrder and Machine Id
    public List<Map<ActiveObjectMap.Key, Value>> GetDetailsByDateAndLineIdAndPOrderAndMachineId(Date predicted_date,
            String LineId, int pOrder, String MachineId) {
        return adminRepo.GetDetailsByDateAndLineIdAndPOrderAndMachineId(predicted_date, LineId, pOrder, MachineId);
    }

    // get values to the table
    public List<Map<ActiveObjectMap.Key, Value>> GetValueByDevice(String Jobid, String batchid, String LineId,
            int pOrder, String MachineId, String DeviceId, String PerId, Date Date11) {
        return adminRepo.GetValueByDevice(Jobid, batchid, LineId, pOrder, MachineId, DeviceId, PerId, Date11);
    }

    // post data
    // public List<Map<ActiveObjectMap.Key, Value>> postcurrentdata(String Jobid,
    // String jobDescription, String batchid,
    // String batchStart, String batchEnd,
    // String productId, String LineId, Date prodictedDate, int productionOrder, int
    // customerId,
    // int crudOperation, String RollNumber, String rollLength, String rollWeight,
    // String adminId) {
    // return adminRepo.postcurrentprocess(Jobid, jobDescription, batchid,
    // batchStart, batchEnd, productId,
    // LineId, prodictedDate, productionOrder, customerId, crudOperation,
    // RollNumber, rollLength, rollWeight, adminId);
    // }

    public List<Map<ActiveObjectMap.Key, Value>> postcurrentdata(String Jobid, String batchid, String itemWidth,
            String itemLength, String itemThikness,
            String strappingColor, String printedorUnprinted, String strappingPrintColor,
            String corePrintedorUnprinted, String strappingType,
            String batchStart, String batchEnd,
            String productId, String LineId, Date prodictedDate, int productionOrder,
            int customerId, int crudOperation, String RollNumber, String rollLength, String rollWeight,
            String operatorName,
            String shift, String salesOfficer, String adminId, int productType) {
        return adminRepo.postcurrentprocess(Jobid, batchid, itemWidth, itemLength, itemThikness,
                strappingColor, printedorUnprinted, strappingPrintColor, corePrintedorUnprinted, strappingType,
                batchStart, batchEnd,
                productId, LineId, prodictedDate, productionOrder,
                customerId, crudOperation, RollNumber, rollLength, rollWeight, operatorName,
                shift, salesOfficer, adminId, productType);
    }

    // get current process data
    public Map<ActiveObjectMap.Key, Value> getcurrentprocess(String adminId) {
        return adminRepo.getcurrentprocess(adminId);
    }

    // //get colors in line
    // public Map<ActiveObjectMap.Key, Value> getLineColors() {
    // return adminRepo.getLineColors();
    // }

    // device reg curd
    public List<Map<ActiveObjectMap.Key, Value>> DeviceRegistration(String lineId, String machineId_2,
            String machineName, String machineDescription, String deviceId, String parameterId, String des,
            int isitalarmPara, int completed_prod_count, int isitstarterValue, int minValPro1, int maxValPro1, int minValPro2, int maxValPro2,int minValPro3, int maxValPro3,int minValPro4, int maxValPro4,
            String mesuringUnit, String massage, String deviceLocation, String deviceIpAddress, String deviceName,
            int crudOperation) {
        return adminRepo.DeviceRegistration(lineId, machineId_2, machineName, machineDescription, deviceId, parameterId,
                des, isitalarmPara, completed_prod_count, isitstarterValue, minValPro1, maxValPro1, minValPro2, maxValPro2, minValPro3, maxValPro3, minValPro4, maxValPro4, mesuringUnit, massage,
                deviceLocation, deviceIpAddress, deviceName, crudOperation);
    }

    // get all device registration data get by device id
    public Map<ActiveObjectMap.Key, Value> getalldeviceregistration(String deviceId) {
        return adminRepo.getalldeviceregistration(deviceId);
    }

    // get color code
    public List<Map<ActiveObjectMap.Key, Value>> getcolorcode(String lindID, Date addDate) {
        return adminRepo.getcolorcode(lindID, addDate);
    }

    // get color code
    public Map<ActiveObjectMap.Key, Value> GetColorCodetolinedetails(String lindID, Date addDate) {
        return adminRepo.GetColorCodetolinedetails(lindID, addDate);
    }

    // get sumation of product count
    public Map<ActiveObjectMap.Key, Value> getsumofproduct(String lineID) {
        return adminRepo.getsumofproduct(lineID);
    }

    // put the date into admin controll
    public Map<ActiveObjectMap.Key, Value> AddStartTime(String lineID, Date t_date, int p_order, int ButtonType) {
        return adminRepo.AddStartTime(lineID, t_date, p_order, ButtonType);
    }

    // get button status
    public Map<ActiveObjectMap.Key, Value> ButtonOnorNot(String lineID, Date t_date) {
        return adminRepo.ButtonOnorNot(lineID, t_date);
    }

    // finish production from admin table
    public Map<ActiveObjectMap.Key, Value> DeleteValuesByEndTime(String lineID, Date t_date, int p_order) {
        return adminRepo.DeleteValuesByEndTime(lineID, t_date, p_order);
    }

    // calculate wastage in the line
    public Map<ActiveObjectMap.Key, Value> getSumOfProductWastage(String lineID) {
        return adminRepo.getSumOfProductWastage(lineID);
    }

    // HoldProduction
    public Map<ActiveObjectMap.Key, Value> HoldProduction(String lineID, int POrder, int HoldOrNot, String UserId,
            String Reson) {
        return adminRepo.HoldProduction(lineID, POrder, HoldOrNot, UserId, Reson);
    }

    // check username and password
    public Map<ActiveObjectMap.Key, Value> checkuser(String UserName, String Password1) {
        return adminRepo.checkuser(UserName, Password1);
    }

    // get pending productions
    public List<Map<ActiveObjectMap.Key, Value>> getpendings() {
        return adminRepo.getpendings();
    }

    // get pending production by id
    public Map<ActiveObjectMap.Key, Value> getpendingsById(String processID) {
        return adminRepo.getpendingsById(processID);
    }

    // check the production order
    public Map<ActiveObjectMap.Key, Value> checkChangeOrder(String processID1, String processOrder1,
            String processIDchange2, String processOrderchange2) {
        return adminRepo.checkChangeOrder(processID1, processOrder1, processIDchange2, processOrderchange2);
    }

    // get pending productions to second table
    public List<Map<ActiveObjectMap.Key, Value>> getChangedOrdersToSecondTable(String selectedProcessID) {
        return adminRepo.getChangedOrdersToSecondTable(selectedProcessID);
    }

    // get stopped production to add actual weight
    public List<Map<ActiveObjectMap.Key, Value>> getStoppedProductions() {

        return adminRepo.getStoppedProductions();
    }

    public List<Map<ActiveObjectMap.Key, Value>> getacctualweigthtotable(String processID) {
        return adminRepo.getacctualweigthtotable(processID);
    }

    // call sp to get roll numbers to table
    public List<Map<ActiveObjectMap.Key, Value>> getrollnumbers(int ProductionOrder, String lineID) {
        return adminRepo.getrollnumbers(ProductionOrder, lineID);
    }

    // update with actual weight
    public List<Map<ActiveObjectMap.Key, Value>> updateActualWeight(String processID, int RollNumber,
            float Weight_acc) {
        return adminRepo.updateActualWeight(processID, RollNumber, Weight_acc);
    }

    public List<Map<ActiveObjectMap.Key, Value>> getCompletedCountandDate(int ProductionOrder, String lineID,
            int CompletedRollCount) {
        return adminRepo.getCompletedCountandDate(ProductionOrder, lineID, CompletedRollCount);
    }

    // refresh devices when the data is not display in dashboard
    public List<Map<ActiveObjectMap.Key, Value>> publishMassagesToDevices(String lineID) {
        return adminRepo.publishMassagesToDevices(lineID);
    }

    // get Get Customer Details By Date And LineId
    public Map<ActiveObjectMap.Key, Value> GetRollCount(String LineId) {
        return adminRepo.GetRollCount(LineId);
    }

    // REST APIs
    public String saveAdmin(AdminDTO adminDTO) {
        // if the batch is already there in the db return duplicate massage
        if (adminRepo.existsById(adminDTO.getAdmin_id())) {
            return VarList.RSP_DUPLICATED;

        } else {
            // if not save a new batch to the db
            adminRepo.save(modelMapper.map(adminDTO, AdminEntity.class));
            return VarList.RSP_SUCCESS;
        }
    }

    public String updateAdmin(AdminDTO adminDTO) {
        // should be checked the batch is already exit
        if (adminRepo.existsById(adminDTO.getAdmin_id())) {
            // if the batch is already there update the data
            adminRepo.save(modelMapper.map(adminDTO, AdminEntity.class));
            return VarList.RSP_SUCCESS;
        } else {
            // if the batch is not already there return error
            return VarList.RSP_NO_DATA_FOUND;
        }
    }

    public List<AdminDTO> getAllAdmins() {
        // find the all data in db using findAll() and return as list
        List<AdminEntity> adminList = adminRepo.findAll();
        return modelMapper.map(adminList, new TypeToken<ArrayList<AdminDTO>>() {

        }.getType());
    }

    public AdminDTO searchAdmin(int admin_id) {
        if (adminRepo.existsById(admin_id)) {
            AdminEntity admin = adminRepo.findById(admin_id).orElse(null);
            return modelMapper.map(admin, AdminDTO.class);
        } else {
            return null;
        }
    }

    public String deleteAdmin(int admin_id) {
        // checked , the batch already in there
        if (adminRepo.existsById(admin_id)) {
            // if the batch is exit delete the batch by batch id
            adminRepo.deleteById(admin_id);
            // and return a success massage
            return VarList.RSP_SUCCESS;
        } else {
            // if not return an error message
            return VarList.RSP_NO_DATA_FOUND;
        }
    }

    public AdminDTO getByJobIdBatchID(String job_id_ad, String batchid_ad) {
        AdminEntity adminEntity = adminRepo.findByJobIdAndBatchId(job_id_ad, batchid_ad);

        if (adminEntity != null) {
            AdminDTO adminDTO = new AdminDTO();
            adminDTO.setAdmin_id(adminEntity.getAdmin_id());
            // Set other properties of AdminDTO if needed

            return adminDTO;
        } else {
            return null; // or throw an exception if needed
        }
    }

    public Map<ActiveObjectMap.Key, Value> GetLastBobbingandLength(int ProductionOrder) {
        return adminRepo.GetLastBobbingandLength(ProductionOrder);
    }

}
