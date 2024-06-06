package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "gravadora")
public class Gravadora {
    @Id
    @Column(name = "Codigo_Gravadora", nullable = false)
    private Integer id;

    @Size(max = 60)
    @NotNull
    @Column(name = "Nome_Gravadora", nullable = false, length = 60)
    private String nomeGravadora;

    @Size(max = 60)
    @Column(name = "Endereco_Gravadora", length = 60)
    private String enderecoGravadora;

    @Size(max = 20)
    @Column(name = "Telefone_Gravadora", length = 20)
    private String telefoneGravadora;

    @Size(max = 20)
    @Column(name = "Contato_Gravadora", length = 20)
    private String contatoGravadora;

    @Size(max = 80)
    @Column(name = "URL_Gravadora", length = 80)
    private String urlGravadora;

    @OneToMany(mappedBy = "codigoGravadora")
    private Set<Cd> cds = new LinkedHashSet<>();

}