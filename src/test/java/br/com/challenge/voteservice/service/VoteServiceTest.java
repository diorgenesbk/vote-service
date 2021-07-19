package br.com.challenge.voteservice.service;

import br.com.challenge.voteservice.exception.UserAlreadyVotedException;
import br.com.challenge.voteservice.exception.UserUnableToVoteException;
import br.com.challenge.voteservice.mapper.VoteMapper;
import br.com.challenge.voteservice.repository.VoteRepository;
import br.com.challenge.voteservice.stub.VoteStub;
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

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


@DisplayName("Dado que há um voto")
public class VoteServiceTest {

    @Spy
    private final ObjectMapper objectMapper = new ObjectMapper();
    @Spy
    private VoteMapper voteMapper = new VoteMapper(objectMapper);
    @Mock
    UserService userService;
    @Mock
    private VoteRepository voteRepository;
    @InjectMocks
    private VoteService voteService;

    @BeforeEach
    void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("Quando tentamos realizar um voto pela primeira vez")
    void registerVoteWhenIsFirstTime() throws UserAlreadyVotedException, UserUnableToVoteException {
        Mockito.when(voteRepository.save(Mockito.any())).thenReturn(VoteStub.anyEntity());
        Mockito.when(voteRepository.findByUserIdAndSessionId(anyInt(), anyInt())).thenReturn(Optional.empty());
        Mockito.when(userService.checkUserAble(anyInt())).thenReturn(Boolean.TRUE);

        voteService.registerVote(VoteStub.anyDto());
        verify(voteRepository, times(1)).save(any());
        verify(voteRepository, times(1)).findByUserIdAndSessionId(anyInt(), anyInt());
    }

    @Test
    @DisplayName("Quando tentamos realizar um voto em uma pauta que o usuário já votou")
    void registerVoteWhenIsNotFirstTime() {
        Mockito.when(voteRepository.save(Mockito.any())).thenReturn(VoteStub.anyEntity());
        Mockito.when(voteRepository.findByUserIdAndSessionId(anyInt(), anyInt())).thenReturn(Optional.of(VoteStub.anyEntity()));
        Mockito.when(userService.checkUserAble(anyInt())).thenReturn(Boolean.TRUE);

        Assertions.assertThrows(UserAlreadyVotedException.class, () -> {
            voteService.registerVote(VoteStub.anyDto());
        });
    }
}
