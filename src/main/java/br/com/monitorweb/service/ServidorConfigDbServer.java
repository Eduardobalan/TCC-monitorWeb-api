package br.com.monitorweb.service;


import br.com.monitorweb.business.ServidorConfigDbBO;
import br.com.monitorweb.entity.ServidorConfigDb;
import br.com.monitorweb.repository.ServidorConfigDbRepository;
import br.com.monitorweb.service.Generic.InformacoesGenericService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Eduardo Balan on 30/06/2017.
 */
@RestController
@RequestMapping(path = "/servidor/{idServidor}/servidorconfiguracoesdb")
public class ServidorConfigDbServer extends InformacoesGenericService<ServidorConfigDb, ServidorConfigDbBO, ServidorConfigDbRepository> {

}
