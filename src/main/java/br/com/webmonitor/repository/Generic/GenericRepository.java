package br.com.webmonitor.repository.Generic;

import br.com.webmonitor.entity.Dominio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import java.io.Serializable;


/**
 * Created by Eduardo Balan on 28/06/2017.
 */
public interface GenericRepository<Entity, IdType extends Serializable> extends JpaRepository<Entity, IdType>, QueryDslPredicateExecutor<Entity> {


}
