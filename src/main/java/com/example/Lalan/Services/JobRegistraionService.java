package com.example.Lalan.Services;

import com.example.Lalan.DTO.AdminDTO;
import com.example.Lalan.DTO.JobRegistrationDTO;
import com.example.Lalan.Entity.AdminEntity;
import com.example.Lalan.Entity.JobRegistrationEntity;
import com.example.Lalan.Entity.ParameterDeviceMachineEntity;
import com.example.Lalan.Repos.AdminRepo;
import com.example.Lalan.Repos.JobRegistrationRepo;
import com.example.Lalan.Util.VarList;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class JobRegistraionService {

    @Autowired
    private JobRegistrationRepo jobRegistrationRepo;

    @Autowired
    private AdminRepo adminRepo;

    @Autowired
    private ModelMapper modelMapper;

    // ----------------------------------------------------------------------------------------------
    // Save job Details
    public String saveJob(JobRegistrationDTO jobRegistrationDTO) {
        if (jobRegistrationRepo.existsById(jobRegistrationDTO.getJobId())) {
            return VarList.RSP_DUPLICATED;
        } else {
            jobRegistrationRepo.save(modelMapper.map(jobRegistrationDTO, JobRegistrationEntity.class));
            return VarList.RSP_SUCCESS;
        }
    }

    // ----------------------------------------------------------------------------------------------------
    // update job details...
    public String updateRegisteredJob(JobRegistrationDTO jobRegistrationDTO) {
        if (jobRegistrationRepo.existsById(jobRegistrationDTO.getJobId())) {
            jobRegistrationRepo.save(modelMapper.map(jobRegistrationDTO, JobRegistrationEntity.class));
            return VarList.RSP_SUCCESS;

        } else {
            return VarList.RSP_NO_DATA_FOUND;
        }
    }

    // ----------------------------------------------------------------------------------------------------
    // Display registered job details...
    public List<JobRegistrationDTO> getAllJobs() {
        Sort sortByJobIdAsc = Sort.by(Sort.Direction.ASC, "jobId");

        List<JobRegistrationEntity> jobList = jobRegistrationRepo.findAll(sortByJobIdAsc);

        return modelMapper.map(jobList, new TypeToken<ArrayList<JobRegistrationDTO>>() {
        }.getType());
    }

    public List<AdminDTO> getAllJobsForReports() {
        List<AdminEntity> jobList = adminRepo.findLatestJobsByJobIdAndProductionEndDatetime();

        return modelMapper.map(jobList, new TypeToken<ArrayList<AdminDTO>>() {
        }.getType());
    }

    public List<AdminDTO> getAllJobsByProductionOrder() {
        List<AdminEntity> jobList = adminRepo.findLatestJobsByProductionOrder();

        return modelMapper.map(jobList, new TypeToken<ArrayList<AdminDTO>>() {
        }.getType());
    }


    // -----------------------------------------------------------------------------------------------------
    // Search job details using jobId...
    public JobRegistrationDTO searchRegisteredJob(String jobId) {
        if (jobRegistrationRepo.existsById(jobId)) {
            JobRegistrationEntity jobRegistrationEntity = jobRegistrationRepo.findById(jobId).orElse(null);
            return modelMapper.map(jobRegistrationEntity, JobRegistrationDTO.class);
        } else {
            return null;
        }
    }

    // --------------------------------------------------------------------------------------------------
    // Delete registered job...
    public String deleteRegisteredJob(String jobId) {
        if (jobRegistrationRepo.existsById(jobId)) {
            jobRegistrationRepo.deleteById(jobId);
            return VarList.RSP_SUCCESS;
        } else {
            return VarList.RSP_NO_DATA_FOUND;
        }
    }

    // public List <JobRegistrationEntity> getallid(String job_id){
    // return jobRegistrationRepo.getalljobids(job_id);
    // }
}
