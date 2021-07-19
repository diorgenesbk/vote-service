package br.com.challenge.voteservice.stub;

import br.com.challenge.voteservice.dto.PautaDto;
import br.com.challenge.voteservice.entity.PautaEntity;
import br.com.challenge.voteservice.entity.SessionEntity;
import br.com.challenge.voteservice.entity.VoteEntity;

import java.time.ZonedDateTime;
import java.util.Collections;


public class PautaStub {

    public static PautaDto anyDto(){
        return PautaDto.builder()
                .description("description")
                .build();
    }

    public static PautaEntity anyEntity(){
        return PautaEntity.builder()
                .description("description")
                .pautaId(1)
                .creationDate(ZonedDateTime.now())
                .sessions(Collections.singletonList(anySession()))
                .build();
    }

    private static SessionEntity anySession(){
        return SessionEntity.builder()
                .lifetime(1)
                .pautaId(1)
                .description("description")
                .creationDate(ZonedDateTime.now())
                .votes(Collections.singletonList(VoteEntity.builder().sessionId(1).choice(true).userId(1).build()))
                .build();
    }
}
