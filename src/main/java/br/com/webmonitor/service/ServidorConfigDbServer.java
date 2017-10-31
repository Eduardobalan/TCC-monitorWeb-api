package br.com.webmonitor.service;


import br.com.webmonitor.business.ServidorConfigDbBO;
import br.com.webmonitor.entity.ServidorConfigDb;
import br.com.webmonitor.repository.ServidorConfigDbRepository;
import br.com.webmonitor.service.Generic.InformacoesGenericService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Eduardo Balan on 30/06/2017.
 */
@RestController
@RequestMapping(path = "/servidor/{idServidor}/servidorconfiguracoesdb")
public class ServidorConfigDbServer extends InformacoesGenericService<ServidorConfigDb, ServidorConfigDbBO, ServidorConfigDbRepository> {

}
