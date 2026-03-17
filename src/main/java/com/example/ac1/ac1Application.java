package com.example.ac1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.ac1.models.Aluno;
import com.example.ac1.models.Curso;
import com.example.ac1.repositories.AlunoRepository;
import com.example.ac1.repositories.CursoRepository;

@SpringBootApplication
public class ac1Application {

	@Bean
	public CommandLineRunner init(
			@Autowired AlunoRepository alunoRepository,
			@Autowired CursoRepository cursoRepository) {
		return args -> {
			Curso c1 = cursoRepository.inserir(new Curso(null, "ADS"));
			Curso c2 = cursoRepository.inserir(new Curso(null, "Arquitetura e Urbanismo"));
			
			Aluno a1 = new Aluno(null, "João Vitor Salazar", c1, 2024);
			Aluno a2 = new Aluno(null, "Mikaella Giovanna Alcides de Moraes", c2, 2024);

			alunoRepository.inserir(a1);
			alunoRepository.inserir(a2);

			List<Aluno> listaAlunos = alunoRepository.listar();
			listaAlunos.forEach(System.out::println);
			List<Curso> listaCursos = cursoRepository.listar();
			listaCursos.forEach(System.out::println);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(ac1Application.class, args);
	}
}
