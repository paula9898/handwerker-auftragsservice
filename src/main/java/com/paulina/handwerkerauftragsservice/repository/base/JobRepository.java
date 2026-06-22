package com.paulina.handwerkerauftragsservice.repository.base;

import com.paulina.handwerkerauftragsservice.model.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, String> {
}
