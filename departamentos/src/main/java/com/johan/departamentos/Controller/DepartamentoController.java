package com.johan.departamentos.controllers;

import com.johan.departamentos.models.DepartamentoModel;
import com.johan.departamentos.services.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/departamentos")
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;

    @PostMapping
    public ResponseEntity<DepartamentoModel> criarDepartamento(@RequestBody DepartamentoModel departamentoModel){

        DepartamentoModel request = departamentoService.criarDepartamento(departamentoModel);

        URI uri = URI.create("/departamentos/" + request.getId());
        return ResponseEntity.created(uri).body(request);
    }


    @GetMapping
    public ResponseEntity<List<DepartamentoModel>> findAll(){
        List<DepartamentoModel> request = departamentoService.findAll();
        return ResponseEntity.ok().body(request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarDepartamento(@PathVariable Long id){
        departamentoService.deletarDepartamento(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public void buscarDepartamentoPorId(@PathVariable Long id){
        departamentoService.buscarDepartamentoPorId(id);

    }

}