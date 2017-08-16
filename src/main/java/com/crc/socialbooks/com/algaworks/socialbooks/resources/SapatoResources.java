package com.crc.socialbooks.com.algaworks.socialbooks.resources;

import com.crc.socialbooks.com.algaworks.socialbooks.com.algaworks.socialbooks.services.SapatoService;
import com.crc.socialbooks.com.algaworks.socialbooks.domain.Sapato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public Sapato salvar (@RequestBody Sapato sapato){
        sapato = sapatoService.salvar(sapato);
        return sapato;
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public Sapato buscar(@PathVariable("id") Long id){
        Sapato sapato = sapatoService.buscar(id);
        return sapato;
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public void deletar (@PathVariable("id") Long id){
        sapatoService.deletar(id);
    }

}
