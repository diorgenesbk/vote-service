package br.com.challenge.voteservice.dto;

import br.com.challenge.voteservice.entity.PautaEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.ZonedDateTime;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SessionDto {
    private Integer sessionId;
    private String description;
    private Integer lifetime;
    private ZonedDateTime creationDate;
    private Integer pautaId;
    private PautaEntity pauta;
}
