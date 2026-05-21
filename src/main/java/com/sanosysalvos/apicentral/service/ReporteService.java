package com.sanosysalvos.apicentral.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sanosysalvos.apicentral.model.ReporteModel;
import com.sanosysalvos.apicentral.repository.ReporteRepository;

@Service
public class ReporteService {

    @Autowired
    private ReporteRepository reporteRepository;

    public ReporteModel crearReporte(ReporteModel reporte) {
        return reporteRepository.save(reporte);

    }

    public List<ReporteModel> obtenerReportes(){
        return reporteRepository.findAll();
    }

    public Optional<ReporteModel> obtenerReportePorId(Long id){
        return reporteRepository.findById(id);
    }

    public List<ReporteModel> obtenerReportePorTipo(String tipoReporte){
        return reporteRepository.findByTipoReporte(tipoReporte);
    }

    public List<ReporteModel> obtenerReportePorComuna(String comunaReporte){
        return reporteRepository.findByComuna(comunaReporte);
    }

    public boolean eliminarReporte(Long id){
        if(reporteRepository.existsById(id)){
            reporteRepository.deleteById(id);
            return true;
        }
        return false;
    }

        
}
