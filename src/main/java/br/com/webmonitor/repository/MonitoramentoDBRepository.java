package br.com.webmonitor.repository;

import br.com.webmonitor.entity.MonitoramentoDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import java.util.List;

/**
 * Created by Eduardo Balan on 07/07/2017.
 */
public interface MonitoramentoDBRepository extends JpaRepository<MonitoramentoDB, Long>, QueryDslPredicateExecutor<MonitoramentoDB> {

}
