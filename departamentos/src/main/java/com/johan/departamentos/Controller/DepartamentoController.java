package com.johan.departamentos.controllers;

import com.johan.departamentos.models.DepartamentoModel;
import com.johan.departamentos.services.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/departamentos")
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;

    @PostMapping
    public DepartamentoModel criarDepartamento(@RequestBody DepartamentoModel departamento){
        return departamentoService.criarDepartamento(departamento);
    }

    @GetMapping
    public List<DepartamentoModel> listarDepartamentos(){
        return departamentoService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<DepartamentoModel> buscarDepartamentoPorId(@PathVariable Long id){
        return departamentoService.buscarDepartamentoPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletarDepartamento(@PathVariable Long id){
        departamentoService.deletarDepartamento(id);
    }
}