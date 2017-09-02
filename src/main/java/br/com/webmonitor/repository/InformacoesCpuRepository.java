package br.com.webmonitor.repository;

import br.com.webmonitor.entity.InformacoesCpu;
import br.com.webmonitor.repository.Generic.InformacoesGenericRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



/**
 * Created by Eduardo Balan on 01/07/2017.
 */
public interface InformacoesCpuRepository extends InformacoesGenericRepository<InformacoesCpu, Long> {



}
