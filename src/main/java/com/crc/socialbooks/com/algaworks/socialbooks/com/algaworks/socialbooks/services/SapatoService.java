package com.crc.socialbooks.com.algaworks.socialbooks.com.algaworks.socialbooks.services;


import com.crc.socialbooks.com.algaworks.socialbooks.domain.Sapato;
import com.crc.socialbooks.com.algaworks.socialbooks.repository.SapatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
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


}
