package br.com.challenge.voteservice.exception;

public class UserAlreadyVotedException extends Exception {

    public UserAlreadyVotedException() {
        super("O usuário informado já votou na respectiva sessão");
    }

}
