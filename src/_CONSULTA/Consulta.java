package _CONSULTA;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import clases.Cliente;

public class Consulta {

	public static void main(String[] args) {
		
		// Variables
		int opcion;
		String opcion_Msj="Seleccione una opci�n.";
		String salir_Msj="Gracias por usar el programa.";
		String errorOpcion_Msj="Esa opci�n no existe, por favor seleccione una opci�n v�lida.";
		
		//Menu
		
		do {
			mostrarMenu();
			opcion = pedirNum(0, 9, opcion_Msj);
			switch(opcion) {
				case 1://Opcion
					separador();
					System.out.println("1");
					separador();
					break;
				case 2://Opcion
					separador();
					System.out.println("2");
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
		System.out.println ("1. Opci�n 1");
		System.out.println ("2. Opci�n 2");
		System.out.println ("3. Opci�n 3");
		System.out.println ("4. Opci�n 4");
		System.out.println ("5. Opci�n 5");
		System.out.println ("6. Opci�n 6");
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
				System.err.println("\nIntroduzca un n�mero no un car�cter, por favor.");
				sc.next();
			}
		} while (numero<inicio || numero>fin);
		return numero;
	}
	
	public static void generarVisitas() {
		
		ArrayList <Cliente> visitasDiarias = new ArrayList<Cliente>();
		int maxVisitas=15;
		int minVisitas=10;
		int visitas=(int)Math.floor(((maxVisitas-minVisitas+1)*Math.random())+minVisitas);
		
		for (int i=0; i<visitas;i++) {
			visitasDiarias.add(new Cliente());
		}

		for(int i=0; i<visitasDiarias.size();i++) {
			System.out.printf(visitasDiarias.get(i).getApellidos()+", ");
			System.out.println(visitasDiarias.get(i).getNombre());
		}
	}
}
