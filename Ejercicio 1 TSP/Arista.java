//Clase que modela una arista en una grafica
public class Arista implements Comparable<Arista>, Cloneable{
    Vertice v1;
    Vertice v2;
    int peso;

    //Contructor de la clase arista
    public Arista(Vertice v1, Vertice v2, int peso){
        this.v1 = v1;
        this.v2 = v2;
        this.peso = peso;
    }

    //Metodo para clonar aristas
    public Arista clone()   {
      Arista clon = new Arista(this.v1 ,this.v2, this.peso);
      return clon;

   }

    //Metodo que verifica si dos aristas son la misma
    public boolean iguales(Arista a){
        if ((v1.nombre).equals((a.v1).nombre) && (v2.nombre).equals((a.v2).nombre) && peso == a.peso){
            return true;
        }else if((v1.nombre).equals((a.v2).nombre) && (v2.nombre).equals((a.v1).nombre) && peso == a.peso){
            return true;
        }else{
            return false;
        }
    }

    //Metodo que verifica si dos aristas son la misma sin tomar en cuenta el peso
    public boolean iguales2(Arista a){
        if ((v1.nombre).equals((a.v1).nombre) && (v2.nombre).equals((a.v2).nombre)){
            return true;
        }else if((v1.nombre).equals((a.v2).nombre) && (v2.nombre).equals((a.v1).nombre)){
            return true;
        }else{
            return false;
        }
    }
    
    //Metodo que regresa una representacion en cadena de una arista
    public String toString(){
        String s = "("+ v1.nombre + ","+ v2.nombre + "): "+ peso;
        return s;
    }
    
    //Metodo que sirve para ordenar una lista de aristas
	@Override
    public int compareTo(Arista a) {
        if (peso < a.peso) {
            return -1;
        }
        if (peso > a.peso) {
            return 1;
        }
            return 0;
    }

}
