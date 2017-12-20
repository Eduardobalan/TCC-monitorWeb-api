package br.com.monitorweb.service;

import br.com.monitorweb.business.UsuarioBO;
import br.com.monitorweb.entity.Usuario;
import br.com.monitorweb.repository.UsuarioRepository;
import br.com.monitorweb.service.Generic.GenericService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Eduardo Balan on 27/06/2017.
 */
@RestController
@RequestMapping(path = "/usuario")
public class UsuarioServer extends GenericService<Usuario, UsuarioBO, UsuarioRepository> {

}