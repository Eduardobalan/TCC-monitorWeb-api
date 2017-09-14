package br.com.webmonitor.repository;

import br.com.webmonitor.entity.Dominio;
import br.com.webmonitor.entity.Usuario;
import br.com.webmonitor.entity.UsuarioHasDominio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import java.util.List;


/**
 * Created by Eduardo Balan on 28/06/2017.
 */
public interface UsuarioHasDominioRepository extends JpaRepository<UsuarioHasDominio, Long>, QueryDslPredicateExecutor<Usuario> {

    List<Usuario> findByUsuario(Usuario usuario);

    List<Dominio> findByDominio(Dominio dominio);
}
