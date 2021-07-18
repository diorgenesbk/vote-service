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
public class VoteRequest {
    @ApiModelProperty(notes = "Opção selecionada pelo usuário", required = true)
    private Boolean choice;
    @ApiModelProperty(notes = "Sessão na qual o usuário está votando", required = true)
    private Integer sessionId;
    @ApiModelProperty(notes = "Usuário votante", required = true)
    private Integer userId;
}
