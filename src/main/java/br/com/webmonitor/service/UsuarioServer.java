package br.com.webmonitor.service;

import br.com.webmonitor.business.UsuarioBO;
import br.com.webmonitor.entity.Usuario;
import br.com.webmonitor.repository.UsuarioRepository;
import br.com.webmonitor.service.Generic.GenericService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Eduardo Balan on 27/06/2017.
 */
@RestController
@RequestMapping(path = "/usuario")
public class UsuarioServer extends GenericService<Usuario, UsuarioBO, UsuarioRepository> {

}