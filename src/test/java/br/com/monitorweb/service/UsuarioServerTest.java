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

@DatabaseSetup(value = UsuarioServerTest.DATASET, type = DatabaseOperation.INSERT)
public class UsuarioServerTest extends GenericTest{

    protected static final String DATASET = "classpath:/datasets/service/usuario.xml";

    @Resource
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setUp() {

        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void buscarTodosTest() throws Exception {
        mockMvc.perform(get("/usuario"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].dthr_cadastro", is("2017-02-28T04:00:00.000+0000")))
                .andExpect(jsonPath("$[0].nome", is("Eduardo")))
                .andExpect(jsonPath("$[0].sobrenome", is("Balan")))
                .andExpect(jsonPath("$[0].login", is("Eduardo Balan")))
                .andExpect(jsonPath("$[0].email", is("Eduardo_balan1@hotmail.com")))
                .andExpect(jsonPath("$[0].senha", is("102030")))
                .andExpect(jsonPath("$[0].sexo", is("MASCULINO")))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].dthr_cadastro", is("2017-02-28T04:00:00.000+0000")))
                .andExpect(jsonPath("$[1].nome", is("karol")))
                .andExpect(jsonPath("$[1].sobrenome", is("Jeronimo")))
                .andExpect(jsonPath("$[1].login", is("KAROL JERONIMO")))
                .andExpect(jsonPath("$[1].email", is("KAROLJERONIMO@hotmail.com")))
                .andExpect(jsonPath("$[1].senha", is("301020")))
                .andExpect(jsonPath("$[1].sexo", is("FEMININO")));

    }

    @Test
    public void buscarPorIdTest() throws Exception {
        mockMvc.perform(get("/usuario/2"))
                .andExpect(jsonPath("$.id", is(2)))
                .andExpect(jsonPath("$.dthr_cadastro", is("2017-02-28T04:00:00.000+0000")))
                .andExpect(jsonPath("$.nome", is("karol")))
                .andExpect(jsonPath("$.sobrenome", is("Jeronimo")))
                .andExpect(jsonPath("$.login", is("KAROL JERONIMO")))
                .andExpect(jsonPath("$.email", is("KAROLJERONIMO@hotmail.com")))
                .andExpect(jsonPath("$.senha", is("301020")))
                .andExpect(jsonPath("$.sexo", is("FEMININO")));
    }

    @Test
    public void inserirTest() throws Exception {

        mockMvc.perform(post("/usuario").contentType(MediaType.APPLICATION_JSON_UTF8)
                .content("{ " +
                        " \"nome\" : \"Ikarol\" ," +
                        " \"dthr_cadastro\" : \"2017-01-28T04:00:00.000+0000\" ," +
                        " \"login\" : \"IKAROL JERONIMO\" ," +
                        " \"email\" : \"IKAROLJERONIMO@hotmail.com\" ," +
                        " \"senha\" : \"I301020\" ," +
                        " \"sexo\" : \"FEMININO\" ," +
                        " \"sobrenome\" : \"IJeronimo\" }"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(3)))
                //.andExpect(jsonPath("$.dthr_cadastro", is("2017-01-28T04:00:00.000+0000")))
                .andExpect(jsonPath("$.nome", is("Ikarol")))
                .andExpect(jsonPath("$.sobrenome", is("IJeronimo")))
                .andExpect(jsonPath("$.login", is("IKAROL JERONIMO")))
                .andExpect(jsonPath("$.email", is("IKAROLJERONIMO@hotmail.com")))
                .andExpect(jsonPath("$.senha", is("I301020")))
                .andExpect(jsonPath("$.sexo", is("FEMININO")));
    }

    @Test
    public void deletarTest() throws Exception {
        mockMvc.perform(delete("/usuario/2"))
                .andExpect(status().isOk());

        mockMvc.perform(get("/usuario"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].dthr_cadastro", is("2017-02-28T04:00:00.000+0000")))
                .andExpect(jsonPath("$[0].nome", is("Eduardo")))
                .andExpect(jsonPath("$[0].sobrenome", is("Balan")))
                .andExpect(jsonPath("$[0].login", is("Eduardo Balan")))
                .andExpect(jsonPath("$[0].email", is("Eduardo_balan1@hotmail.com")))
                .andExpect(jsonPath("$[0].senha", is("102030")))
                .andExpect(jsonPath("$[0].sexo", is("MASCULINO")));
    }

    //----------------  Exception ----------------------------

    @Test
    public void deletarIdInexistenteTest() throws Exception {

        Exception expt = mockMvc.perform(delete("/usuario/999999"))
                .andExpect(status().isInternalServerError())
                .andReturn().getResolvedException();

        Assert.assertTrue(expt.getClass().isAssignableFrom(SqlInexistenteRuntimeException.class));
        Assert.assertTrue(expt.getMessage().equals("Registro não encontrado na base de dados."));
    }
}


