package br.com.webmonitor.service;


import br.com.webmonitor.business.MonitoramentoMemoriaBO;
import br.com.webmonitor.entity.InformacoesMemoria;
import br.com.webmonitor.entity.MonitoramentoMemoria;
import br.com.webmonitor.repository.MonitoramentoMemoriaRepository;
import br.com.webmonitor.service.Generic.GenericService;
import br.com.webmonitor.service.Generic.MonitoramentoGenericService;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Eduardo Balan on 07/07/2017.
 */
@RestController
@RequestMapping(path = "/servidor/informacoes/{idInformacoes}/monitoramentomemoria")
public class MonitoramentoMemoriaService extends MonitoramentoGenericService<MonitoramentoMemoria, MonitoramentoMemoriaBO, MonitoramentoMemoriaRepository> {


}
