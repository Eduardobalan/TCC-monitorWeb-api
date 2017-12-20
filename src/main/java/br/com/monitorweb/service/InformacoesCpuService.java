package br.com.monitorweb.service;

import br.com.monitorweb.business.InformacoesCpuBO;
import br.com.monitorweb.entity.InformacoesCpu;
import br.com.monitorweb.repository.InformacoesCpuRepository;
import br.com.monitorweb.service.Generic.InformacoesGenericService;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Eduardo Balan on 01/07/2017.
 */

@RestController
@RequestMapping(path = "/servidor/{idServidor}/informacoescpu")
public class InformacoesCpuService  extends InformacoesGenericService<InformacoesCpu, InformacoesCpuBO, InformacoesCpuRepository> {

}
