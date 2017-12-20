package br.com.monitorweb.business;

import br.com.monitorweb.business.generic.GenericBO;
import br.com.monitorweb.entity.Usuario;
import br.com.monitorweb.repository.UsuarioRepository;
import org.springframework.stereotype.Component;

/**
 * Created by Eduardo Balan on 29/06/2017.
 */

@Component
public class UsuarioBO extends GenericBO<Usuario, UsuarioRepository> {

}
