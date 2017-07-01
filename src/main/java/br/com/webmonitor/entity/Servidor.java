package br.com.webmonitor.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * Created by Eduardo Balan on 21/06/2017.
 */
@Entity
////@DynamicUpdate
@Table(name = "tb_servidor" , schema = "public")
public class Servidor {

    private static final long serialVersionUID = 6663263309144362556L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "serv_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "domi_id")
    private Dominio dominio;

//    private Long serv_dthr_cadastro;
//    private Long serv_dthr_alteracao;

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

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
