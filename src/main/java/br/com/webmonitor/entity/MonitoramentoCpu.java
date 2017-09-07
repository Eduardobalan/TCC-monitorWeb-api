package br.com.webmonitor.entity;

import br.com.webmonitor.entity.Generic.GenericEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Eduardo Balan on 07/07/2017.
 */
@Entity
@Table(name = "tb_monitoramento_cpu", schema = "public")
public class MonitoramentoCpu implements GenericEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cpum_id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cpui_id")
    private InformacoesCpu informacoesCpu;

    @Column(name = "cpum_numero_nucleo")
    private Long numeroNucleo;

    @Column(name = "cpum_cpu_mhz")
    private Long cpuMhz;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "cpum_dthr_cadastro")
    private Date dthr_cadastro;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public InformacoesCpu getInformacoesCpu() {
        return informacoesCpu;
    }

    public void setInformacoesCpu(InformacoesCpu informacoesCpu) {
        this.informacoesCpu = informacoesCpu;
    }

    public Long getNumeroNucleo() {
        return numeroNucleo;
    }

    public void setNumeroNucleo(Long numeroNucleo) {
        this.numeroNucleo = numeroNucleo;
    }

    public Long getCpuMhz() {
        return cpuMhz;
    }

    public void setCpuMhz(Long cpuMhz) {
        this.cpuMhz = cpuMhz;
    }

    public Date getDthr_cadastro() {
        return dthr_cadastro;
    }

    public void setDthr_cadastro(Date dthr_cadastro) {
        this.dthr_cadastro = dthr_cadastro;
    }
}

