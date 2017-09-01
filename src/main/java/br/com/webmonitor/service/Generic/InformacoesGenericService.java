package br.com.webmonitor.service.Generic;

import br.com.webmonitor.business.GenericBO;
import br.com.webmonitor.entity.Servidor;
import br.com.webmonitor.repository.Generic.InformacoesGenericRepository;
import br.com.webmonitor.repository.Generic.MonitoramentoGenericRepository;
import br.com.webmonitor.repository.ServidorRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
public class InformacoesGenericService<Entity, Business extends GenericBO<Entity, Repository>, Repository extends InformacoesGenericRepository<Entity, Long>> {

    @Autowired
    public Business business;

    @Autowired
    public Repository repository;


    @Autowired
    public ServidorRepository servidorRepository;


    @RequestMapping(method = RequestMethod.GET)
    public List<Entity> buscarPorIdServidor(@PathVariable("idServidor") Long idServidor){
        if(idServidor>0){
            Servidor servidorDaBusca = servidorRepository.findOne(idServidor);
            return repository.findByServidor(servidorDaBusca);
        }else{
            return repository.findAll();
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{idMonitoramento}")
    public Entity buscarPorIdMonitoramento(@PathVariable("idMonitoramento") Long id){
        return repository.findOne(id);
    }

//    @RequestMapping(method = RequestMethod.GET, path = {"/{idServidor}, /{idMonitoramento}"})
//    public Entity buscarPorId(@PathVariable("idServidor") Long idServidor,
//                              @PathVariable("idMonitoramento") Long idMonitoramento){
//        return repository.findOne(idMonitoramento);
//    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{idMonitoramento}")
    public void excluir(@PathVariable("id") Long id) {
        business.excluir(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Entity inserir(@RequestBody Entity Entity) {
       return business.salvar(Entity);
    }
}