package com.crc.socialbooks.com.algaworks.socialbooks.com.algaworks.socialbooks.services;


import com.crc.socialbooks.com.algaworks.socialbooks.com.algaworks.socialbooks.services.exceptions.SapatoNaoEncontradoException;
import com.crc.socialbooks.com.algaworks.socialbooks.domain.Sapato;
import com.crc.socialbooks.com.algaworks.socialbooks.repository.SapatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SapatoService {

    @Autowired
    public SapatoRepository sapatoRepository;

    public List<Sapato> listar (){
        return sapatoRepository.findAll();
    }


    public Sapato salvar (Sapato sapato){
        sapato.setId(null);
        return sapatoRepository.save(sapato);
    }


    public Sapato buscar (Long id){
        Sapato sapato = sapatoRepository.findOne(id);

        if (sapato == null){
            throw new SapatoNaoEncontradoException("Nao foi possivel encontrar o sapato");
        }

        return sapato;
    }

    public void deletar (Long id){
        try {
            sapatoRepository.delete(id);
        }catch (EmptyResultDataAccessException e){
            throw new SapatoNaoEncontradoException("Nao foi possivel encontrar o sapato");
        }
    }



}
