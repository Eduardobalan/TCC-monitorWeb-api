package br.com.webmonitor.repository;

import br.com.webmonitor.entity.Dominio;
import br.com.webmonitor.entity.Servidor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import java.util.List;

/**
 * Created by Eduardo Balan on 28/06/2017.
 */
public interface DominioRepository  extends JpaRepository<Dominio, Long>, QueryDslPredicateExecutor<Dominio>  {

}
