package br.com.webmonitor.repository;

import br.com.webmonitor.entity.InformacoesCpu;
import br.com.webmonitor.entity.InformacoesMemoria;
import br.com.webmonitor.entity.Servidor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import java.util.List;

/**
 * Created by Eduardo Balan on 01/07/2017.
 */
public interface InformacoesCpuRepository extends JpaRepository<InformacoesCpu, Long>, QueryDslPredicateExecutor<InformacoesCpu> {


}
