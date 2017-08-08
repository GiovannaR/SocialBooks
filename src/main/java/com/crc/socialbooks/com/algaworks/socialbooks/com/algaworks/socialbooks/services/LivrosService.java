package com.crc.socialbooks.com.algaworks.socialbooks.com.algaworks.socialbooks.services;

import com.crc.socialbooks.com.algaworks.socialbooks.com.algaworks.socialbooks.services.exceptions.LivroNaoEncontradoException;
import com.crc.socialbooks.com.algaworks.socialbooks.domain.Comentario;
import com.crc.socialbooks.com.algaworks.socialbooks.domain.Livro;
import com.crc.socialbooks.com.algaworks.socialbooks.repository.ComentariosRepository;
import com.crc.socialbooks.com.algaworks.socialbooks.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@Service
public class LivrosService {

    @Autowired
    public LivroRepository livrosRepository;

    @Autowired
    private ComentariosRepository comentariosRepository;

    public List<Livro> listar ( ){
        return livrosRepository.findAll();
    }

    public Livro buscar (Long id){
        Livro livro = livrosRepository.findOne(id);

        if (livro == null){
            throw new LivroNaoEncontradoException("O livro não pôde ser encontrado.");
        }

        return livro;
    }

    public Livro salvar (Livro livro){
        livro.setId(null);
        return livrosRepository.save(livro);

    }

    public void deletar (Long id){
        try{
            livrosRepository.delete(id);
        }catch (EmptyResultDataAccessException e){
            throw new LivroNaoEncontradoException("O livro não pôde ser encontrado");
        }
    }

    public void atualizar (Livro livro){
        verificarExistencia(livro);
        livrosRepository.save(livro);
    }

    private void verificarExistencia(Livro livro){

        buscar(livro.getId());
    }

    public Comentario salvarComentario (@Valid Long LivroId, Comentario comentario){
        Livro livro = buscar(LivroId);
        comentario.setLivro(livro);
        comentario.setData(new Date());

        return comentariosRepository.save(comentario);
    }

    public List<Comentario> listarComentarios(Long livroId){
        Livro livro = buscar(livroId);
        return livro.getComentarios();
    }
}
