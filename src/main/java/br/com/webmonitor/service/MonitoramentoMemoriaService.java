package br.com.webmonitor.service;

import br.com.webmonitor.business.MonitoramentoMemoriaBO;
import br.com.webmonitor.entity.InformacoesMemoria;
import br.com.webmonitor.entity.MonitoramentoMemoria;
import br.com.webmonitor.repository.MonitoramentoMemoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Eduardo Balan on 07/07/2017.
 */
@RestController
@RequestMapping(path = "/monitoramento/memoria")
public class MonitoramentoMemoriaService {

    @Autowired
    private MonitoramentoMemoriaRepository monitoramentoMemoriaRepository;

    @Autowired
    private MonitoramentoMemoriaBO monitoramentoMemoriaBO;

    @RequestMapping(method = RequestMethod.GET)
    public Object buscar(){
        return monitoramentoMemoriaRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET,  path = "/{id}")
    public Object buscarPorId(@PathVariable("id") Long id){
        return monitoramentoMemoriaRepository.findOne(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Object salvar(@RequestBody MonitoramentoMemoria info) {
        return monitoramentoMemoriaBO.salvar(info);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public void delete(@PathVariable("id") Long id){
        monitoramentoMemoriaBO.excluir(id);
    }

}
