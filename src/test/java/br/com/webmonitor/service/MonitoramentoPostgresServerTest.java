package br.com.webmonitor.service;

import br.com.webmonitor.GenericTest;
import br.com.webmonitor.enumeration.EnumSgdbTipoExec;
import br.com.webmonitor.exception.SqlInexistenteRuntimeException;
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

@DatabaseSetup(value = MonitoramentoPostgresServerTest.DATASET, type = DatabaseOperation.INSERT)
public class MonitoramentoPostgresServerTest extends GenericTest {

    protected static final String DATASET = "classpath:/datasets/service/monitoramentoPostgres.xml";

    @Resource
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setUp() {

        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void buscarTodosTest() throws Exception {
        mockMvc.perform(get("/servidor/informacoes/0/monitoramentopostgres"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(4)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].servidorConfigDb.id", is(1)))
                .andExpect(jsonPath("$[0].tipoExecucao", is(EnumSgdbTipoExec.BACKUP.toString())))
                .andExpect(jsonPath("$[0].exito", is(0)))
                .andExpect(jsonPath("$[0].mensagem", is("Completado com sucesso")))
                .andExpect(jsonPath("$[0].dthr_cadastro", is("2017-02-28T04:00:00.000+0000")))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].tipoExecucao", is(EnumSgdbTipoExec.BACKUP.toString())))
                .andExpect(jsonPath("$[2].id", is(3)))
                .andExpect(jsonPath("$[2].tipoExecucao", is(EnumSgdbTipoExec.VACUUM.toString())))
                .andExpect(jsonPath("$[3].id", is(4)))
                .andExpect(jsonPath("$[3].tipoExecucao", is(EnumSgdbTipoExec.VACUUM.toString())));
    }

    @Test
    public void buscarTodosPorInformacoesTest() throws Exception {
        mockMvc.perform(get("/servidor/informacoes/1/monitoramentopostgres"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].servidorConfigDb.id", is(1)))
                .andExpect(jsonPath("$[0].tipoExecucao", is(EnumSgdbTipoExec.BACKUP.toString())))
                .andExpect(jsonPath("$[0].exito", is(0)))
                .andExpect(jsonPath("$[0].mensagem", is("Completado com sucesso")))
                .andExpect(jsonPath("$[0].dthr_cadastro", is("2017-02-28T04:00:00.000+0000")))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].servidorConfigDb.id", is(1)))
                .andExpect(jsonPath("$[1].tipoExecucao", is(EnumSgdbTipoExec.BACKUP.toString())))
                .andExpect(jsonPath("$[1].exito", is(233)));
    }

    @Test
    public void buscarPorIdTest() throws Exception {
        mockMvc.perform(get("/servidor/informacoes/0/monitoramentopostgres/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.servidorConfigDb.id", is(1)))
                .andExpect(jsonPath("$.tipoExecucao", is(EnumSgdbTipoExec.BACKUP.toString())))
                .andExpect(jsonPath("$.exito", is(0)))
                .andExpect(jsonPath("$.mensagem", is("Completado com sucesso")))
                .andExpect(jsonPath("$.dthr_cadastro", is("2017-02-28T04:00:00.000+0000")));
    }

    @Test
    public void inserirTest() throws Exception {

        mockMvc.perform(post("/servidor/informacoes/0/monitoramentopostgres/").contentType(MediaType.APPLICATION_JSON_UTF8)
                .content("{ " +
                        " \"servidorConfigDb\":{\"id\":3}," +
                        " \"tipoExecucao\" : \"BACKUP\" ," +
                        " \"dbmp_exito\" : 0 ," +
                        " \"mensagem\" : \"Exito ao executar o backup\" ," +
                        " \"dthr_cadastro\" : \"2017-02-28T04:00:00.000+0000\" }"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(5)))
                .andExpect(jsonPath("$.servidorConfigDb.id", is(3)))
                .andExpect(jsonPath("$.tipoExecucao", is(EnumSgdbTipoExec.BACKUP.toString())))
                .andExpect(jsonPath("$.exito", is(0)))
                .andExpect(jsonPath("$.mensagem", is("Exito ao executar o backup")));
               // .andExpect(jsonPath("$.dthr_cadastro", is("2017-02-28T04:00:00.000+0000")));
    }

    @Test
    public void deletarTest() throws Exception {
        mockMvc.perform(delete("/servidor/informacoes/0/monitoramentopostgres/3"))
                .andExpect(status().isOk());

        mockMvc.perform(get("/servidor/informacoes/0/monitoramentopostgres/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[2].id", is(4)));
    }

    //----------------  Exception ----------------------------

    @Test
    public void deletarIdInexistenteTest() throws Exception {

        Exception expt = mockMvc.perform(delete("/servidor/informacoes/0/monitoramentopostgres/999999"))
                .andExpect(status().isInternalServerError())
                .andReturn().getResolvedException();

        Assert.assertTrue(expt.getClass().isAssignableFrom(SqlInexistenteRuntimeException.class));
        Assert.assertTrue(expt.getMessage().equals("Registro não encontrado na base de dados."));
    }
}


