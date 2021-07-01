package br.com.senai.aluno;

import java.util.List;
import java.util.Scanner;

import br.com.senai.curso.Curso;
import br.com.senai.curso.CursoController;

public class AlunoController {

	private Scanner in;

	public AlunoController() {
		in = new Scanner(System.in);
	}

	public void menuAluno(List<Aluno> alunos, List<Curso> cursos) {
		System.out.println("\n==== MENU ALUNO ====");
		System.out.println("1 - Cadastrar Aluno");
		System.out.println("2 - Listar Alunos");
		System.out.println("3 - Editar Aluno");
		System.out.println("4 - Excluir Aluno");
		System.out.println("====================");

		System.out.print("> ");
		int opcao = in.nextInt();

		switch (opcao) {
			case 1:
				alunos.add(cadastrarAluno(cursos));
				break;

			case 2:
				listarAlunos(alunos);
				break;

			case 3:
				editarAluno(alunos, cursos);
				break;

			case 4:
				excluirAluno(alunos);
				break;

			default:
				System.out.println("Opção Inválida!");
				break;
		}
	}

	public Aluno cadastrarAluno(List<Curso> cursos) {

		if (cursos.isEmpty()) {
			System.out.println("\nNão possui cursos cadastrados.");
			return null;
		}

		System.out.println("\n=== CADASTRAR ALUNO ===");

		CursoController cursoController = new CursoController();
		Aluno aluno = new Aluno();

		cursoController.listarCursos(cursos);

		System.out.println("\n--- Dados do curso ---");

		System.out.print("Informe o Id do curso que o aluno deseja participar: ");
		int idCurso = in.nextInt() - 1;

		aluno.setCurso(cursos.get(idCurso));

		System.out.println("\n--- Dados do aluno ---");

		in.nextLine();

		System.out.print("Informe o nome: ");
		aluno.setNomeAluno(in.nextLine());

		System.out.print("Informe a idade: ");
		aluno.setIdadeAluno(in.nextInt());

		System.out.print("informe o país: ");
		in.nextLine();
		aluno.setPais(in.nextLine());

		System.out.print("Informe o estado: ");
		aluno.setEstado(in.nextLine());

		System.out.print("Informe a cidade: ");
		aluno.setCidade(in.nextLine());

		System.out.println("\nAluno Cadastrado!");

		return aluno;
	}

	public List<Aluno> listarAlunos(List<Aluno> alunos) {

		if (alunos.isEmpty()) {
			System.out.println("\nNão possui alunos cadastrados.");
			return null;
		}

		System.out.println("\n=== ALUNOS CADASTRADOS ===");

		System.out.printf("| %2s | %4s | %5s | %6s | %14s | %14s | %10s |\n", "Id", "Nome", "Idade", "País", "Estado",
				"Cidade", "Nome Curso");

		for (int i = 0; i < alunos.size(); i++) {
			System.out.printf("| %2d | %4s | %5d | %6s | %14s | %14s | %10s |\n", i + 1, alunos.get(i).getNomeAluno(),
					alunos.get(i).getIdadeAluno(), alunos.get(i).getPais(), alunos.get(i).getEstado(),
					alunos.get(i).getCidade(), alunos.get(i).getCurso().getNomeCurso());
		}

		return alunos;
	}

