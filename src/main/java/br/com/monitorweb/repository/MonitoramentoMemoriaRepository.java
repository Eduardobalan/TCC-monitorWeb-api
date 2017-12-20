package br.com.monitorweb.repository;

import br.com.monitorweb.entity.MonitoramentoMemoria;
import br.com.monitorweb.repository.Generic.MonitoramentoGenericRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Eduardo Balan on 07/07/2017.
 */
public interface MonitoramentoMemoriaRepository extends MonitoramentoGenericRepository<MonitoramentoMemoria, Long> {

    @Override
    @Query("SELECT mon FROM MonitoramentoMemoria mon WHERE mon.informacoesMemoria.id = ?1")
    List<MonitoramentoMemoria> findByidInformacoes(@Param("idInformacoes") Long idInformacoes);
}
