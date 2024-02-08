package com.example.Lalan.Repos;

import com.example.Lalan.Entity.DeviceEntity;

import java.util.List;
import java.util.Map;
import org.hibernate.mapping.Value;
import com.sun.corba.se.impl.oa.poa.ActiveObjectMap;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DeviceRepo extends JpaRepository<DeviceEntity, String> {


     
        //post ND UPDATE device data
        public static final String sqlquerypartdevice = "call sp_DeviceRegistration(?1,?2,?3,?4,?5,?6,?7,?8,?9,?10,?11,?12,?13,?14,?15,?16,?17)";

        @Query(value = sqlquerypartdevice, nativeQuery = true)
        public Map<ActiveObjectMap.Key, Value> postdeviceregistration(String lineId, String machineId, String machineName, String machineDescription, String deviceId, 
                                                                       String parameterId, String des, int isitalarmPara,int isitstarterValue,  int minVal, int maxVal, 
                                                                        String mesuringUnit,String massage, String deviceLocation, String deviceIpAddress, String deviceName, int crudOperation);

    
}
