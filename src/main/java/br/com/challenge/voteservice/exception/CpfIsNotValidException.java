package br.com.challenge.voteservice.exception;

public class CpfIsNotValidException extends Exception {

    public CpfIsNotValidException() {
        super("O Cpf do usuário não é valido");
    }

}
