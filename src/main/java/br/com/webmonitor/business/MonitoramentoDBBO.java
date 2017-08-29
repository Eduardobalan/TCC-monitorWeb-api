package br.com.webmonitor.business;

import br.com.webmonitor.entity.MonitoramentoCpu;
import br.com.webmonitor.entity.MonitoramentoDB;
import br.com.webmonitor.exception.SqlGenericRuntimeException;
import br.com.webmonitor.repository.MonitoramentoCpuRepository;
import br.com.webmonitor.repository.MonitoramentoDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Eduardo Balan on 07/07/2017.
 */
@Component
public class MonitoramentoDBBO {

    @Autowired
    private MonitoramentoDBRepository monitoramentoDBRepository;

    public Object salvar(MonitoramentoDB monitoramentoDB){
        try{
            return monitoramentoDBRepository.save(monitoramentoDB);
        }catch (Exception e){
            throw new SqlGenericRuntimeException(e);
        }
    }

    public void excluir(long id){
        try{
            monitoramentoDBRepository.delete(id);
        }catch (Exception e){
            throw new SqlGenericRuntimeException(e);
        }
    }
}
