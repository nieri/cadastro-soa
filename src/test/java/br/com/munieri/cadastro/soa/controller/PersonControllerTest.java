package br.com.munieri.cadastro.soa.controller;

import br.com.munieri.cadastro.soa.config.WebAppContext;
import br.com.munieri.cadastro.soa.dao.PersonDAO;
import br.com.munieri.cadastro.soa.model.Person;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.junit.Test;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {br.com.munieri.cadastro.soa.config.TestContext.class, WebAppContext.class})
@WebAppConfiguration
public class PersonControllerTest extends TestCase {

    private static final String VIEW_RESOLVER_PREFIX = "/WEB-INF/views";
    private static final String VIEW_RESOLVER_SUFFIX = ".jsp";

    private MockMvc mockMvc;

    @Autowired
    @Qualifier("PersonDAOMock")
    private PersonDAO dao;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setUp() {
        //We have to reset our mock between tests because the mock objects
        //are managed by the Spring container. If we would not reset them,
        //stubbing and verified behavior would "leak" from one test to another.
        Mockito.reset(dao);

        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testHandleRequestView() throws Exception {

        Person person = new Person();
        person.setName("Murilo Nieri");
        person.setMobile("99221133");
        person.setPhone("44553322");

        when(dao.listar()).thenReturn(Arrays.asList(person));

        mockMvc.perform(get("/pessoas/listar"))
                .andExpect(status().isOk())
                .andExpect(view().name("list"))
                .andExpect(forwardedUrl("/WEB-INF/views/list.jsp"))
                .andExpect(model().attribute("personList", hasSize(1)))
                .andExpect(model().attribute("personList", hasItem(
                        allOf(
                                hasProperty("name", is("Murilo Nieri")),
                                hasProperty("phone", is("44553322"))
                        )
                )));

        verify(dao, times(1)).listar();
        verifyNoMoreInteractions(dao);
    }
}