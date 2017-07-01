package br.com.webmonitor.business;

import br.com.webmonitor.entity.MonitoramentoMemoria;
import br.com.webmonitor.exception.SqlGenericRuntimeException;
import br.com.webmonitor.repository.MonitoramentoMemoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Eduardo Balan on 07/07/2017.
 */
@Component
public class MonitoramentoMemoriaBO {


    @Autowired
    private MonitoramentoMemoriaRepository monitoramentoMemoriaRepository;

    public Object salvar(MonitoramentoMemoria monitoramentoMemoria){
        try{
            return monitoramentoMemoriaRepository.save(monitoramentoMemoria);
        }catch (Exception e){
            throw new SqlGenericRuntimeException(e);
        }
    }

    public void excluir(long id){
        try{
            monitoramentoMemoriaRepository.delete(id);
        }catch (Exception e){
            throw new SqlGenericRuntimeException(e);
        }
    }
}
