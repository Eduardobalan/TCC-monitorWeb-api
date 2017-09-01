package br.com.webmonitor.repository.Generic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.io.Serializable;
import java.util.List;


/**
 * Created by Eduardo Balan on 28/06/2017.
 */
public interface MonitoramentoGenericRepository<Entity, IdType extends Serializable> extends JpaRepository<Entity, IdType>, QueryDslPredicateExecutor<Entity> {

//    @Query("SELECT et FROM Entity et WHERE et.Servidor.id = ?1")
//    List<Entity> findByServidor(IdType idServidor);
}
