package br.com.webmonitor.entity;

import br.com.webmonitor.entity.Generic.GenericEntity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Eduardo Balan on 07/07/2017.
 */
@Entity
@Table(name = "tb_monitoramento_swap", schema = "public")
@SequenceGenerator(name = "tb_monitoramento_swap_swam_id_seq", sequenceName = "public.tb_monitoramento_swap_swam_id_seq")
public class MonitoramentoSwap extends GenericEntity<Long>{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "tb_monitoramento_swap_swam_id_seq")
    @Column(name = "swam_id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "swai_id")
    private InformacoesSwap informacoesSwap;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "swam_dthr_cadastro")
    private Date dthr_cadastro;

    @Column(name = "swam_free")
    private Long free;

    @Column(name = "swam_cached")
    private Long cached;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public InformacoesSwap getInformacoesSwap() {
        return informacoesSwap;
    }

    public void setInformacoesSwap(InformacoesSwap informacoesSwap) {
        this.informacoesSwap = informacoesSwap;
    }

    public Date getDthr_cadastro() {
        return dthr_cadastro;
    }

    public void setDthr_cadastro(Date dthr_cadastro) {
        this.dthr_cadastro = dthr_cadastro;
    }

    public Long getFree() {
        return free;
    }

    public void setFree(Long free) {
        this.free = free;
    }

    public Long getCached() {
        return cached;
    }

    public void setCached(Long cached) {
        this.cached = cached;
    }
}

