package com.sanosysalvos.apicentral.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ReporteCreateDTO {
    
    // aquí no va id, ya que la gracia del dto es dejar este valor fuera para mayor seguridad
    @NotBlank(message = "El titulo del reporte es obligatorio")
    private String tituloReporte;

    @NotBlank(message = "La descripcion del reporte es obligatoria")
    private String descripcionReporte;

    @NotBlank(message = "tipo de reporte debe ser obligatorio")
    private String tipoReporte;

    @NotBlank(message = "la fecha del reporte es obligatoria")
    private String fechaReporte;

    @NotBlank(message = "la comuna es obligatoria")
    private String comunaReporte;

    @NotNull(message = "latitud es obligatoria")
    private Double latitudReporte;

    @NotNull(message = "longitud es obligatorio")
    private Double longitudReporte;
}
