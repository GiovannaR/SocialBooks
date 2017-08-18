package com.crc.socialbooks.com.algaworks.socialbooks.resources;

import com.crc.socialbooks.com.algaworks.socialbooks.com.algaworks.socialbooks.services.SapatoService;
import com.crc.socialbooks.com.algaworks.socialbooks.domain.Comprador;
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
    public ResponseEntity<Void> salvar (@RequestBody Sapato sapato){
        sapato = sapatoService.salvar(sapato);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public ResponseEntity<Sapato> buscar(@PathVariable("id") Long id){
        Sapato sapato = sapatoService.buscar(id);
        return ResponseEntity.status(HttpStatus.OK).body(sapato);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deletar (@PathVariable("id") Long id){
        sapatoService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> atualizar (@RequestBody Sapato sapato, @PathVariable("id") Long id ){
        sapato.setId(id);
        sapatoService.atualizar(sapato);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}/comprador", method = RequestMethod.POST)
    public ResponseEntity<Void> adicionarComprador (@PathVariable("id") Long id, @RequestBody Comprador comprador){
        sapatoService.adicionarComprador(id, comprador);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @RequestMapping(value = "/{id}/comprador", method = RequestMethod.GET)
    public ResponseEntity<Comprador> listarComprador (@PathVariable("id") Long id){
        Comprador comprador = sapatoService.listarComprador(id);
        return ResponseEntity.status(HttpStatus.OK).body(comprador);
    }

}
