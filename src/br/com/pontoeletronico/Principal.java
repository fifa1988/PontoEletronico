package br.com.pontoeletronico;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import br.com.pontoeletronico.modelo.Batida;
import br.com.pontoeletronico.modelo.Usuario;

public class Principal {
	static List<Usuario> usuarios = null;
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		usuarios = new ArrayList<>();
		Usuario usuario = new Usuario("Ariel", "Programador");
		incluirUsuario(usuario);
		
		Usuario usuario2 = new Usuario("Alison", "Programador");
		incluirUsuario(usuario2);
		
		boolean pararPerguntas = false;
		while (!pararPerguntas) {
			listarUsuarios();			
			selecionarUsuario();
			System.out.println("Você deseja encerrar programa?");
			System.out.println("1 - SIM");
			System.out.println("2 - NÃO");
			System.out.print("Selecionar uma opção: ");
			int encerrarLaco = scanner.nextInt();
			if(encerrarLaco == 1) {
				pararPerguntas = true;
			}
		}
		
		usuarios.get(0).listarBatidas();
		
		usuarios.get(1).listarBatidas();
		
		System.out.println("");
	}
	
	public static void incluirUsuario(Usuario usuario) {
		usuarios.add(usuario);
	}
	
	public static void listarUsuarios() {
		System.out.println("Lista de usuários:");
		for (int i = 0; i < usuarios.size(); i++) {
			System.out.println(i + " - " + usuarios.get(i).getNome() + " - " + usuarios.get(i).getCargo());
		}
	}
	
	public static void selecionarUsuario() {
		System.out.print("Digite o ID do usuário para abrir mais opções: ");
		int usuarioId = scanner.nextInt();	
		boolean pararPerguntas = false;
		while (!pararPerguntas) {
			acoesUsuario(usuarioId);
			System.out.println("Você deseja encerrar a sessao de usuário?");
			System.out.println("1 - SIM");
			System.out.println("2 - NÃO");
			System.out.print("Selecionar uma opção: ");
			int encerrarLaco = scanner.nextInt();
			if(encerrarLaco == 1) {
				pararPerguntas = true;
			}
		}
	}
		
	public static void acoesUsuario(int usuarioId) {		
		System.out.println("Selecionar uma opção: ");
		System.out.println("1 - Incluir batida");
		System.out.println("2 - Editar batida do usuário");
		System.out.println("3 - Excluir batida");		
		System.out.print("Selecionar uma opção: ");
		int usuarioOpcaoId = scanner.nextInt();
		if(usuarioOpcaoId == 1) {
			System.out.println("Selecione o tipo da batida: ");
			System.out.println("1 - Entrada");
			System.out.println("2 - Saída");
			System.out.print("Selecionar uma opção: ");
			int entradaSaidaId = scanner.nextInt();
			String entradaSaida = "";
			if(entradaSaidaId == 1) {
				entradaSaida = "Entrada";
			}else {
				entradaSaida = "Saída";
			}
			Batida batida = new Batida(new Date(), entradaSaida);
			Usuario usuario = usuarios.get(usuarioId);
			usuario.incluirBatida(batida);
		} else if(usuarioOpcaoId == 2) {
			usuarios.get(usuarioId).editarBatida();
		} else if(usuarioOpcaoId == 3) {
			usuarios.get(usuarioId).excluirBatida();
		}else {
			System.out.println("Número informado não é válido");
			acoesUsuario(usuarioId);
		}
		
	}

}
