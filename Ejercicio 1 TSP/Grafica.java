import java.util.ArrayList;
import java.util.*;

//Clase que representa una grafica
public class Grafica implements Cloneable{
    public ArrayList<Vertice>vertices; //Lista de vertices en una grafica
    public ArrayList<Arista> aristas; //Lista de aristas de la grafica
    
    //Constructor de una grafica
	public Grafica(ArrayList<Vertice>vertices, ArrayList<Arista>aristas){
        this.vertices = vertices;
        this.aristas = aristas;
	}

    //Metodo que nos ayuda a conar una grafica    
	public Grafica clone()   {
      Grafica clon = new Grafica(this.vertices ,this.aristas);
      return clon;

   }

    //Metodo que genera un arbol generador de peso minimo
    public Grafica arbolGen(){
        ordenarAristas();
        ArrayList<Arista> aristas2 = aristas;
        ArrayList<Arista> arbol = new ArrayList<Arista>();
        ArrayList<Vertice> verticesA = new ArrayList<Vertice>();
        verticesA.add(vertices.get(0));
        while(arbol.size() != (vertices.size()-1)){
            ArrayList<Arista> aux = aristasIncidentes(verticesA, aristas2);
            for(Arista a : aux){
                if(!(encuentraArista(arbol, a)) && nuevoV(verticesA, a)){
                    arbol.add(a);
                    if(!existeV(verticesA , a.v1)){
                        verticesA.add(a.v1);
                    }else if(!existeV(verticesA , a.v2)){
                        verticesA.add(a.v2);
                    }
                    break;
                }
            }
        }
        Grafica arbolito = new Grafica(verticesA, arbol);
        arbolito.verticesGrado();
        return arbolito;
    }

    //Metodo que nos regresa una grafica inducida por vertices
    public Grafica graficaInducida(ArrayList<Vertice> lv){
        ArrayList<Arista> aux = new ArrayList<Arista>();
        for(Arista a : aristas){
            if((existeV(lv, a.v1)) && (existeV(lv, a.v2))){
                aux.add(a);
            }
        }
        Grafica inducida = new Grafica(lv, aux);
        return inducida;
    }

    //Metodo que nos ayuda a asignar el grado a un vertice usando las aristas de la grafica
    public void gradoVertice(Vertice v){
        int grado = 0;
        for(Arista a : aristas){
            if((((a.v1).nombre).equals(v.nombre)) || (((a.v2).nombre).equals(v.nombre))){
                grado++;
            }
        }
        v.grado = grado;
    }

    //Metodo que nos ayuda a asignar el grado de los vertices usando las aristas de la grafica
    public void verticesGrado(){
        for(Vertice v : vertices){
            gradoVertice(v);
        }
    }

    //Metodo que nos regresa los vertices de grado impar en una grafica
    public ArrayList<Vertice> verticesImpares(){
        ArrayList<Vertice> aux = new ArrayList<Vertice>();
        for(Vertice v : vertices){
            if ((v.grado)%2 != 0){
                aux.add(v);
            }
        }
        return aux;
    }

    //Metodo que nos regresa un apareamiento de la grafica
    public ArrayList<Arista> apareamientoMin(Grafica arbol){
        ArrayList<Vertice> lv = new ArrayList<Vertice>();
        int tamanio = (vertices.size()/2); 
        ArrayList<Arista> la = aristas;
        Collections.sort(la);
        ArrayList<Arista> apareamiento = new ArrayList<Arista>();
        while((apareamiento.size()) < tamanio){
            for(Arista a : la){
                if(!existeV(lv, a.v1) && !existeV(lv, a.v2)){
                    lv.add(a.v1);
                    lv.add(a.v2);
                    apareamiento.add(a);
                }
            }
        }
        return apareamiento;
     }

    //Metodo que nos ayuda a meter aristas nuevas a una grafica
    public Grafica unirAristas(ArrayList<Arista> la){
        ArrayList<Arista> nuevas = aristas;
        for(Arista a : la){
            nuevas.add(a);   
        }
        Grafica euleriana =  new Grafica(vertices, nuevas);
        euleriana.verticesGrado();
        return euleriana;
    }

    
    //Metodo que nos devuelve las aristas incidentes a un conjunto de vertices 
    public ArrayList<Arista> aristasIncidentes(ArrayList<Vertice> lv, ArrayList<Arista> la){
        ArrayList<Arista> aux = new ArrayList<Arista>();
        for(Vertice v : lv){
            for (Arista a : la){
                if(incidenteA(a, v) && !(encuentraArista(aux, a))){
                    aux.add(a);
                }
            }
        }
        Collections.sort(aux);
        return aux;
    }

