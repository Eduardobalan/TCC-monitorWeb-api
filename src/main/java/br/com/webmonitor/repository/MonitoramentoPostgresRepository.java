package br.com.webmonitor.repository;

import br.com.webmonitor.entity.MonitoramentoPostgres;
import br.com.webmonitor.repository.Generic.MonitoramentoGenericRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Eduardo Balan on 07/07/2017.
 */
public interface MonitoramentoPostgresRepository extends MonitoramentoGenericRepository<MonitoramentoPostgres, Long> {

    @Override
    @Query("SELECT mon FROM MonitoramentoPostgres mon WHERE mon.informacoesPostgres.id = ?1")
    List<MonitoramentoPostgres> findByidInformacoes(@Param("idInformacoes") Long idInformacoes);
}
