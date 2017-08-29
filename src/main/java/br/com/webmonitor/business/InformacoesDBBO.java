package br.com.webmonitor.business;

import br.com.webmonitor.entity.InformacoesDB;
import br.com.webmonitor.exception.SqlGenericRuntimeException;
import br.com.webmonitor.repository.InformacoesDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Eduardo Balan on 01/07/2017.
 */
@Component
public class InformacoesDBBO {

    @Autowired
    private InformacoesDBRepository informacoesDBRepository;

    public Object salvar(InformacoesDB informacoesDB){
        try{
            return informacoesDBRepository.save(informacoesDB);
        }catch (Exception e){
            throw new SqlGenericRuntimeException(e);
        }
    }

    public void excluir(long id){
        try{
            informacoesDBRepository.delete(id);
        }catch (Exception e){
            throw new SqlGenericRuntimeException(e);
        }
    }

}
