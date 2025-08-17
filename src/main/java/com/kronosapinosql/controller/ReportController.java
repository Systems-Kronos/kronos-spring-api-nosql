package com.kronosapinosql.controller;

import com.kronosapinosql.repository.ReportRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/report")
@Tag(name = "Report", description = "Operações relacionadas ao Report")
public class ReportController {

    @Autowired
    private ReportRepository repository;


}
