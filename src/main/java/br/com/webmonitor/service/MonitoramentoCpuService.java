package br.com.webmonitor.service;

import br.com.webmonitor.business.MonitoramentoCpuBO;
import br.com.webmonitor.entity.MonitoramentoCpu;
import br.com.webmonitor.repository.MonitoramentoCpuRepository;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Eduardo Balan on 07/07/2017.
 */
@RestController
@RequestMapping(path = "/monitoramento/cpu")
public class MonitoramentoCpuService extends GenericService<MonitoramentoCpu, MonitoramentoCpuBO, MonitoramentoCpuRepository>{

}
