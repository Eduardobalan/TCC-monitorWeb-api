package br.com.webmonitor.service;

import br.com.webmonitor.business.DominioBO;
import br.com.webmonitor.entity.Dominio;
import br.com.webmonitor.repository.DominioRepository;
import javafx.beans.binding.BooleanExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Eduardo Balan on 27/06/2017.
 */
@CrossOrigin(origins = "http://127.0.0.1:8080")
@RestController
@RequestMapping(path = "/dominio")
public class DominioServer {

    @Autowired
    private DominioRepository dominioRepository ;

    @Autowired
    private DominioBO dominioBO;


    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public Object buscarPorId(@PathVariable("id") Long id){
        return dominioRepository.findById(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Dominio> buscar(){

        return dominioRepository.findAll();
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
