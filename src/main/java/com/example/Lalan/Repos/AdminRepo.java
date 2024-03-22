package com.example.Lalan.Repos;

import com.example.Lalan.DTO.LineRegistrationDTO;
import com.example.Lalan.Entity.AdminEntity;
import com.example.Lalan.Entity.BatchEntity;
import com.example.Lalan.Entity.LineRegistrationEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sun.corba.se.impl.oa.poa.ActiveObjectMap;
import org.hibernate.mapping.Value;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.QueryLookupStrategy;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface AdminRepo extends JpaRepository<AdminEntity, Integer> {

        // select job id and retrieve batch id
        public static final String sqlquerypart2 = "call sp_GetBatchID(?1)";

        @Query(value = sqlquerypart2, nativeQuery = true)
        public List<Object[]> getallbactchidssbyprocedure(String job_id_ad);

        public static final String sqlquerypart3 = "call sp_GetLineDetailsByDate(?1)";

        @Query(value = sqlquerypart3, nativeQuery = true)
        public List<Map<ActiveObjectMap.Key, Value>> getLineByDate(String lineID);

        // get Get Customer Details By Date And LineId
        public static final String sqlquerypart4 = "call sp_GetDetailsByDateAndLineId(?1 , ?2)";

        @Query(value = sqlquerypart4, nativeQuery = true)
        public List<Map<ActiveObjectMap.Key, Value>> GetDetailsByDateAndLineId(Date predicted_date, String LineId);

        // get Get Customer Details By Date And LineId
        public static final String sqlquerypart5 = "call sp_GetDetailsByDateAndLineIdAndPOrder(?1 , ?2 , ?3)";

        @Query(value = sqlquerypart5, nativeQuery = true)
        public List<Map<ActiveObjectMap.Key, Value>> GetDetailsByDateAndLineIdAndPOrder(Date predicted_date,
                        String LineId,
                        int pOrder);

        // get Get Perameters By Date And LineId and pOrder and Machine Id
        public static final String sqlquerypart6 = "call sp_GetDetailsByDateAndLineIdAndPOrderAndMachineId(?1 , ?2 , ?3, ?4)";

        @Query(value = sqlquerypart6, nativeQuery = true)
        public List<Map<ActiveObjectMap.Key, Value>> GetDetailsByDateAndLineIdAndPOrderAndMachineId(Date predicted_date,
                        String LineId, int pOrder, String MachineId);

        // get values to the table
        public static final String sqlquerypart7 = "call sp_GetValueByDevice(?1 , ?2 , ?3, ?4 , ?5 , ?6 , ?7 , ?8)";

        @Query(value = sqlquerypart7, nativeQuery = true)
        public List<Map<ActiveObjectMap.Key, Value>> GetValueByDevice(String Jobid, String batchid, String LineId,
                        int pOrder, String MachineId, String DeviceId, String PerId, Date Date11);

        // post current process data
        // public static final String sqlquerypart8 = "call insert_line(?1 , ?2 , ?3, ?4
        // , ?5 , ?6 , ?7 , ?8, ?9, ?10, ?11, ?12,?13,?14,?15)";

        // @Query(value = sqlquerypart8, nativeQuery = true)
        // public List<Map<ActiveObjectMap.Key, Value>> postcurrentprocess(String Jobid,
        // String jobDescription,
        // String batchid, String batchStart, String batchEnd,
        // String productId, String LineId, Date prodictedDate, int productionOrder,
        // int customerId, int crudOperation, String RollNumber, String rollLength,
        // String rollWeight, String adminId);

        public static final String sqlquerypart8 = "call insert_line(?1 , ?2 , ?3, ?4 , ?5 , ?6 , ?7 , ?8, ?9, ?10, ?11, ?12,?13,?14,?15,?16,?17,?18,?19,?20,?21,?22,?23,?24,?25,?26)";

        @Query(value = sqlquerypart8, nativeQuery = true)
        public List<Map<ActiveObjectMap.Key, Value>> postcurrentprocess(String Jobid, String batchid, String itemWidth,
                        String itemLength, String itemThikness,
                        String strappingColor, String printedorUnprinted, String strappingPrintColor,
                        String corePrintedorUnprinted, String strappingType,
                        String batchStart, String batchEnd,
                        String productId, String LineId, Date prodictedDate, int productionOrder,
                        int customerId, int crudOperation, String RollNumber, String rollLength, String rollWeight,
                        String operatorName,
                        String shift, String salesOfficer, String adminId, int productType);

        // get all current process data
        public static final String sqlquerypart9 = "call sp_Getallprocess(?1)";

        @Query(value = sqlquerypart9, nativeQuery = true)
        public Map<ActiveObjectMap.Key, Value> getcurrentprocess(String adminId);

        // get colors
        // public static final String sqlquerypart10 = "call sp_GetColorCode()";

        // @Query(value = sqlquerypart10, nativeQuery = true)
        // public Map<ActiveObjectMap.Key, Value> getLineColors();

        // get device reg crud
        public static final String sqlquerypart11 = "call sp_DeviceRegistration(?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8, ?9, ?10, ?11, ?12, ?13, ?14, ?15, ?16, ?17, ?18, ?19, ?20, ?21, ?22, ?23, ?24)";

        @Query(value = sqlquerypart11, nativeQuery = true)
        public List<Map<ActiveObjectMap.Key, Value>> DeviceRegistration(String lineId, String machineId_2,
                        String machineName, String machineDescription, String deviceId, String parameterId, String des,
                        int isitalarmPara, int completed_prod_count, int isitstarterValue, int minValPro1, int maxValPro1,int minValPro2, int maxValPro2, int minValPro3, int maxValPro3, int minValPro4, int maxValPro4,
                        String mesuringUnit,
                        String massage, String deviceLocation, String deviceIpAddress, String deviceName,
                        int crudOperation);

        // get all device registration data get by device id
        public static final String sqlquerypart12 = "call sp_Getalldeviceregistrations(?1)";

        @Query(value = sqlquerypart12, nativeQuery = true)
        public Map<ActiveObjectMap.Key, Value> getalldeviceregistration(String deviceId);

        // get color code 2
        public static final String sqlquerypart14 = "call sp_GetColorCode02(?1, ?2)";

        @Query(value = sqlquerypart14, nativeQuery = true)
        public Map<ActiveObjectMap.Key, Value> GetColorCodetolinedetails(String lindID, Date addDate);

        // get color code
        public static final String sqlquerypart13 = "call sp_GetColorCode(?1, ?2)";

        @Query(value = sqlquerypart13, nativeQuery = true)
        public List<Map<ActiveObjectMap.Key, Value>> getcolorcode(String lindID, Date addDate);

        // get sumation of product count
        public static final String sqlquerypart15 = "call sp_GetSumOfProduct(?1)";

        @Query(value = sqlquerypart15, nativeQuery = true)
        public Map<ActiveObjectMap.Key, Value> getsumofproduct(String lineID);

        // put the date into admin controll
        public static final String sqlquerypart16 = "call sp_AddStartTime(?1, ?2, ?3 , ?4)";

        @Query(value = sqlquerypart16, nativeQuery = true)
        public Map<ActiveObjectMap.Key, Value> AddStartTime(String lineID, Date t_date, int p_order, int ButtonType);

        // get button status
        public static final String sqlquerypart17 = "call sp_ButtonOnorNot(?1, ?2)";

        @Query(value = sqlquerypart17, nativeQuery = true)
        public Map<ActiveObjectMap.Key, Value> ButtonOnorNot(String lineID, Date t_date);

        // finish production from admin table
        public static final String sqlquerypart18 = "call sp_DeleteValuesByEndTime(?1, ?2, ?3)";

        @Query(value = sqlquerypart18, nativeQuery = true)
        public Map<ActiveObjectMap.Key, Value> DeleteValuesByEndTime(String lineID, Date t_date, int p_order);

        // calculate wastage in the line
        public static final String sqlquerypart19 = "call sp_GetSumOfProductWastage(?1)";

        @Query(value = sqlquerypart19, nativeQuery = true)
        public Map<ActiveObjectMap.Key, Value> getSumOfProductWastage(String lineID);

        // HoldProduction
        public static final String sqlquerypart20 = "call HoldProduction(?1,?2,?3,?4,?5)";

        @Query(value = sqlquerypart20, nativeQuery = true)
        public Map<ActiveObjectMap.Key, Value> HoldProduction(String lineID, int POrder, int HoldOrNot, String UserId,
                        String Reson);

        // check user username and password
        public static final String sqlquerypart21 = "call sp_CheckUser(?1,?2)";

        @Query(value = sqlquerypart21, nativeQuery = true)
        public Map<ActiveObjectMap.Key, Value> checkuser(String UserName, String Password1);

        // get pending productions
        public static final String sqlquerypart22 = "call sp_getChangedOrders()";

        @Query(value = sqlquerypart22, nativeQuery = true)
        public List<Map<ActiveObjectMap.Key, Value>> getpendings();

        // get pending production by id
        public static final String sqlquerypart23 = "call sp_getorderchangeById(?1)";

        @Query(value = sqlquerypart23, nativeQuery = true)
        public Map<ActiveObjectMap.Key, Value> getpendingsById(String processID);

        // check the production order
        public static final String sqlquerypart24 = "call sp_checkChangeOrder(?1, ?2, ?3, ?4)";

        @Query(value = sqlquerypart24, nativeQuery = true)
        public Map<ActiveObjectMap.Key, Value> checkChangeOrder(String processID1, String processOrder1,
                        String processIDchange2, String processOrderchange2);

        // get pending productions to second table

        public static final String sqlquerypart25 = "call sp_getChangedOrdersToSecondTable(?1)";

        @Query(value = sqlquerypart25, nativeQuery = true)
        public List<Map<ActiveObjectMap.Key, Value>> getChangedOrdersToSecondTable(String selectedProcessID);

        // get details to add actual weight
        public static final String sqlquerypart26 = "call sp_getActualWeight()";

        @Query(value = sqlquerypart26, nativeQuery = true)
        public List<Map<ActiveObjectMap.Key, Value>> getStoppedProductions();

        public static final String sqlquerypart27 = "call sp_RetriveAccualWeightByProcessID(?1)";

        @Query(value = sqlquerypart27, nativeQuery = true)
        public List<Map<ActiveObjectMap.Key, Value>> getacctualweigthtotable(String processID);

        // call sp to insert actual weight (get the roll numbers)

        public static final String sqlquerypart28 = "call sp_insertActualWeight(?1,?2)";

        @Query(value = sqlquerypart28, nativeQuery = true)
        public List<Map<ActiveObjectMap.Key, Value>> getrollnumbers(int ProductionOrder, String lineID);

        // update with actual weight
        public static final String sqlquerypart29 = "call sp_InsertAccWeightToTable(?1,?2,?3)";

        @Query(value = sqlquerypart29, nativeQuery = true)
        public List<Map<ActiveObjectMap.Key, Value>> updateActualWeight(String processID, int RollNumber,
                        float Weight_acc);

        public static final String sqlquerypart30 = "call sp_accual_weight_insert2(?1,?2,?3)";

        @Query(value = sqlquerypart30, nativeQuery = true)
        public List<Map<ActiveObjectMap.Key, Value>> getCompletedCountandDate(int ProductionOrder, String lineID,
                        int CompletedRollCount);

        // refresh devices when the data is not display in dashboard
        public static final String sqlquerypart31 = "call sp_Message_publish(?1)";

        @Query(value = sqlquerypart31, nativeQuery = true)
        public List<Map<ActiveObjectMap.Key, Value>> publishMassagesToDevices(String lineID);

        // get Get Customer Details By LineId
        public static final String sqlquerypart32 = "call sp_GetRollCount(?1 )";

        @Query(value = sqlquerypart32, nativeQuery = true)
        public Map<ActiveObjectMap.Key, Value> GetRollCount(String LineId);

        @Query("SELECT a FROM AdminEntity a WHERE a.job_id_ad = :jobId AND a.batchid_ad = :batchId")
        AdminEntity findByJobIdAndBatchId(@Param("jobId") String jobId, @Param("batchId") String batchId);

        // AdminEntity findByJob_id_adAndBatchid_ad(String job_id_ad, String batchid_ad);

        // get last bobbing and length
        public static final String sqlquerypart33 = "call sp_GetLastbobbinandLength(?1 )";

        @Query(value = sqlquerypart33, nativeQuery = true)
        public Map<ActiveObjectMap.Key, Value> GetLastBobbingandLength(int ProductionOrder);

        @Query("SELECT a FROM AdminEntity a WHERE (a.job_id_ad, a.production_end_datetime) IN " +
           "(SELECT a.job_id_ad, MAX(a.production_end_datetime) FROM AdminEntity a GROUP BY a.job_id_ad) order by a.production_end_datetime desc")
        List<AdminEntity> findLatestJobsByJobIdAndProductionEndDatetime();

        @Query("SELECT a FROM AdminEntity a WHERE (a.job_id_ad, a.production_order) IN " +
           "(SELECT a.job_id_ad, MAX(a.production_order) FROM AdminEntity a GROUP BY a.job_id_ad) order by a.production_order desc")
        List<AdminEntity> findLatestJobsByProductionOrder();
}
