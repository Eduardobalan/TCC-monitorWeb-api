package br.com.webmonitor.service;

import br.com.webmonitor.business.MonitoramentoDBBO;
import br.com.webmonitor.entity.MonitoramentoDB;
import br.com.webmonitor.repository.MonitoramentoDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Eduardo Balan on 07/07/2017.
 */
@RestController
@RequestMapping(path = "/monitoramento/db")
public class MonitoramentoDBService {

    @Autowired
    private MonitoramentoDBRepository monitoramentoDBRepository;

    @Autowired
    private MonitoramentoDBBO monitoramentoDBBO;

    @RequestMapping(method = RequestMethod.GET)
    public Object buscar(){
        return monitoramentoDBRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET,  path = "/{id}")
    public Object buscarPorId(@PathVariable("id") Long id){
        return monitoramentoDBRepository.findByInformacoesDB(id);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public Object salvar(@RequestBody MonitoramentoDB info) {
        return monitoramentoDBBO.salvar(info);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public void delete(@PathVariable("id") Long id){
        monitoramentoDBBO.excluir(id);
    }

}
