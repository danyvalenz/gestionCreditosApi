package com.galaxy.gestionCreditosApi.controller;

import com.galaxy.gestionCreditosApi.model.Evidencia;
import com.galaxy.gestionCreditosApi.service.Impl.EvidenciaServiceImpl;
import org.hibernate.annotations.NaturalId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;

@RestController
@RequestMapping("/api/evidencia")
public class EvidenciaController {

    @Autowired
    private EvidenciaServiceImpl evidenciaService;

    @Value("${custom-path}")
    private String ruta;
    @PostMapping("/registrar/evidencia")
    public Evidencia saveEvidencia(@RequestParam MultipartFile archivoEvidencia, @RequestParam String tipoArchivo,@RequestParam Long id) throws Exception{
        String fileName = this.ruta+"/"+archivoEvidencia.getOriginalFilename();

        InputStream inputStream = archivoEvidencia.getInputStream();
        File targetFile = new File(fileName);
        OutputStream outputStream = new FileOutputStream(targetFile);

        int read;

        byte[] bytes = new byte[1024];

        while ((read = inputStream.read(bytes)) != -1) {
            outputStream.write(bytes, 0, read);
        }

        outputStream.close();

        // convierte de file a base 64
        byte[] input_file = Files.readAllBytes(Paths.get(fileName));
        String archivo = Base64.getEncoder().encodeToString(input_file);

        Evidencia evidencia = new Evidencia();
        evidencia.setArchivoEvidencia(archivo);
        evidencia.setIdEvidencia(id);
        evidencia.setTipoArchivo(tipoArchivo);
        return evidenciaService.saveEvidencia(evidencia);

    }

    @GetMapping("/getAll")
    public List<Evidencia> getAllEvidencias(){
        return evidenciaService.getAllEvidenciass();
    }
}
