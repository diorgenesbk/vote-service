package br.com.challenge.voteservice.api.v1;

import br.com.challenge.voteservice.UserAlreadyVotedException;
import br.com.challenge.voteservice.api.v1.request.VoteRequest;
import br.com.challenge.voteservice.mapper.ErrorMapper;
import br.com.challenge.voteservice.mapper.VoteMapper;
import br.com.challenge.voteservice.service.VoteService;
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
@RequestMapping("/v1/votes")
public class VoteApi {

    private final VoteService voteService;
    private final VoteMapper voteMapper;
    private final ErrorMapper errorMapper;

    @ApiOperation(value="Votação")
    @PostMapping()
    public ResponseEntity<?> registerVote(@RequestBody @Validated VoteRequest voteRequest) {
        try{
            voteService.registerVote(voteMapper.mapToDto(voteRequest));
        }
        catch (UserAlreadyVotedException ex){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(errorMapper.buildConflictResponse(ex.getMessage()));
        }

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
