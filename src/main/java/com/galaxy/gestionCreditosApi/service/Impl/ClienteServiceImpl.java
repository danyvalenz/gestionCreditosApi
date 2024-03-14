package com.galaxy.gestionCreditosApi.service.Impl;

import com.galaxy.gestionCreditosApi.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.galaxy.gestionCreditosApi.model.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClienteServiceImpl {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> getAllClients(){

        return clienteRepository.findAll();
    }

    public Cliente findById(UUID idCliente){
        return clienteRepository.findById(idCliente).orElse(new Cliente());
    }



}
