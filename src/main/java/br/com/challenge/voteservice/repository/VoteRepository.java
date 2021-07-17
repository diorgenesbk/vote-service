package br.com.challenge.voteservice.repository;

import br.com.challenge.voteservice.entity.VoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VoteRepository extends JpaRepository<VoteEntity, Integer> {

}
