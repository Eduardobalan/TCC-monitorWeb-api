package br.com.monitorweb.service;

import br.com.monitorweb.business.MonitoramentoPostgresBO;
import br.com.monitorweb.entity.MonitoramentoPostgres;
import br.com.monitorweb.repository.MonitoramentoPostgresRepository;
import br.com.monitorweb.service.Generic.MonitoramentoGenericService;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Eduardo Balan on 07/07/2017.
 */
@RestController
@RequestMapping(path = "/servidor/informacoes/{idInformacoes}/monitoramentopostgres")
public class MonitoramentoPostgresService extends MonitoramentoGenericService<MonitoramentoPostgres, MonitoramentoPostgresBO, MonitoramentoPostgresRepository> {

}
