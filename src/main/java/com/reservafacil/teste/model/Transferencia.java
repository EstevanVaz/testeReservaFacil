package com.reservafacil.teste.model;

import java.time.LocalDate;

public class Transferencia {

	private String contaOrigem;
	private String contaDestino;
	private String valorTransferencia;
	private String dataTransferencia;
	private String dataAgendamento;
	private String taxa;

	public Transferencia() {
	}
	
	
	public Transferencia(String contaOrigem, String contaDestino,
			String valorTransferencia, String dataTransferencia, String dataAgendamento, String taxa) {
		this.contaOrigem = contaOrigem;
		this.contaDestino = contaDestino;
		this.valorTransferencia = valorTransferencia;
		this.dataTransferencia = dataTransferencia;
		this.dataAgendamento = dataAgendamento;
		this.taxa = taxa;
	}
	
	public String getContaOrigem() {
		return contaOrigem;
	}

	public void setContaOrigem(String contaOrigem) {
		this.contaOrigem = contaOrigem;
	}

	public String getContaDestino() {
		return contaDestino;
	}

	public void setContaDestino(String contaDestino) {
		this.contaDestino = contaDestino;
	}

	public String getValorTransferencia() {
		return valorTransferencia;
	}

	public void setValorTransferencia(String valorTransferencia) {
		this.valorTransferencia = valorTransferencia;
	}

	public String getDataTransferencia() {
		return dataTransferencia;
	}

	public void setDataTransferencia(String dataTransferencia) {
		this.dataTransferencia = dataTransferencia;
	}

	public String getDataAgendamento() {
		return dataAgendamento;
	}

	public void setDataAgendamento(String dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}

	public String getTaxa() {
		return taxa;
	}

	public void setTaxa(String taxa) {
		this.taxa = taxa;
	}

}
