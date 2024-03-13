package com.galaxy.gestionCreditosApi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "cliente_solicitante")
@Data
public class Cliente {

    @Id
    @Column(name = "id_cliente")
    private Long idCliente;
    private String nombreCliente;
    private String apellidoPaCliente;
    private String apellidoMaCliente;
    private Integer edadCliente;
    @OneToMany(mappedBy = "cliente",fetch = FetchType.EAGER)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "cliente"})
    private List<Credito> creditos;


    @OneToMany(mappedBy = "cliente",fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "cliente"})
    private List<Evidencia> evidencias;



}
