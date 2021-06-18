package Practica.Final;
import java.awt.PageAttributes.MediaType;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class FinalControllers {


	@GetMapping("/primitiva")
	   public String combinacion() {
		String resultadoString="";
		resultadoString=generarCombinacion()+"<br>";
		return HTML(resultadoString);
	}
	

	@GetMapping(value="/primitiva/XML")
	public Combinaciones combinacionXML() {
		Combinaciones comb1=new Combinaciones();
		comb1=generarCombinacionXML();
		return comb1;
	}
	
	@GetMapping("/primitiva/{id}")
	public String combinacion2(@PathVariable("id") int id) {
		String resultado="";
		System.out.println(id);
		for (int a =0; a<id; a++) 
		{
			resultado+=generarCombinacion()+"<br>";

		}
		System.out.println();
		return HTML(resultado);


	}
	
	private Combinaciones generarCombinacionXML(){

//		Genera combinaciones y las muestra en pantalla
		Combinaciones comb1 = new Combinaciones();
		
			Set<Integer> setCombinacion = new TreeSet<Integer>();
			Random generator;
			int reint=0;
			int comp=0;
		     try {
		     do {
				Thread.sleep(1);
				generator = new Random(System.currentTimeMillis());
				setCombinacion.add((int)(generator.nextDouble()*49)+1);
				Thread.sleep(1);
				comp = ((int)((generator.nextDouble()*49))+1);
			}
			while (setCombinacion.size()<6);
				
				System.out.println("punto1");
			while (setCombinacion.contains(comp)){
				comp = ((int)((generator.nextDouble()*49))+1);
			}
			System.out.println("punto2");

			Thread.sleep(1);
			 reint = (int)(generator.nextDouble()*10);

			 
			Iterator<Integer> it = setCombinacion.iterator();
			System.out.println("punto3");

			int  numeros[]=new int[6];
			int a=0;
			while (it.hasNext()){
				numeros[a]=(int) it.next();
				a++;
			}

		comb1.setNumero1(numeros[0]);
		comb1.setNumero2(numeros[1]);
		comb1.setNumero3(numeros[2]);
		comb1.setNumero4(numeros[3]);
		comb1.setNumero5(numeros[4]);
		comb1.setNumero6(numeros[5]);
		comb1.setComplementario(comp);
		comb1.setReintegro(reint);
			
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		     
			return comb1;
			

		}

    private String HTML(String cadena) {
		String resultado="";
		resultado="<HTML><table border=\"1\"><tr><th>Titulo</th><th>Noticia</th></tr>";

		StringTokenizer tokens=new StringTokenizer(cadena,"<br>");
		int a=1;
		while(tokens.hasMoreTokens())
		{
                		resultado+="<tr><td> combinación: "+a+"</td>";
				resultado+="<td>"+tokens.nextToken()+"</td></tr>";
				a++;
		}
			resultado+="</body></HTML>";
	    return resultado;
    }
    
    private String  generarCombinacion(){

//		Genera combinaciones y las muestra en pantalla
			
			Set<Integer> setCombinacion = new TreeSet<Integer>();
			String combinacion = "";
			Random generator;
			int reint=0;
			int comp=0;
		     try {
		     do {
				Thread.sleep(1);
				generator = new Random(System.currentTimeMillis());
				setCombinacion.add((int)(generator.nextDouble()*49)+1);
				Thread.sleep(1);
				comp = ((int)((generator.nextDouble()*49))+1);
			}
			while (setCombinacion.size()<6);
				
		
			while (setCombinacion.contains(comp)){
				comp = ((int)((generator.nextDouble()*49))+1);
			}
			
			Thread.sleep(1);
			 reint = (int)(generator.nextDouble()*10);
			

			Iterator<Integer> it = setCombinacion.iterator();
			
			while (it.hasNext()){
				combinacion += it.next()+ "-";
			}
			combinacion +=" C-"+comp+ " R-"+ reint;
			System.out.println(combinacion);
			
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		     
			return combinacion;
			

		}
}
