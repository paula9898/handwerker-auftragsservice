package com.paulina.handwerkerauftragsservice.service;

import com.paulina.handwerkerauftragsservice.exception.CustomerNotFoundException;
import com.paulina.handwerkerauftragsservice.exception.EmployeeNotFoundException;
import com.paulina.handwerkerauftragsservice.exception.JobNotFoundException;
import com.paulina.handwerkerauftragsservice.model.entity.Customer;
import com.paulina.handwerkerauftragsservice.model.entity.Employee;
import com.paulina.handwerkerauftragsservice.model.entity.Job;
import com.paulina.handwerkerauftragsservice.repository.base.CustomerRepository;
import com.paulina.handwerkerauftragsservice.repository.base.EmployeeRepository;
import com.paulina.handwerkerauftragsservice.repository.base.JobRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class JobServiceImpl implements JobService {
    private final JobRepository jobRepository;
    private final CustomerRepository customerRepository;
    private final EmployeeRepository employeeRepository;


    public JobServiceImpl(JobRepository jobRepository, CustomerRepository customerRepository, EmployeeRepository employeeRepository) {
        this.jobRepository = jobRepository;
        this.customerRepository = customerRepository;
        this.employeeRepository = employeeRepository;
    }


    @Override
    public Job createJob(Job job) {
        if(job.getId() == null) {
            job.setId(UUID.randomUUID().toString());
        }

        String customerId = job.getCustomer().getId();
        String employeeId = job.getEmployee().getId();

        Customer customer = customerRepository.findById(customerId).orElseThrow(() ->
                new CustomerNotFoundException("Customer with id "+ customerId + "was not found"));

        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() ->
                new EmployeeNotFoundException("Employee with id "+ employeeId + "was not found"));

        job.setCustomer(customer);
        job.setEmployee(employee);


        return jobRepository.save(job);
    }

    @Override
    public Job getJobById(String id) {
        return jobRepository.findById(id).orElseThrow(() -> new JobNotFoundException(
                "The job with id" + id + "was not found"
        ));
    }

    @Override
    public Job updateJob(String id, Job job) {
        Job foundJob = jobRepository.findById(id).orElseThrow(
                () -> new JobNotFoundException("Job with: " + id + "not found")
        );

        foundJob.setTitle(job.getTitle());
        foundJob.setDescription(job.getDescription());
        foundJob.setStatus(job.getStatus());
        foundJob.setCustomer(job.getCustomer());
        foundJob.setEmployee(job.getEmployee());

        return jobRepository.save(foundJob);
    }

    @Override
    public void deleteJob(String id) {
        Job jobToDelete = jobRepository.findById(id) .orElseThrow(() ->
                new JobNotFoundException("Job  with " + id + "was not found"));

        jobRepository.delete(jobToDelete);

    }

    @Override
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }
}
