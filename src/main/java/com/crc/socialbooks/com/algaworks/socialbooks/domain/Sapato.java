package com.crc.socialbooks.com.algaworks.socialbooks.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;


//import javax.persistence.*;

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
    @OneToOne(mappedBy = "sapato")
    private Comprador comprador;



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


    public Comprador getComprador() {
        return comprador;
    }

    public void setComprador(Comprador comprador) {
        this.comprador = comprador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
