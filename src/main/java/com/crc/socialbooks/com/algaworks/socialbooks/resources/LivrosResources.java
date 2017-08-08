package com.crc.socialbooks.com.algaworks.socialbooks.resources;

import com.crc.socialbooks.com.algaworks.socialbooks.com.algaworks.socialbooks.services.LivrosService;
import com.crc.socialbooks.com.algaworks.socialbooks.com.algaworks.socialbooks.services.exceptions.LivroNaoEncontradoException;
import com.crc.socialbooks.com.algaworks.socialbooks.domain.Comentario;
import com.crc.socialbooks.com.algaworks.socialbooks.domain.Livro;
import com.crc.socialbooks.com.algaworks.socialbooks.repository.LivrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;


@RestController
@RequestMapping("/livros")
public class LivrosResources {

    @Autowired
    public LivrosService livrosService;

    @RequestMapping( method = RequestMethod.GET)
    public ResponseEntity<List<Livro>> listar( ){
        return ResponseEntity.status(HttpStatus.OK).body(livrosService.listar());
    }

    @RequestMapping( method = RequestMethod.POST)
    public ResponseEntity<Void> salvar (@Valid @RequestBody Livro livro){

        livro = livrosService.salvar(livro);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id").buildAndExpand(livro.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value ="/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> buscar(@PathVariable("id") Long id){
        Livro livro = livrosService.buscar(id);

        CacheControl cacheControl = CacheControl.maxAge(150, TimeUnit.SECONDS);

        return ResponseEntity.status(HttpStatus.OK).cacheControl(cacheControl).body(livro);
    }

    @RequestMapping(value ="/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deletar (@PathVariable("id") Long id){
        livrosService.deletar(id);
        return  ResponseEntity.noContent().build();
    }

    @RequestMapping(value ="/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> atualizar (@RequestBody Livro livro, @PathVariable("id") Long id){
        livro.setId(id);
        livrosService.atualizar(livro);

        return ResponseEntity.noContent().build();
    }


    @RequestMapping(value= "/{id}/comentarios", method = RequestMethod.POST)
    public ResponseEntity<Void> adicionarComentario ( @PathVariable("id") Long livroId, @RequestBody Comentario comentarios){
        livrosService.salvarComentario(livroId, comentarios);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest( ).build( ).toUri();

        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value="/{id}/comentarios", method = RequestMethod.GET)
    public ResponseEntity<List<Comentario>> listarComentarios(@PathVariable("id") Long livroid){
        List<Comentario> comentarios = livrosService.listarComentarios(livroid);

        return ResponseEntity.status(HttpStatus.OK).body(comentarios);
    }
}
