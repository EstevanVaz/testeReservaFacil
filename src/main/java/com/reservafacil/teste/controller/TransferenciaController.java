package com.reservafacil.teste.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.reservafacil.teste.model.Transferencia;
import com.reservafacil.teste.repository.Transferencias;

@Controller
public class TransferenciaController {

	@Autowired
	private Transferencias transferencias;
	
	@RequestMapping("/transferencias")
	public ModelAndView listar() {

		ModelAndView mv = new ModelAndView("ListaTransferencias");
		mv.addObject("transferencias", transferencias.todos());
		mv.addObject(new Transferencia());

		return mv;
	}

	@RequestMapping(value = "/transferencias", method = RequestMethod.POST)
	public String salvar(Transferencia transferencia) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dataTransferencia = LocalDate.parse(transferencia.getDataTransferencia(),formatter);
		LocalDate dataAgendamento = LocalDate.now();
	
		String taxa = transferencias.calcularTaxa(dataAgendamento, dataTransferencia, new Double(transferencia.getValorTransferencia()));
		String formattedString = dataAgendamento.format(formatter);
		transferencia.setDataAgendamento(formattedString);
		transferencia.setTaxa(taxa);
		
		if (!taxa.equalsIgnoreCase("-1")){
			this.transferencias.adicionar(transferencia);
			return "redirect:/transferencias";
		}else{
			return "redirect:/erro";
		}
	}
	
	@RequestMapping("/erro")
	public String erro() {

		return "Erro";
	}

	
}