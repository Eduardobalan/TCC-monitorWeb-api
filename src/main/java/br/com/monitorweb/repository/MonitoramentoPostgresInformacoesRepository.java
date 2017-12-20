package br.com.monitorweb.repository;

import br.com.monitorweb.entity.MonitoramentoPostgresInformacoes;
import br.com.monitorweb.repository.Generic.MonitoramentoGenericRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


/**
 * Created by Eduardo Balan on 28/06/2017.
 */
public interface MonitoramentoPostgresInformacoesRepository extends MonitoramentoGenericRepository<MonitoramentoPostgresInformacoes, Long> {

    @Override
    @Query("SELECT inf FROM MonitoramentoPostgresInformacoes inf WHERE inf.servidorConfigInformacoesDb.id = ?1")
    List<MonitoramentoPostgresInformacoes> findByidInformacoes(Long id);
}
