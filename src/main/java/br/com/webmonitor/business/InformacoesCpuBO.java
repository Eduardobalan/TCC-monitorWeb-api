package br.com.webmonitor.business;

import br.com.webmonitor.entity.InformacoesCpu;
import br.com.webmonitor.exception.SqlGenericRuntimeException;
import br.com.webmonitor.repository.InformacoesCpuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Eduardo Balan on 01/07/2017.
 */
@Component
public class InformacoesCpuBO {

    @Autowired
    private InformacoesCpuRepository informacoesCpuRepository;

    public Object salvar(InformacoesCpu informacoesCpu){
        try{
            return informacoesCpuRepository.save(informacoesCpu);
        }catch (Exception e){
            throw new SqlGenericRuntimeException(e);
        }
    }

    public void excluir(long id){
        try{
            informacoesCpuRepository.delete(id);
        }catch (Exception e){
            throw new SqlGenericRuntimeException(e);
        }
    }

}
