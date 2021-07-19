package br.com.challenge.voteservice.service;

import br.com.challenge.voteservice.client.UserPermissionClient;
import br.com.challenge.voteservice.client.response.UserPermissionResponse;
import br.com.challenge.voteservice.exception.CpfIsNotValidException;
import br.com.challenge.voteservice.exception.UserAlreadyVotedException;
import br.com.challenge.voteservice.mapper.UserMapper;
import br.com.challenge.voteservice.mapper.VoteMapper;
import br.com.challenge.voteservice.repository.UserRepository;
import br.com.challenge.voteservice.repository.VoteRepository;
import br.com.challenge.voteservice.stub.UserStub;
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

import java.net.URISyntaxException;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.notNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


@DisplayName("Dado que há um usuário")
public class UserServiceTest {

    @Spy
    private final ObjectMapper objectMapper = new ObjectMapper();
    @Spy
    private UserMapper userMapper = new UserMapper(objectMapper);
    @Mock
    private UserPermissionClient userPermissionClient;
    @InjectMocks
    private UserService userService;

    @BeforeEach
    void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("Quando queremos consultar se o usuário está apto a votar")
    void getUserPermission() throws URISyntaxException, CpfIsNotValidException {
        Mockito.when(userPermissionClient.getUserPermission(anyString())).thenReturn(UserStub.anyUserPermissionResponse());

        UserPermissionResponse userPermissionResponse = userService.getUserPermission(anyString());
        verify(userPermissionClient, times(1)).getUserPermission(anyString());

        Assertions.assertNotNull(userPermissionResponse);
    }

    @Test
    @DisplayName("Quando queremos consultar se o usuário está apto a votar, mas informamos um cpf invalido")
    void getUserPermissionWhenCpfIsNotValid() throws URISyntaxException, CpfIsNotValidException {
        Mockito.when(userPermissionClient.getUserPermission(anyString())).thenReturn(UserStub.anyUserPermissionResponse());

        UserPermissionResponse userPermissionResponse = userService.getUserPermission(anyString());
        verify(userPermissionClient, times(1)).getUserPermission(anyString());

        Assertions.assertNotNull(userPermissionResponse);
    }
}
