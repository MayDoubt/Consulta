package _CONSULTA;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
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
		double [] listaTarifas = {60.00,65.50};
		ArrayList <String> listaDni = null; //La lista de dni es para acotar el numero de pacientes y asegurar que vuelven a la consulta.
		String [][] listaClientes = new String [2][];
		
		//Variables de registro
		ArrayList <ArrayList> registroClientes = new ArrayList<ArrayList>();
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
					generarEntidades(listaDni);
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
	
	public static void generarEntidades(ArrayList <String> listaDni) {
		
	}
	
	public static void generarAgenda(LocalDate fechaInicial, String [][] clientes) {
		generarVisitas(clientes);
	}
	
	public static void generarVisitas(String [][] clientes) {
		registroClientes(clientes);
	}
	
	public static void registroClientes(String [][] clientes) {
		
	}
}
