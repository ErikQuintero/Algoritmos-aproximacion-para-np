import java.util.ArrayList;
import java.util.*;

//Clase que sirve para probar nuestro esquema de subset sum 
public class Prueba{
	public static void main(String[] args){

		System.out.println("Que conjunto quieres probar?\n");
		
		System.out.println("La 1:\n");
		System.out.println(Ejemplares.s1());
		System.out.println("La 2:\n");
		System.out.println(Ejemplares.s2());
		System.out.println("La 3:\n");
		System.out.println(Ejemplares.s3());
		System.out.println("La 4:\n");
		System.out.println(Ejemplares.s4());
		System.out.println("La 5:\n");
		System.out.println(Ejemplares.s5());
		Scanner sc = new Scanner(System.in);
		String escaner = sc.nextLine();
		if(escaner.equals("1")){
			Ejemplares e = Ejemplares.s1();		
			ArrayList<Integer> prueba = e.lista;
			double radioAux = e.radio;
			int objetivoAux = e.objetivo;
			System.out.println(e.toString());
			int aprox = SubsetSum.aproximacionS(prueba, objetivoAux, radioAux);
			System.out.println("Aproximacion: "+ aprox);
		}else if(escaner.equals("2")){
			Ejemplares e = Ejemplares.s2();		
			ArrayList<Integer> prueba = e.lista;
			double radioAux = e.radio;
			int objetivoAux = e.objetivo;
			System.out.println(e.toString());
			int aprox = SubsetSum.aproximacionS(prueba, objetivoAux, radioAux);
			System.out.println("Aproximacion: "+ aprox);
		}else if(escaner.equals("3")){
			Ejemplares e = Ejemplares.s3();		
			ArrayList<Integer> prueba = e.lista;
			double radioAux = e.radio;
			int objetivoAux = e.objetivo;
			System.out.println(e.toString());
			int aprox = SubsetSum.aproximacionS(prueba, objetivoAux, radioAux);
			System.out.println("Aproximacion: "+ aprox);
		}else if(escaner.equals("4")){
			Ejemplares e = Ejemplares.s4();		
			ArrayList<Integer> prueba = e.lista;
			double radioAux = e.radio;
			int objetivoAux = e.objetivo;
			System.out.println(e.toString());
			int aprox = SubsetSum.aproximacionS(prueba, objetivoAux, radioAux);
			System.out.println("Aproximacion: "+ aprox);
		}else if(escaner.equals("5")){
			Ejemplares e = Ejemplares.s5();		
			ArrayList<Integer> prueba = e.lista;
			double radioAux = e.radio;
			int objetivoAux = e.objetivo;
			System.out.println(e.toString());
			int aprox = SubsetSum.aproximacionS(prueba, objetivoAux, radioAux);
			System.out.println("Aproximacion: "+ aprox);
		}else{

		}
	}

}
