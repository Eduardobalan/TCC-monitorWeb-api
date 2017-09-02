package br.com.webmonitor.repository;

import br.com.webmonitor.entity.InformacoesDB;
import br.com.webmonitor.entity.MonitoramentoDB;
import br.com.webmonitor.entity.MonitoramentoMemoria;
import br.com.webmonitor.repository.Generic.MonitoramentoGenericRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Eduardo Balan on 07/07/2017.
 */
public interface MonitoramentoDBRepository extends MonitoramentoGenericRepository<MonitoramentoDB, Long> {

    @Override
    @Query("SELECT mon FROM MonitoramentoDB mon WHERE mon.informacoesDB.id = ?1")
    List<MonitoramentoDB> findByidInformacoes(@Param("idInformacoes") Long idInformacoes);
}
