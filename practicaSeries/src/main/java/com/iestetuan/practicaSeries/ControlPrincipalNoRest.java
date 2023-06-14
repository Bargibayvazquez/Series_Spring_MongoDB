package com.iestetuan.practicaSeries;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.iestetuan.practicaSeries.model.Premios;
import com.iestetuan.practicaSeries.model.Serie;
import com.iestetuan.practicaSeries.repository.PremiosRespository;
import com.iestetuan.practicaSeries.repository.SerieRespositori;
@Controller

public class ControlPrincipalNoRest {
@Autowired
	SerieRespositori IS;

@Autowired
	PremiosRespository IP;


@GetMapping("/crear/Premio")
public String CrearPremio() {
	

	
	List<Serie>ch= IS.findBynombreSerieContaining("DOOM PATROL");
	List<Serie>Emy = 	IS.getp("E");
	List<Serie>GB = 	IS.getp("F");
	List<Serie>FZ = 	IS.getp("G");
	

	
	
	Premios p=new Premios (1,"EMMY","Importante",Emy);
	Premios p1=new Premios (2,"Globos de oro","Importante",GB);
	Premios p2=new Premios (3,"Critics Choice","Medio",ch);
	Premios p3=new Premios (4,"Premios Feroz","Leve",FZ);

	
	
	
	
	IP.save(p);
	IP.save(p1);
	IP.save(p2);
	IP.save(p3);
	


	System.out.println("-----------------------------Acabamos de crear una Lista de Premios REVISA MONGO DB----------------------------------------");

	
	return "ejemplo";

}

@GetMapping("/crear/Serie")
	public String CrearSerie() {
	


	List<String>helencoS=Arrays.asList("Homer","Marge","Bart","Lisa","Maggie","Abuelo Simpson");
	List<String>helencoR=Arrays.asList("Rick","Morty","Beth","Summer","Jerry");
	List<String>helencoSOPRA=Arrays.asList("Tony","Chrisopher","Pauli","Livia","Silvio","Junior");
	List<String>helencoXMEN=Arrays.asList("Lobezno","Ciclope","Tormenta","Fenix","Gammbito","Profesor x");
	List<String>helencoDOOM=Arrays.asList("Robotman","Negative Man","Elasti-girl","Crazy Jany","Cyborg","Dorothy");
	
	
	Serie s=new Serie(1,"Los Simpson ",1987," Matt Groening",helencoS,"E");
	Serie s1=new Serie(2,"Rick & Morty ",2013," Justin Roiland, Dan Harmon",helencoR,"G");
	Serie s2=new Serie(3," Soprano ",1999," David Chase",helencoSOPRA,"E");
	Serie s3=new Serie(4,"Las supernenas",1992,"  Stan Lee, Jack Kirby, Steve Ditko, Len Wein",helencoXMEN,"F");
	Serie s4=new Serie(5,"DOOM PATROL ",2019," Matt Jeremy Carver",helencoDOOM,"F");

		IS.save(s);
		IS.save(s1);
		IS.save(s2);
		IS.save(s3);
		IS.save(s4);
		
		
	System.out.println("-----------------------------Acabamos de crear una Lista de series con su helenco corespondiente REVISA MONGO DB----------------------------------------");
	return "ejemplo";
}



@GetMapping("/Borar/Serie/{id}")
	public String deletedSerie(@PathVariable("id")Integer id) {
	
	IS.deleteById(id);
	
	
	
	System.out.println("-----------------------------Acabamos de borrar una  serie de su lista con su helenco corespondiente este es su ID:  "+id+"----------REVISA MONGO DB ---");
	
	
	return "ejemplo";
	
	
}
@GetMapping("/Update/Serie/{id}")
	public String updateSerie(@PathVariable("id")Integer id) {
	Serie s=IS.findById(id).orElse(null);
	
	s.setNombreSerie("XMEN");
	IS.save(s);
	
	
	System.out.println("-----------------------------Acabamos de actualizar  la serie con id :  "+id+"----------REVISA MONGO DB ---");

	return "ejemplo";
	
	

	
	
}

@GetMapping("/Update/Premio/{id}")
public String updatePremio(@PathVariable("id")Integer id) {
Premios ps=IP.findById(id).orElse(null);

ps.setImportancia("media");

IP.save(ps);


System.out.println("-----------------------------Acabamos de actualizar el nivel de importancia de unos premios  este es su ID:  "+id+"----------REVISA MONGO DB ---");

return "ejemplo";

}
@GetMapping("/Borar/Premios/{id}")
public String deletedPremios(@PathVariable("id")Integer id) {

IP.deleteById(id);



System.out.println("----------------------------- Acabamos de borrar un premio este es su ID:  "+id+"----------REVISA MONGO DB ---");


return "ejemplo";


}
@GetMapping("/Listar/Premios/Importancia")
public String premiosImportancia() {
	
	List<Premios> pr= IP.getImportancia("Importante");
	 System.out.println("--------------------------------------------Vamos a listar los premios con relevnacia mas importante--------------------------------------------");
	
	
	pr.forEach(x-> System.out.println(x));	
	
	System.out.println("--------------------------------------------FIN DE LA LISTA---------------------------------------------------------------------------------------");
	
	return "ejemplo";
	
	
	
}
@GetMapping("/Listar/Premios/Personalizada")
public String premiosPersonalizados() {
	
	List<Premios> pr= IP.getConsultaVariada();
	 System.out.println("--------------------------------------------Vamos a listar los premios con una query personalizada--------------------------------------------");
	
	
	pr.forEach(x-> System.out.println(x));	
	
	System.out.println("--------------------------------------------FIN DE LA LISTA---------------------------------------------------------------------------------------");
	
	return "ejemplo";
	
	
	
}
}
