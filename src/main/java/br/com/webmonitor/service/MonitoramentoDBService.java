package br.com.webmonitor.service;

import br.com.webmonitor.business.MonitoramentoDBBO;
import br.com.webmonitor.entity.MonitoramentoDB;
import br.com.webmonitor.repository.MonitoramentoDBRepository;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Eduardo Balan on 07/07/2017.
 */
@RestController
@RequestMapping(path = "/monitoramento/db")
public class MonitoramentoDBService extends GenericService<MonitoramentoDB, MonitoramentoDBBO, MonitoramentoDBRepository>{

}
