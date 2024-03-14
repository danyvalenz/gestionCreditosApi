package com.galaxy.gestionCreditosApi.service;

import com.galaxy.gestionCreditosApi.model.Evidencia;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

public interface EvidenciaService {

    public Evidencia saveEvidencia(Evidencia evidencia);

    List<Evidencia> getAllEvidenciass();

    String evidenciaPorId(Long idCliente);
    String evidenciaPorIdEvidencia(Long idEvidencia);
    // public Evidencia saveEvidencia(@RequestParam MultipartFile archivoEvidencia,@RequestParam MultipartFile fotoSolicitante,@RequestParam MultipartFile videoResumenSolicitante, @RequestParam Long idCliente,@RequestParam Long idCredito ) throws Exception{
    Evidencia guardarEvidencia(MultipartFile archivoEvidencia,MultipartFile fotoSolicitante,MultipartFile videoResumenSolicitante,Long idCliente,Long idCredito) throws IOException;




}
