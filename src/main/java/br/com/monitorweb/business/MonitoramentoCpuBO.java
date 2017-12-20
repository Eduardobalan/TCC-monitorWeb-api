package br.com.monitorweb.business;

import br.com.monitorweb.business.generic.GenericBO;
import br.com.monitorweb.entity.MonitoramentoCpu;
import br.com.monitorweb.repository.MonitoramentoCpuRepository;
import org.springframework.stereotype.Component;

/**
 * Created by Eduardo Balan on 07/07/2017.
 */
@Component
public class MonitoramentoCpuBO extends GenericBO<MonitoramentoCpu, MonitoramentoCpuRepository> {
}
