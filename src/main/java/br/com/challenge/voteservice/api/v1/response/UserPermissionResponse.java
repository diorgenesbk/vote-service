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
public class UserPermissionResponse {
    @ApiModelProperty(notes = "Status do usuário, indica se ele está apto ou não a votar")
    private String status;
}
