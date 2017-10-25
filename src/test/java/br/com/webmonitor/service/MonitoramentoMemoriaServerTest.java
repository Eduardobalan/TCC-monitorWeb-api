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

@DatabaseSetup(value = MonitoramentoMemoriaServerTest.DATASET, type = DatabaseOperation.INSERT)
public class MonitoramentoMemoriaServerTest extends GenericTest {

    protected static final String DATASET = "classpath:/datasets/service/monitoramentoMemoria.xml";

    @Resource
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setUp() {

        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void buscarTodosTest() throws Exception {
        mockMvc.perform(get("/servidor/informacoes/0/monitoramentomemoria"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(4)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].informacoesMemoria.id", is(1)))
                .andExpect(jsonPath("$[0].active", is(16000)))
                .andExpect(jsonPath("$[0].memfree", is(8000)))
                .andExpect(jsonPath("$[0].availabre", is(100)))
                .andExpect(jsonPath("$[0].buffers", is(10)))
                .andExpect(jsonPath("$[0].dthr_cadastro", is("2017-02-28T04:00:00.000+0000")))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[2].id", is(3)))
                .andExpect(jsonPath("$[3].id", is(4)));
    }

    @Test
    public void buscarTodosPorInformacoesTest() throws Exception {
        mockMvc.perform(get("/servidor/informacoes/1/monitoramentomemoria"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].informacoesMemoria.id", is(1)))
                .andExpect(jsonPath("$[0].active", is(16000)))
                .andExpect(jsonPath("$[0].memfree", is(8000)))
                .andExpect(jsonPath("$[0].availabre", is(100)))
                .andExpect(jsonPath("$[0].buffers", is(10)))
                .andExpect(jsonPath("$[0].dthr_cadastro", is("2017-02-28T04:00:00.000+0000")))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].informacoesMemoria.id", is(1)))
                .andExpect(jsonPath("$[1].active", is(8000)));
    }

    @Test
    public void buscarPorIdTest() throws Exception {
        mockMvc.perform(get("/servidor/informacoes/0/monitoramentomemoria/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.informacoesMemoria.id", is(1)))
                .andExpect(jsonPath("$.active", is(16000)))
                .andExpect(jsonPath("$.memfree", is(8000)))
                .andExpect(jsonPath("$.availabre", is(100)))
                .andExpect(jsonPath("$.buffers", is(10)))
                .andExpect(jsonPath("$.dthr_cadastro", is("2017-02-28T04:00:00.000+0000")));
    }

    @Test
    public void inserirTest() throws Exception {

        mockMvc.perform(post("/servidor/informacoes/0/monitoramentomemoria/").contentType(MediaType.APPLICATION_JSON_UTF8)
                .content("{ " +
                        " \"informacoesMemoria\":{\"id\":3}," +
                        " \"active\" : 24000 ," +
                        " \"memfree\" : 22000 ," +
                        " \"availabre\" : 5000 ," +
                        " \"buffers\" : 6000 ," +
                        " \"dthr_cadastro\" : \"2017-02-28T04:00:00.000+0000\" }"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(5)))
                .andExpect(jsonPath("$.informacoesMemoria.id", is(3)))
                .andExpect(jsonPath("$.active", is(24000)))
                .andExpect(jsonPath("$.memfree", is(22000)))
                .andExpect(jsonPath("$.availabre", is(5000)))
                .andExpect(jsonPath("$.buffers", is(6000)));
                //.andExpect(jsonPath("$.dthr_cadastro", is("2017-02-28T04:00:00.000+0000")));
    }

    @Test
    public void deletarTest() throws Exception {
        mockMvc.perform(delete("/servidor/informacoes/0/monitoramentomemoria/3"))
                .andExpect(status().isOk());

        mockMvc.perform(get("/servidor/informacoes/0/monitoramentomemoria/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[2].id", is(4)));
    }

    //----------------  Exception ----------------------------

    @Test
    public void deletarIdInexistenteTest() throws Exception {

        Exception expt = mockMvc.perform(delete("/servidor/informacoes/0/monitoramentomemoria/999999"))
                .andExpect(status().isInternalServerError())
                .andReturn().getResolvedException();

        Assert.assertTrue(expt.getClass().isAssignableFrom(SqlInexistenteRuntimeException.class));
        Assert.assertTrue(expt.getMessage().equals("Registro não encontrado na base de dados."));
    }
}