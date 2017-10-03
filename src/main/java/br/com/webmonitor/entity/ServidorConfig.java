package br.com.webmonitor.entity;

import br.com.webmonitor.entity.Generic.GenericEntity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Eduardo Balan on 01/09/2017.
 */
@Entity
@Table(name = "tb_servidor_config", schema = "public")
public class ServidorConfig extends GenericEntity<Long>{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "serc_id")
    private Long id;

    //@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    //@JsonIdentityReference(alwaysAsId = true)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "serv_id")
    private Servidor servidor;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "serc_dthr_cadastro")
    private Date dthr_cadastro;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "serc_dthr_alteracao")
    private Date dthr_alteracao;

    @Column(name = "serc_intervalo_cpu")
    private Long intervaloCpu;

    @Column(name = "serc_intervalo_mem")
    private Long intervaloMemoria;

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

    public Date getDthr_alteracao() {
        return dthr_alteracao;
    }

    public void setDthr_alteracao(Date dthr_alteracao) {
        this.dthr_alteracao = dthr_alteracao;
    }

    public Date getDthr_cadastro() {
        return dthr_cadastro;
    }

    public void setDthr_cadastro(Date dthr_cadastro) {
        this.dthr_cadastro = dthr_cadastro;
    }

    public Long getIntervaloCpu() {
        return intervaloCpu;
    }

    public void setIntervaloCpu(Long intervaloCpu) {
        this.intervaloCpu = intervaloCpu;
    }

    public Long getIntervaloMemoria() {
        return intervaloMemoria;
    }

    public void setIntervaloMemoria(Long intervaloMemoria) {
        this.intervaloMemoria = intervaloMemoria;
    }
}
