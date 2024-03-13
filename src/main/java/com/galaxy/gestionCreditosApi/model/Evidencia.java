package com.galaxy.gestionCreditosApi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "evidencia_credito")
@Data
public class Evidencia {

    @Id
    @Column(name = "id_evidencia")
    private Long idEvidencia;
    private String tipoArchivo;
    private String archivoEvidencia;

    private String fotoSolicitante;
    private String videoResumenSolicitante;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_credito",referencedColumnName = "id_credito")
    @JsonIgnore
    private Credito credito;

    @ManyToOne
    @JoinColumn(name = "id_cliente",referencedColumnName = "id_cliente")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "evidencias"})
    private Cliente cliente;


}
