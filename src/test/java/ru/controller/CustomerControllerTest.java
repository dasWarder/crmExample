package ru.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import ru.config.WebConfig;
import ru.sevice.CustomerServiceInt;

import javax.annotation.PostConstruct;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringJUnitWebConfig(WebConfig.class)
class CustomerControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private CustomerServiceInt customerServiceInt;


    @PostConstruct
    private void postConstruct() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .build();
    }

    @Test
    void getCustomerList() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/customers"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    void getCustomer() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/customers/2"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    void getCustomerWithWrongId() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/customers/9999"))
                .andExpect(status().isNotFound())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    void getCustomerWithTextId() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/customers/asrff"))
                .andExpect(status().isBadRequest())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    void deleteCustomer() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/customers/1"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void deleteWrongId() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/customers/99999"))
                .andExpect(status().isNotFound())
                .andDo(print());
    }

    @Test
    void deleteWithTextId() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/customers/asf"))
                .andExpect(status().isBadRequest())
                .andDo(print());
    }
    


}