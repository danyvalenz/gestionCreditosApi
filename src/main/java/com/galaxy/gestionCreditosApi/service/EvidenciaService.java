package com.galaxy.gestionCreditosApi.service;

import com.galaxy.gestionCreditosApi.model.Evidencia;

import java.util.List;

public interface EvidenciaService {

    public Evidencia saveEvidencia(Evidencia evidencia);

    List<Evidencia> getAllEvidenciass();
}
