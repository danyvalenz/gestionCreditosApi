package com.galaxy.gestionCreditosApi.service.Impl;

import com.galaxy.gestionCreditosApi.model.Evidencia;
import com.galaxy.gestionCreditosApi.repository.EvidenciaRepository;
import com.galaxy.gestionCreditosApi.service.EvidenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.galaxy.gestionCreditosApi.model.Credito;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

@Service
public class EvidenciaServiceImpl implements EvidenciaService {

    @Autowired
    EvidenciaRepository evidenciaRepository;
    @Value("${custom-path}")
    private String ruta;
    @Override
    public Evidencia saveEvidencia(Evidencia evidencia) {
        return evidenciaRepository.save(evidencia);
    }

    @Override
    public List<Evidencia> getAllEvidenciass() {
        return evidenciaRepository.findAll();
    }

    @Override
    public String evidenciaPorId(Long idCliente) {
        String base64 = "";
        Optional<Evidencia> obtenerEvidencia = evidenciaRepository.findById(idCliente);
        if(obtenerEvidencia.isPresent()){
            base64 = obtenerEvidencia.get().getArchivoEvidencia();
            //base64 = obtenerEvidencia.get().getFotoSolicitante();
        }

        return base64;
    }

    @Override
    public String evidenciaPorIdEvidencia(Long idEvidencia) {

        
        return null;
    }

    @Override
    public Evidencia guardarEvidencia(MultipartFile archivoEvidencia, MultipartFile fotoSolicitante, MultipartFile videoResumenSolicitante, Long idCliente, Long idCredito) throws IOException {
        String fileName = this.ruta+"/"+archivoEvidencia.getOriginalFilename();
        List<String> archivosName = new ArrayList<>();
        archivosName.add(this.ruta+archivoEvidencia.getOriginalFilename());
        archivosName.add(this.ruta+fotoSolicitante.getOriginalFilename());
        archivosName.add(this.ruta+videoResumenSolicitante.getOriginalFilename());
        for (String rutacompleta :
                archivosName) {

            InputStream inputStream = archivoEvidencia.getInputStream();
            File targetFile = new File(rutacompleta);
            OutputStream outputStream = new FileOutputStream(targetFile);

            int read;

            byte[] bytes = new byte[1024];

            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }

            outputStream.close();

        }


        // convierte de file a base 64 el PDF
        byte[] input_file = Files.readAllBytes(Paths.get(archivosName.get(0).toString()));
        String archivoEvidenciaPDF = Base64.getEncoder().encodeToString(input_file);

        // convierte de file a base 64 la Imagen
        input_file = Files.readAllBytes(Paths.get(archivosName.get(1).toString()));
        String fotoDelSolicitante = Base64.getEncoder().encodeToString(input_file);

        // convierte de file a base 64 Vidoe
        input_file = Files.readAllBytes(Paths.get(archivosName.get(2).toString()));
        String videoDelSolicitante = Base64.getEncoder().encodeToString(input_file);



        Long ramdonui = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
        Evidencia evidencia = new Evidencia();
        Credito credito = new Credito();
        credito.setIdCredito(idCredito);
        evidencia.setArchivoEvidencia(archivoEvidenciaPDF);
        evidencia.setFotoSolicitante(fotoDelSolicitante);
        evidencia.setVideoResumenSolicitante(videoDelSolicitante);
        evidencia.setCredito(credito);
        evidencia.setIdEvidencia(ramdonui);

        return evidenciaRepository.save(evidencia);
    }


}
