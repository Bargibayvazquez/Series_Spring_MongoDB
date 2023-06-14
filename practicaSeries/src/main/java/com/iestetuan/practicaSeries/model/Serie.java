package com.iestetuan.practicaSeries.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection="Series")
public class Serie {
@Id 
	private Integer id;
	private String nombreSerie;
	private Integer anyoSerie;
	private String Creadorserie;
	private List<String>helenco;
	private String TP;

//Getters & Setters
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombreSerie() {
		return nombreSerie;
	}
	public void setNombreSerie(String nombreSerie) {
		this.nombreSerie = nombreSerie;
	}
	public Integer getAnyoSerie() {
		return anyoSerie;
	}
	public void setAnyoSerie(Integer anyoSerie) {
		this.anyoSerie = anyoSerie;
	}
	public String getCreadorserie() {
		return Creadorserie;
	}
	public void setCreadorserie(String creadorserie) {
		Creadorserie = creadorserie;
	}
	public List<String> getHelenco() {
		return helenco;
	}
	public void setHelenco(List<String> helenco) {
		this.helenco = helenco;
	}
	public String getTP() {
		return TP;
	}
	public void setTP(String tP) {
		TP = tP;
	}
	
	//ToString
	
	
	
	@Override
	public String toString() {
		return "Serie [id=" + id + ", nombreSerie=" + nombreSerie + ", anyoSerie=" + anyoSerie + ", Creadorserie="
				+ Creadorserie + ", helenco=" + helenco + ", TP=" + TP + "]";
	}
	public Serie() {
		super();
	}
	public Serie(Integer id, String nombreSerie, Integer anyoSerie, String creadorserie, List<String> helenco,
			String tP) {
		super();
		this.id = id;
		this.nombreSerie = nombreSerie;
		this.anyoSerie = anyoSerie;
		Creadorserie = creadorserie;
		this.helenco = helenco;
		TP = tP;
	}

	
	
	
	
}
