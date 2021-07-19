package br.com.challenge.voteservice.stub;

import br.com.challenge.voteservice.client.response.UserPermissionResponse;

public class UserStub {

    public static UserPermissionResponse anyUserPermissionResponse(){
        return UserPermissionResponse.builder()
                .status("status")
                .build();
    }
}
