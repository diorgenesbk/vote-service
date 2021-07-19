package br.com.challenge.voteservice.mapper;

import br.com.challenge.voteservice.api.v1.request.VoteRequest;
import br.com.challenge.voteservice.api.v1.response.ErrorResponse;
import br.com.challenge.voteservice.dto.VoteDto;
import br.com.challenge.voteservice.entity.VoteEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class ErrorMapper {

    public ErrorResponse buildConflictResponse(String error){
        return buildResponse(error, HttpStatus.CONFLICT);
    }

    public ErrorResponse buildBadRequestResponse(String error){
        return buildResponse(error, HttpStatus.BAD_REQUEST);
    }

    public ErrorResponse buildNotFoundResponse(String error){
        return buildResponse(error, HttpStatus.NOT_FOUND);
    }

    private ErrorResponse buildResponse(String error, HttpStatus status){
        return ErrorResponse.builder()
                .error(error)
                .status(status)
                .build();
    }

}
