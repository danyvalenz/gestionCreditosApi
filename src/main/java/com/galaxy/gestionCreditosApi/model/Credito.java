package com.galaxy.gestionCreditosApi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "creditos_galaxy")
@Data
public class Credito {
    @Id
    @Column(name = "id_credito")
    private Long idCredito;

    private String tipoCredito;
    private Float importe;
    private Integer numeroCuotas;
    private Float calculoIntereses;
    private String fecha;
    private String motivoCredito;

    @ManyToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "creditos"})
    private Cliente cliente;
}
