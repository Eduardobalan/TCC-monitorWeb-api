package br.com.monitorweb.service;

import br.com.monitorweb.entity.Usuario;
import br.com.monitorweb.entity.UsuarioHasDominio;
import br.com.monitorweb.exception.SqlInexistenteRuntimeException;
import br.com.monitorweb.repository.UsuarioHasDominioRepository;
import br.com.monitorweb.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/usuariohasdominio")
    public class UsuarioHasDominioService {

    /* Repositorio responsavel*/
    @Autowired
    private UsuarioHasDominioRepository usuarioHasDominioRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<UsuarioHasDominio> buscar(){
        return usuarioHasDominioRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public Object buscarPorId(@PathVariable("id") Long id){
        Usuario UsuarioDaBusca = usuarioRepository.findOne(id);

        if(UsuarioDaBusca == null){
            throw new SqlInexistenteRuntimeException("Usuario não localizado.", null);
        }

        return usuarioHasDominioRepository.findByUsuario(UsuarioDaBusca);
    }
//
//    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
//    public void excluir(@PathVariable("id") Long id) {
//        business.excluir(id);
//    }
//
//    @RequestMapping(method = RequestMethod.POST)
//    public Entity inserir(@RequestBody Entity Entity) {
//        return business.inserir(Entity);
//    }
}
