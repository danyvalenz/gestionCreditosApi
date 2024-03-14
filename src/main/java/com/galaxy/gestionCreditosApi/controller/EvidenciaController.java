package com.galaxy.gestionCreditosApi.controller;

import com.galaxy.gestionCreditosApi.model.Evidencia;
import com.galaxy.gestionCreditosApi.service.Impl.EvidenciaServiceImpl;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.annotations.NaturalId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/evidencia")
public class EvidenciaController {

    @Autowired
    private EvidenciaServiceImpl evidenciaService;

    @Value("${custom-path}")
    private String ruta;
    @PostMapping("/registrar/evidencia")
    public Evidencia saveEvidencia(@RequestParam MultipartFile archivoEvidencia,@RequestParam MultipartFile fotoSolicitante,@RequestParam MultipartFile videoResumenSolicitante, @RequestParam Long idCliente,@RequestParam Long idCredito ) throws Exception{

        return evidenciaService.guardarEvidencia(archivoEvidencia,fotoSolicitante,videoResumenSolicitante,idCliente,idCredito);

    }

    @GetMapping("/getAll")
    public List<Evidencia> getAllEvidencias(){
        return evidenciaService.getAllEvidenciass();
    }


}
