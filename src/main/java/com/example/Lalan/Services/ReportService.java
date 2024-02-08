package com.example.Lalan.Services;

import com.example.Lalan.DTO.ReportDTO;
import com.example.Lalan.Repos.ReportRepo;
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
public class ReportService {
    @Autowired
    private ReportRepo reportRepo;

    @Autowired
    private ModelMapper modelMapper;

    public List<Map<ActiveObjectMap.Key, Value>> GetProductionHoursMonthly() {

        return reportRepo.GetProductionHoursMonthly();
    }

    public List<Map<ActiveObjectMap.Key, Value>> GetProductionHoursOtherwise() {

        return reportRepo.GetProductionHoursOtherwise();
    }

    public List<Map<ActiveObjectMap.Key, Value>> GetProductionLenthInfo() {

        return reportRepo.GetProductionLenthInfo();
    }

    public List<Map<ActiveObjectMap.Key, Value>> GetProductionInfo() {

        return reportRepo.GetProductionInfo();
    }

    public List<Map<ActiveObjectMap.Key, Value>> GetDailyProduction() {

        return reportRepo.GetDailyProduction();
    }

    public List<Map<ActiveObjectMap.Key, Value>> GetWastage() {

        return reportRepo.GetWastage();
    }

    public List<Map<ActiveObjectMap.Key, Value>> GetUpToDateProduction() {

        return reportRepo.GetUpToDateProduction();
    }

    public List<Map<ActiveObjectMap.Key, Value>> GetAllProduct() {

        return reportRepo.GetAllProduct();
    }

    public List<Map<ActiveObjectMap.Key, Value>> GetAllLine() {

        return reportRepo.GetAllLine();
    }

    public List<Map<ActiveObjectMap.Key, Value>> GetAllAbnomalParameter(String JobSelect, String selectBatch) {

        return reportRepo.GetAllAbnomalParameter(JobSelect, selectBatch);
    }

    public List<Map<ActiveObjectMap.Key, Value>> GetMachineStatus() {

        return reportRepo.GetMachineStatus();
    }

    public List<Map<ActiveObjectMap.Key, Value>> GetOrderInHand() {

        return reportRepo.GetOrderInHand();
    }

    public List<Map<ActiveObjectMap.Key, Value>> GetOrderInHand2() {

        return reportRepo.GetOrderInHand2();
    }

    public List<Map<ActiveObjectMap.Key, Value>> GetOrderInHand3() {

        return reportRepo.GetOrderInHand3();
    }
}
