package br.com.webmonitor.service;

import br.com.webmonitor.business.DominioBO;
import br.com.webmonitor.entity.Dominio;
import br.com.webmonitor.repository.DominioRepository;
import br.com.webmonitor.service.Generic.GenericService;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Eduardo Balan on 27/06/2017.
 */
@RestController
@RequestMapping(path = "/dominio")
public class DominioServer extends GenericService<Dominio, DominioBO, DominioRepository> {

}