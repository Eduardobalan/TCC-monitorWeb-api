package br.com.monitorweb.repository;

import br.com.monitorweb.entity.MonitoramentoCpu;
import br.com.monitorweb.repository.Generic.MonitoramentoGenericRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


/**
 * Created by Eduardo Balan on 07/07/2017.
 */
public interface MonitoramentoCpuRepository extends MonitoramentoGenericRepository<MonitoramentoCpu, Long> {

    @Override
    @Query("SELECT mon FROM MonitoramentoCpu mon WHERE mon.informacoesCpu.id = ?1")
    List<MonitoramentoCpu> findByidInformacoes(@Param("idInformacoes") Long idInformacoes);
}
