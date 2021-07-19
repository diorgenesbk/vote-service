package br.com.challenge.voteservice.stub;

import br.com.challenge.voteservice.api.v1.request.PautaRequest;
import br.com.challenge.voteservice.dto.PautaDto;
import br.com.challenge.voteservice.entity.PautaEntity;
import br.com.challenge.voteservice.entity.SessionEntity;
import br.com.challenge.voteservice.entity.VoteEntity;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


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
                .votes(anyVoteList())
                .build();
    }

    private static List<VoteEntity> anyVoteList(){
        ArrayList<VoteEntity> voteList = new ArrayList<>();
        voteList.add(VoteEntity.builder().sessionId(1).choice(true).userId(1).build());
        voteList.add(VoteEntity.builder().sessionId(1).choice(false).userId(1).build());
        return voteList;
    }
}
