package br.com.webmonitor.repository;

import br.com.webmonitor.entity.MonitoramentoPostgresInformacoes;
import br.com.webmonitor.repository.Generic.MonitoramentoGenericRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


/**
 * Created by Eduardo Balan on 28/06/2017.
 */
public interface MonitoramentoPostgresInformacoesRepository extends MonitoramentoGenericRepository<MonitoramentoPostgresInformacoes, Long> {

    @Override
    @Query("SELECT inf FROM MonitoramentoPostgresInformacoes inf WHERE inf.servidorConfigInformacoesDb.id = ?1")
    List<MonitoramentoPostgresInformacoes> findByidInformacoes(@Param("idServidorConfigInformacoesDb") Long idServidorConfigInformacoesDb);
}
