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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * Created by Eduardo Balan on 27/06/2017.
 */

@DatabaseSetup(value = DominioServerTest.DATASET, type = DatabaseOperation.INSERT)
public class DominioServerTest extends GenericTest{

    protected static final String DATASET = "classpath:/datasets/service/dominio.xml";

    @Resource
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setUp() {

        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void buscarTodosTest() throws Exception {
        mockMvc.perform(get("/dominio"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].nome", is("Cliente")))
                .andExpect(jsonPath("$[0].observacao", is("Cliente normal")))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].nome", is("Super Cliente")))
                .andExpect(jsonPath("$[1].observacao", is("Sempre cuidar muito desses clientes")));
    }

    @Test
    public void buscarPorIdTest() throws Exception {
        mockMvc.perform(get("/dominio/2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(2)))
                .andExpect(jsonPath("$.nome", is("Super Cliente")))
                .andExpect(jsonPath("$.observacao", is("Sempre cuidar muito desses clientes")));
    }

    @Test
    public void inserirTest() throws Exception {

        mockMvc.perform(post("/dominio").contentType(MediaType.APPLICATION_JSON_UTF8)
                .content("{ " +
                        " \"nome\" : \"Novo Registro\" ," +
                        " \"observacao\" : \"Nova Observacao\" }"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(3)))
                .andExpect(jsonPath("$.nome", is("Novo Registro")))
                .andExpect(jsonPath("$.observacao", is("Nova Observacao")));
    }

    @Test
    public void deletarTest() throws Exception {
        mockMvc.perform(delete("/dominio/2"))
                .andExpect(status().isOk());

        mockMvc.perform(get("/dominio"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].nome", is("Cliente")))
                .andExpect(jsonPath("$[0].observacao", is("Cliente normal")));
    }

    //----------------  Exception ----------------------------

    @Test
    public void deletarIdInexistenteTest() throws Exception {

        Exception expt = mockMvc.perform(delete("/dominio/999999"))
                .andExpect(status().isInternalServerError())
                .andReturn().getResolvedException();

        Assert.assertTrue(expt.getClass().isAssignableFrom(SqlInexistenteRuntimeException.class));
        Assert.assertTrue(expt.getMessage().equals("Registro não encontrado na base de dados."));
    }
}


