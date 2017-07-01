package br.com.webmonitor.entity;

import javax.persistence.*;
import java.io.Serializable;


/**
 * Created by Eduardo Balan on 21/06/2017.
 */

@Entity
//@DynamicUpdate
@Table(name = "TB_DOMINIO" , schema = "public")
public class Dominio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "domi_id")
    private Long id;

    @Column(name = "domi_nome")
    private String nome;

    @Column(name = "domi_observacao")
    private String observacao;


    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public String getObs() {
        return observacao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setObs(String observacao) {
        this.observacao = observacao;
    }


}
