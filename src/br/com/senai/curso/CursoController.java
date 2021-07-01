package br.com.senai.curso;

import java.util.List;
import java.util.Scanner;

import br.com.senai.aluno.Aluno;

public class CursoController {

	private Scanner in;

	public CursoController() {
		in = new Scanner(System.in);
	}

	public void menuCurso(List<Curso> cursos, List<Aluno> alunos) {
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
				excluirCurso(cursos, alunos);
				break;

			default:
				System.out.println("Op??o Inv?lida!");
				break;
		}
	}

	public Curso cadastrarCurso() {

		System.out.println("\n=== CADASTRAR CURSO ===");

		Curso curso = new Curso();

		in.nextLine();

		System.out.print("Informe o nome do curso: ");
		curso.setNomeCurso(in.nextLine());

		System.out.println("\nCurso cadastrado!");

		return curso;
	}

	public List<Curso> listarCursos(List<Curso> cursos) {

		if (cursos.isEmpty()) {
			System.out.println("\nN˜o possui cursos cadastrados.");
			return null;
		}

		System.out.println("\n=== CURSOS CADASTRADOS ===");

		System.out.printf("| %2s | %10s |\n", "Id", "Nome Curso");

		for (int i = 0; i < cursos.size(); i++) {
			System.out.printf("| %2d | %10s |\n", i + 1, cursos.get(i).getNomeCurso());
		}

		return cursos;
	}

	public List<Curso> editarCurso(List<Curso> cursos) {

		if (cursos.isEmpty()) {
			System.out.println("\nN˜o possui cursos cadastrados.");
			return null;
		}

		listarCursos(cursos);

		Curso curso = new Curso();

		System.out.println("\n=== EDITAR CURSO ===");

		System.out.print("Informe o Id do curso para editar: ");
		int idCurso = in.nextInt() - 1;

		System.out.print("\nInforme o novo nome do curso: ");
		curso.setNomeCurso(in.nextLine());

		cursos.set(idCurso, curso);

		System.out.println("\nNome alterado.");

		return cursos;
	}

	public void excluirCurso(List<Curso> cursos, List<Aluno> alunos) {

		if (cursos.isEmpty()) {
			System.out.println("\nN˜o possui cursos cadastrados.");
			return;
		}

		listarCursos(cursos);

		System.out.println("\n=== EXCLUIR CURSO ===");

		System.out.print("Informe o Id do curso para excluir: ");
		int idCurso = in.nextInt() - 1;

		String nomeCurso = cursos.get(idCurso).getNomeCurso();

		for (int i = 0; i < alunos.size(); i++) {
			String alunoNomeCurso = alunos.get(i).getCurso().getNomeCurso();

			if (alunoNomeCurso.equals(nomeCurso)) {
				System.out.println("\nN?o ? poss?vel excluir o curso!");
				return;
			}
		}

		if (cursos.size() <= idCurso) {
			System.out.println("\nCurso n˜o cadastrado.");
			return;
		}

		cursos.remove(idCurso);

		System.out.println("\nCurso exclu?do!");
	}
}
