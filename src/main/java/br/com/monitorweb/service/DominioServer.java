package br.com.monitorweb.service;

import br.com.monitorweb.business.DominioBO;
import br.com.monitorweb.entity.Dominio;
import br.com.monitorweb.repository.DominioRepository;
import br.com.monitorweb.service.Generic.GenericService;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Eduardo Balan on 27/06/2017.
 */
@RestController
@RequestMapping(path = "/dominio")
public class DominioServer extends GenericService<Dominio, DominioBO, DominioRepository> {

}