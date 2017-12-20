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

@DatabaseSetup(value = ServidorServerTest.DATASET, type = DatabaseOperation.INSERT)
public class ServidorServerTest extends GenericTest{

    protected static final String DATASET = "classpath:/datasets/service/servidor.xml";

    @Resource
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setUp() {

        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void buscarTodosTest() throws Exception {
        mockMvc.perform(get("/servidor"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].nome", is("Servidor1")))
                .andExpect(jsonPath("$[0].empresa", is("Emp1")))
                .andExpect(jsonPath("$[0].observacao", is("obs1")))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].nome", is("Servidor2")))
                .andExpect(jsonPath("$[2].id", is(3)))
                .andExpect(jsonPath("$[2].nome", is("Servidor3")));

    }

    @Test
    public void buscarPorIdTest() throws Exception {
        mockMvc.perform(get("/servidor/2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(2)))
                .andExpect(jsonPath("$.dthr_cadastro", is("2017-02-28T04:00:00.000+0000")))
                .andExpect(jsonPath("$.nome", is("Servidor2")))
                .andExpect(jsonPath("$.empresa", is("Emp2")))
                .andExpect(jsonPath("$.observacao", is("obs2")));
    }

    @Test
    public void inserirTest() throws Exception {

        mockMvc.perform(post("/servidor").contentType(MediaType.APPLICATION_JSON_UTF8)
                .content("{ " +
                        " \"nome\" : \"Novo Registro\" ," +
                        " \"dominio\":{\"id\":2}," +
                        " \"empresa\" : \"Nova Empresa\" ," +
                        " \"dthr_cadastro\" : \"2017-02-28T04:00:00.000+0000\" ," +
                        " \"observacao\" : \"Nova Observacao\" }"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(4)))
                .andExpect(jsonPath("$.nome", is("Novo Registro")))
                .andExpect(jsonPath("$.dominio.id", is(2)))
                .andExpect(jsonPath("$.empresa", is("Nova Empresa")))
                //.andExpect(jsonPath("$.dthr_cadastro", is("2017-02-28T04:00:00.000+0000")))
                .andExpect(jsonPath("$.observacao", is("Nova Observacao")));
    }

    @Test
    public void deletarTest() throws Exception {
        mockMvc.perform(delete("/servidor/3"))
                .andExpect(status().isOk());

        mockMvc.perform(get("/servidor"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[1].id", is(2)));
    }

    //----------------  Exception ----------------------------

    @Test
    public void deletarIdInexistenteTest() throws Exception {

        Exception expt = mockMvc.perform(delete("/servidor/999999"))
                .andExpect(status().isInternalServerError())
                .andReturn().getResolvedException();

        Assert.assertTrue(expt.getClass().isAssignableFrom(SqlInexistenteRuntimeException.class));
        Assert.assertTrue(expt.getMessage().equals("Registro não encontrado na base de dados."));
    }
}


