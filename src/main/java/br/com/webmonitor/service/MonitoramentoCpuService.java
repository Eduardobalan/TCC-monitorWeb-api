package br.com.webmonitor.service;

import br.com.webmonitor.business.MonitoramentoCpuBO;
import br.com.webmonitor.entity.MonitoramentoCpu;
import br.com.webmonitor.repository.MonitoramentoCpuRepository;
import br.com.webmonitor.service.Generic.GenericService;
import br.com.webmonitor.service.Generic.MonitoramentoGenericService;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Eduardo Balan on 07/07/2017.
 */
@RestController
@RequestMapping(path = "/servidor/informacoes/{idInformacoes}/monitoramentocpu")
public class MonitoramentoCpuService extends MonitoramentoGenericService<MonitoramentoCpu, MonitoramentoCpuBO, MonitoramentoCpuRepository> {

}
