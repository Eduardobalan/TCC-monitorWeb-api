package br.com.webmonitor.service;

import br.com.webmonitor.business.InformacoesMemoriaBO;
import br.com.webmonitor.business.InformacoesSwapBO;
import br.com.webmonitor.entity.InformacoesMemoria;
import br.com.webmonitor.entity.InformacoesSwap;
import br.com.webmonitor.repository.InformacoesMemoriaRepository;
import br.com.webmonitor.repository.InformacoesSwapRepository;
import br.com.webmonitor.service.Generic.InformacoesGenericService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Eduardo Balan on 01/07/2017.
 */

@RestController
@RequestMapping(path = "/servidor/{idServidor}/informacoesswap")
public class InformacoesSwapService extends InformacoesGenericService<InformacoesSwap, InformacoesSwapBO, InformacoesSwapRepository> {

}
