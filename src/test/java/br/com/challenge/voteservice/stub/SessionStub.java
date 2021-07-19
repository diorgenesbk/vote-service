package br.com.challenge.voteservice.stub;

import br.com.challenge.voteservice.dto.SessionDto;
import br.com.challenge.voteservice.entity.SessionEntity;
import java.time.ZonedDateTime;


public class SessionStub {

    public static SessionDto anyDto(){
        return SessionDto.builder()
                .description("description")
                .build();
    }

    public static SessionEntity anyEntity(){
        return SessionEntity.builder()
                .description("description")
                .pautaId(1)
                .creationDate(ZonedDateTime.now())
                .build();
    }
}
