package br.com.webmonitor.business;

import br.com.webmonitor.business.generic.GenericBO;
import br.com.webmonitor.entity.Usuario;
import br.com.webmonitor.repository.UsuarioRepository;
import org.springframework.stereotype.Component;

/**
 * Created by Eduardo Balan on 29/06/2017.
 */

@Component
public class UsuarioBO extends GenericBO<Usuario, UsuarioRepository> {

}
