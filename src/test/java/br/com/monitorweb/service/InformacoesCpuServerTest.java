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

@DatabaseSetup(value = InformacoesCpuServerTest.DATASET, type = DatabaseOperation.INSERT)
public class InformacoesCpuServerTest extends GenericTest {

    protected static final String DATASET = "classpath:/datasets/service/informacoesCpu.xml";

    @Resource
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setUp() {

        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void buscarTodosTest() throws Exception {
        mockMvc.perform(get("/servidor/0/informacoescpu"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].nome", is("I7")))
                .andExpect(jsonPath("$[0].cacheSize", is(516)))
                .andExpect(jsonPath("$[0].cpuCores", is(8)))
                .andExpect(jsonPath("$[0].siblings", is(16)))
                .andExpect(jsonPath("$[0].dthr_cadastro", is("2017-02-28T04:00:00.000+0000")))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[2].id", is(3)));
    }

    @Test
    public void buscarTodosPorServidorTest() throws Exception {
        mockMvc.perform(get("/servidor/1/informacoescpu"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].nome", is("I7")))
                .andExpect(jsonPath("$[0].cacheSize", is(516)))
                .andExpect(jsonPath("$[0].cpuCores", is(8)))
                .andExpect(jsonPath("$[0].siblings", is(16)))
                .andExpect(jsonPath("$[0].dthr_cadastro", is("2017-02-28T04:00:00.000+0000")))
                .andExpect(jsonPath("$[1].id", is(2)));
    }

    @Test
    public void buscarPorIdTest() throws Exception {
        mockMvc.perform(get("/servidor/0/informacoescpu/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.nome", is("I7")))
                .andExpect(jsonPath("$.cacheSize", is(516)))
                .andExpect(jsonPath("$.cpuCores", is(8)))
                .andExpect(jsonPath("$.siblings", is(16)))
                .andExpect(jsonPath("$.dthr_cadastro", is("2017-02-28T04:00:00.000+0000")));
    }

    @Test
    public void inserirTest() throws Exception {

        mockMvc.perform(post("/servidor/0/informacoescpu/").contentType(MediaType.APPLICATION_JSON_UTF8)
                .content("{ " +
                        " \"nome\" : \"I9\" ," +
                        " \"servidor\":{\"id\":2}," +
                        " \"cacheSize\" : 1024 ," +
                        " \"cpuCores\" : 16 ," +
                        " \"siblings\" : 32 }"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(4)))
                .andExpect(jsonPath("$.nome", is("I9")))
                .andExpect(jsonPath("$.cacheSize", is(1024)))
                .andExpect(jsonPath("$.cpuCores", is(16)))
                .andExpect(jsonPath("$.siblings", is(32)));
                //.andExpect(jsonPath("$.dthr_cadastro", is("2017-02-28T04:00:00.000+0000")));
    }

    @Test
    public void deletarTest() throws Exception {
        mockMvc.perform(delete("/servidor/0/informacoescpu/3"))
                .andExpect(status().isOk());

        mockMvc.perform(get("/servidor/0/informacoescpu/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[1].id", is(2)));
    }

    //----------------  Exception ----------------------------

    @Test
    public void deletarIdInexistenteTest() throws Exception {

        Exception expt = mockMvc.perform(delete("/servidor/0/informacoescpu/999999"))
                .andExpect(status().isInternalServerError())
                .andReturn().getResolvedException();

        Assert.assertTrue(expt.getClass().isAssignableFrom(SqlInexistenteRuntimeException.class));
        Assert.assertTrue(expt.getMessage().equals("Registro não encontrado na base de dados."));
    }

    @Test
    public void buscarIdInexistenteServidorTest() throws Exception {

        Exception expt =  mockMvc.perform(get("/servidor/99999999/informacoescpu"))
                .andExpect(status().isInternalServerError())
                .andReturn().getResolvedException();

        Assert.assertTrue(expt.getClass().isAssignableFrom(SqlInexistenteRuntimeException.class));
        Assert.assertTrue(expt.getMessage().equals("Servidor não localizado."));
    }
}


