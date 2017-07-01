package br.com.webmonitor.service;

import br.com.webmonitor.business.InformacoesMemoriaBO;
import br.com.webmonitor.entity.InformacoesMemoria;
import br.com.webmonitor.repository.InformacoesMemoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Eduardo Balan on 01/07/2017.
 */

@RestController
@RequestMapping(path = "/informacoes/memoria")
public class InformacoesMemoriaService {

    @Autowired
    private InformacoesMemoriaBO informacoesMemoriaBO;

    @Autowired
    private InformacoesMemoriaRepository informacoesMemoriaRepository;

    @RequestMapping(method = RequestMethod.GET)
    public Object buscar(){
        return informacoesMemoriaRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET,  path = "/{id}")
    public Object buscarPorId(@PathVariable("id") Long id){
        return informacoesMemoriaRepository.findOne(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Object salvar(@RequestBody InformacoesMemoria info) {
        return informacoesMemoriaBO.salvar(info);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public void delete(@PathVariable("id") Long id){
        informacoesMemoriaBO.excluir(id);
    }
}
