package br.com.webmonitor.service;

import br.com.webmonitor.business.InformacoesPostgresBO;
import br.com.webmonitor.entity.InformacoesPostgres;
import br.com.webmonitor.repository.InformacoesPostgresRepository;
import br.com.webmonitor.service.Generic.InformacoesGenericService;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Eduardo Balan on 01/07/2017.
 */

@RestController
@RequestMapping(path = "/servidor/{idServidor}/informacoespostgres")
public class InformacoesPostgresService extends InformacoesGenericService<InformacoesPostgres, InformacoesPostgresBO, InformacoesPostgresRepository> {

}
