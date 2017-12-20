package br.com.monitorweb.service;


import br.com.monitorweb.business.MonitoramentoMemoriaBO;
import br.com.monitorweb.entity.MonitoramentoMemoria;
import br.com.monitorweb.repository.MonitoramentoMemoriaRepository;
import br.com.monitorweb.service.Generic.MonitoramentoGenericService;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Eduardo Balan on 07/07/2017.
 */
@RestController
@RequestMapping(path = "/servidor/informacoes/{idInformacoes}/monitoramentomemoria")
public class MonitoramentoMemoriaService extends MonitoramentoGenericService<MonitoramentoMemoria, MonitoramentoMemoriaBO, MonitoramentoMemoriaRepository> {


}
