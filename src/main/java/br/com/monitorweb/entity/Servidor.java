package br.com.monitorweb.entity;

import br.com.monitorweb.entity.Generic.GenericEntity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Eduardo Balan on 21/06/2017.
 */

////@DynamicUpdate
//@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "tb_servidor", schema = "public")
@SequenceGenerator(name = "tb_servidor_domi_id_seq", sequenceName = "public.tb_servidor_domi_id_seq")
public class Servidor  extends GenericEntity<Long>{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "tb_servidor_domi_id_seq")
    @Column(name = "serv_id")
    private Long id;

//    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
//    @JsonIdentityReference(alwaysAsId = true)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "domi_id")
    private Dominio dominio;

    @Temporal(TemporalType.TIMESTAMP)
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
