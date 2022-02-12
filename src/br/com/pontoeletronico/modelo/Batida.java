package br.com.pontoeletronico.modelo;

import java.util.Date;

public class Batida {
	private Date hora;
	private String tipoBatida;
	
	public Batida() {
	}
	
	public Batida(Date hora, String tipoBatida) {
		this.hora = hora;
		this.tipoBatida = tipoBatida;
	}
	public Date getHora() {
		return hora;
	}
	public void setHora(Date hora) {
		this.hora = hora;
	}
	public String getTipoBatida() {
		return tipoBatida;
	}
	public void setTipoBatida(String tipoBatida) {
		this.tipoBatida = tipoBatida;
	}
	
}
