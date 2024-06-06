package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "autor")
public class Autor {
    @Id
    @Column(name = "Codigo_Autor", nullable = false)
    private Integer id;

    @Size(max = 60)
    @NotNull
    @Column(name = "Nome_Autor", nullable = false, length = 60)
    private String nomeAutor;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "musica_autor",
            joinColumns = @JoinColumn(name = "Codigo_Autor"),
            inverseJoinColumns = @JoinColumn(name = "Codigo_Musica"))
    private Set<Musica> musicas = new LinkedHashSet<>();

    @Override
    public String toString() {
        return "Autor{" +
                "id=" + id +
                ", nomeAutor='" + nomeAutor + '\'' +
                ", musicas=" + musicas +
                '}';
    }
}