package ru.goodvard.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import ru.goodvard.controller.dto.SendEmailDto;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MailRequestController.class)
class MailRequestControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void sendEmail() throws Exception {
        SendEmailDto request = request();

        mvc.perform(post("/api/send")
                .content(asJsonString(request))
                .contentType(APPLICATION_JSON)
                .accept(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("SUCCESS")));

    }

    private SendEmailDto request() {
        return new SendEmailDto("NAME", "PHONE", "EMAIL", "MESSAGE");
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}