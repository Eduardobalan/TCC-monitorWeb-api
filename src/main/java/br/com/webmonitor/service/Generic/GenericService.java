package br.com.webmonitor.service.Generic;

import br.com.webmonitor.business.GenericBO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.*;

import javax.persistence.MappedSuperclass;
import java.util.List;


/**
 * Created by Eduardo Balan on 27/06/2017.
 */
@MappedSuperclass
public class GenericService<Entity, Business extends GenericBO<Entity, Repository>, Repository extends JpaRepository<Entity, Long>> {

    @Autowired
    public Business business;

    @Autowired
    public Repository repository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Entity> buscar(){
        return repository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public Object buscarPorId(@PathVariable("id") Long id){
        return repository.findOne(id);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public void excluir(@PathVariable("id") Long id) {
        business.excluir(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Entity inserir(@RequestBody Entity Entity) {
       return business.salvar(Entity);
    }
}
