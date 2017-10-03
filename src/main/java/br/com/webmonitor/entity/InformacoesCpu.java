package br.com.webmonitor.entity;

import br.com.webmonitor.entity.Generic.GenericEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Eduardo Balan on 01/07/2017.
 */
@Entity
//@DynamicUpdate
@Table(name = "tb_informacoes_cpu", schema = "public")
public class InformacoesCpu extends GenericEntity<Long>{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cpui_id")
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "serv_id")
    private Servidor servidor;

    @Column(name = "cpui_nome")
    private String nome;

    @Column(name = "cpui_cache_size")
    private Long cacheSize;

    @Column(name = "cpui_cpu_cores")
    private Long cpuCores;

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

    public Long getCacheSize() {
        return cacheSize;
    }

    public void setCacheSize(Long cacheSize) {
        this.cacheSize = cacheSize;
    }

    public Long getCpuCores() {
        return cpuCores;
    }

    public void setCpuCores(Long cpuCores) {
        this.cpuCores = cpuCores;
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
