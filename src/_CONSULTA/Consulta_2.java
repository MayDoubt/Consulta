package _CONSULTA;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Consulta_2 {
	
	//Variables de registro y generales
    static ArrayList <Paciente> registroPacientes;
    static Profesional [] registroEspecialistas;
    static ArrayList<Visita> registroVisitas;
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
		/*Metodo general de generación de entidades*/
		public static void generarConsultas(int numeroPacientes, int numeroEspecialistas, LocalDate fechaInicial, LocalDate fechaFinal) {
			
			registroPacientes = new ArrayList<Paciente>();
			registroEspecialistas = new Profesional[numeroEspecialistas];
			registroVisitas = new ArrayList<Visita>();
			festivos = new ArrayList <Integer>();
			String [] listaEspecialidades = {"Homeopatía","Quiropraxia"};
			ArrayList <Persona> bolsaClientes = new ArrayList <Persona>();
			
				generarFestivos(fechaInicial);
				generarEntidades(numeroEspecialistas);
				bolsaClientes=generarEntidades(numeroPacientes,listaEspecialidades);
				generarAgenda(fechaInicial,fechaFinal, bolsaClientes);
				System.out.println("Se han generado las consultas correctamente.");
				
		}
		
		/*Metodo de generación de periodos de consulta*/
		private static void generarAgenda(LocalDate fechaInicial, LocalDate fechaFinal, ArrayList <Persona> bolsaClientes) {
			int periodoConsultas = ((int)ChronoUnit.DAYS.between(fechaInicial, fechaFinal))+1;
			for (int i=0; i<periodoConsultas; i++) {
	                    generarDia(fechaInicial,bolsaClientes,i);
			}
		}
		
		/*Metodo de generación de dias particulares*/
		public static void generarDia(LocalDate fechaInicial, ArrayList <Persona> bolsaClientes, int fecha){
	        if (!festivos.contains(fecha)) {
	        	for (int i=0; i<registroEspecialistas.length; i++) {
	        		if(!diaLibre(registroEspecialistas[i],fechaInicial,fecha)) {
	        				generarVisitas(bolsaClientes, registroEspecialistas[i], fecha);
	        		}
	        	}
	        }
		}
		
		/*Metodo de generación de visitas*/
		private static void generarVisitas(ArrayList<Persona> bolsaClientes, Profesional profesional, int fecha) {
		     int nVisitas=(int)(Math.floor(6*Math.random())+10); //random para las visitas de ese dia y ese especialista
	            for(int i=0;i<nVisitas;i++){
	                int randomCliente = (int)Math.floor((int)(bolsaClientes.size())*Math.random());//Random para coger clientes al azar y registrarlos si es necesario
	                if(!checkCliente(bolsaClientes.get(randomCliente))){
	                	registroPaciente(bolsaClientes.get(randomCliente));
	                	int idCliente = checkCliente(bolsaClientes.get(randomCliente).dni);
	                	registroVisita(idCliente, registroPacientes.get(idCliente),fecha);
	                }else{
	                    int idCliente = checkCliente(bolsaClientes.get(randomCliente).dni);
	                    registroVisita(idCliente, registroPacientes.get(idCliente),fecha);
	                }
	            }
		}
		private static void registroPaciente(Persona persona) {
			// TODO Auto-generated method stub
			
		}

		/*Metodo que devuelve la posicion de un cliente por su dni*/
		private static int checkCliente(String dniCliente) {
		    for(int i=0; i<registroPacientes.size();i++) {
	        	if(registroPacientes.get(i).dni.equals(dniCliente)) {
	                    return i;
	        	}
	        }
	        return -1;
		}

		/*Metodo que comprueba si existe el registro de paciente del cliente*/
		private static boolean checkCliente(Persona cliente) {
			for(int i=0; i<registroPacientes.size();i++) {
				if(registroPacientes.get(i).dni.equals(cliente.dni)) {
					return true;
				}
			}
			return false;
		}

		private static void registroVisita(int idCliente, Paciente paciente, int fecha) {
			Visita visita = new Visita(paciente);
			registroVisitas.add(visita);
		}

		/*Metodo de comprobación de dia festivo/libre*/
		public static boolean diaLibre(Profesional registroEspecialista, LocalDate fechaInicial, int fecha) {
            LocalDate dia = fechaInicial.plusDays(fecha-1);
            int diaSem=dia.getDayOfWeek().ordinal();
            	if ((int)registroEspecialista.diaLibre==diaSem||diaSem>4) {
            		return true;
            	} else {
            		return false;
            	}
		}
		
		private static ArrayList<Persona> generarEntidades(int numeroEntidades, String [] listaEspecialidades) {
			ArrayList <Persona> bolsaClientes = new ArrayList <Persona>();
            for (int i=0; i<numeroEntidades; i++) {
            	Persona cliente = new Persona ();
            	bolsaClientes.add(cliente);
            }
			return bolsaClientes;	
		}
		private static void generarEntidades(int numeroEntidades) {
			
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
