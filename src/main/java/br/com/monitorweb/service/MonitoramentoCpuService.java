package br.com.monitorweb.service;

import br.com.monitorweb.business.MonitoramentoCpuBO;
import br.com.monitorweb.entity.MonitoramentoCpu;
import br.com.monitorweb.repository.MonitoramentoCpuRepository;
import br.com.monitorweb.service.Generic.MonitoramentoGenericService;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Eduardo Balan on 07/07/2017.
 */
@RestController
@RequestMapping(path = "/servidor/informacoes/{idInformacoes}/monitoramentocpu")
public class MonitoramentoCpuService extends MonitoramentoGenericService<MonitoramentoCpu, MonitoramentoCpuBO, MonitoramentoCpuRepository> {

}
