package br.com.senai.aluno;

import java.util.List;
import java.util.ArrayList;

import br.com.senai.curso.Curso;
import br.com.senai.endereco.Endereco;

public class Aluno extends Endereco {
	private String nomeAluno;
	private int idadeAluno;
	private List<Curso> cursos = new ArrayList<Curso>();
	
	public String getNomeAluno() {
		return nomeAluno;
	}
	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}
	public int getIdadeAluno() {
		return idadeAluno;
	}
	public void setIdadeAluno(int idadeAluno) {
		this.idadeAluno = idadeAluno;
	}
}
