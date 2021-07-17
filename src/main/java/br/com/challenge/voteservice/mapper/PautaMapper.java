package br.com.challenge.voteservice.mapper;

import br.com.challenge.voteservice.api.v1.request.PautaRequest;
import br.com.challenge.voteservice.dto.PautaDto;
import br.com.challenge.voteservice.entity.PautaEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.time.ZonedDateTime;


@Component
@RequiredArgsConstructor
public class PautaMapper {

    private final ObjectMapper objectMapper;

    public PautaEntity mapToEntity(PautaDto pautaDto){
        return objectMapper.convertValue(pautaDto, PautaEntity.class);
    }

    public PautaDto mapToDto(PautaRequest pautaRequest){
        return  objectMapper.convertValue(pautaRequest, PautaDto.class);
    }
}