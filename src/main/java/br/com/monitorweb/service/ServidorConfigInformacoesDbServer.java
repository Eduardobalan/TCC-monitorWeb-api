package br.com.monitorweb.service;


import br.com.monitorweb.business.ServidorConfigInformacoesDbBO;
import br.com.monitorweb.entity.ServidorConfigInformacoesDb;
import br.com.monitorweb.repository.ServidorConfigInformacoesDbRepository;
import br.com.monitorweb.service.Generic.InformacoesGenericService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Eduardo Balan on 30/06/2017.
 */
@RestController
@RequestMapping(path = "/servidor/{idServidor}/servidorconfiguracoesinformacoesdb")
public class ServidorConfigInformacoesDbServer extends InformacoesGenericService<ServidorConfigInformacoesDb, ServidorConfigInformacoesDbBO, ServidorConfigInformacoesDbRepository> {

}
