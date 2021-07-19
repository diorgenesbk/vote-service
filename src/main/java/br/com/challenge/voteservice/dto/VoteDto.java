package br.com.challenge.voteservice.dto;

import br.com.challenge.voteservice.entity.SessionEntity;
import br.com.challenge.voteservice.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.ZonedDateTime;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VoteDto {
    private Integer voteId;
    private Boolean choice;
    private ZonedDateTime voteDateTime;
    private Integer sessionId;
    private SessionDto session;
    private Integer userId;
    private UserDto user;
}
