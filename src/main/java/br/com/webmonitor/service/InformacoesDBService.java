package br.com.webmonitor.service;

import br.com.webmonitor.business.InformacoesDBBO;
import br.com.webmonitor.entity.InformacoesCpu;
import br.com.webmonitor.entity.InformacoesDB;
import br.com.webmonitor.repository.InformacoesDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Eduardo Balan on 01/07/2017.
 */

@RestController
@RequestMapping(path = "/informacoes/db")
public class InformacoesDBService {

    @Autowired
    private InformacoesDBBO informacoesDBBO;

    @Autowired
    private InformacoesDBRepository informacoesDBRepository;

    @RequestMapping(method = RequestMethod.GET)
    public Object buscar(){
        return informacoesDBRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET,  path = "/{id}")
    public Object buscarPorId(@PathVariable("id") Long id){
        return informacoesDBRepository.findOne(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Object salvar(@RequestBody InformacoesDB info) {
        return informacoesDBBO.salvar(info);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public void delete(@PathVariable("id") Long id){
        informacoesDBBO.excluir(id);
    }
}
