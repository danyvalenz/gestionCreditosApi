package com.galaxy.gestionCreditosApi.service.Impl;

import com.galaxy.gestionCreditosApi.model.Evidencia;
import com.galaxy.gestionCreditosApi.repository.EvidenciaRepository;
import com.galaxy.gestionCreditosApi.service.EvidenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvidenciaServiceImpl implements EvidenciaService {

    @Autowired
    EvidenciaRepository evidenciaRepository;
    @Override
    public Evidencia saveEvidencia(Evidencia evidencia) {
        return evidenciaRepository.save(evidencia);
    }

    @Override
    public List<Evidencia> getAllEvidenciass() {
        return evidenciaRepository.findAll();
    }


}
