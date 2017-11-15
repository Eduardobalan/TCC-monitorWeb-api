package br.com.webmonitor.service;


import br.com.webmonitor.business.ServidorConfigDbBO;
import br.com.webmonitor.business.ServidorConfigInformacoesDbBO;
import br.com.webmonitor.entity.ServidorConfigDb;
import br.com.webmonitor.entity.ServidorConfigInformacoesDb;
import br.com.webmonitor.repository.ServidorConfigDbRepository;
import br.com.webmonitor.repository.ServidorConfigInformacoesDbRepository;
import br.com.webmonitor.service.Generic.InformacoesGenericService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Eduardo Balan on 30/06/2017.
 */
@RestController
@RequestMapping(path = "/servidor/{idServidor}/servidorconfiguracoesinformacoesdb")
public class ServidorConfigInformacoesDbServer extends InformacoesGenericService<ServidorConfigInformacoesDb, ServidorConfigInformacoesDbBO, ServidorConfigInformacoesDbRepository> {

}
