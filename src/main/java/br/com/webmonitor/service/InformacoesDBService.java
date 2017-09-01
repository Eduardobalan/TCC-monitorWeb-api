package br.com.webmonitor.service;

import br.com.webmonitor.business.InformacoesDBBO;
import br.com.webmonitor.entity.InformacoesDB;
import br.com.webmonitor.repository.InformacoesDBRepository;
import br.com.webmonitor.service.Generic.GenericService;
import br.com.webmonitor.service.Generic.InformacoesGenericService;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Eduardo Balan on 01/07/2017.
 */

@RestController
@RequestMapping(path = "/servidor/{idServidor}/informacoesdb")
public class InformacoesDBService extends InformacoesGenericService<InformacoesDB, InformacoesDBBO, InformacoesDBRepository> {

}
