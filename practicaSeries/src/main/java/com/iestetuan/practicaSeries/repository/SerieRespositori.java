package com.iestetuan.practicaSeries.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.iestetuan.practicaSeries.model.Premios;
import com.iestetuan.practicaSeries.model.Serie;

public interface SerieRespositori  extends MongoRepository<Serie, Integer>  {

	
	List<Serie>findBynombreSerieContaining(String nombreSerie);
	

//Querys predeterminadas.

@Query("{TP: ?0}") 
	 List<Serie>getp(String tP);


@Query( "{anyoSerie: {$lt: ?0}}" )    
List<Serie>getAnyo(Integer anyoSerie);


@Query("{$and :[{TP: ?0},{AnyoSerie: ?1}] }")
List<Serie>dosEntredas(String TP,Integer AnyoSerie);



@Query (value="{Creadorserie:'Matt Jeremy Carver'}", fields="{'nombreSerie':1}")
List <Serie>findQuery();
}
