package br.com.webmonitor.business;

import br.com.webmonitor.entity.MonitoramentoCpu;
import br.com.webmonitor.exception.SqlGenericRuntimeException;
import br.com.webmonitor.repository.MonitoramentoCpuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Eduardo Balan on 07/07/2017.
 */
@Component
public class MonitoramentoCpuBO {

    @Autowired
    private MonitoramentoCpuRepository monitoramentoCpuRepository;

    public Object salvar(MonitoramentoCpu monitoramentoCpu){
        try{
            return monitoramentoCpuRepository.save(monitoramentoCpu);
        }catch (Exception e){
            throw new SqlGenericRuntimeException(e);
        }
    }

    public void excluir(long id){
        try{
            monitoramentoCpuRepository.delete(id);
        }catch (Exception e){
            throw new SqlGenericRuntimeException(e);
        }
    }
}
