package br.com.challenge.voteservice.repository;

import br.com.challenge.voteservice.entity.PautaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PautaRepository extends JpaRepository<PautaEntity, Integer> {

}
