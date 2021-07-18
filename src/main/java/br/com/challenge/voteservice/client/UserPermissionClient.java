package br.com.challenge.voteservice.client;

import br.com.challenge.voteservice.client.response.UserPermissionResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@Component
@RequiredArgsConstructor
public class UserPermissionClient {

    @Value("${url.user-permission}")
    private String userPermissionUrl;


    public UserPermissionResponse getUserPermission(String cpf) throws URISyntaxException {
        return new RestTemplate()
        .getForEntity(getUri(cpf), UserPermissionResponse.class)
        .getBody();
    }

    private URI getUri(String path) throws URISyntaxException {
        return new URI(String.format(userPermissionUrl, path));
    }

}
