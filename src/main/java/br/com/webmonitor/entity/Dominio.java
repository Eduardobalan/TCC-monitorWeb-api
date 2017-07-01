package br.com.webmonitor.entity;

import javax.persistence.*;
import java.io.Serializable;


/**
 * Created by Eduardo Balan on 21/06/2017.
 */

@Entity
//@DynamicUpdate
@Table(name = "TB_DOMINIO" , schema = "public")
public class Dominio implements Serializable {

    private static final long serialVersionUID = 6663273309134361548L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "domi_id")
    private Long id;

    @Column(name = "domi_nome")
    private String nome;

    @Column(name = "domi_obs")
    private String obs;

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
        return obs;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }


}