    //Metodo que nos dice si una arista incide en un vertice
    public boolean incidenteA (Arista a, Vertice v){
        if((a.v1.nombre).equals(v.nombre) || (a.v2.nombre).equals(v.nombre)){
            return true;
        }else{
            return false;
        }
    }

    //Metodo que nos dice si un vertice se encuentra en una lista de vertices
    public boolean existeV(ArrayList<Vertice> lv, Vertice v){
        boolean existe = false;
        for(Vertice vAux : lv){
            if((vAux.nombre).equals(v.nombre)){
                existe = true;
                break;
            }
        }
        return existe;
    }

    //Metodo que nos dice si una arista se encuentra en una lista de aristas   
    public boolean encuentraArista(ArrayList<Arista>aux, Arista a){
        boolean esta = false;
        for(Arista a2 : aux){
            if((((a.v1).nombre).equals(a2.v1.nombre)) && (((a.v2).nombre).equals(a2.v2.nombre))){
                esta = true;
                break;
            }
        }
        return esta;
    }

    //Metodo que nos ayuda a verificar si se formará un ciclo al añadir una arista
    public boolean nuevoV(ArrayList<Vertice> aux, Arista a){
        boolean existeV1 = existeV(aux, a.v1);
        boolean existeV2 = existeV(aux, a.v2);
        return !(existeV1 && existeV2);
    }

    
    //Metodo que ordena de la grafica
    public void ordenarAristas(){
        Collections.sort(aristas);
    }
    
    //Metodo que ordena todos los vecinos de un vertice de la grafica
    public void ordenarVertice(){
        for (Vertice v : vertices){
            Collections.sort(v.vecinos);
        }
    }

    //Metodo que imprime una representacion en cadena de una grafica
	public String toString(){
        String s = "";
        for(Vertice x: vertices){
            s = s + x.toString() + "\n";
        }
        return s;
	}

    
    //Metodo que nos devuelve las aristas incidentes a un vertice
    public ArrayList<Arista> aristasV(ArrayList<Arista> la, Vertice v){
        ArrayList<Arista> aux = new ArrayList<Arista>();
        for (Arista a : la){
            if(incidenteA(a, v) && !(encuentraArista(aux, a))){
                aux.add(a);
            }
        }
        Collections.sort(aux);
        return aux;
	}
    
    //Metodo que sirve para eliminar una arista
    public void eliminaArista(Arista a){
        for(Vertice v : vertices){
            if(v.nombre.equals(a.v1.nombre)){
                v.grado = v.grado -1;
            }
            if(v.nombre.equals(a.v2.nombre)){
                v.grado = v.grado -1;
            }
        }
        aristas.remove(a);
    }

    //Metodo que nos devuelve el mejor vertice para hacer el camino euleriano
    public Vertice optimo(Vertice actual, ArrayList<Arista> incidentes){
        ArrayList<Vertice> vecinos = new ArrayList<Vertice>();
        for(Arista a : incidentes){
            if(actual.nombre.equals(a.v1.nombre)){
                vecinos.add(a.v2);
            }else if(actual.nombre.equals(a.v2.nombre)){
                vecinos.add(a.v1);
            }
        }
        Collections.sort(vecinos);
        return vecinos.get(0);
    }

    //Metodo que nos regresa una arista usando sus extremos
    public Arista regresaArista(Vertice v1, Vertice v2){
        Arista aux = null;
        for(Arista a : aristas){
            if(v1.nombre.equals(a.v1.nombre) && v2.nombre.equals(a.v2.nombre)){
                aux = a;
                break;

            }else if(v2.nombre.equals(a.v1.nombre) && v1.nombre.equals(a.v2.nombre)){
                aux = a;
                break;
            }
        }
        return aux;
    }

	//Metodo que modifica el peso de una arista
    public void regresaPeso(Arista a, ArrayList<Arista> la){
        for(Arista a2 : la){
            if(a.iguales2(a2)){
                a.peso = a2.peso;    
            }
        }
    }

    //Metodo que calcula la diferencia de dos arraylist
    public ArrayList<Vertice> faltantes(ArrayList<Vertice> lv){
        ArrayList<Vertice> vertices2 = new ArrayList<Vertice>();
        for(Vertice v : vertices){
            ArrayList<Vertice> vecinos = v.vecinos;
            String nombre = v.nombre;
            int grado = v.grado;
            Vertice v2 = new Vertice(vecinos, nombre);
            v2.grado = grado;
            vertices2.add(v2);
        }
        ArrayList<Vertice> faltantes = new ArrayList<Vertice>();
        for(Vertice v : vertices2){
            if(!existeV(lv,v)){
                faltantes.add(v);
            }   
        }
        return faltantes;
    }

