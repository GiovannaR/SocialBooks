package com.crc.socialbooks.com.algaworks.socialbooks.resources;

import com.crc.socialbooks.com.algaworks.socialbooks.domain.Livro;
import com.crc.socialbooks.com.algaworks.socialbooks.repository.LivrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;



@RestController
@RequestMapping("/livros")
public class LivrosResources {

    @Autowired
    public LivrosRepository livrosRepository;

    @RequestMapping( method = RequestMethod.GET)
    public List<Livro> listar( ){
        return livrosRepository.findAll();
    }

    @RequestMapping( method = RequestMethod.POST)
    public void salvar (@RequestBody Livro livro){
        livrosRepository.save(livro);
    }

    @RequestMapping(value ="/{id}", method = RequestMethod.GET)
    public Livro buscar(@PathVariable("id") Long id){
        return livrosRepository.findOne(id);
    }

    @RequestMapping(value ="/{id}", method = RequestMethod.DELETE)
    public void deletar (@PathVariable("id") Long id){
        livrosRepository.delete(id);
    }
}
