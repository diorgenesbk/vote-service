package br.com.challenge.voteservice.api.v1;

import br.com.challenge.voteservice.api.v1.request.SessionRequest;
import br.com.challenge.voteservice.dto.SessionDto;
import br.com.challenge.voteservice.mapper.SessionMapper;
import br.com.challenge.voteservice.service.SessionService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/sessions")
public class SessionApi {

    private final SessionService sessionService;
    private final SessionMapper sessionMapper;

    @ApiOperation(value="Abertura de nova sessão")
    @PostMapping()
    public ResponseEntity<?> openSession(@RequestBody @Validated SessionRequest sessionRequest){
        try{
            SessionDto sessionDto = sessionMapper.mapToDto(sessionRequest);
            sessionService.openSession(sessionDto);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception ex){
            //log
            throw ex;
        }
    }
}
