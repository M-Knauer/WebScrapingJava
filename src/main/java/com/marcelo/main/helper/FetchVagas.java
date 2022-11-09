package com.marcelo.main.helper;

import java.io.IOException;
import com.marcelo.main.model.Vaga;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

@Service
public class FetchVagas {
	
	public static List<Vaga> extrairDados() throws IOException {
		return extrairDados("tecnologia");
	}
	
	public static List<Vaga> extrairDados(String query) throws IOException {
		if (query == null) {
			query = "tecnologia";
		}
		//url do site
		String url = "https://www.vagas.com.br/vagas-de-"+query;
		
		//conectando e obtendo uma copia do html inteiro da pagina
		Document doc = Jsoup.connect(url).get();
		
		// pegando a lista de anuncios de trabalho
		List<Element> anuncios = doc.getElementsByClass("grupoDeVagas");
		
		// pegando a tag <a> desses anuncios
		List<Element> anchors = new ArrayList<>();
		anuncios.forEach(element -> {
			anchors.addAll(element.getElementsByTag("a"));
		});
		
		// pegando o titulo das tags <a>/anchor
		List<String> titles = new ArrayList<>();
		anchors.forEach(element -> {
			titles.add(element.attr("title"));
		});
		
		// pegando os links dos trabalhos
		List<String> href = new ArrayList<>();
		anchors.forEach(link -> {
			href.add("https://www.vagas.com.br"+link.attr("href"));
		});
		
		// pegando a tag <span>
		List<Element> empresas = new ArrayList<>();
		anuncios.forEach(element -> {
			empresas.addAll(element.getElementsByClass("emprVaga"));
		});
		
		List<Element> nivelVagas = new ArrayList<>();
		anuncios.forEach(e -> {
			nivelVagas.addAll(e.getElementsByClass("nivelVaga"));
		});
		
		List<Element> detalhes = new ArrayList<>();
		anuncios.forEach(e -> {
			detalhes.addAll(e.getElementsByTag("p"));
		});
		
		List<Element> locais = new ArrayList<>();
		anuncios.forEach(action -> {
			locais.addAll(action.getElementsByClass("vaga-local"));
		});
		
		List<Element> datas = new ArrayList<>();
		anuncios.forEach(action -> {
			datas.addAll(action.getElementsByClass("data-publicacao"));
					});
					
					List<Vaga> vagas = new ArrayList<>();
					for (int c = 0; c < locais.size(); c++) {
						Vaga vaga = new Vaga(
									titles.get(c), 
									empresas.get(c).text(), 
									nivelVagas.get(c).text(), 
									locais.get(c).text(), 
									detalhes.get(c).text(),
									datas.get(c).text(),
									href.get(c)
								);
						vagas.add(vaga);
					}
			
			return vagas;
			
	}

	public static void main(String[] args) throws IOException {
		
		List<Vaga> vagas = extrairDados();
		
		vagas.forEach(action -> {
			System.out.printf("%s\n%s\n%s\n%s\n%s\n%s\n", action.getTitulo(), action.getNivel(),action.getDetalhes(),action.getLocal(), action.getData(), action.getLink());
			System.out.println();
		});
		
		
		
	}

}
