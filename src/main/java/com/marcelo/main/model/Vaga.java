package com.marcelo.main.model;

public class Vaga {
	private String titulo;
	private String empresa;
	private String nivel;
	private String local;
	private String detalhes;
	private String data;
	private String link;
	
	public Vaga() {
		
	}

	public Vaga(String titulo, String empresa, String nivel, String local, String detalhes, String data, String link) {
		this.titulo = titulo;
		this.empresa = empresa;
		this.nivel = nivel;
		this.local = local;
		this.detalhes = detalhes;
		this.data = data;
		this.link = link;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getDetalhes() {
		return detalhes;
	}

	public void setDetalhes(String detalhes) {
		this.detalhes = detalhes;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
	
}
