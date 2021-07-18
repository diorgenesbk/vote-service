package br.com.challenge.voteservice.service;

import br.com.challenge.voteservice.dto.SessionDto;
import br.com.challenge.voteservice.entity.SessionEntity;
import br.com.challenge.voteservice.mapper.SessionMapper;
import br.com.challenge.voteservice.repository.SessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class SessionService {

    private final SessionMapper sessionMapper;
    private final SessionRepository sessionRepository;

    public void openSession(SessionDto sessionDto){
        SessionEntity sessionEntity = sessionMapper.mapToEntity(sessionDto);
        sessionRepository.save(sessionEntity);
    }

}
