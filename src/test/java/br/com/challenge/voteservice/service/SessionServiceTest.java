package br.com.challenge.voteservice.service;

import br.com.challenge.voteservice.api.v1.response.VoteCountResponse;
import br.com.challenge.voteservice.exception.PautaDoesNotHaveVoteException;
import br.com.challenge.voteservice.exception.PautaNotFoundException;
import br.com.challenge.voteservice.mapper.PautaMapper;
import br.com.challenge.voteservice.mapper.SessionMapper;
import br.com.challenge.voteservice.repository.PautaRepository;
import br.com.challenge.voteservice.repository.SessionRepository;
import br.com.challenge.voteservice.stub.PautaStub;
import br.com.challenge.voteservice.stub.SessionStub;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


@DisplayName("Dado que há uma sessão")
public class SessionServiceTest {

    @Spy
    private final ObjectMapper objectMapper = new ObjectMapper();
    @Spy
    private SessionMapper sessionMapper = new SessionMapper(objectMapper);
    @Mock
    private SessionRepository sessionRepository;
    @InjectMocks
    private SessionService sessionService;

    @BeforeEach
    void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("Quando tentamos abrir uma nova Sessão")
    void registerSession(){
        Mockito.when(sessionRepository.save(Mockito.any())).thenReturn(SessionStub.anyEntity());
        sessionService.openSession(SessionStub.anyDto());
        verify(sessionRepository, times(1)).save(Mockito.any());
    }
}
