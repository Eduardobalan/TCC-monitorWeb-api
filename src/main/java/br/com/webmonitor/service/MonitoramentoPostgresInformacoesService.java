package br.com.webmonitor.service;

import br.com.webmonitor.business.MonitoramentoPostgresInformacoesBO;
import br.com.webmonitor.entity.MonitoramentoPostgresInformacoes;
import br.com.webmonitor.repository.MonitoramentoPostgresInformacoesRepository;
import br.com.webmonitor.service.Generic.MonitoramentoGenericService;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Eduardo Balan on 01/07/2017.
 */

@RestController
@RequestMapping(path = "/servidor/informacoes/{idInformacoes}/monitoramentopostgresinformacoes")
public class MonitoramentoPostgresInformacoesService extends MonitoramentoGenericService<MonitoramentoPostgresInformacoes, MonitoramentoPostgresInformacoesBO, MonitoramentoPostgresInformacoesRepository> {

}
