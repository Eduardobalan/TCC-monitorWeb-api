package br.com.monitorweb.service;

import br.com.monitorweb.business.MonitoramentoPostgresInformacoesBO;
import br.com.monitorweb.entity.MonitoramentoPostgresInformacoes;
import br.com.monitorweb.repository.MonitoramentoPostgresInformacoesRepository;
import br.com.monitorweb.service.Generic.MonitoramentoGenericService;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Eduardo Balan on 01/07/2017.
 */

@RestController
@RequestMapping(path = "/servidor/informacoes/{idInformacoes}/monitoramentopostgresinformacoes")
public class MonitoramentoPostgresInformacoesService extends MonitoramentoGenericService<MonitoramentoPostgresInformacoes, MonitoramentoPostgresInformacoesBO, MonitoramentoPostgresInformacoesRepository> {

}
