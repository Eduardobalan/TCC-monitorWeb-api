package br.com.webmonitor.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Eduardo Balan on 01/07/2017.
 */
@Entity
//@DynamicUpdate
@Table(name = "tb_informacoes_cpu", schema = "public")
public class InformacoesCpu {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cpui_id")
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "serv_id", nullable = true)
    private Servidor servidor;

    @Column(name = "cpui_nome")
    private String nome;

    @Column(name = "cpui_cache_size")
    private Long cache_size;

    @Column(name = "cpui_cpu_cores")
    private Long cpu_cores;

    //Numero de cores Virtuais
    @Column(name = "cpui_siblings")
    private Long siblings;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "cpui_dthr_cadastro")
    private Date dthr_cadastro;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Servidor getServidor() {
        return servidor;
    }

    public void setServidor(Servidor servidor) {
        this.servidor = servidor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getCache_size() {
        return cache_size;
    }

    public void setCache_size(Long cache_size) {
        this.cache_size = cache_size;
    }

    public Long getCpu_cores() {
        return cpu_cores;
    }

    public void setCpu_cores(Long cpu_cores) {
        this.cpu_cores = cpu_cores;
    }

    public Long getSiblings() {
        return siblings;
    }

    public void setSiblings(Long siblings) {
        this.siblings = siblings;
    }

    public Date getDthr_cadastro() {
        return dthr_cadastro;
    }

    public void setDthr_cadastro(Date dthr_cadastro) {
        this.dthr_cadastro = dthr_cadastro;
    }
}
