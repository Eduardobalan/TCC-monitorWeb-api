package br.com.webmonitor.entity;

import br.com.webmonitor.entity.Generic.GenericEntity;
import br.com.webmonitor.enumeration.EnumSgdbTipoExec;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Eduardo Balan on 07/07/2017.
 */
@Entity
@Table(name = "tb_monitoramento_postgres", schema = "public")
@SequenceGenerator(name = "tb_monitoramento_postgres_dbmp_id_seq", sequenceName = "public.tb_monitoramento_postgres_dbmp_id_seq")
public class MonitoramentoPostgres extends GenericEntity<Long>{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "tb_monitoramento_postgres_dbmp_id_seq")
    @Column(name = "dbmp_id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dbip_id")
    private InformacoesPostgres informacoesPostgres;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "dbmp_tipo_execucao",  nullable = false)
    private EnumSgdbTipoExec tipoExecucao;

    @Column(name = "dbmp_exito")
    private int exito;

    @Column(name = "dbmp_mensagem")
    private String mensagem;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dbmp_dthr_cadastro")
    private Date dthr_cadastro;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public InformacoesPostgres getInformacoesPostgres() {
        return informacoesPostgres;
    }

    public void setInformacoesPostgres(InformacoesPostgres informacoesPostgres) {
        this.informacoesPostgres = informacoesPostgres;
    }

    public EnumSgdbTipoExec getTipoExecucao() {
        return tipoExecucao;
    }

    public void setTipoExecucao(EnumSgdbTipoExec tipoExecucao) {
        this.tipoExecucao = tipoExecucao;
    }

    public int getExito() {
        return exito;
    }

    public void setExito(int exito) {
        this.exito = exito;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public Date getDthr_cadastro() {
        return dthr_cadastro;
    }

    @Override
    public void setDthr_cadastro(Date dthr_cadastro) {
        this.dthr_cadastro = dthr_cadastro;
    }
}

