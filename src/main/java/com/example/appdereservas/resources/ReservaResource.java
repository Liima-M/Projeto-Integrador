package com.example.appdereservas.resources;

import com.example.appdereservas.entities.Cliente;
import com.example.appdereservas.entities.Reserva;

import com.example.appdereservas.services.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/reservas")
public class ReservaResource {

    @Autowired
    private ReservaService service;

    @GetMapping
    public ResponseEntity<List<Reserva>> findAll(){
        List<Reserva> list = service.findAll();

        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Reserva> findById(@PathVariable Long id){
        Reserva obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}