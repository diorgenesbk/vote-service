package br.com.challenge.voteservice.api.v1.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel
public class SessionRequest {
    @ApiModelProperty(notes="Descrição da Sessão", required = true)
    private String description;

    @ApiModelProperty(notes="Tempo de duração da Sessão em minutos")
    private Integer lifetime;

    @ApiModelProperty(notes="Pauta na qual a sessão será baseada", required = true)
    private Integer pautaId;


}
