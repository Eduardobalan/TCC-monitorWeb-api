package br.com.webmonitor.entity;

import br.com.webmonitor.entity.Generic.GenericEntity;
import br.com.webmonitor.exception.GenericRuntimeException;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


/**
 * Created by Eduardo Balan on 21/06/2017.
 */

@Entity
//@DynamicUpdate
@Table(name = "TB_DOMINIO" , schema = "PUBLIC")
public class Dominio implements GenericEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "domi_id")
    private Long id;

    @Column(name = "domi_nome")
    private String nome;

    @Column(name = "domi_observacao")
    private String observacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
