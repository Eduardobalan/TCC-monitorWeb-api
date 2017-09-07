package br.com.webmonitor.business;

import br.com.webmonitor.business.generic.GenericBO;
import br.com.webmonitor.entity.MonitoramentoDB;
import br.com.webmonitor.repository.MonitoramentoDBRepository;
import org.springframework.stereotype.Component;

/**
 * Created by Eduardo Balan on 07/07/2017.
 */
@Component
public class MonitoramentoDBBO extends GenericBO<MonitoramentoDB, MonitoramentoDBRepository> {
}
