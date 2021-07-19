package br.com.challenge.voteservice.service;

import br.com.challenge.voteservice.api.v1.response.VoteCountResponse;
import br.com.challenge.voteservice.dto.PautaDto;
import br.com.challenge.voteservice.entity.PautaEntity;
import br.com.challenge.voteservice.exception.PautaDoesNotHaveVoteException;
import br.com.challenge.voteservice.exception.PautaNotFoundException;
import br.com.challenge.voteservice.mapper.PautaMapper;
import br.com.challenge.voteservice.repository.PautaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class PautaService {

    private final PautaMapper pautaMapper;
    private final PautaRepository pautaRepository;

    public void registerPauta(PautaDto pautaDto){
        PautaEntity pautaEntity = pautaMapper.mapToEntity(pautaDto);
        pautaRepository.save(pautaEntity);
    }

    public VoteCountResponse getVoteCount(Integer pautaId) throws PautaDoesNotHaveVoteException, PautaNotFoundException {
        PautaEntity pautaEntity = getPautaEntity(pautaId);
        return pautaMapper.mapToVoteCountResponse(pautaEntity);
    }

    private PautaEntity getPautaEntity(Integer pautaId) throws PautaNotFoundException {
        return pautaRepository.findBypautaId(pautaId).orElseThrow(PautaNotFoundException::new);
    }

}
