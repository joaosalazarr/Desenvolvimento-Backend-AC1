package com.example.ac1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ac1.models.Curso;
import com.example.ac1.repositories.CursoRepository;

@RestController
public class CursoController {
    
    @Autowired
    private CursoRepository cursoRepository;

    @PostMapping("/cursos")
    public Curso inserir(@RequestBody Curso curso) {
        return cursoRepository.inserir(curso);
    }

    @GetMapping("/cursos")
    public List<Curso> mostrarTodos() {
        List<Curso> listaCursos = cursoRepository.listar();
        return listaCursos;
    }
}