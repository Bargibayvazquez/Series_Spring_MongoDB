package com.iestetuan.practicaSeries.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Document (collection="Premios")
public class Premios {
@Id
	private Integer id;
	private String nombrePremio;
	private String Importancia;
	
@DBRef()
	private  List <Serie>serie;
	
	
	
	

//Getters & Setters.	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombrePremio() {
		return nombrePremio;
	}
	public void setNombrePremio(String nombrePremio) {
		this.nombrePremio = nombrePremio;
	}
	public String getImportancia() {
		return Importancia;
	}
	public void setImportancia(String importancia) {
		Importancia = importancia;
	}
	public List<Serie> getSerie() {
		return serie;
	}
	public void setSerie(List<Serie> serie) {
		this.serie = serie;
	}
	
//ToString	
	@Override
	public String toString() {
		return "Premios [id=" + id + ", nombrePremio=" + nombrePremio + ", Importancia=" + Importancia + ", serie="
				+ serie + "]";
	}
	
	
//Constructores
	
	
	public Premios() {
		super();
	}
	public Premios(Integer id, String nombrePremio, String importancia, List<Serie> serie) {
		super();
		this.id = id;
		this.nombrePremio = nombrePremio;
		this.Importancia = importancia;
		this.serie = serie;
	}
	

	
	
	
}
