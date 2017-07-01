package br.com.webmonitor.service;

import br.com.webmonitor.business.ServidorBO;
import br.com.webmonitor.entity.Servidor;
import br.com.webmonitor.repository.ServidorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Eduardo Balan on 30/06/2017.
 */
@RestController
@RequestMapping(path = "/servidor")
public class ServidorServer {

    @Autowired
    private ServidorBO servidorBO;
    
    @Autowired
    private ServidorRepository servidorRepository;

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public Servidor buscarPorId(@PathVariable("id") Long id){
        return servidorRepository.findOne(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Object buscar(){
        return servidorRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Object salvar(@RequestBody Servidor servidor) {
        return servidorBO.salvar(servidor);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public void excluir(@PathVariable("id") Long id) {
        servidorBO.excluir(id);
    }

}
