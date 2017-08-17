package com.crc.socialbooks.com.algaworks.socialbooks.handler;

import com.crc.socialbooks.com.algaworks.socialbooks.com.algaworks.socialbooks.services.exceptions.LivroNaoEncontradoException;
import com.crc.socialbooks.com.algaworks.socialbooks.com.algaworks.socialbooks.services.exceptions.SapatoNaoEncontradoException;
import com.crc.socialbooks.com.algaworks.socialbooks.domain.DetalhesErro;
import com.crc.socialbooks.com.algaworks.socialbooks.domain.Sapato;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(SapatoNaoEncontradoException.class)
    public ResponseEntity<DetalhesErro> handleSapatoNaoEncontradoException(SapatoNaoEncontradoException e, HttpServletRequest request){
        DetalhesErro erro = new DetalhesErro();
        erro.setStatus(404l);
        erro.setTitulo("O sapato não pôde ser encontrado");
        erro.setMensagemDesenvolvedor("http://erros.socialbooks.com/404");
        erro.setTimestamp(System.currentTimeMillis());


        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }
}
