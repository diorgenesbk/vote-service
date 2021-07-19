package br.com.challenge.voteservice.service;

import br.com.challenge.voteservice.client.UserPermissionClient;
import br.com.challenge.voteservice.client.response.UserPermissionResponse;
import br.com.challenge.voteservice.entity.UserEntity;
import br.com.challenge.voteservice.enums.UserStatusEnum;
import br.com.challenge.voteservice.exception.CpfIsNotValidException;
import br.com.challenge.voteservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.net.URISyntaxException;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserPermissionClient userPermissionClient;
    private final UserRepository userRepository;

    public UserPermissionResponse getUserPermission(String cpf) throws URISyntaxException, CpfIsNotValidException {
        return userPermissionClient.getUserPermission(cpf);
    }

    public Boolean checkUserAble(Integer userId) {
        try{
            UserEntity userEntity = userRepository.findByUserId(userId);
            UserPermissionResponse userPermissionResponse = getUserPermission(userEntity.getCpf());

            return UserStatusEnum.ABLE_TO_VOTE.getValue().equals(userPermissionResponse.getStatus());
        } catch (Exception e){
            //log
        }
        return Boolean.FALSE;
    }
}
