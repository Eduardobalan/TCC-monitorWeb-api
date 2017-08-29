package br.com.webmonitor.service;

import br.com.webmonitor.business.MonitoramentoCpuBO;
import br.com.webmonitor.entity.MonitoramentoCpu;
import br.com.webmonitor.repository.MonitoramentoCpuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Eduardo Balan on 07/07/2017.
 */
@RestController
@RequestMapping(path = "/monitoramento/cpu")
public class MonitoramentoCpuService {

    @Autowired
    private MonitoramentoCpuRepository monitoramentoCpuRepository;

    @Autowired
    private MonitoramentoCpuBO monitoramentoCpuBO;

    @RequestMapping(method = RequestMethod.GET)
    public Object buscar(){
        return monitoramentoCpuRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET,  path = "/{id}")
    public Object buscarPorId(@PathVariable("id") Long id){
        return monitoramentoCpuRepository.findOne(id);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public Object salvar(@RequestBody MonitoramentoCpu info) {
        return monitoramentoCpuBO.salvar(info);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public void delete(@PathVariable("id") Long id){
        monitoramentoCpuBO.excluir(id);
    }

}
