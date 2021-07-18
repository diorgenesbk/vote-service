package br.com.challenge.voteservice.mapper;

import br.com.challenge.voteservice.api.v1.response.UserPermissionResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class UserMapper {

    private final ObjectMapper objectMapper;

    public UserPermissionResponse mapToResponse(br.com.challenge.voteservice.client.response.UserPermissionResponse userPermissionResponse){
        return  objectMapper.convertValue(userPermissionResponse, UserPermissionResponse.class);
    }
}
