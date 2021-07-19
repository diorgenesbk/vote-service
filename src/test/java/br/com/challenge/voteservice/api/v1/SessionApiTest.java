package br.com.challenge.voteservice.api.v1;

import br.com.challenge.voteservice.mapper.PautaMapper;
import br.com.challenge.voteservice.mapper.SessionMapper;
import br.com.challenge.voteservice.service.PautaService;
import br.com.challenge.voteservice.service.SessionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class SessionApiTest {
    @Autowired
    private MockMvc mvc;
    @Mock
    private SessionMapper sessionMapper;
    @Mock
    private SessionService sessionService;
    @InjectMocks
    private SessionApi sessionApi;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mvc = MockMvcBuilders.standaloneSetup(sessionApi).build();
    }

    @Test
    public void openSession() throws Exception {
        String validBody = new String(Files.readAllBytes(Paths.get("src/test/resources/json/sessionRequest.json")));
        mvc.perform(post("/v1/sessions")
                .contentType(MediaType.APPLICATION_JSON)
                .content(validBody))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void openSessionWithInvalidBody() throws Exception {
        mvc.perform(post("/v1/sessions")
                .contentType(MediaType.APPLICATION_JSON)
                .content(""))
                .andExpect(status().isBadRequest());
    }

}
