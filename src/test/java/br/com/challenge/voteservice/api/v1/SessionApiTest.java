package br.com.challenge.voteservice.api.v1;

import br.com.challenge.voteservice.mapper.PautaMapper;
import br.com.challenge.voteservice.service.PautaService;
import br.com.challenge.voteservice.stub.PautaStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import springfox.documentation.spring.web.json.Json;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class PautaApiTest {
    @Autowired
    private MockMvc mvc;
    @Mock
    private PautaMapper pautaMapper;
    @Mock
    private PautaService pautaService;
    @InjectMocks
    private PautaApi pautaApi;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mvc = MockMvcBuilders.standaloneSetup(pautaApi).build();
    }

    @Test
    public void registerPauta() throws Exception {
        String validBody = new String(Files.readAllBytes(Paths.get("src/test/resources/json/pautaRequest.json")));
        mvc.perform(post("/v1/pautas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(validBody))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void registerPautaWithInvalidBody() throws Exception {
        mvc.perform(post("/v1/pautas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(""))
                .andExpect(status().isBadRequest());
    }

}
