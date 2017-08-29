package br.com.webmonitor.repository;

import br.com.webmonitor.entity.InformacoesCpu;
import br.com.webmonitor.entity.InformacoesDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Eduardo Balan on 01/07/2017.
 */
public interface InformacoesDBRepository extends JpaRepository<InformacoesDB, Long> {

    @Query("SELECT s FROM InformacoesDB s WHERE s.id = ?1")
    InformacoesDB findOne(Long id);

    @Query("SELECT s FROM InformacoesDB s")
    List<InformacoesDB> findAll();
}
