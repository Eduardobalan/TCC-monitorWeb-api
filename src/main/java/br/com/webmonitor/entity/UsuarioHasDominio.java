package br.com.webmonitor.entity;

import br.com.webmonitor.entity.Dominio;
import br.com.webmonitor.entity.PK.UsuarioHasDominioPK;
import br.com.webmonitor.entity.Usuario;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Eduardo Balan on 14/09/2017.
 */

@Entity
@Table(name = "tb_usuario_has_tb_dominio", schema = "public")
@IdClass(UsuarioHasDominioPK.class)
public class UsuarioHasDominio {

    @Id
    @Column(name = "usu_id")
    private Long usuarioId;

    @Id
    @Column(name = "domi_id")
    private Long dominioId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usu_id", insertable = false, updatable = false)
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "domi_id", insertable = false, updatable = false)
    private Dominio dominio;


    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Long getDominioId() {
        return dominioId;
    }

    public void setDominioId(Long dominioId) {
        this.dominioId = dominioId;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Dominio getDominio() {
        return dominio;
    }

    public void setDominio(Dominio dominio) {
        this.dominio = dominio;
    }
}