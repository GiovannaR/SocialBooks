package com.crc.socialbooks.com.algaworks.socialbooks.com.algaworks.socialbooks.services.exceptions;

public class AutoresExistentesException extends RuntimeException {

    public AutoresExistentesException  (String mensagem){
        super(mensagem);
    }

    public AutoresExistentesException(String mensagem, Throwable causa){
        super(mensagem, causa);
    }
}
