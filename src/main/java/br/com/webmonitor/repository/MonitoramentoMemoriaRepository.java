package br.com.webmonitor.repository;

import br.com.webmonitor.entity.MonitoramentoMemoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Eduardo Balan on 07/07/2017.
 */
public interface MonitoramentoMemoriaRepository extends JpaRepository<MonitoramentoMemoria, Long> {

    @Query("SELECT mm FROM MonitoramentoMemoria mm LEFT JOIN FETCH mm.informacoesMemoria inf WHERE inf.id = ?1")
    List<MonitoramentoMemoria> findByInformacoesMemoria(Long id);
}
