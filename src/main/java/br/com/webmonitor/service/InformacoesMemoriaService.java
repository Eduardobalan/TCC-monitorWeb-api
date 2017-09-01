package br.com.webmonitor.service;

import br.com.webmonitor.business.InformacoesMemoriaBO;
import br.com.webmonitor.entity.InformacoesMemoria;
import br.com.webmonitor.repository.InformacoesMemoriaRepository;
import br.com.webmonitor.service.Generic.GenericService;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Eduardo Balan on 01/07/2017.
 */

@RestController
@RequestMapping(path = "/informacoes/memoria")
public class InformacoesMemoriaService extends GenericService<InformacoesMemoria, InformacoesMemoriaBO, InformacoesMemoriaRepository> {
}
