package br.com.webmonitor.repository;

import br.com.webmonitor.entity.Servidor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by Eduardo Balan on 28/06/2017.
 */
public interface ServidorRepository extends JpaRepository<Servidor, Long> {

    //@Query("SELECT c FROM BancadaMembro c JOIN FETCH c.sessaoLegislativa JOIN FETCH c.parlamentar WHERE c.id = ?1")
    //BancadaMembro buscarObjetoCompleto(Long bancadaMembroId);

    //@Query("SELECT Srv FROM Servidor Srv WHERE Srv.id = ?1")
    @Query("SELECT s FROM Servidor s WHERE s.id = ?1")
    Servidor findById(Long id);


}
