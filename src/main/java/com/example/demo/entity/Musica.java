package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "musica")
public class Musica {
    @Id
    @Column(name = "Codigo_Musica", nullable = false)
    private Integer id;

    @Size(max = 60)
    @NotNull
    @Column(name = "Nome_Musica", nullable = false, length = 60)
    private String nomeMusica;

    @Column(name = "Duracao_Musica")
    private LocalTime duracaoMusica;

    @OneToMany(mappedBy = "codigoMusica")
    private Set<Faixa> faixas = new LinkedHashSet<>();

    @ManyToMany
    @JoinTable(name = "musica_autor",
            joinColumns = @JoinColumn(name = "Codigo_Musica"),
            inverseJoinColumns = @JoinColumn(name = "Codigo_Autor"))
    private Set<Autor> autors = new LinkedHashSet<>();

    @Override
    public String toString() {
        return "Musica{" +
                "id=" + id +
                ", nomeMusica='" + nomeMusica + '\'' +
                ", duracaoMusica=" + duracaoMusica +
                '}';
    }
}