package br.com.monitorweb.service;

import br.com.monitorweb.business.InformacoesMemoriaBO;
import br.com.monitorweb.entity.InformacoesMemoria;
import br.com.monitorweb.repository.InformacoesMemoriaRepository;
import br.com.monitorweb.service.Generic.InformacoesGenericService;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Eduardo Balan on 01/07/2017.
 */

@RestController
@RequestMapping(path = "/servidor/{idServidor}/informacoesmemoria")
public class InformacoesMemoriaService extends InformacoesGenericService<InformacoesMemoria, InformacoesMemoriaBO, InformacoesMemoriaRepository> {
}
