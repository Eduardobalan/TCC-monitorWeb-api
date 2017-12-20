package br.com.monitorweb.service;

import br.com.monitorweb.GenericTest;
import br.com.monitorweb.enumeration.EnumSgdb;
import br.com.monitorweb.exception.SqlInexistenteRuntimeException;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
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

@DatabaseSetup(value = ServidorConfigInformacoesDbServerTest.DATASET, type = DatabaseOperation.INSERT)
public class ServidorConfigInformacoesDbServerTest extends GenericTest {

    protected static final String DATASET = "classpath:/datasets/service/servidorConfigInformacoesDb.xml";

    @Resource
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setUp() {

        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void buscarTodosTest() throws Exception {
        mockMvc.perform(get("/servidor/0/servidorconfiguracoesinformacoesdb"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].servidor.id", is(1)))
                .andExpect(jsonPath("$[0].nomeSgdb", is(EnumSgdb.POSTGRESQL.toString())))
                .andExpect(jsonPath("$[0].intervaloExec", is(3600)))
                .andExpect(jsonPath("$[0].ativo", is(true)))
                .andExpect(jsonPath("$[0].pathMain", is("/etc/postgres/9.6/main")))
                .andExpect(jsonPath("$[0].dthr_alteracao", is("2017-02-28T04:00:00.000+0000")))
                .andExpect(jsonPath("$[0].dthr_cadastro", is("2017-02-28T04:00:00.000+0000")))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].servidor.id", is(1)))
                .andExpect(jsonPath("$[1].nomeSgdb", is(EnumSgdb.POSTGRESQL.toString())))
                .andExpect(jsonPath("$[1].intervaloExec", is(7200)))
                .andExpect(jsonPath("$[1].ativo", is(true)))
                .andExpect(jsonPath("$[1].pathMain", is("/etc/postgres/9.1/main")))
                .andExpect(jsonPath("$[2].id", is(3)))
                .andExpect(jsonPath("$[2].servidor.id", is(3)))
                .andExpect(jsonPath("$[2].nomeSgdb", is(EnumSgdb.POSTGRESQL.toString())))
                .andExpect(jsonPath("$[2].intervaloExec", is(14400)))
                .andExpect(jsonPath("$[2].ativo", is(false)))
                .andExpect(jsonPath("$[2].pathMain", is("/etc/postgres/8.4/main")));
    }

    @Test
    public void buscarTodosPorServidorTest() throws Exception {
        mockMvc.perform(get("/servidor/1/servidorconfiguracoesinformacoesdb"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].servidor.id", is(1)))
                .andExpect(jsonPath("$[0].nomeSgdb", is(EnumSgdb.POSTGRESQL.toString())))
                .andExpect(jsonPath("$[0].intervaloExec", is(3600)))
                .andExpect(jsonPath("$[0].dthr_alteracao", is("2017-02-28T04:00:00.000+0000")))
                .andExpect(jsonPath("$[0].dthr_cadastro", is("2017-02-28T04:00:00.000+0000")))
                .andExpect(jsonPath("$[0].ativo", is(true)))
                .andExpect(jsonPath("$[0].pathMain", is("/etc/postgres/9.6/main")))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].servidor.id", is(1)))
                .andExpect(jsonPath("$[1].nomeSgdb", is(EnumSgdb.POSTGRESQL.toString())))
                .andExpect(jsonPath("$[1].intervaloExec", is(7200)))
                .andExpect(jsonPath("$[1].ativo", is(true)))
                .andExpect(jsonPath("$[1].pathMain", is("/etc/postgres/9.1/main")));
    }

    @Test
    public void buscarPorIdTest() throws Exception {
        mockMvc.perform(get("/servidor/0/servidorconfiguracoesinformacoesdb/1"))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.servidor.id", is(1)))
                .andExpect(jsonPath("$.nomeSgdb", is(EnumSgdb.POSTGRESQL.toString())))
                .andExpect(jsonPath("$.pathMain", is("/etc/postgres/9.6/main")))
                .andExpect(jsonPath("$.intervaloExec", is(3600)))
                .andExpect(jsonPath("$.ativo", is(true)))
                .andExpect(jsonPath("$.dthr_alteracao", is("2017-02-28T04:00:00.000+0000")))
                .andExpect(jsonPath("$.dthr_cadastro", is("2017-02-28T04:00:00.000+0000")));
    }

    @Test
    public void inserirTest() throws Exception {

        mockMvc.perform(post("/servidor/0/servidorconfiguracoesinformacoesdb/").contentType(MediaType.APPLICATION_JSON_UTF8)
                .content("{ " +
                        " \"servidor\":{\"id\":2}," +
                        " \"nomeSgdb\" : \"POSTGRESQL\" ," +
                        " \"pathMain\" : \"/etc/postgres/9.8/main\" ," +
                        " \"ativo\" : true," +
                        " \"intervaloExec\" : 9999 }"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(4)))
                .andExpect(jsonPath("$.servidor.id", is(2)))
                .andExpect(jsonPath("$.nomeSgdb", is(EnumSgdb.POSTGRESQL.toString())))
                .andExpect(jsonPath("$.pathMain", is("/etc/postgres/9.8/main")))
                .andExpect(jsonPath("$.intervaloExec", is(9999)))
                .andExpect(jsonPath("$.ativo", is(true)));
    }

    @Test
    public void deletarTest() throws Exception {
        mockMvc.perform(delete("/servidor/0/servidorconfiguracoesinformacoesdb/3"))
                .andExpect(status().isOk());

        mockMvc.perform(get("/servidor/0/servidorconfiguracoesinformacoesdb/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[1].id", is(2)));
    }

    //----------------  Exception ----------------------------

    @Test
    public void deletarIdInexistenteTest() throws Exception {

        Exception expt = mockMvc.perform(delete("/servidor/0/servidorconfiguracoesinformacoesdb/999999"))
                .andExpect(status().isInternalServerError())
                .andReturn().getResolvedException();

        Assert.assertTrue(expt.getClass().isAssignableFrom(SqlInexistenteRuntimeException.class));
        Assert.assertTrue(expt.getMessage().equals("Registro não encontrado na base de dados."));
    }
}


