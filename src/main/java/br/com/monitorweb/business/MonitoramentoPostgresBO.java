package br.com.monitorweb.business;

import br.com.monitorweb.business.generic.GenericBO;
import br.com.monitorweb.entity.MonitoramentoPostgres;
import br.com.monitorweb.repository.MonitoramentoPostgresRepository;
import org.springframework.stereotype.Component;

/**
 * Created by Eduardo Balan on 07/07/2017.
 */
@Component
public class MonitoramentoPostgresBO extends GenericBO<MonitoramentoPostgres, MonitoramentoPostgresRepository> {
}
