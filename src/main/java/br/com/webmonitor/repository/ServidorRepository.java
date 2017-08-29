package br.com.webmonitor.repository;

import br.com.webmonitor.entity.Servidor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Eduardo Balan on 28/06/2017.
 */
public interface ServidorRepository extends JpaRepository<Servidor, Long> {

//    @Query("SELECT s FROM Servidor s LEFT JOIN FETCH s.dominio WHERE s.id = ?1")
//    Servidor findById(Long id);
//
//    @Query("SELECT s FROM Servidor s WHERE s.id = ?1")
//    Servidor findById2(Long id);

}
