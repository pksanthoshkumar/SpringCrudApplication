package com.example.crud;

import com.example.crud.domain.Books;
import com.example.crud.repo.BookRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringJUnitConfig
@SpringBootTest
public class BookControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @MockBean
    private BookRepo repo;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testGetBooks() throws Exception {
        List<Books> books = new ArrayList<>();
        books.add(new Books(1L, "Book1", "Author1"));

        when(repo.findAll()).thenReturn(books);

        ResultActions resultActions = mockMvc.perform(get("/books/get"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].title").value("Book1"))
                .andExpect(jsonPath("$[0].author").value("Author1"));

        verify(repo, times(1)).findAll();
        //resultActions.andDo(print());
    }

    @Test
    public void testAddBook() throws Exception {
        Books bookToAdd = new Books(null, "NewBook", "NewAuthor");
        Books savedBook = new Books(1L, "NewBook", "NewAuthor");

        when(repo.save(any(Books.class))).thenReturn(savedBook);

        mockMvc.perform(post("/books/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"title\":\"NewBook\",\"author\":\"NewAuthor\"}"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.title").value("NewBook"))
                .andExpect(jsonPath("$.author").value("NewAuthor"));

        verify(repo, times(1)).save(any(Books.class));
    }

    // Add similar test methods for other controller methods (updateBook and deleteBook)
}
