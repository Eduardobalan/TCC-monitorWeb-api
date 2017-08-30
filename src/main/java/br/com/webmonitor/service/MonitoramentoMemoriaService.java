package br.com.webmonitor.service;


import br.com.webmonitor.business.MonitoramentoMemoriaBO;
import br.com.webmonitor.entity.MonitoramentoMemoria;
import br.com.webmonitor.repository.MonitoramentoMemoriaRepository;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Eduardo Balan on 07/07/2017.
 */
@RestController
@RequestMapping(path = "/monitoramento/memoria")
public class MonitoramentoMemoriaService extends GenericService<MonitoramentoMemoria, MonitoramentoMemoriaBO, MonitoramentoMemoriaRepository> {

}
