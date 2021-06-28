package br.com.senai.aluno;

import java.util.List;
import java.util.Scanner;

public class AlunoController {
	
	private Scanner in;
	
	public AlunoController() {
		in = new Scanner(System.in);
	}
	
	public void menuAluno(List<Aluno> alunos) {
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
			alunos.add(cadastrarAluno());
			break;
			
		case 2:
			listarAlunos(alunos);
			break;
			
		case 3:
			editarAluno(alunos);
			break;
			
		case 4:
			excluirAluno(alunos);
			break;
			
		default:
			System.out.println("Opção Inválida!");
			break;
		}
	}
	
	public Aluno cadastrarAluno() {
		Aluno alunos = new Aluno();
		
		in.nextLine();
		
		System.out.print("\nInforme o nome: ");
		alunos.setNomeAluno(in.nextLine());
		
		System.out.print("Informe a idade: ");
		alunos.setIdadeAluno(in.nextInt());
		
		System.out.print("informe o pais: ");
		in.nextLine();
		alunos.setPais(in.nextLine());
		
		System.out.print("Informe o estado: ");
		alunos.setEstado(in.nextLine());
		
		System.out.print("Informe a cidade: ");
		alunos.setCidade(in.nextLine());
		
		System.out.println("\nAluno Cadastrado!");
		
		return alunos;
	}
	
	public List<Aluno> listarAlunos(List<Aluno> alunos) {
		
		if (alunos.isEmpty()) {
			System.out.println("\nNão possui alunos cadastrados.");
			return null;
		}

		System.out.println("\n=== ALUNOS CADASTRADOS ===");

		System.out.printf(
				"| %2s | %4s | %5s | %6s | %14s | %14s |\n", 
				"Id", "Nome", "Idade", "Pais", "Estado", "Cidade");

		for (int i = 0; i < alunos.size(); i++) {
			System.out.printf(
					"| %2d | %4s | %5d | %6s | %14s | %14s |\n",
					i + 1, 
					alunos.get(i).getNomeAluno(), 
					alunos.get(i).getIdadeAluno(), 
					alunos.get(i).getPais(), 
					alunos.get(i).getEstado(), 
					alunos.get(i).getCidade()
					);
		}
		
		return alunos;
	}
	
	public List<Aluno> editarAluno(List<Aluno> alunos) {
		
		if (alunos.isEmpty()) {
			System.out.println("\nNão possui alunos cadastrados.");
			return null;
		}
		
		
		return alunos;
	}
	
	public void excluirAluno(List<Aluno> alunos) {
		
		if (alunos.isEmpty()) {
			System.out.println("\nNão possui alunos cadastrados.");
		}
		
		
		System.out.println("Aluno excluído!");
	}
}
