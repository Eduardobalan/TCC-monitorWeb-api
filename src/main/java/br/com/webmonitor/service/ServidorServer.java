package br.com.webmonitor.service;

import br.com.webmonitor.business.ServidorBO;
import br.com.webmonitor.entity.Servidor;
import br.com.webmonitor.repository.ServidorRepository;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Eduardo Balan on 30/06/2017.
 */
@RestController
@RequestMapping(path = "/servidor")
public class ServidorServer extends GenericService<Servidor, ServidorBO, ServidorRepository>{

}
