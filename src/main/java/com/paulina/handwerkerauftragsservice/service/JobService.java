package com.paulina.handwerkerauftragsservice.service;

import com.paulina.handwerkerauftragsservice.model.entity.Employee;
import com.paulina.handwerkerauftragsservice.model.entity.Job;
import com.paulina.handwerkerauftragsservice.model.enums.JobStatus;

import java.util.List;

public interface JobService {
    Job createJob(Job job);
    Job getJobById(String id);
    Job updateJob(String id, Job job);
    void deleteJob(String id);
    List<Job> getAllJobs();
    Job updateJobStatus(String id, JobStatus status);
    Job assignEmployee(String jobId, String employeeId);
}
