package com.example.appdereservas.resources;

import com.example.appdereservas.entities.Cliente;
import com.example.appdereservas.entities.Gestor;
import com.example.appdereservas.services.GestorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/gestores")
public class GestorResource {

    @Autowired
    private GestorService service;

    @GetMapping
    public ResponseEntity<List<Gestor>> findAll(){
        List<Gestor> list = service.findAll();

        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Gestor> findById(@PathVariable Long id){
        Gestor obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}
