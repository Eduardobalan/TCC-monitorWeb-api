package br.com.monitorweb.service;


import br.com.monitorweb.business.MonitoramentoSwapBO;
import br.com.monitorweb.entity.MonitoramentoSwap;
import br.com.monitorweb.repository.MonitoramentoSwapRepository;
import br.com.monitorweb.service.Generic.MonitoramentoGenericService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Eduardo Balan on 07/07/2017.
 */
@RestController
@RequestMapping(path = "/servidor/informacoes/{idInformacoes}/monitoramentoswap")
public class MonitoramentoSwapService extends MonitoramentoGenericService<MonitoramentoSwap, MonitoramentoSwapBO, MonitoramentoSwapRepository> {


}
