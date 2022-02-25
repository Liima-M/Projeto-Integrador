package com.example.appdereservas.resources;

import com.example.appdereservas.entities.Reserva;

import com.example.appdereservas.services.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/reservas")
public class ReservaResource {

    @Autowired
    private ReservaService reservaService;


    @GetMapping
    @ResponseStatus(HttpStatus.FOUND)
    public List<Reserva> getReserva(){
        return  reservaService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public Reserva findById(@PathVariable Long id){
        return reservaService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Reserva insert(@RequestBody Reserva c){
        return reservaService.insert(c);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void delete(@PathVariable Long id){
        reservaService.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Reserva update(@PathVariable Long id, @RequestBody Reserva c){
        return c = reservaService.update(id,c);
    }

}
