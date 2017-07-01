package br.com.webmonitor.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.transaction.Transactional;
import javax.xml.crypto.Data;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Eduardo Balan on 21/06/2017.
 */
@Entity
////@DynamicUpdate
@Table(name = "tb_servidor", schema = "public")
//@JsonIgnoreProperties(ignoreUnknown = true)
public class Servidor  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "serv_id")
    private Long id;

    //@Transient
    //@JsonIgnore
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

    public Dominio getDominio() {
        return dominio;
    }

    public void setDominio(Dominio dominio) {
        this.dominio = dominio;
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

    public Date getDthr_cadastro() {
        return dthr_cadastro;
    }

    public void setDthr_cadastro(Date dthr_cadastro) {
        this.dthr_cadastro = dthr_cadastro;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
