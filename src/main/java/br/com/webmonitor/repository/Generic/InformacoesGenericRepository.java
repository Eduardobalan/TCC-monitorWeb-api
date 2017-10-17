package br.com.webmonitor.repository.Generic;

import br.com.webmonitor.entity.Servidor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;


/**
 * Created by Eduardo Balan on 28/06/2017.
 */
@NoRepositoryBean
public interface InformacoesGenericRepository<Entity, IdType extends Serializable> extends JpaRepository<Entity, IdType>, QueryDslPredicateExecutor<Entity> {

    List<Entity> findByServidor(Servidor Servidor);

//    @Query("SELECT s FROM  Servidor where s.serv_id = ?1")
//    Servidor findServidor(Long id);
}
