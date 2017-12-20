package br.com.monitorweb.service;

import br.com.monitorweb.business.InformacoesSwapBO;
import br.com.monitorweb.entity.InformacoesSwap;
import br.com.monitorweb.repository.InformacoesSwapRepository;
import br.com.monitorweb.service.Generic.InformacoesGenericService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Eduardo Balan on 01/07/2017.
 */

@RestController
@RequestMapping(path = "/servidor/{idServidor}/informacoesswap")
public class InformacoesSwapService extends InformacoesGenericService<InformacoesSwap, InformacoesSwapBO, InformacoesSwapRepository> {

}
