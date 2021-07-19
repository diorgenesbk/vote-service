package br.com.challenge.voteservice.stub;

import br.com.challenge.voteservice.dto.VoteDto;
import br.com.challenge.voteservice.entity.VoteEntity;

import java.time.ZonedDateTime;


public class VoteStub {

    public static VoteDto anyDto(){
        return VoteDto.builder()
                .sessionId(1)
                .choice(true)
                .userId(1)
                .voteDateTime(ZonedDateTime.now())
                .build();
    }

    public static VoteEntity anyEntity(){
        return VoteEntity.builder()
                .sessionId(1)
                .choice(true)
                .userId(1)
                .voteDateTime(ZonedDateTime.now())
                .build();
    }
}
