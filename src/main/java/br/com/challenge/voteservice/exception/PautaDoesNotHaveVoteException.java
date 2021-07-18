package br.com.challenge.voteservice.exception;

public class PautaDoesNotHaveVoteException extends Exception {

    public PautaDoesNotHaveVoteException() {
        super("A Pauta em questão não possui votos");
    }

}
