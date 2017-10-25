package br.com.webmonitor.entity;

import br.com.webmonitor.entity.Generic.GenericEntity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Eduardo Balan on 07/07/2017.
 */
@Entity
@Table(name = "tb_monitoramento_db", schema = "public")
@SequenceGenerator(name = "tb_monitoramento_db_dbmo_id_seq", sequenceName = "public.tb_monitoramento_db_dbmo_id_seq")
public class MonitoramentoDB extends GenericEntity<Long>{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "tb_monitoramento_db_dbmo_id_seq")
    @Column(name = "dbmo_id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dbin_id")
    private InformacoesDB informacoesDB;

    @Column(name = "dbmo_exito_backup")
    private int exitoBackup;

    @Column(name = "dbmo_exito_vacuum")
    private int exitoVacuum;

    @Column(name = "dbmo_mensagem_backup")
    private String mensagemBackup;

    @Column(name = "dbmo_mensagem_vacuum")
    private String mensagemVacuum;

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

    public int getExitoBackup() {
        return exitoBackup;
    }

    public void setExitoBackup(int exitoBackup) {
        this.exitoBackup = exitoBackup;
    }

    public int getExitoVacuum() {
        return exitoVacuum;
    }

    public void setExitoVacuum(int exitoVacuum) {
        this.exitoVacuum = exitoVacuum;
    }

    public String getMensagemBackup() {
        return mensagemBackup;
    }

    public void setMensagemBackup(String mensagemBackup) {
        this.mensagemBackup = mensagemBackup;
    }

    public String getMensagemVacuum() {
        return mensagemVacuum;
    }

    public void setMensagemVacuum(String mensagemVacuum) {
        this.mensagemVacuum = mensagemVacuum;
    }

    public Date getDthr_cadastro() {
        return dthr_cadastro;
    }

    public void setDthr_cadastro(Date dthr_cadastro) {
        this.dthr_cadastro = dthr_cadastro;
    }
}

