package _CONSULTA;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Consulta_2 {
	
	//Variables de registro
    static ArrayList <ArrayList> registroPacientes;
    static ArrayList [] registroEspecialistas;
    static ArrayList<int[]> registroVisitas;
    static ArrayList <Integer> festivos;
    
	
	public static void main(String[] args) {
		// Variables
			int opcion;
			Locale espaniol = new Locale("es", "ES"); //Para posterior formateo de fechas
			LocalDate fechaInicial = LocalDate.of(LocalDate.now().getYear(),Month.MARCH,1);
			LocalDate fechaFinal = LocalDate.of(LocalDate.now().getYear(),Month.APRIL,30);
		    
			//Variables de generacion	
			int numeroEspecialistas = 6;
			int numeroPacientes = 3000;
			
			
		    //Variables de mensajes
		    String opcion_Msj="Seleccione una opción.";
		    String salir_Msj="Gracias por usar el programa.";
		    String errorOpcion_Msj="Esa opción no existe, por favor seleccione una opcion válida.";
		            
		    //Menu
		        
		    do {
		       	mostrarMenu();
		        opcion = pedirNum(0, 9, opcion_Msj);
		        switch(opcion) {
		           	case 1://Opcion
		      			separador();
		      			generarConsultas(numeroPacientes,numeroEspecialistas,fechaInicial,fechaFinal);
		       			separador();
		       			break;
		       		case 2://Opcion imprimir visitas
		      			separador();
		       			separador();
		          		break;
		           	case 3://Opcion facturacion
		           		separador();
		           		separador();
		           		break;
		           	case 4://Opcion subMenu consultas generales
		           		separador();
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
			
		/*Metodos de interfaz de usuario*/
		public static void mostrarMenu() {//Muestra las opciones del menu
			System.out.println ("MENU:\n");
		    System.out.println ("1. Generación de consultas");
		    System.out.println ("2. Imprimir visitas");
		    System.out.println ("3. Facturación periodo generado");
		    System.out.println ("4. Consultas generales");
		    System.out.println ("9. Salir \n");
		}
		
		public static void separador() {
			System.out.println("\n======================================================\n");
		}
		
		public static int pedirNum (int inicio, int fin, String mensaje) {
            int numero=0;
            Scanner sc;
            sc = new Scanner(System.in);
            do{
            	try{
                    System.out.print(mensaje+" Introduce un n�mero entre "+(inicio)+" y "+(fin)+": ");
                    numero = sc.nextInt();		
            	} catch (InputMismatchException | NumberFormatException ex){
                    System.err.println("\nIntroduzca un n�mero no un caracter, por favor.");
                    sc.next();
            	}
            } while (numero<inicio || numero>fin);
            return numero;
		}
		
		/*Modulo generarEntidades*/
		public static void generarConsultas(int numeroPacientes, int numeroEspecialistas, LocalDate fechaInicial, LocalDate fechaFinal) {
			
			registroPacientes = new ArrayList<ArrayList>();
			registroEspecialistas = new ArrayList[numeroEspecialistas];
			registroVisitas = new ArrayList<int[]>();
			festivos = new ArrayList <Integer>();
			String [] listaEspecialidades = {"Homeopatía","Quiropraxia"};
			
				generarFestivos(fechaInicial);
				generarEntidades(numeroPacientes);
				generarEntidades(numeroEspecialistas,listaEspecialidades);
				generarAgenda(fechaInicial,fechaFinal);
				System.out.println("Se han generado las consultas correctamente.");
		}

		private static void generarAgenda(LocalDate fechaInicial, LocalDate fechaFinal) {
			// TODO Auto-generated method stub
			
		}

		private static void generarEntidades(int numeroEntidades ) {
			// TODO Auto-generated method stub
			
		}
		private static void generarEntidades(int numeroEntidades, String [] listaEspecialidades) {
			// TODO Auto-generated method stub
			
		}

		private static void generarFestivos(LocalDate fechaInicial) {
			LocalDate anioNuevo = LocalDate.of(LocalDate.now().getYear(), 1, 1);
	        LocalDate dAndalucia = LocalDate.of(LocalDate.now().getYear(), 2, 28);
	        LocalDate dTrabajador = LocalDate.of(LocalDate.now().getYear(), 5, 1);
	        LocalDate Agosto15 = LocalDate.of(LocalDate.now().getYear(), 8, 15);
	        LocalDate Oct12 = LocalDate.of(LocalDate.now().getYear(), 10, 12);
	        LocalDate santos = LocalDate.of(LocalDate.now().getYear(), 11, 1);
	        LocalDate independencia = LocalDate.of(LocalDate.now().getYear(), 12, 6);
	        LocalDate navidad = LocalDate.of(LocalDate.now().getYear(), 12, 25);
            LocalDate [] fechasFestivos = {anioNuevo,dAndalucia,dTrabajador,Agosto15,Oct12,santos,independencia,independencia.plusDays(2),navidad};
			for(int i=0; i<fechasFestivos .length;i++) {
				festivos.add(generarFecha(fechaInicial,fechasFestivos[i]));
			}
		}
		
		private static int generarFecha (LocalDate fechaInicial, LocalDate fecha) {
			int newFecha = (int) ChronoUnit.DAYS.between(fechaInicial, fecha);
			return newFecha;
		}
        
}
