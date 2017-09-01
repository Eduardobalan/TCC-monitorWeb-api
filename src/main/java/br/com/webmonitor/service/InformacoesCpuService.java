package br.com.webmonitor.service;

import br.com.webmonitor.business.InformacoesCpuBO;
import br.com.webmonitor.entity.InformacoesCpu;
import br.com.webmonitor.repository.InformacoesCpuRepository;
import br.com.webmonitor.service.Generic.GenericService;
import br.com.webmonitor.service.Generic.InformacoesGenericService;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Eduardo Balan on 01/07/2017.
 */

@RestController
@RequestMapping(path = "/servidor/{idServidor}/informacoescpu")
public class InformacoesCpuService  extends InformacoesGenericService<InformacoesCpu, InformacoesCpuBO, InformacoesCpuRepository> {

}
