package br.com.webmonitor.service;


import br.com.webmonitor.business.MonitoramentoMemoriaBO;
import br.com.webmonitor.business.MonitoramentoSwapBO;
import br.com.webmonitor.entity.MonitoramentoMemoria;
import br.com.webmonitor.entity.MonitoramentoSwap;
import br.com.webmonitor.repository.MonitoramentoMemoriaRepository;
import br.com.webmonitor.repository.MonitoramentoSwapRepository;
import br.com.webmonitor.service.Generic.MonitoramentoGenericService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Eduardo Balan on 07/07/2017.
 */
@RestController
@RequestMapping(path = "/servidor/informacoes/{idInformacoes}/monitoramentoswap")
public class MonitoramentoSwapService extends MonitoramentoGenericService<MonitoramentoSwap, MonitoramentoSwapBO, MonitoramentoSwapRepository> {


}
