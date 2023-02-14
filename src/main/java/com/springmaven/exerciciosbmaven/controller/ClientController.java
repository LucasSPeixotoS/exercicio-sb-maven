package com.springmaven.exerciciosbmaven.controller;

import com.springmaven.exerciciosbmaven.model.entity.Client;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/client")
public class ClientController {

    @RequestMapping
    public Client getClient(){
        return new Client(26, "Lucas", "111.111.111.11");
    }

    @GetMapping("/{id}")
    public Client findById(@PathVariable int id){
        return new Client(24, "Eleonora", "111.111.111.11");
    }

    @GetMapping
    public Client findByClientId(@RequestParam(name = "id") int id){
        return new Client(id, 28, "Natalino", "111.111.111.11");
    }
}
