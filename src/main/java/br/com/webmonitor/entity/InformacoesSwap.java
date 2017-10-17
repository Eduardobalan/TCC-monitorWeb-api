package br.com.webmonitor.entity;

import br.com.webmonitor.entity.Generic.GenericEntity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Eduardo Balan on 01/07/2017.
 */
@Entity
//@DynamicUpdate
@Table(name = "tb_informacoes_swap" , schema = "public")
@SequenceGenerator(name = "tb_informacoes_swap_swai_id_seq", sequenceName = "public.tb_informacoes_swap_swai_id_seq")
public class InformacoesSwap extends GenericEntity<Long>{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "tb_informacoes_swap_swai_id_seq")
    @Column(name = "swai_id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "serv_id")
    private Servidor servidor;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "swai_dthr_cadastro")
    private Date dthr_cadastro;

    @Column(name = "swai_total")
    private Long total;

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

    public Date getDthr_cadastro() {
        return dthr_cadastro;
    }

    public void setDthr_cadastro(Date dthr_cadastro) {
        this.dthr_cadastro = dthr_cadastro;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
