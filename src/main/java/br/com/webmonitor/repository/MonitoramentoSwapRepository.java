package br.com.webmonitor.repository;

import br.com.webmonitor.entity.MonitoramentoMemoria;
import br.com.webmonitor.entity.MonitoramentoSwap;
import br.com.webmonitor.repository.Generic.MonitoramentoGenericRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Eduardo Balan on 07/07/2017.
 */
public interface MonitoramentoSwapRepository extends MonitoramentoGenericRepository<MonitoramentoSwap, Long> {

    @Override
    @Query("SELECT mon FROM MonitoramentoSwap mon WHERE mon.informacoesSwap.id = ?1")
    List<MonitoramentoSwap> findByidInformacoes(@Param("idInformacoes") Long idInformacoes);
}
