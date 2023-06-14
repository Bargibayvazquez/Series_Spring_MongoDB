package com.iestetuan.practicaSeries.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.iestetuan.practicaSeries.model.Premios;
import com.iestetuan.practicaSeries.model.Serie;

public interface PremiosRespository extends MongoRepository<Premios,Integer> {

	List <Premios>findBynombrePremioContaining(String nombrePremio);


//Querys Especificas
	
@Query("{Importancia: ?0}")       	
List<Premios>getImportancia(String Importancia);


@Query (value="{nombrePremio:'EMMY'}", fields="{'id':1,'Importancia':1,'nombrePremio':1}")
List<Premios>getConsultaVariada();

}
