package br.com.pontoeletronico.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Usuario {
	private String nome;
	private String cargo;
	private List<Batida> batidas;
	private Scanner scanner = new Scanner(System.in);
	
	public Usuario() {
		
	}
	
	public Usuario(String nome, String cargo) {
		this.nome = nome;
		this.cargo = cargo;
		this.batidas = new ArrayList<Batida>();
	}
	
	public void incluirBatida(Batida batida) {
		batidas.add(batida);
	}
	
	public void editarBatida() {
		listarBatidas();
		System.out.print("Digite o ID da batida para editar: ");
		int batidaId = scanner.nextInt();
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
		this.batidas.get(batidaId).setTipoBatida(entradaSaida);
		this.batidas.get(batidaId).setHora(new Date());
	}
	
	public void excluirBatida() {
		listarBatidas();
		System.out.print("Digite o ID da batida para excluir: ");
		int batidaId = scanner.nextInt();
		Batida batida = this.batidas.get(batidaId);
		System.out.println("Você tem certeza que quer excluir o registro - " + batida.getTipoBatida() + " " + batida.getHora());
		System.out.println("Digite 1 para SIM");
		System.out.println("Digite 2 para NÃO");
		System.out.print("Informe o valor: ");
		int confirmacaoId = scanner.nextInt();
		if(confirmacaoId == 1) {
			this.batidas.remove(batida);
		}
	}
		
	public void listarBatidas() {
		System.out.println("Batidas do usuário "+ this.nome +" :");
		for (int i = 0; i < this.batidas.size(); i++) {
			System.out.println("Id: "+i+" Tipo Batida:" + this.batidas.get(i).getTipoBatida() + " - " + this.batidas.get(i).getHora());
		}
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public List<Batida> getBatida() {
		return batidas;
	}
	public void setBatida(List<Batida> batidas) {
		this.batidas = batidas;
	}
	
}
