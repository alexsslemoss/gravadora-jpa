package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "cd")
public class Cd {
    @Id
    @Column(name = "Codigo_CD", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Codigo_Gravadora", nullable = false)
    private Gravadora codigoGravadora;

    @Size(max = 60)
    @NotNull
    @Column(name = "Nome_CD", nullable = false, length = 60)
    private String nomeCd;

    @Column(name = "Preco_Venda_Cd", precision = 14, scale = 2)
    private BigDecimal precoVendaCd;

    @Column(name = "Data_Lancamento_Cd")
    private LocalDate dataLancamentoCd;

    @Column(name = "CD_Indicado")
    private Integer cdIndicado;

    @Column(name = "Capa_Cd")
    private byte[] capaCd;

    @OneToMany(mappedBy = "codigoCd")
    private Set<CdCategoria> cdCategorias = new LinkedHashSet<>();

    @OneToMany(mappedBy = "codigoCd")
    private Set<Faixa> faixas = new LinkedHashSet<>();

}