package com.example.Lalan.Controller;

import com.example.Lalan.DTO.AdminDTO;
import com.example.Lalan.DTO.ResponseDTO;
import com.example.Lalan.Services.AdminService;
import com.example.Lalan.Util.VarList;
import com.sun.corba.se.impl.oa.poa.ActiveObjectMap;
import org.hibernate.mapping.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

// import java.text.SimpleDateFormat;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private ResponseDTO responseDTO;

    @GetMapping("/getallbatches/{job_id_ad}")
    public List<Object[]> getallbatchdata(@PathVariable String job_id_ad) {

        return adminService.getallbatches(job_id_ad);
    }



    @GetMapping("/getLineByDate/{lineID}")
    public List<Map<ActiveObjectMap.Key, Value>> getLineByDate(
            @PathVariable String lineID) {
        return adminService.getLineByDate(lineID);
    }

    // get Get Customer Details By Date And LineId
    @GetMapping("/GetDetailsByDateAndLineId/{Date}/{LineId}")
    public List<Map<ActiveObjectMap.Key, Value>> GetDetailsByDateAndLineId(
            @PathVariable(value = "Date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date Date11,
            @PathVariable String LineId) {
        return adminService.GetDetailsByDateAndLineId(Date11, LineId);
    }

    // get Get machines By Date And LineId and pOrder
    @GetMapping("/GetDetailsByDateAndLineIdAndPOrder/{Date}/{LineId}/{pOrder}")
    public List<Map<ActiveObjectMap.Key, Value>> GetDetailsByDateAndLineIdAndPOrder(
            @PathVariable(value = "Date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date Date11,
            @PathVariable String LineId, @PathVariable int pOrder) {
        return adminService.GetDetailsByDateAndLineIdAndPOrder(Date11, LineId, pOrder);
    }

    @GetMapping("/GetDetailsByDateAndLineIdAndPOrder/{Date}/{LineId}/{pOrder}/{MachineId}")
    public List<Map<ActiveObjectMap.Key, Value>> GetDetailsByDateAndLineIdAndPOrderAndMachineId(
            @PathVariable(value = "Date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date Date11,
            @PathVariable String LineId, @PathVariable int pOrder, @PathVariable String MachineId) {
        return adminService.GetDetailsByDateAndLineIdAndPOrderAndMachineId(Date11, LineId, pOrder, MachineId);
    }

    // get values to the table
    @GetMapping("/GetValueByDevice/{Jobid}/{batchid}/{LineId}/{pOrder}/{MachineId}/{DeviceId}/{PerId}/{Date}")
    public List<Map<ActiveObjectMap.Key, Value>> GetValueByDevice(
            @PathVariable String Jobid, @PathVariable String batchid, @PathVariable String LineId,
            @PathVariable int pOrder, @PathVariable String MachineId, @PathVariable String DeviceId,
            @PathVariable String PerId,
            @PathVariable(value = "Date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date Date11) {
        return adminService.GetValueByDevice(Jobid, batchid, LineId, pOrder, MachineId, DeviceId, PerId, Date11);
    }


    // @GetMapping("/postcurrentdata/{Jobid}/{jobDescription}/{batchid}/{batchStart}/{batchEnd}/{productId}/{LineId}/{Date}/{productionOrder}/{customerId}/{crudOperation}/{RollNumber}/{rollLength}/{rollWeight}/{adminId}")
    // public List<Map<ActiveObjectMap.Key, Value>> postcurrentprocess (@PathVariable String Jobid,@PathVariable String jobDescription,@PathVariable String batchid,@PathVariable String batchStart,
    //                                                                  @PathVariable String batchEnd,
    //                                                                  @PathVariable String productId, @PathVariable String LineId,
    //                                                                  @PathVariable (value = "Date")@DateTimeFormat(pattern = "yyyy-MM-dd") Date prodictedDate,  @PathVariable int productionOrder,   @PathVariable int customerId,
    //                                                                  @PathVariable int crudOperation, @PathVariable String RollNumber,@PathVariable String rollLength,@PathVariable  String rollWeight, @PathVariable String adminId)
    //         {
    //     return adminService.postcurrentdata(Jobid, jobDescription, batchid, batchStart, batchEnd, productId, LineId,  prodictedDate, productionOrder, customerId, crudOperation,RollNumber, rollLength,  rollWeight, adminId);
    // }

    
        @GetMapping("/postcurrentdata/{Jobid}/{batchid}/{itemWidth}/{itemLength}/{itemThikness}/{strappingColor}/{printedorUnprinted}/{strappingPrintColor}/{corePrintedorUnprinted}/{strappingType}/{batchStart}/{batchEnd}/{productId}/{LineId}/{Date}/{productionOrder}/{customerId}/{crudOperation}/{RollNumber}/{rollLength}/{rollWeight}/{operatorName}/{shift}/{salesOfficer}/{adminId}")
    public List<Map<ActiveObjectMap.Key, Value>> postcurrentprocess (@PathVariable String Jobid,@PathVariable String batchid,@PathVariable String itemWidth,
                                                                     @PathVariable String itemLength,@PathVariable String itemThikness, @PathVariable String strappingColor,
                                                                     @PathVariable String printedorUnprinted, @PathVariable String strappingPrintColor, @PathVariable String corePrintedorUnprinted,
                                                                     @PathVariable String strappingType,@PathVariable String batchStart,
                                                                     @PathVariable String batchEnd,
                                                                     @PathVariable String productId, @PathVariable String LineId,
                                                                     @PathVariable (value = "Date")@DateTimeFormat(pattern = "yyyy-MM-dd") Date prodictedDate,  @PathVariable int productionOrder, 
                                                                     @PathVariable int customerId,
                                                                     @PathVariable int crudOperation, @PathVariable String RollNumber,@PathVariable String rollLength,
                                                                     @PathVariable  String rollWeight, @PathVariable String operatorName,
                                                                     @PathVariable String shift,@PathVariable String salesOfficer,@PathVariable String adminId)
    {
        return adminService.postcurrentdata( Jobid,batchid
                ,   itemWidth,  itemLength,  itemThikness,
    strappingColor,  printedorUnprinted,  strappingPrintColor,  corePrintedorUnprinted,  strappingType,
    batchStart,  batchEnd,
    productId,  LineId,  prodictedDate,  productionOrder,
    customerId,  crudOperation,  RollNumber,  rollLength,  rollWeight,  operatorName,
    shift,  salesOfficer, adminId);
}


    @GetMapping("/getcurrentprocess/{adminId}")
    public Map<ActiveObjectMap.Key, Value> getcurrentprocess (@PathVariable String adminId)
            {
        return adminService.getcurrentprocess(adminId);
    }



     //Device Registration
     @GetMapping("/DeviceRegistration/{lineId}/{machineId_2}/{machineName}/{machineDescription}/{deviceId}/{parameterId}/{des}/{isitalarmPara}/{completed_prod_count}/{isitstarterValue}/{minVal}/{maxVal}/{mesuringUnit}/{massage}/{deviceLocation}/{deviceIpAddress}/{deviceName}/{crudOperation}")
     public List<Map<ActiveObjectMap.Key, Value>> DeviceRegistration (@PathVariable String lineId, @PathVariable String machineId_2, @PathVariable String machineName, @PathVariable String machineDescription, @PathVariable String deviceId, @PathVariable String parameterId, @PathVariable String des, @PathVariable int isitalarmPara, @PathVariable int completed_prod_count, @PathVariable int isitstarterValue, @PathVariable int minVal, @PathVariable int maxVal, @PathVariable String mesuringUnit, @PathVariable String massage, @PathVariable String deviceLocation, @PathVariable String deviceIpAddress, @PathVariable String deviceName, @PathVariable int crudOperation)
             {
         return adminService.DeviceRegistration(lineId,machineId_2,machineName,machineDescription,deviceId,parameterId,des,isitalarmPara,completed_prod_count,isitstarterValue, minVal, maxVal, mesuringUnit, massage, deviceLocation, deviceIpAddress, deviceName, crudOperation);
     }


    //get all device registration data  get by device id
    @GetMapping("/getalldeviceregistration/{deviceId}")
    public Map<ActiveObjectMap.Key, Value> getalldeviceregistration (@PathVariable String deviceId)
    {
        return adminService.getalldeviceregistration(deviceId);
    }




    //get color code
    @GetMapping("/getcolorcode/{lindID}/{Date}")
    public List<Map<ActiveObjectMap.Key, Value>> getcolorcode (@PathVariable String lindID,   @PathVariable (value = "Date")@DateTimeFormat(pattern = "yyyy-MM-dd") Date addDate)
    {
        return adminService.getcolorcode(lindID,addDate);
    }
    //get color code2
    @GetMapping("/GetColorCodetolinedetails/{lindID}/{Date}")
    public Map<ActiveObjectMap.Key, Value> GetColorCodetolinedetails (@PathVariable String lindID,   @PathVariable (value = "Date")@DateTimeFormat(pattern = "yyyy-MM-dd") Date addDate)
    {
        return adminService.GetColorCodetolinedetails(lindID,addDate);
    }



     //get sumation of product count
     @GetMapping("/getsumofproduct/{lineID}")
     public Map<ActiveObjectMap.Key, Value> getsumofproduct (@PathVariable String lineID)
     {
         return adminService.getsumofproduct(lineID);
     }

     //get sumation of product count
     @GetMapping("/AddStartTime/{lineID}/{Date}/{p_order}/{ButtonType}")
     public Map<ActiveObjectMap.Key, Value> AddStartTime (@PathVariable String lineID,   @PathVariable (value = "Date")@DateTimeFormat(pattern = "yyyy-MM-dd") Date t_date, @PathVariable int p_order ,@PathVariable int ButtonType)
     {
         return adminService.AddStartTime( lineID,t_date, p_order,ButtonType);
     }
      // get button status
     @GetMapping("/ButtonOnorNot/{lineID}/{Date}")
     public Map<ActiveObjectMap.Key, Value> ButtonOnorNot (@PathVariable String lineID,   @PathVariable (value = "Date")@DateTimeFormat(pattern = "yyyy-MM-dd") Date t_date)
     {
         return adminService.ButtonOnorNot( lineID,t_date);
     }
   // finish production from admin table 
    @GetMapping("/DeleteValuesByEndTime/{lineID}/{Date}/{p_order}")
    public Map<ActiveObjectMap.Key, Value> DeleteValuesByEndTime (@PathVariable String lineID,   @PathVariable (value = "Date")@DateTimeFormat(pattern = "yyyy-MM-dd") Date t_date, @PathVariable int p_order)
    {
        return adminService.DeleteValuesByEndTime(lineID,t_date, p_order);
    }

     // calculate wastage in the line
     @GetMapping("/getSumOfProductWastage/{lineID}")
     public Map<ActiveObjectMap.Key, Value> getSumOfProductWastage (@PathVariable String lineID)
     {
         return adminService.getSumOfProductWastage(lineID);
     }
     // HoldProduction
     @GetMapping("/HoldProduction/{lineID}/{POrder}/{HoldOrNot}/{UserId}/{Reson}")
     public Map<ActiveObjectMap.Key, Value> HoldProduction (@PathVariable String lineID,@PathVariable int POrder,@PathVariable int HoldOrNot,@PathVariable String UserId,@PathVariable String Reson)
     {
         return adminService.HoldProduction(lineID,POrder,HoldOrNot,UserId,Reson);
     }



     //check username and password
    @GetMapping("/checkuser/{UserName}/{Password1}")
    public  Map<ActiveObjectMap.Key, Value> checkuser(@PathVariable String UserName, @PathVariable String Password1)
    {
        return adminService.checkuser(UserName, Password1);
    }


    //get pending productions

    @GetMapping("/getpendings")
    public  List<Map<ActiveObjectMap.Key, Value>>  getpendings()
    {
        return adminService.getpendings();
    }

    //get pending production by id
    @GetMapping("/getpendingsById/{processID}")
    public  Map<ActiveObjectMap.Key, Value> getpendingsById(@PathVariable String processID)
    {
        return adminService.getpendingsById(processID);
    }


    //check the production order

    @GetMapping("/checkChangeOrder/{processID1}/{processOrder1}/{processIDchange2}/{processOrderchange2}")
    public  Map<ActiveObjectMap.Key, Value> checkChangeOrder(@PathVariable String processID1,@PathVariable String processOrder1,@PathVariable String processIDchange2,@PathVariable String processOrderchange2)
    {
        return adminService.checkChangeOrder(processID1,  processOrder1,  processIDchange2,  processOrderchange2);
    }


    @GetMapping("/getChangedOrdersToSecondTable/{selectedProcessID}")
    public  List<Map<ActiveObjectMap.Key, Value>> getChangedOrdersToSecondTable(@PathVariable String selectedProcessID)
    {
        return adminService.getChangedOrdersToSecondTable(selectedProcessID);
    }


    //get stopped production to add actual weight
    @GetMapping("/getstoppedproductions")
    public  List<Map<ActiveObjectMap.Key, Value>>  getStoppedProductions()
    {

        return adminService.getStoppedProductions();
    }


    @GetMapping("/getacctualweigthtotable/{processID}")
    public  List<Map<ActiveObjectMap.Key, Value>> getacctualweigthtotable(@PathVariable String processID)
    {
        return adminService.getacctualweigthtotable(processID);
    }

    //call sp to get roll numbers to table
    @GetMapping("/getrollnumbers/{ProductionOrder}/{lineID}")
    public List<Map<ActiveObjectMap.Key, Value>> getrollnumbers(@PathVariable  int ProductionOrder,@PathVariable String lineID)
    {
        return adminService.getrollnumbers(ProductionOrder, lineID);
    }

    //update with actual weight
    @GetMapping("/updateActualWeight/{processID}/{RollNumber}/{Weight_acc}")
    public List<Map<ActiveObjectMap.Key, Value>> updateActualWeight(@PathVariable String processID, @PathVariable int RollNumber,@PathVariable float Weight_acc)
    {
        return adminService.updateActualWeight(processID,  RollNumber,  Weight_acc);
    }



    @GetMapping("/getCompletedCountandDate/{ProductionOrder}/{lineID}/{CompletedRollCount}")
    public List<Map<ActiveObjectMap.Key, Value>> getCompletedCountandDate(
            @PathVariable int ProductionOrder, @PathVariable String lineID, @PathVariable int CompletedRollCount) {
        return adminService.getCompletedCountandDate(ProductionOrder, lineID, CompletedRollCount);
    }

    @GetMapping("/publishMassagesToDevices/{lineID}")
    public List<Map<ActiveObjectMap.Key, Value>> publishMassagesToDevices(@PathVariable String lineID) {
        return adminService.publishMassagesToDevices(lineID);
    }

    @GetMapping("/GetRollCount/{lineID}")
    public Map<ActiveObjectMap.Key, Value> GetRollCount(@PathVariable String lineID) {
        return adminService.GetRollCount(lineID);
    }

    @GetMapping("/GetLastBobbingandLength/{ProductionOrder}")
    public Map<ActiveObjectMap.Key, Value> GetLastBobbingandLength(@PathVariable int ProductionOrder) {
        return adminService.GetLastBobbingandLength(ProductionOrder);
    }
















    //REST APIs
    @PostMapping("/saveAdmin")
    public ResponseEntity saveAdmin(@RequestBody AdminDTO adminDTO){

        try{
            String res = adminService.saveAdmin(adminDTO);
            if(res.equals("00")){
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Successfully Added");
                responseDTO.setContent(adminDTO);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);

            }else if(res.equals("06")){
                responseDTO.setCode(VarList.RSP_DUPLICATED);
                responseDTO.setMessage("Already Added");
                responseDTO.setContent(adminDTO);
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

    @PutMapping(value = "/updateAdmin/{adminid_ad}")
    public ResponseEntity updateAdmin(@RequestBody AdminDTO adminDTO){

        try{
            String res = adminService.updateAdmin(adminDTO);
            if(res.equals("00")){
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Update Success");
                responseDTO.setContent(adminDTO);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);

            }else if(res.equals("01")){
                responseDTO.setCode(VarList.RSP_DUPLICATED);
                responseDTO.setMessage(" Added state not found");
                responseDTO.setContent(adminDTO);
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

    @GetMapping("/getAllAdmins")
    public ResponseEntity getAllAdmins(){
        try {
            List<AdminDTO> adminDTOList = adminService.getAllAdmins();
            responseDTO.setCode(VarList.RSP_SUCCESS);
            responseDTO.setMessage("getting Success");
            responseDTO.setContent(adminDTOList);
            return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);

        }catch (Exception ex){
            responseDTO.setCode(VarList.RSP_ERROR);
            responseDTO.setMessage(ex.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @GetMapping("/searchAdmin/{admin_id}")
    public ResponseEntity searchAdmin(@PathVariable int admin_id){
        try {
            AdminDTO adminDTO = adminService.searchAdmin(admin_id);
            if (adminDTO !=null) {
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Success");
                responseDTO.setContent(adminDTO);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
            } else {
                responseDTO.setCode(VarList.RSP_NO_DATA_FOUND);
                responseDTO.setMessage("No admin Available For this  ID");
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

    @GetMapping("/searchAdmin/{job_id_ad}/{batchid_ad}")
    public ResponseEntity getByJobIdBatchID(@PathVariable String job_id_ad, @PathVariable String batchid_ad){
        try {
            AdminDTO adminDTO = adminService.getByJobIdBatchID(job_id_ad, batchid_ad);
            if (adminDTO !=null) {
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Success");
                responseDTO.setContent(adminDTO);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
            } else {
                responseDTO.setCode(VarList.RSP_NO_DATA_FOUND);
                responseDTO.setMessage("No admin Available For this  ID");
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

    @DeleteMapping("/deleteAdmin/{admin_id}")
    public ResponseEntity deleteAdmin(@PathVariable int admin_id){
        try {
            String res = adminService.deleteAdmin(admin_id);
            if (res.equals("00")) {
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Delete Success");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
            } else {
                responseDTO.setCode(VarList.RSP_NO_DATA_FOUND);
                responseDTO.setMessage("No admin Available For this  id");
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
