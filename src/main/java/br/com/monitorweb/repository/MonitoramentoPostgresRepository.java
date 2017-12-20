package br.com.monitorweb.repository;

import br.com.monitorweb.entity.MonitoramentoPostgres;
import br.com.monitorweb.repository.Generic.MonitoramentoGenericRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Eduardo Balan on 07/07/2017.
 */
public interface MonitoramentoPostgresRepository extends MonitoramentoGenericRepository<MonitoramentoPostgres, Long> {

    @Override
    @Query("SELECT mon FROM MonitoramentoPostgres mon WHERE mon.servidorConfigDb.id = ?1")
    List<MonitoramentoPostgres> findByidInformacoes(@Param("idServidorConfigDb") Long idServidorConfigDb);
}
