package _CONSULTA;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Consulta {

	public static void main(String[] args) {
		
		// Variables
		int opcion;
		Locale espaniol = new Locale("es", "ES");
		LocalDate fechaInicial = LocalDate.of(LocalDate.now().getYear(),Month.MARCH,1);
		LocalDate fechaFinal = LocalDate.of(LocalDate.now().getYear(),Month.APRIL,30);
		
		//Variables de generacion	
		int numeroEspecialistas = 3;
		String [] listaEspecialidad = {"Homeopatia","Quiropraxia","Sin especialidad"};
		String [] listaMetodoPago = {"Transferencia","Tarjeta","Efectivo"};
		double [] listaTarifas = {60.00,65.50};
		ArrayList <String> listaDni = new ArrayList <String>();
		ArrayList <String[]> listaClientes = new ArrayList <String[]>();
		ArrayList <Integer> festivos = new ArrayList <Integer>();
		
		
		//Variables de registro
		ArrayList <ArrayList> registroClientes = new ArrayList<ArrayList>();
		ArrayList [] registroEspecialistas = new ArrayList[numeroEspecialistas];
		ArrayList <int []> registroVisitas = new ArrayList<int[]>();
		
		//Variables de mensajes
		String opcion_Msj="Seleccione una opcion.";
		String salir_Msj="Gracias por usar el programa.";
		String errorOpcion_Msj="Esa opcion no existe, por favor seleccione una opcion valida.";
		
		//Menu
		
		do {
			mostrarMenu();
			opcion = pedirNum(0, 9, opcion_Msj);
			switch(opcion) {
				case 1://Opcion
					separador();
					generarEntidades(listaClientes, listaDni, listaMetodoPago,listaEspecialidad, 15);
					generarEntidades(registroEspecialistas,listaEspecialidad, numeroEspecialistas);
					generarFestivos(fechaInicial,festivos);
					imprimirPrueba(registroEspecialistas);
					generarAgenda(fechaInicial,fechaFinal, listaClientes, registroClientes, registroEspecialistas, festivos);
					//imprimirPrueba(listaClientes);
					separador();
					break;
				case 2://Opcion
					separador();
					separador();
					break;
				case 3://Opcion
					separador();
					System.out.println("3");
					separador();
					break;
				case 4://Opcion
					separador();
					System.out.println("4");
					separador();
					break;
				case 5://Opcion
					separador();
					System.out.println("5");
					separador();
					break;
				case 6://Opcion
					separador();
					System.out.println("6");
					separador();
					break;
				case 9://Exit Option
					separador();
					System.out.println(salir_Msj);
					separador();
					break;
				default://Otra opcion error
					separador();
					System.out.println(errorOpcion_Msj);
					separador();
					break;
			}
		} while (opcion != 9);

	}
	
	//==============METODOS==============//
	
	/*M�todos de interfaz de usuario*/
	public static void mostrarMenu() {//Muestra las opciones del menu
		System.out.println ("Menu:\n");
		System.out.println ("1. Opcion 1");
		System.out.println ("2. Opcion 2");
		System.out.println ("3. Opcion 3");
		System.out.println ("4. Opcion 4");
		System.out.println ("5. Opcion 5");
		System.out.println ("6. Opcion 6");
		System.out.println ("9. Salir \n");
	}
	public static void separador() {
		System.out.println("\n=======================================\n");
	}
	public static int pedirNum (int inicio, int fin, String mensaje) {
		int numero=0;
		Scanner sc;
		sc = new Scanner(System.in);
		do{
			try{
				System.out.print(mensaje+" Introduce un numero entre "+(inicio)+" y "+(fin)+": ");
				numero = sc.nextInt();
						
			} catch (InputMismatchException | NumberFormatException ex){
				System.err.println("\nIntroduzca un numero no un caracter, por favor.");
				sc.next();
			}
		} while (numero<inicio || numero>fin);
		return numero;
	}
	
	/*Modulo generarEntidades*/
	public static void generarEntidades(ArrayList <String[]> listaClientes, ArrayList <String> listaDni, String [] listaMetodoPago,String [] listaEspecialidad, int nEntidades) {
		
		String [] listaNombres = {"Rishbha","Handel","Milind","Pulkita","Yesus","Mell","Trent","Kalantha","Upravda","Stacy","Kalantha","Lincoln","Ernest","Stamford","Pryderi","Pablo","Fernando","Grace","Jaun","Nesim","Lilah","Mayrah","Madelyn","Barlow","Ilka","Beryl","Onora","Edeline","Stratton","Beryl"};
		String [] listaApellidos = {"Gladstone","Weeden","Sylvia","Utter","Lebron","Vicente","Weigand","Nelson","Lewallen","Brew","Mccombs","Rhee","William","Vierra","Kegley","Shears","Dann","Sparkle","Habib","Adcock","Sundberg","Elia","Hickok","Huertas", "Hodnett","Higgins","Klos","Junker","Enright"};
		generarDni(nEntidades, listaDni);
		for (int i=0; i<nEntidades; i++) {
			
			int randomDni = (int)Math.floor((int)(listaDni.size())*Math.random());
			int randomNom = (int)Math.floor((int)(listaNombres.length)*Math.random());
			int randomApe = (int)Math.floor((int)(listaApellidos.length)*Math.random());
			int randomApe2 = (int)Math.floor((int)(listaApellidos.length)*Math.random());
			int randomEsp = (int)Math.floor((int)(listaEspecialidad.length)*Math.random());
			int randomMP = (int)Math.floor((int)(listaMetodoPago.length)*Math.random());
			String [] cliente = {listaDni.remove(randomDni),listaNombres[randomNom],listaApellidos[randomApe]+" "+listaApellidos[randomApe2],listaEspecialidad[randomEsp],listaMetodoPago[randomMP]}; 
	
			listaClientes.add(cliente);
		}
			
		
	}
	public static void generarEntidades(ArrayList [] registroEspecialistas, String [] listaEspecialidad, int nEntidades) {  //ToDo --Hacer que uno de ellos tenga dos especialidades y no se repitan.
		String [] listaNombres = {"Rishbha","Handel","Milind","Pulkita","Yesus","Mell","Trent","Kalantha","Upravda","Stacy","Kalantha","Lincoln","Ernest","Stamford","Pryderi","Pablo","Fernando","Grace","Jaun","Nesim","Lilah","Mayrah","Madelyn","Barlow","Ilka","Beryl","Onora","Edeline","Stratton","Beryl"};
		String [] listaApellidos = {"Gladstone","Weeden","Sylvia","Utter","Lebron","Vicente","Weigand","Nelson","Lewallen","Brew","Mccombs","Rhee","William","Vierra","Kegley","Shears","Dann","Sparkle","Habib","Adcock","Sundberg","Elia","Hickok","Huertas", "Hodnett","Higgins","Klos","Junker","Enright"};
		String [] dias = {"lunes", "martes","miercoles","jueves","viernes"};
		
		for (int i=0; i<nEntidades; i++) {
			if(i<2){
				int randomNom = (int)Math.floor((int)(listaNombres.length)*Math.random());
				int randomApe = (int)Math.floor((int)(listaApellidos.length)*Math.random());
				int randomApe2 = (int)Math.floor((int)(listaApellidos.length)*Math.random());
				int randomEsp = (int)Math.floor((int)(listaEspecialidad.length-1)*Math.random());
				int randomDia = (int)Math.floor((int)(dias.length)*Math.random());
				ArrayList especialista = new ArrayList();
				especialista.add(listaNombres[randomNom]);
				especialista.add(listaApellidos[randomApe]);
				especialista.add(listaApellidos[randomApe2]);
				especialista.add(randomEsp);
				especialista.add(2);
				especialista.add(randomDia);
				registroEspecialistas[i]=new ArrayList<>();
				registroEspecialistas[i] = especialista;
			}else{
				int randomNom = (int)Math.floor((int)(listaNombres.length)*Math.random());
				int randomApe = (int)Math.floor((int)(listaApellidos.length)*Math.random());
				int randomApe2 = (int)Math.floor((int)(listaApellidos.length)*Math.random());
				int randomDia = (int)Math.floor((int)(dias.length)*Math.random());
				ArrayList especialista = new ArrayList();
				especialista.add(listaNombres[randomNom]);
				especialista.add(listaApellidos[randomApe]);
				especialista.add(listaApellidos[randomApe2]);
				especialista.add(1);
				especialista.add(0);
				especialista.add(randomDia);
				registroEspecialistas[i]=new ArrayList<>();
				registroEspecialistas[i] = especialista;
			}
		}
	}
	public static void generarDni(int nEntidades, ArrayList <String> listaDni) {
		String dni = "";
		for (int i=0; i<nEntidades; i++) {
			do {
				dni=generarDatosDni();
			} while (listaDni.contains(dni));	
			listaDni.add(dni);
		}
	}
	public static String generarDatosDni() {
		int dni = (int)Math.floor((int)100000000*Math.random());
		int indice = dni % 23;
		String letras = "TRWAGMYFPDXBNJZSQVHLCKET";
		return String.format("%08d",dni)+letras.toCharArray()[indice];
	}
	
	public static void generarFestivos(LocalDate fechaInicial, ArrayList <Integer> festivos) {
		LocalDate feria = LocalDate.of(LocalDate.now().getYear(), 4, 13);
		int feriaDays = (int) ChronoUnit.DAYS.between(fechaInicial, feria);
		festivos.add(0);
		festivos.add(feriaDays);
		festivos.add(feriaDays+1);
	}
	
	/*Modulo generarAgenda*/
	public static void generarAgenda(LocalDate fechaInicial, LocalDate fechaFinal, ArrayList <String[]> listaClientes, ArrayList <ArrayList> registroClientes,  ArrayList [] registroEspecialistas, ArrayList <Integer> festivos) {	//ToDo
		int periodoConsultas = ((int)ChronoUnit.DAYS.between(fechaInicial, fechaFinal))+1;
		System.out.println(periodoConsultas);
		for (int i=0; i<periodoConsultas; i++) {
			generarDia(fechaInicial, listaClientes, registroClientes, registroEspecialistas, festivos, i);
			System.out.println(" ");
		}
	}
	public static void generarDia(LocalDate fechaInicial, ArrayList <String[]> listaClientes, ArrayList <ArrayList> registroClientes,  ArrayList [] registroEspecialistas, ArrayList <Integer> festivos, int fecha){

		if (!festivos.contains(fecha)) {
			for (int i=0; i<registroEspecialistas.length; i++) {
				if(!diaLibre(registroEspecialistas[i],fechaInicial,fecha)) {
					System.out.println("se puede registrar");
					//generarVisitas(listaClientes, registroClientes);
				} else {System.out.println("No se puede");}
			}
		}
	}
	
	public static boolean diaLibre(ArrayList registroEspecialista, LocalDate fechaInicial, int fecha) {
		LocalDate dia = fechaInicial.plusDays(fecha-1);
		int diaSem=dia.getDayOfWeek().ordinal();
		if ((int)registroEspecialista.get(5)==diaSem||diaSem>4) {
			return true;
		} else {
			return false;
		}
	}
	
	/*Modulo generarVisitas*/
	public static void generarVisitas(ArrayList <String[]> listaClientes, ArrayList <ArrayList> registroClientes) { //ToDo
		registroClientes(listaClientes, registroClientes);
		registroVisita(listaClientes, registroClientes);
	}
	public static void registroClientes(ArrayList <String[]> listaClientes, ArrayList <ArrayList> registroClientes) { //ToDo
		
	}
	public static void registroVisita(ArrayList <String[]> listaClientes, ArrayList <ArrayList> 
	registroClientes) { //ToDo
		
	}
	
	/*Modulo de consultaDatos*/
	public static void imprimirPrueba(ArrayList <String[]> listaClientes) {
		for(String i [] : listaClientes) {
			System.out.println(Arrays.toString(i));
		}
	}  //Metodo para testeo de clientes.
	
	public static void imprimirPrueba(ArrayList [] listaEspecialistas) {
		for(ArrayList i : listaEspecialistas) {
			System.out.println(i);
		}
	}  //Metodo para testeo de especialistas.
	public static void imprimirVisitas(ArrayList <int []> registroVisitas) {  //ToDo
		//Habr�a que crear un m�todo ya mostrando valores formateados y que se entiendan no con enteros.
	}
}
