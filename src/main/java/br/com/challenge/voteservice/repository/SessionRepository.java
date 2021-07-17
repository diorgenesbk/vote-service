package br.com.challenge.voteservice.repository;

import br.com.challenge.voteservice.entity.SessionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SessionRepository extends JpaRepository<SessionEntity, Integer> {

}
