package com.paulina.handwerkerauftragsservice.controller;

import com.paulina.handwerkerauftragsservice.model.entity.Employee;
import com.paulina.handwerkerauftragsservice.model.entity.Job;
import com.paulina.handwerkerauftragsservice.model.enums.JobStatus;
import com.paulina.handwerkerauftragsservice.service.EmployeeService;
import com.paulina.handwerkerauftragsservice.service.JobService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/jobs")

public class JobController {
    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public List<Job> getJobs() {
        return jobService.getAllJobs();
    }

    @PostMapping
    public Job addJob(@RequestBody Job job) {
        return jobService.createJob(job);
    }

    @GetMapping("/{id}")
    public Job getJob(@PathVariable String id) {
        return jobService.getJobById(id);
    }

    @PutMapping("/{id}")
    public Job updateJob(@PathVariable String id, @RequestBody Job job) {
        return jobService.updateJob(id,job);
    }

    @DeleteMapping("/{id}")
    public String deleteJob(@PathVariable String id) {
        jobService.deleteJob(id);

        return "Deleted job with id - " + id;
    }

    @PatchMapping("/{id}/status")
    public Job changeJobStatus(@PathVariable String id, @RequestParam JobStatus status) {
        return jobService.updateJobStatus(id,status);
    }

    @PatchMapping("/{id}/employee/{employeeId}")
    public Job assignEmployee(@PathVariable String id, @PathVariable String employeeId) {
        return jobService.assignEmployee(id,employeeId);
    }


}
