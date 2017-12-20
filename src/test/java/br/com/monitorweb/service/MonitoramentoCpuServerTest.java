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

@DatabaseSetup(value = MonitoramentoCpuServerTest.DATASET, type = DatabaseOperation.INSERT)
public class MonitoramentoCpuServerTest extends GenericTest {

    protected static final String DATASET = "classpath:/datasets/service/monitoramentoCpu.xml";

    @Resource
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setUp() {

        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void buscarTodosTest() throws Exception {
        mockMvc.perform(get("/servidor/informacoes/0/monitoramentocpu"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(4)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].informacoesCpu.id", is(1)))
                .andExpect(jsonPath("$[0].informacoesCpu.nome", is("I7")))
                .andExpect(jsonPath("$[0].coreId", is(16)))
                .andExpect(jsonPath("$[0].cpuMhz", is(3200)))
                .andExpect(jsonPath("$[0].dthr_cadastro", is("2017-02-28T04:00:00.000+0000")))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[2].id", is(3)))
                .andExpect(jsonPath("$[3].id", is(4)));
    }

    @Test
    public void buscarTodosPorInformacoesTest() throws Exception {
        mockMvc.perform(get("/servidor/informacoes/1/monitoramentocpu"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].informacoesCpu.id", is(1)))
                .andExpect(jsonPath("$[0].informacoesCpu.nome", is("I7")))
                .andExpect(jsonPath("$[0].coreId", is(16)))
                .andExpect(jsonPath("$[0].cpuMhz", is(3200)))
                .andExpect(jsonPath("$[0].dthr_cadastro", is("2017-02-28T04:00:00.000+0000")))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].informacoesCpu.id", is(1)))
                .andExpect(jsonPath("$[1].informacoesCpu.nome", is("I7")))
                .andExpect(jsonPath("$[1].coreId", is(8)));
    }

    @Test
    public void buscarPorIdTest() throws Exception {
        mockMvc.perform(get("/servidor/informacoes/0/monitoramentocpu/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.informacoesCpu.id", is(1)))
                .andExpect(jsonPath("$.informacoesCpu.nome", is("I7")))
                .andExpect(jsonPath("$.coreId", is(16)))
                .andExpect(jsonPath("$.cpuMhz", is(3200)))
                .andExpect(jsonPath("$.dthr_cadastro", is("2017-02-28T04:00:00.000+0000")));
    }

    @Test
    public void inserirTest() throws Exception {

        mockMvc.perform(post("/servidor/informacoes/0/monitoramentocpu/").contentType(MediaType.APPLICATION_JSON_UTF8)
                .content("{ " +
                        " \"nome\" : \"I9\" ," +
                        " \"informacoesCpu\":{\"id\":3}," +
                        //" \"dthr_cadastro\" : \"2017-02-28T04:00:00.000+0000\" ," +
                        " \"coreId\" : 1 ," +
                        " \"cpuMhz\" : 3300 }"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(5)))
                .andExpect(jsonPath("$.informacoesCpu.id", is(3)))
                .andExpect(jsonPath("$.coreId", is(1)))
                .andExpect(jsonPath("$.cpuMhz", is(3300)));
                //.andExpect(jsonPath("$.dthr_cadastro", is("2017-02-28T04:00:00.000+0000")));
    }

    @Test
    public void deletarTest() throws Exception {
        mockMvc.perform(delete("/servidor/informacoes/0/monitoramentocpu/3"))
                .andExpect(status().isOk());

        mockMvc.perform(get("/servidor/informacoes/0/monitoramentocpu/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[2].id", is(4)));
    }

    //----------------  Exception ----------------------------

    @Test
    public void deletarIdInexistenteTest() throws Exception {

        Exception expt = mockMvc.perform(delete("/servidor/informacoes/0/monitoramentocpu/999999"))
                .andExpect(status().isInternalServerError())
                .andReturn().getResolvedException();

        Assert.assertTrue(expt.getClass().isAssignableFrom(SqlInexistenteRuntimeException.class));
        Assert.assertTrue(expt.getMessage().equals("Registro não encontrado na base de dados."));
    }
}


