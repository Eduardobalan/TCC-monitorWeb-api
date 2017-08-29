package br.com.webmonitor.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Eduardo Balan on 21/06/2017.
 */

////@DynamicUpdate
//@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "tb_servidor", schema = "public")
public class Servidor  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "serv_id")
    private Long id;

    @Column(name = "domi_id")
    private Long domi_id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "domi_id")
    private Dominio dominio;

    @Column(name = "serv_dthr_cadastro")
    private Date dthr_cadastro;

    @Column(name = "serv_nome")
    private String nome;

    @Column(name = "serv_empresa")
    private String empresa;

    @Column(name = "serv_observacao")
    private String observacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDomi_id() {
        return domi_id;
    }

    public void setDomi_id(Long domi_id) {
        this.domi_id = domi_id;
    }

    public Dominio getDominio() {
        return dominio;
    }

    public void setDominio(Dominio dominio) {
        this.dominio = dominio;
    }

    public Date getDthr_cadastro() {
        return dthr_cadastro;
    }

    public void setDthr_cadastro(Date dthr_cadastro) {
        this.dthr_cadastro = dthr_cadastro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
