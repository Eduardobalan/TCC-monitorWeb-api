package br.com.webmonitor.business;

import br.com.webmonitor.business.generic.GenericBO;
import br.com.webmonitor.entity.MonitoramentoPostgres;
import br.com.webmonitor.repository.MonitoramentoPostgresRepository;
import org.springframework.stereotype.Component;

/**
 * Created by Eduardo Balan on 07/07/2017.
 */
@Component
public class MonitoramentoPostgresBO extends GenericBO<MonitoramentoPostgres, MonitoramentoPostgresRepository> {
}
