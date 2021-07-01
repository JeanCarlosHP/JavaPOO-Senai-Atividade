package br.com.senai;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.senai.aluno.Aluno;
import br.com.senai.aluno.AlunoController;
import br.com.senai.curso.Curso;
import br.com.senai.curso.CursoController;

public class ProgramaPrincipal {

	public static void main(String[] args) {
		List<Aluno> alunos = new ArrayList<Aluno>();
		List<Curso> cursos = new ArrayList<Curso>();

		Scanner in = new Scanner(System.in);
		boolean sair = true;

		AlunoController alunoController = new AlunoController();
		CursoController cursoController = new CursoController();

		do {
			menuPrincipal();
			int opcao = in.nextInt();

			switch (opcao) {
				case 1:
					alunoController.menuAluno(alunos, cursos);
					break;

				case 2:
					cursoController.menuCurso(cursos, alunos);
					break;

				case 0:
					System.out.println("\nSistema Finalizado!");
					sair = false;
					break;

				default:
					System.out.println("Opção Inválida!");
					break;
			}

		} while (sair);
		in.close();
	}

	public static void menuPrincipal() {
		System.out.println("\n=== MENU PRINCIPAL ===");
		System.out.println("1 - Registro Aluno");
		System.out.println("2 - Registro Curso");
		System.out.println("0 - Sair");
		System.out.println("======================");

		System.out.print("> ");
	}

}
