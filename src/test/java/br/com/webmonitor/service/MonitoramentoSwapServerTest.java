package br.com.webmonitor.service;

import br.com.webmonitor.GenericTest;
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

@DatabaseSetup(value = MonitoramentoSwapServerTest.DATASET, type = DatabaseOperation.INSERT)
public class MonitoramentoSwapServerTest extends GenericTest {

    protected static final String DATASET = "classpath:/datasets/service/monitoramentoSwap.xml";

    @Resource
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setUp() {

        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void buscarTodosTest() throws Exception {
        mockMvc.perform(get("/servidor/informacoes/0/monitoramentoswap"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(4)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].informacoesSwap.id", is(1)))
                .andExpect(jsonPath("$[0].free", is(20000)))
                .andExpect(jsonPath("$[0].cached", is(21100)))
                .andExpect(jsonPath("$[0].dthr_cadastro", is("2017-02-28T04:00:00.000+0000")))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[2].id", is(3)))
                .andExpect(jsonPath("$[3].id", is(4)));
    }

    @Test
    public void buscarTodosPorInformacoesTest() throws Exception {
        mockMvc.perform(get("/servidor/informacoes/1/monitoramentoswap"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].informacoesSwap.id", is(1)))
                .andExpect(jsonPath("$[0].free", is(20000)))
                .andExpect(jsonPath("$[0].cached", is(21100)))
                .andExpect(jsonPath("$[0].dthr_cadastro", is("2017-02-28T04:00:00.000+0000")))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].informacoesSwap.id", is(1)))
                .andExpect(jsonPath("$[1].free", is(19000)));
    }

    @Test
    public void buscarPorIdTest() throws Exception {
        mockMvc.perform(get("/servidor/informacoes/0/monitoramentoswap/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.informacoesSwap.id", is(1)))
                .andExpect(jsonPath("$.free", is(20000)))
                .andExpect(jsonPath("$.cached", is(21100)))
                .andExpect(jsonPath("$.dthr_cadastro", is("2017-02-28T04:00:00.000+0000")));
    }

    @Test
    public void inserirTest() throws Exception {

        mockMvc.perform(post("/servidor/informacoes/0/monitoramentoswap/").contentType(MediaType.APPLICATION_JSON_UTF8)
                .content("{ " +
                        " \"informacoesSwap\":{\"id\":3}," +
                        " \"free\" : 40000 ," +
                        " \"cached\" : 40100 ," +
                        " \"dthr_cadastro\" : \"2017-02-28T04:00:00.000+0000\" }"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.informacoesSwap.id", is(3)))
                .andExpect(jsonPath("$.free", is(40000)))
                .andExpect(jsonPath("$.cached", is(40100)))
                .andExpect(jsonPath("$.dthr_cadastro", is("2017-02-28T04:00:00.000+0000")));
    }

    @Test
    public void deletarTest() throws Exception {
        mockMvc.perform(delete("/servidor/informacoes/0/monitoramentoswap/3"))
                .andExpect(status().isOk());

        mockMvc.perform(get("/servidor/informacoes/0/monitoramentoswap/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[2].id", is(4)));
    }

    //----------------  Exception ----------------------------

    @Test
    public void deletarIdInexistenteTest() throws Exception {

        Exception expt = mockMvc.perform(delete("/servidor/informacoes/0/monitoramentoswap/999999"))
                .andExpect(status().isInternalServerError())
                .andReturn().getResolvedException();

        Assert.assertTrue(expt.getClass().isAssignableFrom(SqlInexistenteRuntimeException.class));
        Assert.assertTrue(expt.getMessage().equals("Registro não encontrado na base de dados."));
    }
}