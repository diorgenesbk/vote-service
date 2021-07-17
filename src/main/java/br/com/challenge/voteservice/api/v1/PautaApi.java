package br.com.challenge.voteservice.api.v1;

import br.com.challenge.voteservice.PautaService;
import br.com.challenge.voteservice.api.v1.request.PautaRequest;
import br.com.challenge.voteservice.dto.PautaDto;
import br.com.challenge.voteservice.mapper.PautaMapper;
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
@RequestMapping("/v1/pautas")
public class PautaApi {

    private final PautaService pautaService;
    private final PautaMapper pautaMapper;

    @ApiOperation(value="Cadastro de Pautas", response = PautaDto.class)
    @PostMapping()
    public ResponseEntity<?> registerPauta(@RequestBody @Validated PautaRequest pautaRequest){
        pautaService.registerPauta(pautaMapper.mapToDto(pautaRequest));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
