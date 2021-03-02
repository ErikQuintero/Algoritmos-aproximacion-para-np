import java.util.ArrayList;

//Clase que modela un vertice en una grafica
public class Vertice implements Comparable<Vertice>, Cloneable{
    public ArrayList<Vertice>vecinos; //vecinos del vertice en una grafica 
    String nombre; //Nombre del vertice que sirve como identificador
    int grado = 0;
    public int distancia = 0;
    
    //Constructor de la clase vertice
	public Vertice(ArrayList<Vertice>vecinos, String nombre){
        this.vecinos = vecinos;
        this.nombre = nombre;
	}

	public Vertice(ArrayList<Vertice>vecinos, String nombre, int x){
        this.vecinos = vecinos;
        this.nombre = nombre;
        this.distancia = x;
	}

    public Vertice clone()   {
      Vertice clon = new Vertice(this.vecinos ,this.nombre);
      return clon;

   }
   
    //Metodo que regresa el nombre del vertice
	public String getNombre(){
        return nombre;
	}


     //Metodo que imprime un vertice
	public String toString(){
        String s = "v";
        s = s + this.nombre + " vecinos: [";
        int tamano = 0;
        for(Vertice x:vecinos){
            if(tamano != ((vecinos.size())-1)){
                s = s + "(v"+ x.getNombre() + "," + x.distancia + ")"+",";
            }else{
                s = s + "(v"+ x.getNombre() + "," + x.distancia + ")";
            }
            tamano++;
        }
        s = s + "]";
        return s; 
	}

	//Metodo que modifica la distancia de un vertice
	public void setDistancia(int x){
        distancia = x;
	}

    //Metodo que sirve para ordenar una lista de vertices
	@Override
    public int compareTo(Vertice v) {
        if (grado < v.grado) {
            return -1;
        }
        if (grado >v.grado) {
            return 1;
        }
            return 0;
    }

}
