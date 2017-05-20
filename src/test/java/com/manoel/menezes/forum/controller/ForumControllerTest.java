package com.manoel.menezes.forum.controller;

import com.manoel.menezes.forum.query.model.ForumFinder;
import com.manoel.menezes.forum.query.model.ForumQueryModel;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.mockito.BDDMockito.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ForumControllerTest {

    @Autowired
    private MockMvc mvc;


    @MockBean
    private ForumFinder finder;

    @Test
    public void testFindAll() throws Exception {

        given(finder.findAll())
                .willReturn(Arrays.asList(new ForumQueryModel("n", "c", 0, 0, 0)));

        mvc.perform(MockMvcRequestBuilders.get("/forums")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content()
                        .string("[{\"name\":\"n\",\"category\":\"c\",\"threads\":0,\"messages\":0,\"views\":0}]"));
    }



}
