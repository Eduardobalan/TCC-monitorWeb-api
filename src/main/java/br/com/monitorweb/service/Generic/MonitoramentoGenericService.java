package br.com.monitorweb.service.Generic;

import br.com.monitorweb.business.generic.GenericBO;
import br.com.monitorweb.entity.Generic.GenericEntity;
import br.com.monitorweb.entity.Servidor;
import br.com.monitorweb.exception.SqlInexistenteRuntimeException;
import br.com.monitorweb.repository.Generic.MonitoramentoGenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.persistence.MappedSuperclass;
import java.util.List;


/**
 * Class de service MonitoramentoGenericService é responsavel pelos serviços genericos do tipo Monitoramento.
 *
 * @author Eduardo Balan
 *
 * @param Entity Entidade a qual ela ira prestar o servico.
 * @param Business Business responsavel pela regras de servico da entidade.
 * @param Repository Repositorio responsavel pela Entity que vc esta utilizando.
 *
 * @throws SqlInexistenteRuntimeException
 * @throws SqlGenericRuntimeException
 *
 */
@MappedSuperclass
public class MonitoramentoGenericService<Entity extends GenericEntity, Business extends GenericBO<Entity, Repository>, Repository extends MonitoramentoGenericRepository<Entity, Long>> {

    /* Regras de servico da Entity.*/
    @Autowired
    private Business business;

    /* Repositorio responsavel pela Entity.*/
    @Autowired
    private Repository repository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Entity> buscarPorIdServidor(@PathVariable("idInformacoes") Long idInformacoes){
        if(idInformacoes<=0){
            return repository.findAll();
        }else{
            return repository.findByidInformacoes(idInformacoes);
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{idMonitoramento}")
    public Entity buscarPorIdMonitoramento(@PathVariable("idMonitoramento") Long idMonitoramento){
        return repository.findOne(idMonitoramento);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{idMonitoramento}")
    public void excluir(@PathVariable("idMonitoramento") Long idMonitoramento) {
        business.excluir(idMonitoramento);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Entity inserir(@RequestBody Entity Entity) {
        return business.inserir(Entity);
    }
}
