package com.example.ac1.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_alunos")
public class Aluno {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;
    
    private int anoIngresso;
    
    @ManyToOne
    @JoinColumn(name = "idCurso")
    private Curso curso;

    public Aluno(Long id, String nome, Curso curso, int anoIngresso) 
    {
        this.id = id;
        this.nome = nome;
        this.curso = curso;
        this.anoIngresso = anoIngresso;
    }

    public Aluno() {}

    public Long getId() 
    {
        return this.id;
    }

    public void setId(Long id) 
    {
        this.id = id;
    }

    public String getNome() 
    {
        return this.nome;
    }

    public void setNome(String nome) 
    {
        this.nome = nome;
    }

    public Curso getCurso() 
    {
        return this.curso;
    }

    public void setCurso(Curso curso) 
    {
        this.curso = curso;
    }

    public int getAnoIngresso()
    {
        return this.anoIngresso;
    }

    public void setAnoIngresso(int anoIngresso)
    {
        this.anoIngresso = anoIngresso;
    }

    @Override
    public String toString() 
    {
        return "Aluno [id=" + this.id + ", nome=" + this.nome + ", curso=" + this.curso + ", anoIngresso=" + this.anoIngresso + "]";
    }
}
