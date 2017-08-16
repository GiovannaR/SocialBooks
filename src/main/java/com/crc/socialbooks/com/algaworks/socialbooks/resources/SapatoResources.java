package com.crc.socialbooks.com.algaworks.socialbooks.resources;

import com.crc.socialbooks.com.algaworks.socialbooks.com.algaworks.socialbooks.services.SapatoService;
import com.crc.socialbooks.com.algaworks.socialbooks.domain.Sapato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sapato")
public class SapatoResources {

    @Autowired
    public SapatoService sapatoService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Sapato>> listar (){
        return ResponseEntity.status(HttpStatus.OK).body(sapatoService.listar());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> salvar (@RequestBody Sapato sapato){
        sapato = sapatoService.salvar(sapato);
        return ResponseEntity.status(HttpStatus.OK);
    }


}
