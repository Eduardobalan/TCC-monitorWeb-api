package br.com.webmonitor.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Eduardo Balan on 07/07/2017.
 */
@Entity
@Table(name = "tb_monitoramento_cpu", schema = "public")
public class MonitoramentoCpu {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cpum_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cpui_id")
    private InformacoesCpu informacoesCpu;

    @Column(name = "cpum_numero_nucleo")
    private Long numero_nucleo;

    @Column(name = "cpum_cpu_mhz")
    private Long cpu_mhz;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "cpum_dthr_cadastro")
    private Date dthr_cadastro;

    public Long getId() {
        return id;
    }

    public InformacoesCpu getInformacoesCpu() {
        return informacoesCpu;
    }

    public Long getNumero_nucleo() {
        return numero_nucleo;
    }

    public Long getCpu_mhz() {
        return cpu_mhz;
    }

    public Date getDthr_cadastro() {
        return dthr_cadastro;
    }
}

