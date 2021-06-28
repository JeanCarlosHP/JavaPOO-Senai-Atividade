package br.com.senai.curso;

import java.util.List;
import java.util.Scanner;

public class CursoController {
	
	private Scanner in;
	
	public CursoController() {
		in = new Scanner(System.in);
	}
	
	public void menuCurso(List<Curso> cursos) {
		System.out.println("\n=== MENU CURSO ===");
		System.out.println("1 - Cadastrar Curso");
		System.out.println("2 - Listar Cursos");
		System.out.println("3 - Editar Curso");
		System.out.println("4 - Excluir Curso");
		System.out.println("=========================");
		
		System.out.print("> ");
		int opcao = in.nextInt();
		
		switch (opcao) {
		case 1:
			cursos.add(cadastrarCurso());
			break;
			
		case 2:
			listarCursos(cursos);
			break;
			
		case 3:
			editarCurso(cursos);
			break;
			
		case 4:
			excluirCurso(cursos);
			break;
			
		default:
			System.out.println("Opção Inválida!");
			break;
		}
	}
	
	public Curso cadastrarCurso() {
		Curso cursos = new Curso();
		
		return cursos;
	}
	
	public List<Curso> listarCursos(List<Curso> cursos) {
		
		
		return cursos;
	}
	
	public List<Curso> editarCurso(List<Curso> cursos) {
		
		
		return cursos;
	}
	
	public void excluirCurso(List<Curso> cursos) {
		
		
		System.out.println("Curso excluído!");
	}
}
