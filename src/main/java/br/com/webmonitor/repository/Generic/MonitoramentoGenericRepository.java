package br.com.webmonitor.repository.Generic;

import br.com.webmonitor.entity.MonitoramentoMemoria;
import br.com.webmonitor.entity.Servidor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;

import java.io.Serializable;
import java.util.List;


/**
 * Created by Eduardo Balan on 28/06/2017.
 */
@NoRepositoryBean
public interface MonitoramentoGenericRepository<Entity, IdType extends Serializable> extends JpaRepository<Entity, IdType>, QueryDslPredicateExecutor<Entity> {

    List<Entity> findByidInformacoes(Long id);
}
