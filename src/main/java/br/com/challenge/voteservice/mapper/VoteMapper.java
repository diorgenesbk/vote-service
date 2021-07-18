package br.com.challenge.voteservice.mapper;

import br.com.challenge.voteservice.api.v1.request.VoteRequest;
import br.com.challenge.voteservice.dto.VoteDto;
import br.com.challenge.voteservice.entity.VoteEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.time.ZonedDateTime;


@Component
@RequiredArgsConstructor
public class VoteMapper {

    private final ObjectMapper objectMapper;

    public VoteEntity mapToEntity(VoteDto voteDto){
        return VoteEntity.builder()
                .userId(voteDto.getUserId())
                .choice(voteDto.getChoice())
                .sessionId(voteDto.getSessionId())
                .voteDateTime(defineVoteDate(voteDto))
                .build();
    }

    public VoteDto mapToDto(VoteRequest voteRequest){
        return objectMapper.convertValue(voteRequest, VoteDto.class);
    }

    private ZonedDateTime defineVoteDate(VoteDto voteDto){
        return ObjectUtils.isEmpty(voteDto.getVoteDateTime()) ? ZonedDateTime.now() : voteDto.getVoteDateTime();
    }
}
