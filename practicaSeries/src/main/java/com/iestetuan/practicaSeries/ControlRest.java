package com.iestetuan.practicaSeries;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iestetuan.practicaSeries.model.Premios;
import com.iestetuan.practicaSeries.model.Serie;
import com.iestetuan.practicaSeries.repository.PremiosRespository;
import com.iestetuan.practicaSeries.repository.SerieRespositori;

@RestController
@RequestMapping("/api")
public class ControlRest {
@Autowired
	SerieRespositori SR;
@Autowired
	PremiosRespository IP;

@GetMapping(value="/Premios",produces="application/json;charset=UTF-8")	
public List<Premios>getAllPremios(){
	
	List <Premios>PremiosList;
	
	PremiosList=IP.findAll();
	
	System.out.println("------------------Se listaran desde el navegador todas los premios---------------------------");
	
	return PremiosList;
	
}


@GetMapping(value="/Series",produces="application/json;charset=UTF-8")	
	public List<Serie>getAllSerie(){
	
	List<Serie>serieList;
	serieList=SR.findAll();
    
	System.out.println("------------------Se listaran desde el navegador todas las series---------------------------");
	
	return serieList;
	
	
	}

@GetMapping(value="/Serie/porID/{id}")
	public String getSerieById(@PathVariable("id")Integer id) {
	
	Serie ser=SR.findById(id).orElse(null);
	
	System.out.println("------------------Se lista todo de este id :"+id+ "   vaya al navegador---------------------------");

	
	return ser.toString();
	
	
}
@GetMapping(value="/Serie/porNombre/{nombreSerie}", produces="application/json;charset=UTF-8")
	public List<Serie> getSeriebyNombre(@PathVariable("nombreSerie") String nombreSerie){
		
	List<Serie> serieList;
	
	serieList=SR.findBynombreSerieContaining(nombreSerie);
	
	System.out.println("------------------Se lista todo de esta serie :"+nombreSerie+ "   vaya al navegador---------------------------");
	
	return serieList;
	
}
@GetMapping(value="/Premios/porNombre/{nombrePremio}", produces="application/json;charset=UTF-8")
public List<Premios> getPremiobyNombre(@PathVariable("nombrePremio") String nombrePremio){
	
List<Premios> premiosList;

premiosList=IP.findBynombrePremioContaining(nombrePremio);

System.out.println("------------------Se lista todo de este premio :"+nombrePremio+ "   vaya al navegador---------------------------");

return premiosList;

}

@GetMapping(value="/Lista/Serie/porAnyo", produces="application/json;charset=UTF-8")
public List<Serie> getSeriebyAnyo(){
	
List<Serie> SerieList;

SerieList=SR.getAnyo(2000);

System.out.println("------------------Se listan las series que son anteriores al 1999---------------------------");

return SerieList;

}
@GetMapping(value="/Lista/Serie/porAnyoyTP", produces="application/json;charset=UTF-8")
public List<Serie> getSeriebyAnyoyTp(){
	
List<Serie> SerieList;

SerieList=SR.dosEntredas("E",1999 );

System.out.println("------------------Se listan las series que son del 1999 y ademas su TP es E---------------------------");

return SerieList;

}




}