	public List<Aluno> editarAluno(List<Aluno> alunos, List<Curso> cursos) {

		if (alunos.isEmpty()) {
			System.out.println("\nNão possui alunos cadastrados.");
			return null;
		}

		listarAlunos(alunos);

		Aluno aluno = new Aluno();
		CursoController cursoController = new CursoController();

		System.out.println("\n=== EDITAR ALUNO ===");

		System.out.print("Informe o Id do aluno para editar: ");
		int idAluno = in.nextInt() - 1;

		System.out.println("\n1) Editar o nome do aluno");
		System.out.println("2) Editar a idade do aluno");
		System.out.println("3) Editar o país do aluno");
		System.out.println("4) Editar o estado do aluno");
		System.out.println("5) Editar a cidade do aluno");
		System.out.println("6) Editar o curso");

		System.out.print("\nInforme o campo para ser editado: ");
		int campo = in.nextInt();
		in.nextLine();

		switch (campo) {
			case 1:
				System.out.println("\n--- Editar nome ---");

				System.out.print("Informe o novo nome: ");
				aluno.setNomeAluno(in.nextLine());

				aluno.setIdadeAluno(alunos.get(idAluno).getIdadeAluno());
				aluno.setPais(alunos.get(idAluno).getPais());
				aluno.setEstado(alunos.get(idAluno).getEstado());
				aluno.setCidade(alunos.get(idAluno).getCidade());
				aluno.setCurso(alunos.get(idAluno).getCurso());

				System.out.println("\nNome alterado.");
				break;

			case 2:
				System.out.println("\n--- Editar idade ---");

				System.out.print("Informe a nova idade: ");
				aluno.setIdadeAluno(in.nextInt());

				aluno.setNomeAluno(alunos.get(idAluno).getNomeAluno());
				aluno.setPais(alunos.get(idAluno).getPais());
				aluno.setEstado(alunos.get(idAluno).getEstado());
				aluno.setCidade(alunos.get(idAluno).getCidade());
				aluno.setCurso(alunos.get(idAluno).getCurso());

				System.out.println("\nIdade alterada.");
				break;

			case 3:
				System.out.println("\n--- Editar país ---");

				System.out.print("Informe o novo país: ");
				aluno.setPais(in.nextLine());

				aluno.setNomeAluno(alunos.get(idAluno).getNomeAluno());
				aluno.setIdadeAluno(alunos.get(idAluno).getIdadeAluno());
				aluno.setEstado(alunos.get(idAluno).getEstado());
				aluno.setCidade(alunos.get(idAluno).getCidade());
				aluno.setCurso(alunos.get(idAluno).getCurso());

				System.out.println("\nPaís alterado.");
				break;

			case 4:
				System.out.println("\n--- Editar estado ---");

				System.out.print("Informe o novo estado: ");
				aluno.setEstado(in.nextLine());

				aluno.setNomeAluno(alunos.get(idAluno).getNomeAluno());
				aluno.setIdadeAluno(alunos.get(idAluno).getIdadeAluno());
				aluno.setPais(alunos.get(idAluno).getPais());
				aluno.setCidade(alunos.get(idAluno).getCidade());
				aluno.setCurso(alunos.get(idAluno).getCurso());

				System.out.println("\nEstado alterado.");
				break;

			case 5:
				System.out.println("\n--- Editar cidade ---");

				System.out.print("Informe a nova cidade: ");
				aluno.setCidade(in.nextLine());

				aluno.setNomeAluno(alunos.get(idAluno).getNomeAluno());
				aluno.setIdadeAluno(alunos.get(idAluno).getIdadeAluno());
				aluno.setPais(alunos.get(idAluno).getPais());
				aluno.setEstado(alunos.get(idAluno).getEstado());
				aluno.setCurso(alunos.get(idAluno).getCurso());

				System.out.println("\nCidade alterada.");
				break;
				
			case 6:
				System.out.println("\n--- Editar curso ---");
				
				cursoController.listarCursos(cursos);
				
				System.out.print("\nInforme o Id do novo curso: ");
				aluno.setCurso(cursos.get(in.nextInt() - 1));
				
				aluno.setNomeAluno(alunos.get(idAluno).getNomeAluno());
				aluno.setIdadeAluno(alunos.get(idAluno).getIdadeAluno());
				aluno.setPais(alunos.get(idAluno).getPais());
				aluno.setEstado(alunos.get(idAluno).getEstado());
				aluno.setCidade(alunos.get(idAluno).getCidade());
				
				System.out.println("\nCurso alterado.");
				break;

			default:
				System.out.println("\nOpção Inválida!");
				break;
		}

		alunos.set(idAluno, aluno);

		return alunos;
	}

	public void excluirAluno(List<Aluno> alunos) {

		if (alunos.isEmpty()) {
			System.out.println("\nNão possui alunos cadastrados.");
			return;
		}

		listarAlunos(alunos);

		System.out.println("\n=== EXCLUIR ALUNO ===");

		System.out.print("Informe o Id do aluno para excluir: ");
		int idAluno = in.nextInt() - 1;

		if (alunos.size() <= idAluno) {
			System.out.println("\nAluno não cadastrado.");
			return;
		}

		alunos.remove(idAluno);

		System.out.println("\nAluno excluí­do!");

	}
}
