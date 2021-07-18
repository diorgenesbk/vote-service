package br.com.challenge.voteservice.api.v1;

import br.com.challenge.voteservice.api.v1.response.UserPermissionResponse;
import br.com.challenge.voteservice.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;


@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/users")
public class UserApi {

    private final UserService userService;

    @ApiOperation(value="Consultar se o usuário está ou não apto a votar", response = UserPermissionResponse.class)
    @GetMapping("/{cpf}")
    public ResponseEntity<?> getUserPermission(@PathVariable String cpf) throws URISyntaxException {
            return ResponseEntity.ok(userService.getUserPermission(cpf));
    }
}
