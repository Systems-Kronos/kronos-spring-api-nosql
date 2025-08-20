package com.kronosapinosql.service;

import com.kronosapinosql.model.Report;
import com.kronosapinosql.repository.ReportRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReportService {
    private final ReportRepository reportRepository;

    public ReportService(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    public List<Report> listarTodosReports() {
        return reportRepository.findAll();
    }

    public Optional<Report> buscarPorId(String id) {
        return reportRepository.findById(id);
    }

    public Report salvar(Report report) {
        return reportRepository.save(report);
    }
    public Report atualizar(String id, Report novoReport) {
        return reportRepository.findById(id)
                .map(report -> {
                    report.setTarefa(novoReport.getTarefa());
                    report.setProblema(novoReport.getProblema());
                    report.setDescricao(novoReport.getDescricao());
                    return reportRepository.save(report);
                })
                .orElseThrow(() -> new RuntimeException("Report não encontrada!"));
    }

    public void deletar(String id) {
        reportRepository.deleteById(id);
    }
}
