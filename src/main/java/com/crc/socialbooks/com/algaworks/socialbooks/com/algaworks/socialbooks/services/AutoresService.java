package com.crc.socialbooks.com.algaworks.socialbooks.com.algaworks.socialbooks.services;

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

}
