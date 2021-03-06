package br.com.monitorweb.repository.Generic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;


/**
 * Created by Eduardo Balan on 28/06/2017.
 */
@NoRepositoryBean
public interface MonitoramentoGenericRepository<Entity, IdType extends Serializable> extends JpaRepository<Entity, IdType>, QueryDslPredicateExecutor<Entity> {

    List<Entity> findByidInformacoes(Long id);
}
