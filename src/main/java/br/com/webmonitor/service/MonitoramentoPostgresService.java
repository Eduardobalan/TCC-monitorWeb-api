package br.com.webmonitor.service;

import br.com.webmonitor.business.MonitoramentoPostgresBO;
import br.com.webmonitor.entity.MonitoramentoPostgres;
import br.com.webmonitor.repository.MonitoramentoPostgresRepository;
import br.com.webmonitor.service.Generic.MonitoramentoGenericService;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Eduardo Balan on 07/07/2017.
 */
@RestController
@RequestMapping(path = "/servidor/informacoes/{idInformacoes}/monitoramentopostgres")
public class MonitoramentoPostgresService extends MonitoramentoGenericService<MonitoramentoPostgres, MonitoramentoPostgresBO, MonitoramentoPostgresRepository> {

}
