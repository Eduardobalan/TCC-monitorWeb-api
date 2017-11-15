package br.com.webmonitor.business;

import br.com.webmonitor.business.generic.GenericBO;
import br.com.webmonitor.entity.ServidorConfigDb;
import br.com.webmonitor.entity.ServidorConfigInformacoesDb;
import br.com.webmonitor.repository.ServidorConfigDbRepository;
import br.com.webmonitor.repository.ServidorConfigInformacoesDbRepository;
import org.springframework.stereotype.Component;

/**
 * Created by Eduardo Balan on 30/06/2017.
 */
@Component
public class ServidorConfigInformacoesDbBO extends GenericBO<ServidorConfigInformacoesDb, ServidorConfigInformacoesDbRepository> {

}
