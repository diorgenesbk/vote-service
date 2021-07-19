package br.com.challenge.voteservice.service;

import br.com.challenge.voteservice.api.v1.response.VoteCountResponse;
import br.com.challenge.voteservice.exception.PautaDoesNotHaveVoteException;
import br.com.challenge.voteservice.exception.PautaNotFoundException;
import br.com.challenge.voteservice.mapper.PautaMapper;
import br.com.challenge.voteservice.repository.PautaRepository;
import br.com.challenge.voteservice.stub.PautaStub;
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
import springfox.documentation.spring.web.ObjectMapperConfigurer;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;



@DisplayName("Dado que há uma pauta")
public class PautaServiceTest {

    @Spy
    private final ObjectMapper objectMapper = new ObjectMapper();
    @Spy
    private PautaMapper pautaMapper = new PautaMapper(objectMapper);
    @Mock
    private PautaRepository pautaRepository;
    @InjectMocks
    private PautaService pautaService;

    @BeforeEach
    void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("Quando tentamos registrar uma Pauta")
    void registerPauta(){
        Mockito.when(pautaRepository.save(Mockito.any())).thenReturn(PautaStub.anyEntity());
        pautaService.registerPauta(PautaStub.anyDto());
        verify(pautaRepository, times(1)).save(Mockito.any());
    }

    @Test
    @DisplayName("Quando consultamos as quantidades de votos")
    void getVoteCount() throws PautaNotFoundException, PautaDoesNotHaveVoteException {
        Mockito.when(pautaRepository.findBypautaId(Mockito.anyInt())).thenReturn(Optional.of(PautaStub.anyEntity()));
        VoteCountResponse voteCountResponse = pautaService.getVoteCount(anyInt());

        Assertions.assertEquals(1, voteCountResponse.getVoteCount());
    }
}
