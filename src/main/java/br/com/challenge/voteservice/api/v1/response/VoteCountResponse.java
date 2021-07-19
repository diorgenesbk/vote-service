package br.com.challenge.voteservice.api.v1.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VoteCountResponse {
    @ApiModelProperty(notes = "Descrição da pauta em questão")
    private String pauta;
    @ApiModelProperty(notes = "Quantidade de votos recebidos a favor")
    private Long voteCountPositive;

    @ApiModelProperty(notes = "Quantidade de votos recebidos contra")
    private Long voteCountNegative;
}
