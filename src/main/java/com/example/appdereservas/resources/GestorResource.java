package com.example.appdereservas.resources;

import com.example.appdereservas.entities.Cliente;
import com.example.appdereservas.entities.Gestor;
import com.example.appdereservas.services.GestorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/gestores")
public class GestorResource {

    @Autowired
    private GestorService gestorService;


    @GetMapping
    @ResponseStatus(HttpStatus.FOUND)
    public List<Gestor> getGestor(){
        return  gestorService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public Gestor findById(@PathVariable Long id){
        return gestorService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Gestor insert(@RequestBody Gestor c){
        return gestorService.insert(c);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void delete(@PathVariable Long id){
        gestorService.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Gestor update(@PathVariable Long id, @RequestBody Gestor c){
        return c = gestorService.update(id,c);
    }


}
