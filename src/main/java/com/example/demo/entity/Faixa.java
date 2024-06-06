package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "faixa")
public class Faixa {
    @Id
    @Column(name = "Id_Faixa", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Codigo_Musica", nullable = false)
    private Musica codigoMusica;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Codigo_CD", nullable = false)
    private Cd codigoCd;

    @NotNull
    @Column(name = "Numero_Faixa", nullable = false)
    private Integer numeroFaixa;

}