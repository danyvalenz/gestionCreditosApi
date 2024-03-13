package com.galaxy.gestionCreditosApi.service.Impl;

import com.galaxy.gestionCreditosApi.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.galaxy.gestionCreditosApi.model.*;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> getAllClients(){

        return clienteRepository.findAll();
    }

    public Cliente findById(Long idCliente){
        return clienteRepository.findById(idCliente).orElse(new Cliente());
    }



}
