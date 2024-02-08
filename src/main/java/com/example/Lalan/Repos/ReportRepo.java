package com.example.Lalan.Repos;

import com.example.Lalan.Entity.ReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.sun.corba.se.impl.oa.poa.ActiveObjectMap;
import org.hibernate.mapping.Value;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface ReportRepo extends JpaRepository<ReportEntity, Integer> {

    public static final String sqlquerypart1 = "call GRA_Production_Hours_Monthly()";

    @Query(value = sqlquerypart1, nativeQuery = true)
    public List<Map<ActiveObjectMap.Key, Value>> GetProductionHoursMonthly();

    public static final String sqlquerypart2 = "call GRA_Production_Hours_orderwise()";

    @Query(value = sqlquerypart2, nativeQuery = true)
    public List<Map<ActiveObjectMap.Key, Value>> GetProductionHoursOtherwise();

    public static final String sqlquerypart3 = "call GRA_Production_Lenth_Info()";

    @Query(value = sqlquerypart3, nativeQuery = true)
    public List<Map<ActiveObjectMap.Key, Value>> GetProductionLenthInfo();

    public static final String sqlquerypart4 = "call GRA_Production_Info()";

    @Query(value = sqlquerypart4, nativeQuery = true)
    public List<Map<ActiveObjectMap.Key, Value>> GetProductionInfo();

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static final String sqlquerypart5 = "call GPA_Production_Report()";

    @Query(value = sqlquerypart5, nativeQuery = true)
    public List<Map<ActiveObjectMap.Key, Value>> GetDailyProduction();

    public static final String sqlquerypart6 = "call GPA_Wastage_Report()";

    @Query(value = sqlquerypart6, nativeQuery = true)
    public List<Map<ActiveObjectMap.Key, Value>> GetWastage();

    public static final String sqlquerypart7 = "call GPA_Up_To_Date_Production()";

    @Query(value = sqlquerypart7, nativeQuery = true)
    public List<Map<ActiveObjectMap.Key, Value>> GetUpToDateProduction();

    public static final String sqlquerypart8 = "call GPA_Product_Report()";

    @Query(value = sqlquerypart8, nativeQuery = true)
    public List<Map<ActiveObjectMap.Key, Value>> GetAllProduct();

    public static final String sqlquerypart9 = "call GPA_Line_Report()";

    @Query(value = sqlquerypart9, nativeQuery = true)
    public List<Map<ActiveObjectMap.Key, Value>> GetAllLine();

    public static final String sqlquerypart10 = "call GPA_Parameter_Report(?1 , ?2)";

    @Query(value = sqlquerypart10, nativeQuery = true)
    public List<Map<ActiveObjectMap.Key, Value>> GetAllAbnomalParameter(String JobSelect, String selectBatch);

    public static final String sqlquerypart11 = "call GPA_Machine_Status()";

    @Query(value = sqlquerypart11, nativeQuery = true)
    public List<Map<ActiveObjectMap.Key, Value>> GetMachineStatus();

    public static final String sqlquerypart12 = "call GPA_Order_In_Hand()";

    @Query(value = sqlquerypart12, nativeQuery = true)
    public List<Map<ActiveObjectMap.Key, Value>> GetOrderInHand();

    public static final String sqlquerypart13 = "call GPA_Order_In_Hand_Report2()";

    @Query(value = sqlquerypart13, nativeQuery = true)
    public List<Map<ActiveObjectMap.Key, Value>> GetOrderInHand2();

    public static final String sqlquerypart14 = "call GPA_Order_In_Hand_Report3()";

    @Query(value = sqlquerypart14, nativeQuery = true)
    public List<Map<ActiveObjectMap.Key, Value>> GetOrderInHand3();
}
