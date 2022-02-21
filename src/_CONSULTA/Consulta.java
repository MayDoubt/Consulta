package _CONSULTA;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Consulta {

	public static void main(String[] args) {
		
		// Variables
		int opcion;
		Locale españolLocale = new Locale("es", "ES");
		LocalDate fechaInicial = LocalDate.of(LocalDate.now().getYear(),Month.MARCH,1);
		
		//Variables de generacion	
		int numeroEspecialistas = 3;
		String [] listaEspecialidad = {"Homeopatia","Quiropraxia"};
		String [] listaMetodoPago = {"Transferencia","Tarjeta","Efectivo"};
		double [] listaTarifas = {60.00,65.50};
		ArrayList <String> listaDni = new ArrayList <String>();
		ArrayList <String[]> listaClientes = new ArrayList <String[]>(); //
		
		//Variables de registro
		ArrayList <String[]> registroClientes = new ArrayList<String[]>();
		ArrayList [] registroEspecialistas = new ArrayList[numeroEspecialistas];
		ArrayList <int []> registroVisitas = new ArrayList<int[]>();
		
		//Variables de mensajes
		String opcion_Msj="Seleccione una opción.";
		String salir_Msj="Gracias por usar el programa.";
		String errorOpcion_Msj="Esa opción no existe, por favor seleccione una opción válida.";
		
		//Menu
		
		do {
			mostrarMenu();
			opcion = pedirNum(0, 9, opcion_Msj);
			switch(opcion) {
				case 1://Opcion
					separador();
					generarEntidades(listaClientes, listaDni, listaMetodoPago,listaEspecialidad, 15);
					imprimirPrueba(listaClientes);
					separador();
					break;
				case 2://Opcion
					separador();
					generarAgenda(fechaInicial, listaClientes);
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

	public static void mostrarMenu() {//Muestra las opciones del menu
		System.out.println ("Menu:\n");
		System.out.println ("1. Opción 1");
		System.out.println ("2. Opción 2");
		System.out.println ("3. Opción 3");
		System.out.println ("4. Opción 4");
		System.out.println ("5. Opción 5");
		System.out.println ("6. Opción 6");
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
				System.err.println("\nIntroduzca un número no un carácter, por favor.");
				sc.next();
			}
		} while (numero<inicio || numero>fin);
		return numero;
	}
	 
	
	public static void generarEntidades(ArrayList <String[]> listaClientes, ArrayList <String> listaDni, String [] listaMetodoPago,String [] listaEspecialidad, int nEntidades) {
		
		String [] listaNombres = {"Rishbha","Handel","Milind","Pulkita","Arnurna","Mell","Trent","Kalantha","Upravda","Stacy","Kalantha","Lincoln","Ernest","Stamford","Pryderi","Pablo","Fernando","Grace","Fagan","Nesim","Lilah","Mayrah","Madelyn","Barlow","Ilka","Beryl","Onora","Edeline","Stratton","Beryl"};
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
		return Integer.toString(dni)+letras.toCharArray()[indice];
	}
	
	public static void generarAgenda(LocalDate fechaInicial, ArrayList <String[]> listaClientes) {
		generarVisitas(listaClientes);
	}
	
	public static void generarVisitas(ArrayList <String[]> listaClientes) {
		registroClientes(listaClientes);
	}
	
	public static void registroClientes(ArrayList <String[]> listaClientes) {
		
	}
	
	public static void imprimirPrueba(ArrayList <String[]> listaClientes) {
		for(String i [] : listaClientes) {
			System.out.println(Arrays.toString(i));
		}
	}
}
