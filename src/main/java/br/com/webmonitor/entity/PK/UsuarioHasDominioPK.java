package br.com.webmonitor.entity.PK;

import javax.persistence.Column;
import java.io.Serializable;

/**
 * Created by Eduardo Balan on 14/09/2017.
 */
public class UsuarioHasDominioPK implements Serializable{
    @Column(name = "usu_id")
    private Long usuarioId;

    @Column(name = "domi_id")
    private Long dominioId;

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
}


