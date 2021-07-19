package br.com.challenge.voteservice.exception;

public class UserUnableToVoteException extends Exception {

    public UserUnableToVoteException() {
        super("O usuário informado não está habilitado a votar");
    }

}
