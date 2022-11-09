package com.marcelo.main.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.marcelo.main.helper.FetchVagas;
import com.marcelo.main.model.Vaga;

@Controller
public class VagaController {
	
	@RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.POST})
	public String vaga(String queryString, Model model) {
		try {
			if (queryString == "" || queryString == null) {
				queryString = "tecnologia";
			}
			List<Vaga> vagas = FetchVagas.extrairDados(queryString);
			
			model.addAttribute("vagas", vagas);
			model.addAttribute("nomeBusca", "Vagas de "+queryString);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return "index";
		
	}
	
}
