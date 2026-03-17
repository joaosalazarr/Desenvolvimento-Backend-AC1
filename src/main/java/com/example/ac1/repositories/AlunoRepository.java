package com.example.ac1.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.ac1.models.Aluno;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class AlunoRepository 
{
    
    @Autowired
    private EntityManager entityManager;

    @Transactional
    public Aluno inserir(Aluno aluno) 
    {
        return entityManager.merge(aluno);
    }

    public List<Aluno> listar() 
    {
        return entityManager.createQuery(
                "FROM Aluno p", Aluno.class).getResultList();
    }

    public Aluno selecionarPorId(Long id) 
    {
        return entityManager.find(Aluno.class, id);
    }

    @Transactional
    public Aluno editar(Aluno aluno) 
    {
        return entityManager.merge(aluno);
    }

    @Transactional
    public void excluir(Long id) 
    {
        Aluno aluno = entityManager.find(Aluno.class, id);
        if (aluno != null) {
            entityManager.remove(aluno);
        }
    }
}