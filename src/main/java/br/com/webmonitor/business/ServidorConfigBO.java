package br.com.webmonitor.business;

import br.com.webmonitor.entity.Servidor;
import br.com.webmonitor.entity.ServidorConfig;
import br.com.webmonitor.repository.ServidorConfigRepository;
import br.com.webmonitor.repository.ServidorRepository;
import org.springframework.stereotype.Component;

/**
 * Created by Eduardo Balan on 30/06/2017.
 */
@Component
public class ServidorConfigBO extends GenericBO<ServidorConfig, ServidorConfigRepository> {

}
