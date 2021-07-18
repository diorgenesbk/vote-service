package br.com.challenge.voteservice.api.v1;

import br.com.challenge.voteservice.api.v1.response.VoteCountResponse;
import br.com.challenge.voteservice.exception.PautaDoesNotHaveVoteException;
import br.com.challenge.voteservice.exception.PautaNotFoundException;
import br.com.challenge.voteservice.mapper.ErrorMapper;
import br.com.challenge.voteservice.service.PautaService;
import br.com.challenge.voteservice.api.v1.request.PautaRequest;
import br.com.challenge.voteservice.dto.PautaDto;
import br.com.challenge.voteservice.mapper.PautaMapper;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    private final ErrorMapper errorMapper;

    @ApiOperation(value="Cadastro de Pautas")
    @PostMapping()
    public ResponseEntity<?> registerPauta(@RequestBody @Validated PautaRequest pautaRequest){
        pautaService.registerPauta(pautaMapper.mapToDto(pautaRequest));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @ApiOperation(value="Contabilizar os votos de uma determinada pauta", response = VoteCountResponse.class)
    @GetMapping("/{pautaId}")
    public ResponseEntity<?> getVoteCount(@PathVariable Integer pautaId) {
        try{
            return ResponseEntity.ok(pautaService.getVoteCount(pautaId));
        }
        catch (PautaDoesNotHaveVoteException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMapper.buildNotFoundResponse(ex.getMessage()));
        }
        catch (PautaNotFoundException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMapper.buildNotFoundResponse(ex.getMessage()));
        }
    }
}
