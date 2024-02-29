package com.example.Lalan.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.Lalan.Entity.WastageEntity;
import com.sun.corba.se.impl.oa.poa.ActiveObjectMap;
import org.hibernate.mapping.Value;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.QueryLookupStrategy;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


public interface WastageRepo extends JpaRepository<WastageEntity, Integer>  {
        // calculate wastage in the line
        public static final String sqlquerypart33 = "call sp_GetSumOfProductWastageStored(?1)";

        @Query(value = sqlquerypart33, nativeQuery = true)
        public Map<ActiveObjectMap.Key, Value> getProductionWastage(Integer admin_id);

        // calculate wastage in the line
        public static final String sqlquerypart2 = "call sp_wastageOrNot(?1, ?2, ?3, ?4)";

        @Query(value = sqlquerypart2, nativeQuery = true)
        public List<Map<ActiveObjectMap.Key, Value>> getWastageOrNot(Integer admin_id, Integer hisID, Integer oparation, Integer sysLength);

        WastageEntity findByIotInputHisId(Integer iotInputHisId);

        @Modifying
        @Query("UPDATE WastageEntity w SET w.waste_reason = :waste_reason WHERE w.iotInputHisId = :iot_input_his_id")
        void saveWasteReasonById(@Param("iot_input_his_id") Integer iot_input_his_id, @Param("waste_reason") String waste_reason);
}
