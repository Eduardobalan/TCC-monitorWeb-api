package br.com.webmonitor.service;

import br.com.webmonitor.business.DominioBO;
import br.com.webmonitor.entity.Dominio;
import br.com.webmonitor.repository.DominioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Eduardo Balan on 27/06/2017.
 */
@RestController
@RequestMapping(path = "/dominio")
public class DominioServer {

    @Autowired
    private DominioRepository dominioRepository ;

    @Autowired
    private DominioBO dominioBO;


    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public Dominio buscarPorId(@PathVariable("id") Long id){
        return dominioRepository.findOne(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Dominio> buscar(){
        List<Dominio> list = dominioRepository.findAll();
        return list;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Object salvar(@RequestBody Dominio dominio) {
       return dominioBO.salvar(dominio);
    }


    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public void excluir(@PathVariable("id") Long id) {
        dominioBO.excluir(id);
    }
}
