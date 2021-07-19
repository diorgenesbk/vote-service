package br.com.challenge.voteservice.client;

import br.com.challenge.voteservice.client.response.UserPermissionResponse;
import br.com.challenge.voteservice.exception.CpfIsNotValidException;
import com.sun.javafx.binding.StringFormatter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import javax.xml.ws.http.HTTPException;
import java.net.URI;
import java.net.URISyntaxException;

@Component
@RequiredArgsConstructor
public class UserPermissionClient {

    @Value("${url.user-permission}")
    private String userPermissionUrl;


    public UserPermissionResponse getUserPermission(String cpf) throws URISyntaxException, CpfIsNotValidException {
        UserPermissionResponse response = null;
        try {
            URI uri = getUri(cpf);
            response = new RestTemplate()
                    .getForEntity(uri, UserPermissionResponse.class)
                    .getBody();
        }
        catch (HttpClientErrorException e){
            if(HttpStatus.NOT_FOUND.equals(e.getStatusCode()))
                throw new CpfIsNotValidException();

            throw new RuntimeException("Erro ao conultar o status do usuário");
        }
        catch (Exception e){
            throw new RuntimeException("Erro ao conultar o status do usuário");
        }
        return response;
    }

    private URI getUri(String path) throws URISyntaxException {
        return new URI(StringFormatter.concat(userPermissionUrl, path).getValue());
    }

}
