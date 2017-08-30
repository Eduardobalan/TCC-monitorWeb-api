package br.com.webmonitor.repository;

import br.com.webmonitor.entity.Servidor;
import br.com.webmonitor.entity.ServidorConfig;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Eduardo Balan on 28/06/2017.
 */
public interface ServidorConfigRepository extends JpaRepository<ServidorConfig, Long> {

}
