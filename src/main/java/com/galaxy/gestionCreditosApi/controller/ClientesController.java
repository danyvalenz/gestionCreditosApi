package com.galaxy.gestionCreditosApi.controller;

import com.galaxy.gestionCreditosApi.service.Impl.ClienteServiceImpl;
import com.galaxy.gestionCreditosApi.service.Impl.EvidenciaServiceImpl;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.galaxy.gestionCreditosApi.model.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class ClientesController {

    @Autowired
    private ClienteServiceImpl clienteService;

    @Autowired
    private EvidenciaServiceImpl evidenciaService;
    @GetMapping("/clientes")
    public List<Cliente> getAllClients()
    {
        return clienteService.getAllClients();
    }

    @GetMapping("/buscar/id/{id}")
    public Cliente findById(@PathVariable("id") UUID idCliente){
        return clienteService.findById(idCliente);
    }

    @GetMapping("/cliente/evidencia/por/id/{idCliente}")
    public void getEvidencia(HttpServletResponse response,@PathVariable("idCliente") Long idCliente) throws IOException {
        String b64 = evidenciaService.evidenciaPorId(idCliente);
        byte[] decoder = Base64.getDecoder().decode(b64);



        String mimeType = "application/pdf";

        response.setContentType(mimeType);
        response.setHeader("Content-Disposition", String.format("inline; filename=\"%s\"", "reporte.pdf"));
        response.setContentLength(decoder.length);
        //response.setContentLength(encoded.length);

        ByteArrayInputStream inStream = new ByteArrayInputStream( decoder);
        //ByteArrayInputStream inStream = new ByteArrayInputStream( encoded);

        FileCopyUtils.copy(inStream, response.getOutputStream());
    }
}
