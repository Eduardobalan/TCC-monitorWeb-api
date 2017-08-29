package br.com.webmonitor.service;

import br.com.webmonitor.business.InformacoesCpuBO;
import br.com.webmonitor.entity.InformacoesCpu;
import br.com.webmonitor.repository.InformacoesCpuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Eduardo Balan on 01/07/2017.
 */

@RestController
@RequestMapping(path = "/informacoes/cpu")
public class InformacoesCpuService {

    @Autowired
    private InformacoesCpuBO informacoesCpuBO;

    @Autowired
    private InformacoesCpuRepository informacoesCpuRepository;

    @RequestMapping(method = RequestMethod.GET)
    public Object buscar(){
        return informacoesCpuRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET,  path = "/{id}")
    public Object buscarPorId(@PathVariable("id") Long id){
        return informacoesCpuRepository.findOne(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Object salvar(@RequestBody InformacoesCpu info) {
        return informacoesCpuBO.salvar(info);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public void delete(@PathVariable("id") Long id){
        informacoesCpuBO.excluir(id);
    }
}
