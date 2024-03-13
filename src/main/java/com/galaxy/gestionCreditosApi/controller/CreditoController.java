package com.galaxy.gestionCreditosApi.controller;

import com.galaxy.gestionCreditosApi.model.Credito;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class CreditoController {


    @GetMapping("/listar/id/{id}")
    public Credito listarPorId(@PathVariable("id") Long id){
        Credito credito = new Credito();
        credito.setIdCredito(id);
        credito.setMotivoCredito("credito personal");
        credito.setTipoCredito("credito liquido");
        credito.setImporte(102.00F);
        credito.setFecha("11/02/2024");
        credito.setCalculoIntereses(1231.32F);
        credito.setNumeroCuotas(36);
        //credito.setNombreSolicitante("Daniel Valenzuela");

        return credito;
    }
}
