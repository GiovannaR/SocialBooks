package com.crc.socialbooks.com.algaworks.socialbooks.domain;

import com.fasterxml.jackson.annotation.JsonInclude;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Sapato {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String nome;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer cor;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer tamanho;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String estilo;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String usuario;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCor() {
        return cor;
    }

    public void setCor(Integer cor) {
        cor = cor;
    }

    public Integer getTamanho() {
        return tamanho;
    }

    public void setTamanho(Integer tamanho) {
        this.tamanho = tamanho;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
