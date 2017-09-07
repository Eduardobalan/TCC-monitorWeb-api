package br.com.webmonitor.entity;

import br.com.webmonitor.entity.Generic.GenericEntity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Eduardo Balan on 07/07/2017.
 */
@Entity
@Table(name = "tb_monitoramento_db", schema = "public")
public class MonitoramentoDB implements GenericEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "dbmo_id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dbin_id")
    private InformacoesDB informacoesDB;

    @Column(name = "dbmo_exito")
    private Boolean exito;

    @Column(name = "dbmo_mensagem")
    private String mensagem;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dbmo_dthr_cadastro")
    private Date dthr_cadastro;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public InformacoesDB getInformacoesDB() {
        return informacoesDB;
    }

    public void setInformacoesDB(InformacoesDB informacoesDB) {
        this.informacoesDB = informacoesDB;
    }

    public Boolean getExito() {
        return exito;
    }

    public void setExito(Boolean exito) {
        this.exito = exito;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Date getDthr_cadastro() {
        return dthr_cadastro;
    }

    public void setDthr_cadastro(Date dthr_cadastro) {
        this.dthr_cadastro = dthr_cadastro;
    }
}

