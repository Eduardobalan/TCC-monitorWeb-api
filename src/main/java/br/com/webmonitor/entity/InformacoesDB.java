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
@Table(name = "tb_informacoes_db", schema = "public")
public class InformacoesDB extends GenericEntity<Long>{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "dbin_id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "serv_id")
    private Servidor servidor;

    @Column(name = "dbin_nome")
    private String nome;

    @Column(name = "dbin_versao")
    private String versao;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dbin_dthr_cadastro")
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

    public String getVersao() {
        return versao;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }

    public Date getDthr_cadastro() {
        return dthr_cadastro;
    }

    public void setDthr_cadastro(Date dthr_cadastro) {
        this.dthr_cadastro = dthr_cadastro;
    }
}
