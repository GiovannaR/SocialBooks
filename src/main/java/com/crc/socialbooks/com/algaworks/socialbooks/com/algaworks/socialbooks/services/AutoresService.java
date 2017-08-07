package com.crc.socialbooks.com.algaworks.socialbooks.com.algaworks.socialbooks.services;

import com.crc.socialbooks.com.algaworks.socialbooks.com.algaworks.socialbooks.services.exceptions.AutoresExistentesException;
import com.crc.socialbooks.com.algaworks.socialbooks.com.algaworks.socialbooks.services.exceptions.autorNaoEncontradoException;
import com.crc.socialbooks.com.algaworks.socialbooks.domain.Autor;
import com.crc.socialbooks.com.algaworks.socialbooks.repository.AutoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutoresService {

    @Autowired
    private AutoresRepository autoresRepository;

    public List<Autor> listar(){
        return autoresRepository.findAll();
    }


    public Autor salvar (Autor autor){
        if(autor.getId() != null){
            Autor b = autoresRepository.findOne(autor.getId());

            if (b != null){
                throw new AutoresExistentesException("O autor já existe");
            }
        }
        return autoresRepository.save(autor);
    }

    public Autor buscar (Long id){
        Autor autor = autoresRepository.findOne(id);

        if ( autor == null ){
            throw new autorNaoEncontradoException("Autor não encontrado");
        }
        return autor;
    }

}
