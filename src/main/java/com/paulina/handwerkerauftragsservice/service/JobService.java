package com.paulina.handwerkerauftragsservice.service;

import com.paulina.handwerkerauftragsservice.model.entity.Employee;
import com.paulina.handwerkerauftragsservice.model.entity.Job;

import java.util.List;

public interface JobService {
    Job createJob(Job job);
    Job getJobById(String id);
    Job updateJob(String id, Job job);
    void deleteJob(String id);
    List<Job> getAllJobs();
}
