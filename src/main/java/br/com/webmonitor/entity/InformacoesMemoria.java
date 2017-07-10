package br.com.webmonitor.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Eduardo Balan on 01/07/2017.
 */
@Entity
//@DynamicUpdate
@Table(name = "tb_informacoes_memoria" , schema = "public")
public class InformacoesMemoria{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "memi_id")
    private Long id;

    //@Transient
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "serv_id")
    private Servidor servidor;

    //memi_dthr_cadastro

    @Column(name = "memi_total")
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

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
