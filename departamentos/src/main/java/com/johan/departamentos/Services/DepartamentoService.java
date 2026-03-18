package com.johan.departamentos.services;

import com.johan.departamentos.models.DepartamentoModel;
import com.johan.departamentos.repositories.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartamentoService {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    public DepartamentoModel criarDepartamento(DepartamentoModel departamento){
        return departamentoRepository.save(departamento);
    }

    public List<DepartamentoModel> findAll(){
        return departamentoRepository.findAll();
    }

    public Optional<DepartamentoModel> buscarDepartamentoPorId(Long id){
        return departamentoRepository.findById(id);
    }

    public void deletarDepartamento(Long id){
        departamentoRepository.deleteById(id);
    }
}