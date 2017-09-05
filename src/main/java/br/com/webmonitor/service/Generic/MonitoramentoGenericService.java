package br.com.webmonitor.service.Generic;

import br.com.webmonitor.business.GenericBO;
import br.com.webmonitor.entity.Servidor;
import br.com.webmonitor.exception.GenericRuntimeException;
import br.com.webmonitor.repository.Generic.MonitoramentoGenericRepository;
import br.com.webmonitor.repository.ServidorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.persistence.MappedSuperclass;
import java.util.List;


/**
 * Created by Eduardo Balan on 27/06/2017.
 */
@MappedSuperclass
public class MonitoramentoGenericService<Entity, Business extends GenericBO<Entity, Repository>, Repository extends MonitoramentoGenericRepository<Entity, Long>> {

    @Autowired
    public Business business;

    @Autowired
    public Repository repository;


    @RequestMapping(method = RequestMethod.GET)
    public List<Entity> buscarPorIdServidor(@PathVariable("idInformacoes") Long idServidor){
        if(idServidor>0){
            return repository.findByidInformacoes(idServidor);
        }else{
            return repository.findAll();
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{idInformacoes}")
    public Entity buscarPorIdMonitoramento(@PathVariable("idInformacoes") Long idMonitoramento){
        return repository.findOne(idMonitoramento);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{idInformacoes}")
    public void excluir(@PathVariable("idInformacoes") Long idInformacoes) {
        business.excluir(idInformacoes);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Entity inserir(@RequestBody Entity Entity) {
        return business.inserir(Entity);
    }
}
