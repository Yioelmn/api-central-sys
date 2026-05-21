package com.sanosysalvos.apicentral.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "reportes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReporteModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El titulo del reporte es obligatorio")
    private String tituloReporte;

    @NotBlank(message = "La descripcion del reporte es obligatoria")
    private String descripcionReporte;

    @NotBlank(message = "El tipo del reporte es obligatorio")
    private String tipoReporte;

    @NotBlank(message = "La fecha del reporte es obligatoria")
    private String fechaReporte;

    @NotBlank(message = "la comuna es obligatoria")
    private String comunaReporte;

    @NotNull(message = "latitud es obligatoria")
    private Double latitudReporte;

    @NotNull(message = "longitud es obligatorio")
    private Double longitudReporte;

}
