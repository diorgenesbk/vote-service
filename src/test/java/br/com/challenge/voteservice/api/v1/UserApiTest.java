package br.com.challenge.voteservice.api.v1;

import br.com.challenge.voteservice.exception.CpfIsNotValidException;
import br.com.challenge.voteservice.mapper.ErrorMapper;
import br.com.challenge.voteservice.mapper.UserMapper;
import br.com.challenge.voteservice.service.UserService;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class UserApiTest {
    @Autowired
    private MockMvc mvc;
    @Mock
    private ErrorMapper errorMapper;
    @Mock
    private UserMapper userMapper;
    @Mock
    private UserService userService;
    @InjectMocks
    private UserApi userApi;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mvc = MockMvcBuilders.standaloneSetup(userApi).build();
    }

    @Test
    public void getUserPermissionWithValidCpf() throws Exception {
        mvc.perform(get("/v1/users/62373947021")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void getUserPermissionWithInvalidCpf() throws Exception {
        Mockito.doThrow(CpfIsNotValidException.class).when(userService).getUserPermission(Mockito.anyString());
        mvc.perform(get("/v1/users/11111111111")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError());
    }
}
