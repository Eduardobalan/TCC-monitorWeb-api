package br.com.monitorweb.service;

import br.com.monitorweb.GenericTest;
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

@DatabaseSetup(value = MonitoramentoPostgresInformacoesTest.DATASET, type = DatabaseOperation.INSERT)
public class MonitoramentoPostgresInformacoesTest extends GenericTest {

    protected static final String DATASET = "classpath:/datasets/service/MonitoramentoPostgresInformacoes.xml";

    @Resource
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setUp() {

        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void buscarTodosTest() throws Exception {
        mockMvc.perform(get("/servidor/informacoes/0/monitoramentopostgresinformacoes"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].servidorConfigInformacoesDb.id", is(1)))
                .andExpect(jsonPath("$[0].listenAddresses", is("*")))
                .andExpect(jsonPath("$[0].port", is("5432")))
                .andExpect(jsonPath("$[0].maxConnections", is("100")))
                .andExpect(jsonPath("$[0].ssl", is("true")))
                .andExpect(jsonPath("$[0].sharedBuffers", is("128MB")))
                .andExpect(jsonPath("$[0].tempBuffers", is("8MB")))
                .andExpect(jsonPath("$[0].workMem", is("4MB")))
                .andExpect(jsonPath("$[0].maintenanceWorkMem", is("64MB")))
                .andExpect(jsonPath("$[0].replacementWortTuples", is("true")))
                .andExpect(jsonPath("$[0].maxStackDepth", is("2MB")))
                .andExpect(jsonPath("$[0].maxPreparedTransactions", is("0")))
                .andExpect(jsonPath("$[0].dthr_cadastro", is("2017-02-28T04:00:00.000+0000")))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].servidorConfigInformacoesDb.id", is(1)))
                .andExpect(jsonPath("$[2].id", is(3)))
                .andExpect(jsonPath("$[2].servidorConfigInformacoesDb.id", is(3)));
    }

    @Test
    public void buscarTodosPorServidorTest() throws Exception {
        mockMvc.perform(get("/servidor/informacoes/1/monitoramentopostgresinformacoes"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].servidorConfigInformacoesDb.id", is(1)))
                .andExpect(jsonPath("$[0].listenAddresses", is("*")))
                .andExpect(jsonPath("$[0].port", is("5432")))
                .andExpect(jsonPath("$[0].maxConnections", is("100")))
                .andExpect(jsonPath("$[0].ssl", is("true")))
                .andExpect(jsonPath("$[0].sharedBuffers", is("128MB")))
                .andExpect(jsonPath("$[0].tempBuffers", is("8MB")))
                .andExpect(jsonPath("$[0].workMem", is("4MB")))
                .andExpect(jsonPath("$[0].maintenanceWorkMem", is("64MB")))
                .andExpect(jsonPath("$[0].replacementWortTuples", is("true")))
                .andExpect(jsonPath("$[0].maxStackDepth", is("2MB")))
                .andExpect(jsonPath("$[0].maxPreparedTransactions", is("0")))
                .andExpect(jsonPath("$[0].dthr_cadastro", is("2017-02-28T04:00:00.000+0000")))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].servidorConfigInformacoesDb.id", is(1)));
    }

    @Test
    public void buscarPorIdTest() throws Exception {
        mockMvc.perform(get("/servidor/informacoes/0/monitoramentopostgresinformacoes/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.servidorConfigInformacoesDb.id", is(1)))
                .andExpect(jsonPath("$.listenAddresses", is("*")))
                .andExpect(jsonPath("$.port", is("5432")))
                .andExpect(jsonPath("$.maxConnections", is("100")))
                .andExpect(jsonPath("$.ssl", is("true")))
                .andExpect(jsonPath("$.sharedBuffers", is("128MB")))
                .andExpect(jsonPath("$.tempBuffers", is("8MB")))
                .andExpect(jsonPath("$.workMem", is("4MB")))
                .andExpect(jsonPath("$.maintenanceWorkMem", is("64MB")))
                .andExpect(jsonPath("$.replacementWortTuples", is("true")))
                .andExpect(jsonPath("$.maxStackDepth", is("2MB")))
                .andExpect(jsonPath("$.maxPreparedTransactions", is("0")))
                .andExpect(jsonPath("$.dthr_cadastro", is("2017-02-28T04:00:00.000+0000")));
    }

    @Test
    public void inserirTest() throws Exception {

        mockMvc.perform(post("/servidor/informacoes/0/monitoramentopostgresinformacoes").contentType(MediaType.APPLICATION_JSON_UTF8)
                .content("{ " +
                        " \"servidorConfigInformacoesDb\":{\"id\":2}," +
                        " \"listenAddresses\" : \"*\"," +
                        " \"port\" : \"5432\"," +
                        " \"maxConnections\" : \"100\"," +
                        " \"ssl\" : \"true\"," +
                        " \"sharedBuffers\" : \"128MB\"," +
                        " \"tempBuffers\" : \"8MB\"," +
                        " \"workMem\" : \"4MB\"," +
                        " \"maintenanceWorkMem\" : \"64MB\"," +
                        " \"replacementWortTuples\" : \"true\"," +
                        " \"maxStackDepth\" : \"2MB\"," +
                        " \"maxPreparedTransactions\" : \"0\"," +
                        " \"maxStackDepth\" : \"2MB\"" +
                        "}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(4)))
                .andExpect(jsonPath("$.servidorConfigInformacoesDb.id", is(2)))
                .andExpect(jsonPath("$.listenAddresses", is("*")))
                .andExpect(jsonPath("$.port", is("5432")))
                .andExpect(jsonPath("$.maxConnections", is("100")))
                .andExpect(jsonPath("$.ssl", is("true")))
                .andExpect(jsonPath("$.sharedBuffers", is("128MB")))
                .andExpect(jsonPath("$.tempBuffers", is("8MB")))
                .andExpect(jsonPath("$.workMem", is("4MB")))
                .andExpect(jsonPath("$.maintenanceWorkMem", is("64MB")))
                .andExpect(jsonPath("$.replacementWortTuples", is("true")))
                .andExpect(jsonPath("$.maxStackDepth", is("2MB")))
                .andExpect(jsonPath("$.maxPreparedTransactions", is("0")));

    }

    @Test
    public void deletarTest() throws Exception {
        mockMvc.perform(delete("/servidor/informacoes/0/monitoramentopostgresinformacoes/3"))
                .andExpect(status().isOk());

        mockMvc.perform(get("/servidor/informacoes/0/monitoramentopostgresinformacoes"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[1].id", is(2)));
    }

    //----------------  Exception ----------------------------

    @Test
    public void deletarIdInexistenteTest() throws Exception {

        Exception expt = mockMvc.perform(delete("/servidor/informacoes/0/monitoramentopostgresinformacoes/999999"))
                .andExpect(status().isInternalServerError())
                .andReturn().getResolvedException();

        Assert.assertTrue(expt.getClass().isAssignableFrom(SqlInexistenteRuntimeException.class));
        Assert.assertTrue(expt.getMessage().equals("Registro não encontrado na base de dados."));
    }
}


