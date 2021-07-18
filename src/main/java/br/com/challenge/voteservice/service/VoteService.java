package br.com.challenge.voteservice.service;

import br.com.challenge.voteservice.UserAlreadyVotedException;
import br.com.challenge.voteservice.dto.VoteDto;
import br.com.challenge.voteservice.entity.VoteEntity;
import br.com.challenge.voteservice.mapper.VoteMapper;
import br.com.challenge.voteservice.repository.VoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@RequiredArgsConstructor
@Service
public class VoteService {

    private final VoteMapper voteMapper;
    private final VoteRepository voteRepository;

    public void registerVote(VoteDto voteDto) throws UserAlreadyVotedException {
        verifyVoteByUser(voteDto);

        VoteEntity voteEntity = voteMapper.mapToEntity(voteDto);
        voteRepository.save(voteEntity);
    }

    private void verifyVoteByUser(VoteDto voteDto) throws UserAlreadyVotedException {
        Optional<VoteEntity> voteEntity = voteRepository.findByUserIdAndSessionId(voteDto.getUserId(), voteDto.getSessionId());

        if(voteEntity.isPresent())
            throw new UserAlreadyVotedException();
    }



}
