package br.com.challenge.voteservice.api.v1;

import br.com.challenge.voteservice.api.v1.response.UserPermissionResponse;
import br.com.challenge.voteservice.exception.CpfIsNotValidException;
import br.com.challenge.voteservice.mapper.ErrorMapper;
import br.com.challenge.voteservice.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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

    private final ErrorMapper errorMapper;

    @ApiOperation(value="Consultar se o usuário está ou não apto a votar", response = UserPermissionResponse.class)
    @GetMapping("/{cpf}")
    public ResponseEntity<?> getUserPermission(@PathVariable String cpf) throws URISyntaxException, CpfIsNotValidException {
        try{
            return ResponseEntity.ok(userService.getUserPermission(cpf));
        } catch (CpfIsNotValidException ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMapper.buildBadRequestResponse(ex.getMessage()));
        } catch (Exception ex){
            //log
            throw ex;
        }
    }
}
