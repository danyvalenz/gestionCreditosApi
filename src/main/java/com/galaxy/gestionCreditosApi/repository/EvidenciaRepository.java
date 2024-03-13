package com.galaxy.gestionCreditosApi.repository;

import com.galaxy.gestionCreditosApi.model.Evidencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvidenciaRepository extends JpaRepository<Evidencia,Long> {
}
