package br.com.challenge.voteservice.service;

import br.com.challenge.voteservice.client.UserPermissionClient;
import br.com.challenge.voteservice.client.response.UserPermissionResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.net.URISyntaxException;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserPermissionClient userPermissionClient;

    public UserPermissionResponse getUserPermission(String cpf) throws URISyntaxException {
        return userPermissionClient.getUserPermission(cpf);
    }
}
