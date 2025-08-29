package com.kronosapinosql.repository;

import com.kronosapinosql.model.Report;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReportRepository extends MongoRepository<Report, String> {
}
