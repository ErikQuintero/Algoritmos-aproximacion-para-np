import java.util.ArrayList;
import java.util.Collections;

//Clase que emula el esquema de aproximacion de subset sum
public class SubsetSum{

	//Algoritmo de aproximacion
	public static int aproximacionS(ArrayList<Integer> ls, int t, double epsilon){
		ArrayList<Integer> lista = new ArrayList<Integer>();
		lista.add(0);
		for(int i : ls){
			ArrayList<Integer> aux = new ArrayList<Integer>();
			for(int j : lista){
				int suma = i+j;
				aux.add(suma);				
			}
			mezcla(lista, aux);
			Collections.sort(lista);
			lista = podarElementos(lista, epsilon/(2*ls.size()));
			ArrayList<Integer> menores = new ArrayList<Integer>();			
			for(int k : lista){	
				if(k <= t){
					menores.add(k);
				}				
			}
			lista = menores;			
		}
		return lista.get(lista.size()-1);
	}

	//Metodo que sirve para podar
	public static ArrayList<Integer> podarElementos(ArrayList<Integer> lista, double delta){
		ArrayList<Integer> listaPrima = new ArrayList<Integer>();
		listaPrima.add(lista.get(0));
		int last = lista.get(0); 
		for(int i = 1; i < lista.size(); i++){
			if(lista.get(i) > last*(delta+1)){
				listaPrima.add(lista.get(i));
				last = lista.get(i);
			}
		}
		return listaPrima;
	}

	//Metodo que sirve para ezclar dos listas
	public static void mezcla(ArrayList<Integer> l1, ArrayList<Integer> l2){
		for(int x : l2){
			l1.add(x);
		}
	}
}
