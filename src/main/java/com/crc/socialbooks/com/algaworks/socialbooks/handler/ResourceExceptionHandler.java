package com.crc.socialbooks.com.algaworks.socialbooks.handler;

import com.crc.socialbooks.com.algaworks.socialbooks.com.algaworks.socialbooks.services.exceptions.LivroNaoEncontradoException;
import com.crc.socialbooks.com.algaworks.socialbooks.domain.DetalhesErro;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(LivroNaoEncontradoException.class)
    public ResponseEntity<Void> handleLivroNaoEncontradoException(LivroNaoEncontradoException e, HttpServletRequest request){
        DetalhesErro erro = new DetalhesErro();
        erro.setStatus(404l);
        erro.setTitulo("O livro não pôde ser encontrado");
        return ResponseEntity.notFound().build();
    }
}
