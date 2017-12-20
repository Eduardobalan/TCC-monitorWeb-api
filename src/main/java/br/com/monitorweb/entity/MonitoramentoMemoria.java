package br.com.monitorweb.entity;

import br.com.monitorweb.entity.Generic.GenericEntity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Eduardo Balan on 07/07/2017.
 */
@Entity
@Table(name = "tb_monitoramento_memoria", schema = "public")
@SequenceGenerator(name = "tb_monitoramento_memoria_memm_id_seq", sequenceName = "public.tb_monitoramento_memoria_memm_id_seq")
public class MonitoramentoMemoria extends GenericEntity<Long>{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "tb_monitoramento_memoria_memm_id_seq")
    @Column(name = "memm_id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "memi_id")
    private InformacoesMemoria informacoesMemoria;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "memm_dthr_cadastro")
    private Date dthr_cadastro;

    @Column(name = "memm_active")
    private Long active;

    @Column(name = "memm_memfree")
    private Long memfree;

    @Column(name = "memm_availabre")
    private Long availabre;

    @Column(name = "memm_buffers")
    private Long buffers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public InformacoesMemoria getInformacoesMemoria() {
        return informacoesMemoria;
    }

    public void setInformacoesMemoria(InformacoesMemoria informacoesMemoria) {
        this.informacoesMemoria = informacoesMemoria;
    }

    public Long getActive() {
        return active;
    }

    public void setActive(Long active) {
        this.active = active;
    }

    public Long getMemfree() {
        return memfree;
    }

    public void setMemfree(Long memfree) {
        this.memfree = memfree;
    }

    public Date getDthr_cadastro() {
        return dthr_cadastro;
    }

    public void setDthr_cadastro(Date dthr_cadastro) {
        this.dthr_cadastro = dthr_cadastro;
    }

    public Long getAvailabre() {
        return availabre;
    }

    public void setAvailabre(Long availabre) {
        this.availabre = availabre;
    }

    public Long getBuffers() {
        return buffers;
    }

    public void setBuffers(Long buffers) {
        this.buffers = buffers;
    }
}

