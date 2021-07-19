package br.com.challenge.voteservice.mapper;

import br.com.challenge.voteservice.api.v1.request.SessionRequest;
import br.com.challenge.voteservice.dto.SessionDto;
import br.com.challenge.voteservice.entity.SessionEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.time.ZonedDateTime;


@Component
@RequiredArgsConstructor
public class SessionMapper {

    private final ObjectMapper objectMapper;

    @Value("${param.default-lifetime}")
    private Integer defaultLifetime;

    public SessionEntity mapToEntity(SessionDto sessionDto){
        return SessionEntity.builder()
                .pautaId(sessionDto.getPautaId())
                .description(sessionDto.getDescription())
                .lifetime(defineLifeTime(sessionDto))
                .creationDate(defineCreationDate(sessionDto))
                .build();
    }

    public SessionDto mapToDto(SessionRequest sessionRequest){
        return  objectMapper.convertValue(sessionRequest, SessionDto.class);
    }

    private Integer defineLifeTime(SessionDto sessionDto){
        return ObjectUtils.isEmpty(sessionDto.getLifetime()) ? defaultLifetime : sessionDto.getLifetime();
    }

    private ZonedDateTime defineCreationDate(SessionDto sessionDto){
        return ObjectUtils.isEmpty(sessionDto.getCreationDate()) ? ZonedDateTime.now() : sessionDto.getCreationDate();
    }
}
