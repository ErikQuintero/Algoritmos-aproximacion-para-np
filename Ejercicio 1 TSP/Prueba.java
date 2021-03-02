import java.util.ArrayList;
import java.util.*;

//Aqui se prueba el programa
public class Prueba{
    public static void main(String[] args){

		System.out.println("Que grafica quieres probar?\n");
		
		System.out.println("La 1:\n");
		Grafica eleccion1 = Ejemplar.g1();
		eleccion1.vecinosG(eleccion1.aristas);
		System.out.println(eleccion1);
		System.out.println("La 2:\n");
		Grafica eleccion2 = Ejemplar.g2();
		eleccion2.vecinosG(eleccion2.aristas);
		System.out.println(eleccion2);
		System.out.println("La 3:\n");
		Grafica eleccion3 = Ejemplar.g3();
		eleccion3.vecinosG(eleccion3.aristas);
		System.out.println(eleccion3);
		System.out.println("La 4:\n");
		Grafica eleccion4 = Ejemplar.g4();
		eleccion4.vecinosG(eleccion4.aristas);
		System.out.println(eleccion4);
		System.out.println("La 5:\n");
		Grafica eleccion5 = Ejemplar.g5();
		eleccion5.vecinosG(eleccion5.aristas);
		System.out.println(eleccion5);
		Scanner sc = new Scanner(System.in);
		String escaner = sc.nextLine();
		if(escaner.equals("1")){
			System.out.println("Seleccionaste la grafica 1\n\n");
            Grafica g = Ejemplar.g1();
            g.vecinosG(g.aristas);
            Grafica g2 = g.clonar();
            g2.vecinosG(g2.aristas);
            System.out.println(g);

        
            Grafica arbol = g.arbolGen();
            arbol.vecinosG(arbol.aristas);
            System.out.println("el arbol generador minimo es: \n"+ arbol);
            arbol.verticesGrado();

        
            ArrayList<Vertice> impares = arbol.verticesImpares();
            Grafica indu = g.graficaInducida(impares);
            indu.vecinosG(indu.aristas);
            System.out.println("La grafica inducida es: \n"+ indu);


            ArrayList<Arista> apare = indu.apareamientoMin(arbol);
            System.out.println("El apareamiento es: \n"+ apare + "\n");


       	 	System.out.println("La union del apareamiento con el arbol es:\n");
        	Grafica euleriana = arbol.unirAristas(apare);
        	euleriana.vecinosG(euleriana.aristas);
        	System.out.println(euleriana);


        	System.out.println("El tsp obtenido con peso "+ Grafica.pesoTsp((euleriana.tsp(euleriana.tspV(euleriana.tspAux()),g2))) + " es:" );
        	System.out.println(euleriana.tsp(euleriana.tspV(euleriana.tspAux()),g2));

		}else if(escaner.equals("2")){
			System.out.println("Seleccionaste la grafica 2\n\n");
			Grafica g = Ejemplar.g2();
            g.vecinosG(g.aristas);
            Grafica g2 = g.clonar();
            g2.vecinosG(g2.aristas);
            System.out.println(g);

        
            Grafica arbol = g.arbolGen();
            arbol.vecinosG(arbol.aristas);
            System.out.println("el arbol generador minimo es: \n"+ arbol);
            arbol.verticesGrado();

        
            ArrayList<Vertice> impares = arbol.verticesImpares();
            Grafica indu = g.graficaInducida(impares);
            indu.vecinosG(indu.aristas);
            System.out.println("La grafica inducida es: \n"+ indu);


            ArrayList<Arista> apare = indu.apareamientoMin(arbol);
            System.out.println("El apareamiento es: \n"+ apare + "\n");


       	 	System.out.println("La union del apareamiento con el arbol es:\n");
        	Grafica euleriana = arbol.unirAristas(apare);
        	euleriana.vecinosG(euleriana.aristas);
        	System.out.println(euleriana);


       		System.out.println("El tsp obtenido con peso "+ Grafica.pesoTsp((euleriana.tsp(euleriana.tspV(euleriana.tspAux()),g2))) + " es:" );
        	System.out.println(euleriana.tsp(euleriana.tspV(euleriana.tspAux()),g2));

		}else if(escaner.equals("3")){
			System.out.println("Seleccionaste la grafica 3\n\n");
			Grafica g = Ejemplar.g3();
            g.vecinosG(g.aristas);
            Grafica g2 = g.clonar();
            g2.vecinosG(g2.aristas);
            System.out.println(g);

        
            Grafica arbol = g.arbolGen();
            arbol.vecinosG(arbol.aristas);
            System.out.println("el arbol generador minimo es: \n"+ arbol);
            arbol.verticesGrado();

        
            ArrayList<Vertice> impares = arbol.verticesImpares();
            Grafica indu = g.graficaInducida(impares);
            indu.vecinosG(indu.aristas);
            System.out.println("La grafica inducida es: \n"+ indu);


            ArrayList<Arista> apare = indu.apareamientoMin(arbol);
            System.out.println("El apareamiento es: \n"+ apare + "\n");


       	 	System.out.println("La union del apareamiento con el arbol es:\n");
        	Grafica euleriana = arbol.unirAristas(apare);
        	euleriana.vecinosG(euleriana.aristas);
        	System.out.println(euleriana);


        	System.out.println("El tsp obtenido con peso "+ Grafica.pesoTsp((euleriana.tsp(euleriana.tspV(euleriana.tspAux()),g2))) + " es:" );
        	System.out.println(euleriana.tsp(euleriana.tspV(euleriana.tspAux()),g2));

		}else if(escaner.equals("4")){
			System.out.println("Seleccionaste la grafica 4\n\n");
			Grafica g = Ejemplar.g4();
            g.vecinosG(g.aristas);
            Grafica g2 = g.clonar();
            g2.vecinosG(g2.aristas);
            System.out.println(g);

        
            Grafica arbol = g.arbolGen();
            arbol.vecinosG(arbol.aristas);
            System.out.println("el arbol generador minimo es: \n"+ arbol);
            arbol.verticesGrado();

        
            ArrayList<Vertice> impares = arbol.verticesImpares();
            Grafica indu = g.graficaInducida(impares);
            indu.vecinosG(indu.aristas);
            System.out.println("La grafica inducida es: \n"+ indu);


            ArrayList<Arista> apare = indu.apareamientoMin(arbol);
            System.out.println("El apareamiento es: \n"+ apare + "\n");


       	 	System.out.println("La union del apareamiento con el arbol es:\n");
        	Grafica euleriana = arbol.unirAristas(apare);
        	euleriana.vecinosG(euleriana.aristas);
        	System.out.println(euleriana);


        	System.out.println("El tsp obtenido con peso "+ Grafica.pesoTsp((euleriana.tsp(euleriana.tspV(euleriana.tspAux()),g2))) + " es:" );
        	System.out.println(euleriana.tsp(euleriana.tspV(euleriana.tspAux()),g2));

		}else if(escaner.equals("5")){
			System.out.println("Seleccionaste la grafica 5\n\n");
			Grafica g = Ejemplar.g5();
            g.vecinosG(g.aristas);
            Grafica g2 = g.clonar();
            g2.vecinosG(g2.aristas);
            System.out.println(g);

        
            Grafica arbol = g.arbolGen();
            arbol.vecinosG(arbol.aristas);
            System.out.println("el arbol generador minimo es: \n"+ arbol);
            arbol.verticesGrado();

        
            ArrayList<Vertice> impares = arbol.verticesImpares();
            Grafica indu = g.graficaInducida(impares);
            indu.vecinosG(indu.aristas);
            System.out.println("La grafica inducida es: \n"+ indu);


            ArrayList<Arista> apare = indu.apareamientoMin(arbol);
            System.out.println("El apareamiento es: \n"+ apare + "\n");


       	 	System.out.println("La union del apareamiento con el arbol es:\n");
        	Grafica euleriana = arbol.unirAristas(apare);
        	euleriana.vecinosG(euleriana.aristas);
        	System.out.println(euleriana);


        	System.out.println("El tsp obtenido con peso "+ Grafica.pesoTsp((euleriana.tsp(euleriana.tspV(euleriana.tspAux()),g2))) + " es:" );
        	System.out.println(euleriana.tsp(euleriana.tspV(euleriana.tspAux()),g2));

		}else{
			System.out.println("Opcion invalida, vuelve a ejecutar");
		}
    }

}
