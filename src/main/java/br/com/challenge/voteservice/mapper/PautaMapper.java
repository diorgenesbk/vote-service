package br.com.challenge.voteservice.mapper;

import br.com.challenge.voteservice.api.v1.request.PautaRequest;
import br.com.challenge.voteservice.api.v1.response.VoteCountResponse;
import br.com.challenge.voteservice.dto.PautaDto;
import br.com.challenge.voteservice.entity.PautaEntity;
import br.com.challenge.voteservice.entity.SessionEntity;
import br.com.challenge.voteservice.exception.PautaDoesNotHaveVoteException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.time.ZonedDateTime;
import java.util.Optional;


@Component
@RequiredArgsConstructor
public class PautaMapper {

    private final ObjectMapper objectMapper;

    public PautaEntity mapToEntity(PautaDto pautaDto){
        return PautaEntity.builder()
                .creationDate(defineCreationDate(pautaDto))
                .description(pautaDto.getDescription())
                .build();
    }

    public PautaDto mapToDto(PautaRequest pautaRequest){
        return objectMapper.convertValue(pautaRequest, PautaDto.class);
    }

    public VoteCountResponse mapToVoteCountResponse(PautaEntity pautaEntity) throws PautaDoesNotHaveVoteException {
        return VoteCountResponse.builder()
                .pauta(pautaEntity.getDescription())
                .voteCount(getVoteCount(pautaEntity))
                .build();
    }

    private ZonedDateTime defineCreationDate(PautaDto pautaDto){
        return ObjectUtils.isEmpty(pautaDto.getCreationDate()) ? ZonedDateTime.now() : pautaDto.getCreationDate();
    }

    private Integer getVoteCount(PautaEntity pautaEntity) throws PautaDoesNotHaveVoteException {
        verifyVoteCountIsEmpty(pautaEntity);
        Integer voteCount = 0;

        for (SessionEntity session : pautaEntity.getSessions()) {
            voteCount += session.getVotes().size();
        }

        return voteCount;
    }

    private void verifyVoteCountIsEmpty(PautaEntity pautaEntity) throws PautaDoesNotHaveVoteException {
        if(ObjectUtils.isEmpty(pautaEntity.getSessions()) || pautaEntity.getSessions().stream().allMatch(sessionEntity -> ObjectUtils.isEmpty(sessionEntity.getVotes()))){
            throw new PautaDoesNotHaveVoteException();
        }
    }
}
