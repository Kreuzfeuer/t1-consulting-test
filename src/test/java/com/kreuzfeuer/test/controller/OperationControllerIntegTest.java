package com.kreuzfeuer.test.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class OperationControllerIntegTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getStringDecompositionTest() throws Exception {
        //given
        String str = "asfafwfaaa#f f ... 1!";
        String expectedResult = "{" +
                "\"a\":5," +
                "\"f\":5," +
                "\".\":3," +
                "\"1\":1," +
                "\"!\":1," +
                "\"s\":1," +
                "\"#\":1," +
                "\"w\":1" +
                "}";
        //when
        ResultActions resultActions = mockMvc
                .perform(post("/decomposition")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(str));
        //then
        resultActions.andExpect(status().isOk());
        resultActions.andReturn();
        String contentAsString = resultActions.andReturn().getResponse().getContentAsString();
        Assertions.assertEquals(expectedResult, contentAsString);
    }

    @Test
    void getStringDecompositionWhenBodyNullTest() throws Exception {
        //given
        String str = "";
        //when
        ResultActions resultActions = mockMvc
                .perform(post("/decomposition")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(str));
        //then
        resultActions.andExpect(status().is4xxClientError());
        resultActions.andReturn();
        String contentAsString = resultActions.andReturn().getResponse().getContentAsString();
        Assertions.assertEquals("", contentAsString);
    }
}
