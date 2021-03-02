import java.util.ArrayList;

//Clase que sirve para guardar los ejemplares a usar
public class Ejemplares{
	ArrayList<Integer> lista = new ArrayList<Integer>();
	double radio = 0.0;
	int objetivo = 0;

	public Ejemplares (ArrayList<Integer> lista, double radio, int objetivo){
		this.lista = lista;
		this.radio = radio;
		this.objetivo = objetivo;
	}

	public static Ejemplares s1(){
		ArrayList<Integer> lista = new ArrayList<Integer>();
		lista.add(260);
		lista.add(106);
		lista.add(134);
		lista.add(178);
		lista.add(200);
		lista.add(454);
		lista.add(290);
		lista.add(321);
		lista.add(100);
		lista.add(120);
		double radio = 0.5;
		int objetivo = 783;
		return new Ejemplares(lista, radio, objetivo);
	}

	public static Ejemplares s2(){
		ArrayList<Integer> lista = new ArrayList<Integer>();
		lista.add(20);
		lista.add(26);
		lista.add(13);
		lista.add(18);
		lista.add(20);
		lista.add(45);
		lista.add(29);
		lista.add(32);
		lista.add(10);
		lista.add(12);
		double radio = 0.3;
		int objetivo = 153;
		return new Ejemplares(lista, radio, objetivo);
	}

	public static Ejemplares s3(){
		ArrayList<Integer> lista = new ArrayList<Integer>();
		lista.add(720);
		lista.add(806);
		lista.add(313);
		lista.add(118);
		lista.add(720);
		lista.add(945);
		lista.add(529);
		lista.add(732);
		lista.add(610);
		lista.add(120);
		double radio = 0.09;
		int objetivo = 1564;
		return new Ejemplares(lista, radio, objetivo);
	}

	public static Ejemplares s4(){
		ArrayList<Integer> lista = new ArrayList<Integer>();
		lista.add(72);
		lista.add(80);
		lista.add(33);
		lista.add(18);
		lista.add(70);
		lista.add(95);
		lista.add(29);
		lista.add(73);
		lista.add(61);
		lista.add(10);
		double radio = 0.1;
		int objetivo = 320;
		return new Ejemplares(lista, radio, objetivo);
	}

	public static Ejemplares s5(){
		ArrayList<Integer> lista = new ArrayList<Integer>();
		lista.add(1);
		lista.add(2);
		lista.add(5);
		lista.add(12);
		lista.add(6);
		lista.add(7);
		lista.add(29);
		lista.add(32);
		lista.add(3);
		lista.add(5);
		double radio = 0.03;
		int objetivo = 41;
		return new Ejemplares(lista, radio, objetivo);
	}

	public String toString(){
		String s = "";
		s += "El radio es: " + radio + "\n";
		s += "El objetivo es: " + objetivo + "\n";
		s += "El conjunto es: "+ lista.toString() + "\n";
		return s;
	}
}
