package br.com.webmonitor.business;

import br.com.webmonitor.entity.Servidor;
import br.com.webmonitor.exception.SqlGenericRuntimeException;
import br.com.webmonitor.repository.ServidorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Eduardo Balan on 30/06/2017.
 */
@Component
public class ServidorBO {

    @Autowired
    private ServidorRepository servidorRepository;

    public Object salvar(Servidor servidor){
        try{
            return servidorRepository.save(servidor);
        }catch (Exception e){
            throw new SqlGenericRuntimeException(e);
        }
    }

    public void excluir(Long id){
        try{
            servidorRepository.delete(id);
        }catch (Exception e){
            throw new SqlGenericRuntimeException(e);
        }
    }

}
