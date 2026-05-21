package com.sanosysalvos.apicentral.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sanosysalvos.apicentral.model.ReporteModel;
import com.sanosysalvos.apicentral.service.ReporteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/reportes")
@CrossOrigin(origins = "*") // ideal añadir esto a gestion  de mascotas para evitar los problemas de CORS
public class ReporteController {
    
    @Autowired
    private ReporteService reporteService;

    @PostMapping
    @Operation(summary = "Crear un reporte para saber el estado de una mascota")
    public ResponseEntity<ReporteModel> crearReporte(@Valid @RequestBody ReporteModel reporte){
        ReporteModel nuevoReporte = reporteService.crearReporte(reporte);
        return new ResponseEntity<>(nuevoReporte, HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(summary = "Listar todos los reportes")
    public ResponseEntity<List<ReporteModel>> listarTodos(){
        List<ReporteModel> reportes = reporteService.obtenerReportes();
        return ResponseEntity.ok(reportes);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener los detalles de un reporte por su id")
    public ResponseEntity<ReporteModel> buscarReportePorId(@PathVariable Long id){
        return reporteService.obtenerReportePorId(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/filtrar/tipo/{tipoReporte}")
    @Operation(summary = "Filtrar reportes por tipo")
    public ResponseEntity<List<ReporteModel>> filtrarReportePorTipo(@PathVariable String tipoReporte){
        List<ReporteModel> reportes = reporteService.obtenerReportePorTipo(tipoReporte);
        return ResponseEntity.ok(reportes);
    }

    @GetMapping("/filtrar/comuna/{comunaReporte}")
    @Operation(summary = "Filtrar reportes por comuna")
    public ResponseEntity<List<ReporteModel>> filtrarReportePorComuna(@PathVariable String comunaReporte){
        List<ReporteModel> reportes = reporteService.obtenerReportePorComuna(comunaReporte);
        return ResponseEntity.ok(reportes);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un reporte por su id")
    public ResponseEntity<Void> eliminarReporte(@PathVariable Long id){
        if (reporteService.eliminarReporte(id)){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
