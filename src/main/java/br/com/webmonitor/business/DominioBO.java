package br.com.webmonitor.business;

import br.com.webmonitor.entity.Dominio;
import br.com.webmonitor.exception.GenericRuntimeException;
import br.com.webmonitor.exception.SqlGenericRuntimeException;
import br.com.webmonitor.repository.DominioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Eduardo Balan on 29/06/2017.
 */

@Component
public class DominioBO {

    @Autowired
    private DominioRepository dominioRepository ;

    public Object salvar(Dominio dominio){
        try{
            return dominioRepository.save(dominio);
        }catch (Exception e){
            throw new SqlGenericRuntimeException(e);
        }
    }

    public void excluir(long id){
        try{
            dominioRepository.delete(id);
        }catch (Exception e){
            throw new SqlGenericRuntimeException(e);
        }
    }
}
