package ru.pobedonostsev.library.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@AutoConfigureMockMvc
@SpringBootTest
@TestPropertySource(locations = "classpath:application-integration.properties")
public class LibraryIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getBooks() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/books/1");
        MvcResult result = mvc.perform(request).andExpect(status().isOk()).andReturn();
    }

    @Test
    public void getNotExistBook() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/books/22");
        MvcResult result = mvc.perform(request).andExpect(status().isNotFound()).andReturn();
    }
}
