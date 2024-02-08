package com.example.Lalan.Controller;

import com.example.Lalan.DTO.ReportDTO;
import com.example.Lalan.DTO.ResponseDTO;
import com.example.Lalan.Services.ReportService;
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

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @Autowired
    private ResponseDTO responseDTO;

    @GetMapping("/GetProductionHoursMonthly")
    public List<Map<ActiveObjectMap.Key, Value>> GetProductionHoursMonthly() {

        return reportService.GetProductionHoursMonthly();
    }

    @GetMapping("/GetProductionHoursOtherwise")
    public List<Map<ActiveObjectMap.Key, Value>> GetProductionHoursOtherwise() {

        return reportService.GetProductionHoursOtherwise();
    }

    @GetMapping("/GetProductionLenthInfo")
    public List<Map<ActiveObjectMap.Key, Value>> GetProductionLenthInfo() {

        return reportService.GetProductionLenthInfo();
    }

    @GetMapping("/GetProductionInfo")
    public List<Map<ActiveObjectMap.Key, Value>> GetProductionInfo() {

        return reportService.GetProductionInfo();
    }

    // Get all Productions
    @GetMapping("/GetDailyProduction")
    public List<Map<ActiveObjectMap.Key, Value>> GetDailyProduction() {

        return reportService.GetDailyProduction();
    }

    @GetMapping("/GetWastage")
    public List<Map<ActiveObjectMap.Key, Value>> GetWastage() {

        return reportService.GetWastage();
    }

    @GetMapping("/GetUpToDateProduction")
    public List<Map<ActiveObjectMap.Key, Value>> GetUpToDateProduction() {

        return reportService.GetUpToDateProduction();
    }

    @GetMapping("/GetAllProduct")
    public List<Map<ActiveObjectMap.Key, Value>> GetAllProduct() {

        return reportService.GetAllProduct();
    }

    @GetMapping("/GetAllLine")
    public List<Map<ActiveObjectMap.Key, Value>> GetAllLine() {

        return reportService.GetAllLine();
    }

    @GetMapping("/GetAllAbnomalParameter/{JobSelect}/{selectBatch}")
    public List<Map<ActiveObjectMap.Key, Value>> GetAllAbnomalParameter( @PathVariable String JobSelect, @PathVariable String selectBatch) {

        return reportService.GetAllAbnomalParameter(JobSelect, selectBatch);
    }

    @GetMapping("/GetMachineStatus")
    public List<Map<ActiveObjectMap.Key, Value>> GetMachineStatus() {

        return reportService.GetMachineStatus();
    }

    @GetMapping("/GetOrderInHand")
    public List<Map<ActiveObjectMap.Key, Value>> GetOrderInHand() {

        return reportService.GetOrderInHand();
    }

    @GetMapping("/GetOrderInHand2")
    public List<Map<ActiveObjectMap.Key, Value>> GetOrderInHand2() {

        return reportService.GetOrderInHand2();
    }

    @GetMapping("/GetOrderInHand3")
    public List<Map<ActiveObjectMap.Key, Value>> GetOrderInHand3() {

        return reportService.GetOrderInHand3();
    }
}
