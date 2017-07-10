package br.com.webmonitor.business;

import br.com.webmonitor.entity.InformacoesMemoria;
import br.com.webmonitor.exception.SqlGenericRuntimeException;
import br.com.webmonitor.repository.InformacoesMemoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Eduardo Balan on 01/07/2017.
 */
@Component
public class InformacoesMemoriaBO {

    @Autowired
    private InformacoesMemoriaRepository informacoesMemoriaRepository;

    public Object salvar(InformacoesMemoria informacoesMemoria){
        try{
            return informacoesMemoriaRepository.save(informacoesMemoria);
        }catch (Exception e){
            throw new SqlGenericRuntimeException(e);
        }
    }

    public void excluir(long id){
        try{
            informacoesMemoriaRepository.delete(id);
        }catch (Exception e){
            throw new SqlGenericRuntimeException(e);
        }
    }

}
