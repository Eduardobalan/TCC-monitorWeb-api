package br.com.webmonitor.service;

import br.com.webmonitor.GenericTest;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * Created by Eduardo Balan on 27/06/2017.
 */

@DatabaseSetup(value = UsuarioHasDominioServerTest.DATASET, type = DatabaseOperation.INSERT)
public class UsuarioHasDominioServerTest extends GenericTest{

    protected static final String DATASET = "classpath:/datasets/service/usuarioHasDominio.xml";

    @Resource
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setUp() {

        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void buscarTodosTest() throws Exception {
        mockMvc.perform(get("/usuariohasdominio"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].usuario.id", is(1)))
                .andExpect(jsonPath("$[0].usuario.dthr_cadastro", is("2017-02-28T04:00:00.000+0000")))
                .andExpect(jsonPath("$[0].usuario.nome", is("Eduardo")))
                .andExpect(jsonPath("$[0].usuario.sobrenome", is("Balan")))
                .andExpect(jsonPath("$[0].usuario.login", is("Eduardo Balan")))
                .andExpect(jsonPath("$[0].usuario.email", is("Eduardo_balan1@hotmail.com")))
                .andExpect(jsonPath("$[0].usuario.senha", is("102030")))
                .andExpect(jsonPath("$[0].usuario.sexo", is("MASCULINO")))
                .andExpect(jsonPath("$[0].dominio.id", is(1)))
                .andExpect(jsonPath("$[0].dominio.nome", is("Cliente")))
                .andExpect(jsonPath("$[0].dominio.observacao", is("Cliente normal")))

                .andExpect(jsonPath("$[1].usuario.id", is(2)))
                .andExpect(jsonPath("$[1].usuario.dthr_cadastro", is("2017-02-28T04:00:00.000+0000")))
                .andExpect(jsonPath("$[1].usuario.nome", is("karol")))
                .andExpect(jsonPath("$[1].usuario.sobrenome", is("Jeronimo")))
                .andExpect(jsonPath("$[1].usuario.login", is("KAROL JERONIMO")))
                .andExpect(jsonPath("$[1].usuario.email", is("KAROLJERONIMO@hotmail.com")))
                .andExpect(jsonPath("$[1].usuario.senha", is("301020")))
                .andExpect(jsonPath("$[1].usuario.sexo", is("FEMININO")))
                .andExpect(jsonPath("$[1].dominio.id", is(1)))
                .andExpect(jsonPath("$[1].dominio.nome", is("Cliente")))
                .andExpect(jsonPath("$[1].dominio.observacao", is("Cliente normal")))

                .andExpect(jsonPath("$[2].usuario.id", is(1)))
                .andExpect(jsonPath("$[2].usuario.dthr_cadastro", is("2017-02-28T04:00:00.000+0000")))
                .andExpect(jsonPath("$[2].usuario.nome", is("Eduardo")))
                .andExpect(jsonPath("$[2].usuario.sobrenome", is("Balan")))
                .andExpect(jsonPath("$[2].usuario.login", is("Eduardo Balan")))
                .andExpect(jsonPath("$[2].usuario.email", is("Eduardo_balan1@hotmail.com")))
                .andExpect(jsonPath("$[2].usuario.senha", is("102030")))
                .andExpect(jsonPath("$[2].usuario.sexo", is("MASCULINO")))
                .andExpect(jsonPath("$[2].dominio.id", is(2)))
                .andExpect(jsonPath("$[2].dominio.nome", is("Super Cliente")))
                .andExpect(jsonPath("$[2].dominio.observacao", is("Sempre cuidar muito desses clientes")))
        ;
    }

    @Test
    public void buscarPorIdTest() throws Exception {
        mockMvc.perform(get("/usuariohasdominio/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].usuario.id", is(1)))
                .andExpect(jsonPath("$[0].usuario.dthr_cadastro", is("2017-02-28T04:00:00.000+0000")))
                .andExpect(jsonPath("$[0].usuario.nome", is("Eduardo")))
                .andExpect(jsonPath("$[0].usuario.sobrenome", is("Balan")))
                .andExpect(jsonPath("$[0].usuario.login", is("Eduardo Balan")))
                .andExpect(jsonPath("$[0].usuario.email", is("Eduardo_balan1@hotmail.com")))
                .andExpect(jsonPath("$[0].usuario.senha", is("102030")))
                .andExpect(jsonPath("$[0].usuario.sexo", is("MASCULINO")))
                .andExpect(jsonPath("$[0].dominio.id", is(1)))
                .andExpect(jsonPath("$[0].dominio.nome", is("Cliente")))
                .andExpect(jsonPath("$[0].dominio.observacao", is("Cliente normal")))

                .andExpect(jsonPath("$[1].usuario.id", is(1)))
                .andExpect(jsonPath("$[1].usuario.dthr_cadastro", is("2017-02-28T04:00:00.000+0000")))
                .andExpect(jsonPath("$[1].usuario.nome", is("Eduardo")))
                .andExpect(jsonPath("$[1].usuario.sobrenome", is("Balan")))
                .andExpect(jsonPath("$[1].usuario.login", is("Eduardo Balan")))
                .andExpect(jsonPath("$[1].usuario.email", is("Eduardo_balan1@hotmail.com")))
                .andExpect(jsonPath("$[1].usuario.senha", is("102030")))
                .andExpect(jsonPath("$[1].usuario.sexo", is("MASCULINO")))
                .andExpect(jsonPath("$[1].dominio.id", is(2)))
                .andExpect(jsonPath("$[1].dominio.nome", is("Super Cliente")))
                .andExpect(jsonPath("$[1].dominio.observacao", is("Sempre cuidar muito desses clientes")));
    }

    //----------------  Exception ----------------------------

}


