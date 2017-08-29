package br.com.webmonitor.repository;

import br.com.webmonitor.entity.InformacoesMemoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by Eduardo Balan on 01/07/2017.
 */
public interface InformacoesMemoriaRepository extends JpaRepository<InformacoesMemoria, Long> {

}
