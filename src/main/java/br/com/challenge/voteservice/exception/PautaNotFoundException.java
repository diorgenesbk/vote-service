package br.com.challenge.voteservice.exception;

public class PautaNotFoundException extends Exception {

    public PautaNotFoundException() {
        super("Pauta não encontrada");
    }

}
