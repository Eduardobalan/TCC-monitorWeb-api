package br.com.webmonitor.repository;

import br.com.webmonitor.entity.InformacoesDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;


/**
 * Created by Eduardo Balan on 28/06/2017.
 */
public interface InformacoesDBRepository  extends JpaRepository<InformacoesDB, Long>, QueryDslPredicateExecutor<InformacoesDB>  {

}
