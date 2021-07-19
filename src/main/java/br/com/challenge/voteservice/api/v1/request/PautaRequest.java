package br.com.challenge.voteservice.api.v1.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel
public class PautaRequest {
    @NonNull
    @ApiModelProperty(notes="Descrição da pauta", required = true)
    private String description;
}
