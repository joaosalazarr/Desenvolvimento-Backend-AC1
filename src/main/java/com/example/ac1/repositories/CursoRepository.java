package com.example.ac1.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.ac1.models.Curso;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class CursoRepository {
    
    @Autowired
    private EntityManager entityManager;

    @Transactional
    public Curso inserir(Curso curso) {
        return entityManager.merge(curso);
    }

    public List<Curso> listar() {
        return entityManager.createQuery(
                "FROM Curso t", Curso.class).getResultList();
    }

    public Curso buscarPorId(Long id) {
        return entityManager.find(Curso.class, id);
    }

    @Transactional
    public Curso editar(Curso curso) {
        return entityManager.merge(curso);
    }

    @Transactional
    public void excluir(Long id) {
        Curso curso = buscarPorId(id);
        if (curso != null) {
            entityManager.remove(curso);
        }
    }
}