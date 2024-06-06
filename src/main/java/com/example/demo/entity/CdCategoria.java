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

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "cd_categoria")
public class CdCategoria {
    @Id
    @Column(name = "Codigo_Categoria", nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "Menor_Preco", nullable = false, precision = 14, scale = 2)
    private BigDecimal menorPreco;

    @NotNull
    @Column(name = "Maior_Preco", nullable = false, precision = 14, scale = 2)
    private BigDecimal maiorPreco;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Codigo_CD", nullable = false)
    private Cd codigoCd;

}