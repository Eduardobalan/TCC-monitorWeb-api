package br.com.monitorweb.service;

import br.com.monitorweb.business.ServidorConfigBO;
import br.com.monitorweb.entity.ServidorConfig;
import br.com.monitorweb.repository.ServidorConfigRepository;
import br.com.monitorweb.service.Generic.InformacoesGenericService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Eduardo Balan on 30/06/2017.
 */
@RestController
@RequestMapping(path = "/servidor/{idServidor}/servidorconfiguracoes")
public class ServidorConfigServer extends InformacoesGenericService<ServidorConfig, ServidorConfigBO, ServidorConfigRepository> {

}
