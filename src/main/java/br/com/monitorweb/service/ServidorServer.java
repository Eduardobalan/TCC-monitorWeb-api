package br.com.monitorweb.service;

import br.com.monitorweb.business.ServidorBO;
import br.com.monitorweb.entity.Servidor;
import br.com.monitorweb.repository.ServidorRepository;
import br.com.monitorweb.service.Generic.GenericService;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Eduardo Balan on 30/06/2017.
 */
@RestController
@RequestMapping(path = "/servidor")
public class ServidorServer extends GenericService<Servidor, ServidorBO, ServidorRepository> {

}
