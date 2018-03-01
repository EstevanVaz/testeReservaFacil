package com.reservafacil.teste.repository;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.reservafacil.teste.model.Transferencia;

@Repository
public class Transferencias {

	private static final List<Transferencia> LISTA_TRANSFERENCIAS = new ArrayList<>();
	
	static {
		LISTA_TRANSFERENCIAS.add(new Transferencia("1", "2", "103.0", "01/03/2018","01/03/2018", "3.0"));
	}

	public List<Transferencia> todos() {
		return Transferencias.LISTA_TRANSFERENCIAS;
	}

	public void adicionar(Transferencia transferencia) {
		Transferencias.LISTA_TRANSFERENCIAS.add(transferencia);
	}
	
	public String calcularTaxa(LocalDate dataAgendamento, LocalDate dataTransferencia, Double valorTransferencia){
		
		double taxa = -1;
		 // Calcula a diferença de dias entre as duas datas
		long dias = ChronoUnit.DAYS.between(dataAgendamento,dataTransferencia);
		System.out.println("ChronoUnit.DAYS.between(dataAgendamento,dataTransferencia) => " + dias);
		
		if (dias == 0){
			// Transferências no mesmo dia do agendamento tem uma taxa de $3 mais 3% do valor a ser transferido;
			taxa = 3 + (valorTransferencia*3)/100;
		}else if (dias <= 10){
			// Transferências até 10 dias da data de agendamento possuem uma taxa de $12 multiplicado pela quantidade de dias da data de agendamento até a data de transferência.
			taxa = 12 * dias;
		}else if(dias > 10 && dias <= 20){
			// Acima de 10 até 20 dias da data de agendamento 8%
			taxa = (valorTransferencia*8)/100;
		}else if(dias > 20 && dias <= 30){ 
			// Acima de 20 até 30 dias da data de agendamento 6%
			taxa = (valorTransferencia*6)/100;
		}else if(dias > 30 && dias <= 40){
			// Acima de 30 até 40 dias da data de agendamento 4%
			taxa = (valorTransferencia*4)/100;
		}else if (valorTransferencia > 100000){
			// Acima de 40 dias da data de agendamento e valor superior a 100.000 2%
			taxa = (valorTransferencia*2)/100;
		}
		
		DecimalFormat df = new DecimalFormat("###,##0.00");
		if (taxa > 0){
			return df.format(taxa);	
		}else{
			return "-1";
		}
		
		
	}
}