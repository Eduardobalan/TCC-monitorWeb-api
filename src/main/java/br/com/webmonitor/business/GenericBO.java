package br.com.webmonitor.business;


import br.com.webmonitor.entity.InterfaceGenericEntity;
import br.com.webmonitor.exception.SqlGenericRuntimeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;


import javax.persistence.MappedSuperclass;


/**
 * Created by Eduardo Balan on 29/08/2017.
 */
@MappedSuperclass
public class GenericBO <Entity, Repository extends JpaRepository<Entity, Long>> {

    @Autowired
    private Repository repository;

    public Entity salvar(Entity entity){
        try{
            return repository.save(entity);
        }catch (Exception e){
            throw new SqlGenericRuntimeException(e);
        }
    }


    public void excluir(Long id){
        try{
            repository.delete(id);
        }catch (Exception e){
            throw new SqlGenericRuntimeException(e);
        }
    }

}
