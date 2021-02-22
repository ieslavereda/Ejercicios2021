package test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Test {

	public static void main(String[] args) {
		
		ArrayList<Persona> personas = cargarPersonas("personas.csv");
		Collections.sort(personas);
		System.out.println(personas);
		System.out.println("----------------");
		personas.sort((p1,p2) -> p2.getEdad()-p1.getEdad());
		System.out.println(personas);
		
		String listado="";
		for(Persona p : personas)
			listado+=p.toString();
		
		save(listado,"personas_sort.csv");
		
		
		List<Persona> lista = personas.stream()
								// public boolean test(Persona p)
								.filter(p -> p.getEdad()>30 && p.getEdad()<45)
								.filter(p-> p.getEdad()%2==0)
								.sorted((p1,p2) -> p1.getApellidos().compareTo(p2.getApellidos()))
								.collect(Collectors.toList());
			
		System.out.println(lista);
	}

	private static ArrayList<Persona> cargarPersonas(String file) {
		
		ArrayList<Persona> personas = new ArrayList<Persona>();
		
		try(BufferedReader br = new BufferedReader(new FileReader(file))){
			
			String linea="";
			String[] lineaVector;
			
			while((linea=br.readLine())!=null) {
				lineaVector = linea.split(",");
				personas.add(new Persona(lineaVector[0],lineaVector[1],lineaVector[2],Integer.parseInt(lineaVector[3])));
			}
			
		} catch (Exception e) {
			System.out.println("Se ha producido un error: " +e.getMessage());
		}
		
		return personas;
	}
	
	public static void save(String listado,String fichero) {
		try(PrintWriter pw = new PrintWriter(new FileWriter(fichero))){
			pw.print(listado);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}








