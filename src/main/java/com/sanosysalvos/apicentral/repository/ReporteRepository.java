package com.sanosysalvos.apicentral.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sanosysalvos.apicentral.model.ReporteModel;;

@Repository
public interface ReporteRepository extends JpaRepository<ReporteModel, Long>{

    List<ReporteModel> findByTipoReporte(String tipoReporte);

    List<ReporteModel> findByComuna(String comuna);

    /*para cuando la api de mascotas se conecte a este
    List<ReporteModel> findByMascotaId(Long mascotaId); */
}
