package com.galaxy.gestionCreditosApi.controller;

import com.galaxy.gestionCreditosApi.service.Impl.ClienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.galaxy.gestionCreditosApi.model.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ClientesController {

    @Autowired
    private ClienteServiceImpl clienteService;
    @GetMapping("/clientes")
    public List<Cliente> getAllClients()
    {
        return clienteService.getAllClients();
    }

    @GetMapping("/buscar/id/{id}")
    public Cliente findById(@PathVariable("id") Long idCliente){
        return clienteService.findById(idCliente);
    }
}
