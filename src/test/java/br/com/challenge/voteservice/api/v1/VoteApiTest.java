package br.com.challenge.voteservice.api.v1;

import br.com.challenge.voteservice.exception.UserAlreadyVotedException;
import br.com.challenge.voteservice.mapper.ErrorMapper;
import br.com.challenge.voteservice.mapper.VoteMapper;
import br.com.challenge.voteservice.service.VoteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class VoteApiTest {
    @Autowired
    private MockMvc mvc;
    @Mock
    private ErrorMapper errorMapper;
    @Mock
    private VoteMapper voteMapper;
    @Mock
    private VoteService voteService;
    @InjectMocks
    private VoteApi voteApi;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mvc = MockMvcBuilders.standaloneSetup(voteApi).build();
    }

    @Test
    public void registerVote() throws Exception {
        String validBody = new String(Files.readAllBytes(Paths.get("src/test/resources/json/voteRequest.json")));
        mvc.perform(post("/v1/votes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(validBody))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void registerVoteWithInvalidBody() throws Exception {
        mvc.perform(post("/v1/votes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(""))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void registerVoteWhenUserAlreadyVoted() throws Exception {
        String validBody = new String(Files.readAllBytes(Paths.get("src/test/resources/json/voteRequest.json")));
        Mockito.doThrow(UserAlreadyVotedException.class).when(voteService).registerVote(Mockito.any());
        mvc.perform(post("/v1/votes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(validBody))
                .andExpect(status().is4xxClientError());
    }
}
