package br.com.monitorweb.business;

import br.com.monitorweb.business.generic.GenericBO;
import br.com.monitorweb.entity.ServidorConfig;
import br.com.monitorweb.repository.ServidorConfigRepository;
import org.springframework.stereotype.Component;

/**
 * Created by Eduardo Balan on 30/06/2017.
 */
@Component
public class ServidorConfigBO extends GenericBO<ServidorConfig, ServidorConfigRepository> {

}