    //Metodo que nos ayuda a generar un camino hamiltoniano
    public ArrayList<Vertice> tspAux(){
        Grafica auxiliar = this.clonar();
        ArrayList<Vertice> camino = new ArrayList<Vertice>();
        int finish = auxiliar.aristas.size();
        Collections.sort(auxiliar.vertices);
        Vertice actual = (auxiliar.vertices.get(0));
        camino.add(actual); 
        while(camino.size() != finish+1){
            ArrayList<Vertice> actualL= new ArrayList<Vertice>();
            actualL.add(actual);
            ArrayList<Arista> incidentes = aristasIncidentes(actualL, auxiliar.aristas);
            if(incidentes.size() != 0){
                Vertice mejor = auxiliar.optimo(actual, incidentes);
                Arista seleccion = regresaArista(actual, mejor);
                camino.add(mejor);
                actual = mejor;
                ArrayList<Arista> aristasFix = new ArrayList<Arista>();
                for(Arista quedar : auxiliar.aristas){
                    if(!seleccion.iguales2(quedar)){
                        aristasFix.add(quedar);   
                    }
                }
                auxiliar.aristas = aristasFix;
            }else{
               ArrayList<Vertice> falt = auxiliar.faltantes(camino);
               Collections.sort(falt);
               if(falt.size() == 0){
                   break;
               }
               actual = falt.get(0);
               camino.add(actual);
            }
        }
        return camino;
    }

	//Metodo que nos regresa un tsp de vertices
    public ArrayList<Vertice> tspV(ArrayList<Vertice> euleriano){
        ArrayList<Vertice> tspVer = new ArrayList<Vertice>();
        for(Vertice v : euleriano){
            if(!existeV(tspVer, v)){
                tspVer.add(v);
            }
        }
        tspVer.add(tspVer.get(0));
        return tspVer;
    }

	//Metodo que nos regresa un tsp de aristas
    public ArrayList<Arista> tsp(ArrayList<Vertice> tspV, Grafica original){
        ArrayList<Arista> tspF = new ArrayList<Arista>();
        for(int i = 0 ; i < tspV.size(); i++){
            if(i != tspV.size() - 1){
                Arista a = new Arista(tspV.get(i), tspV.get(i+1), 0);
                tspF.add(a);
            }
        }
        for(Arista aux : tspF){
            regresaPeso(aux, original.aristas);
        }
        return tspF;
    }

	//Metodo que nos regresa el peso de un tsp
	public static int pesoTsp(ArrayList<Arista> tsp){
		int i = 0;
    	for(Arista a : tsp){
			i = i + a.peso;
    	}
    	return i;
    }
    
    //Metodo que nos ayuda a clonar una grafca porque el de arriba no sirve
    public Grafica clonar(){
        ArrayList<Vertice> vertices2 = new ArrayList<Vertice>();
        for(Vertice v : vertices){
            ArrayList<Vertice> vecinos = v.vecinos;
            String nombre = v.nombre;
            int grado = v.grado;
            Vertice v2 = new Vertice(vecinos, nombre);
            v2.grado = grado;
            vertices2.add(v2);
        }
        ArrayList<Arista> aristas2 = new ArrayList<Arista>();
        for(Arista a : aristas){
            Vertice v1 = a.v1;
            Vertice v2 = a.v2;
            int peso = a.peso;
            Arista a2 = new Arista(v1, v2, peso);
            aristas2.add(a2);
        }
        return new Grafica(vertices2, aristas2);
    }       

    //Metodo que nos devuelve los vecinos de un vertice
    public ArrayList<Vertice> vecinosV(ArrayList<Arista> la, Vertice v){
        ArrayList<Vertice> aux = new ArrayList<Vertice>();
        for (Arista a : la){
            if(incidenteA(a, v)){
                if(v.nombre.equals(a.v1.nombre)){
                    ArrayList<Vertice> laux = new ArrayList<Vertice>();
                    String s = a.v2.nombre;
                    int x = a.peso;
                    Vertice vAux = new Vertice(laux, s, x);  
                    aux.add(vAux);
                }else{
                    ArrayList<Vertice> laux = new ArrayList<Vertice>();
                    String s = a.v1.nombre;
                    int x = a.peso;
                    Vertice vAux = new Vertice(laux, s, x);  
                    aux.add(vAux);
                }
            }
        }
        Collections.sort(aux);
        return aux;
	}

	//Metodo que corrige los vecinos de un vertice usando las aristas de la grafica
	public void vecinosG (ArrayList<Arista> la){
        for(Vertice v : vertices){
            vecinosV(la, v);
            v.vecinos = vecinosV(la, v);
        }
	} 
}
