package com.galaxy.gestionCreditosApi.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class GestionCreditosController {


    @GetMapping("/saludo")
    public String saludo(){
        return "saludo";
    }

    /*
    @GetMapping("/hateoas")
    public CreditoDTO consultaHateoas(){

        /*
        CreditoDTO creditoDTO = new CreditoDTO();
        Credito c = new Credito();
        c.setIdCredito(1L);
        ControllerLinkBuilder linkto = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(CreditoController.class).listarPorId(c.getIdCredito()));
        creditoDTO.add(linkto.withSelfRel());
        
        return  creditoDTO;
    }*/
}
