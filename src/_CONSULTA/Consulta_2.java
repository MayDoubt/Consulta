package _CONSULTA;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.InputMismatchException;

import java.util.Scanner;

public class Consulta_2 {
	
	//Variables de registro y generales
    static ArrayList <Paciente> registroPacientes = new ArrayList<Paciente>();
    static Profesional [] registroEspecialistas;
    static ArrayList<Visita> registroVisitas = new ArrayList<Visita>();
    static ArrayList <Integer> festivos = new ArrayList <Integer>();
    static LocalDate fechaInicial = LocalDate.of(LocalDate.now().getYear(),Month.JANUARY,1);
    
	public static void main(String[] args) {
			// Variables
			int opcion;
			LocalDate fechaFinal = LocalDate.of(LocalDate.now().getYear(),Month.DECEMBER,31);
			
			//Variables de generacion
			int numeroEspecialistas = 6;
			int numeroInicialPacientes = 3000;
			int numeroPacientes = 1000;
			int numeroDobleEsp = 4;
			registroEspecialistas = new Profesional[numeroEspecialistas];
			
			
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
		      			generarConsultas(numeroPacientes,numeroEspecialistas,numeroInicialPacientes,numeroDobleEsp, fechaInicial,fechaFinal);
		       			separador();
		       			break;
		       		case 2://Opcion imprimir visitas
		      			separador();
		      			imprimirVisitas();
		       			separador();
		          		break;
		       		case 3://Opcion imprimir profesionales
		      			separador();
		      			imprimirEspecialistas();
		       			separador();
		          		break;
		           	case 4://Opcion imprimir registro clientes
		           		separador();
		           		imprimirClientes();
		           		separador();
		           		break;
		           	case 5://Opcion facturacion
		           		separador();
		           		imprimirFacturacion(fechaFinal);
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
		/*Metodo mostrar menú*/
		public static void mostrarMenu() {//Muestra las opciones del menu
			System.out.println ("MENU:\n");
		    System.out.println ("1. Generación de consultas");
		    System.out.println ("2. Imprimir visitas");
		    System.out.println ("3. Registro especialistas");
		    System.out.println ("4. Registro clientes");
		    System.out.println ("5. Imprimir facturación anual");
		    System.out.println ("9. Salir \n");
		}
		
		public static void separador() {
			System.out.println("\n=======================================================\n");
		}
		
		public static int pedirNum (int inicio, int fin, String mensaje) {
            int numero=0;
            Scanner sc;
            sc = new Scanner(System.in);
            do{
            	try{
                    System.out.print(mensaje+" Introduce un número entre "+(inicio)+" y "+(fin)+": ");
                    numero = sc.nextInt();		
            	} catch (InputMismatchException | NumberFormatException ex){
                    System.err.println("\nIntroduzca un número no un caracter, por favor.");
                    sc.next();
            	}
            } while (numero<inicio || numero>fin);
            return numero;
		}
		
		/*Modulo generarEntidades*/
		/*Metodo general de generación de entidades*/
		public static void generarConsultas(int numeroPacientes, int numeroEspecialistas,int numeroInicialPacientes, int numeroDobleEsp, LocalDate fechaInicial, LocalDate fechaFinal) {
			
			ArrayList <Persona> bolsaInicialClientes = new ArrayList <Persona>();
			
				generarFestivos(fechaInicial);
				generarEntidades(numeroEspecialistas,numeroDobleEsp);
				bolsaInicialClientes=generarEntidades(numeroInicialPacientes);
				registroInicial(bolsaInicialClientes);
				generarAgenda(fechaInicial,fechaFinal, bolsaInicialClientes);
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
		private static void generarVisitas(ArrayList<Persona> bolsaInicialClientes, Profesional profesional, int fecha) {
		     int nVisitas=(int)(Math.floor(6*Math.random())+10); //random para las visitas de ese dia y ese especialista
	            for(int i=0;i<nVisitas;i++){
	            	boolean randomRegistro = ((int)Math.floor((int)201*Math.random())==0)?true:false;//Random para coger clientes al azar y registrarlos si es necesario
	            	if(randomRegistro) {
	            		Persona cliente = new Persona ();
	            		int randomEsp= (int)Math.floor((int)(profesional.especialidades.length)*Math.random());
	            		registroPaciente(cliente,profesional.idEspecialista,profesional.especialidades[randomEsp]);
	            		
	                } else {
	                	int randomCliente = (int)Math.floor((int)(registroPacientes.size())*Math.random());
	                	registroVisita(registroPacientes.get(randomCliente).idPaciente, registroPacientes.get(randomCliente),fecha);
	                }
	            }
		}

		/*Metodo de generación de clientes*/
		private static ArrayList<Persona> generarEntidades(int numeroEntidades) {
			ArrayList <Persona> bolsaClientes = new ArrayList <Persona>();
            for (int i=0; i<numeroEntidades; i++) {
            	Persona cliente = new Persona ();
            	bolsaClientes.add(cliente);
            }
			return bolsaClientes;	
		}
		
		/*Metodo de generación de especialistas*/
		private static void generarEntidades(int numeroEntidades, int numeroDobleEsp) {
			Profesional [] listaEspecialistas = new Profesional [numeroEntidades]; 
            for (int i=0; i<numeroEntidades; i++) {
            	if (i>numeroDobleEsp) {
            		Profesional especialista = new Profesional(1);
            		listaEspecialistas [i]=especialista;
            	} else {
            		Profesional especialista = new Profesional(1);
        			listaEspecialistas [i]=especialista;
            	}
            }	
            registroEspecialistas=listaEspecialistas;
		}
		
		/*Metodo de generación de festivos*/
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
		
		/*Metodo de generación de un entero de la diferencia entre dias*/
		private static int generarFecha (LocalDate fechaInicial, LocalDate fecha) {
			int newFecha = (int) ChronoUnit.DAYS.between(fechaInicial, fecha);
			return newFecha;
		}
		
		/*Metodo de generación de una fecha del entero de la posicion*/
		private static LocalDate generarFecha (LocalDate fechaInicial, int fecha) {
				return fechaInicial.plusDays(fecha);
		}

		/*Modulo de registro*/
		private static void registroInicial(ArrayList <Persona> bolsaInicialClientes) {
			for(int i=0;i<bolsaInicialClientes.size();i++) {
				int randomEspecialista=(int)Math.floor((int)registroEspecialistas.length*Math.random());
				String randomEspecialidad=registroEspecialistas[randomEspecialista].especialidades[(int)Math.floor((int)registroEspecialistas[randomEspecialista].especialidades.length*Math.random())];
				registroPaciente(bolsaInicialClientes.get(i),randomEspecialista,randomEspecialidad);
			}
		}
		/*Metodo de registro de pacientes*/
		private static int registroPaciente(Persona persona, int idEspecialista, String especialidades) {
				Paciente registroCliente = new Paciente(persona, idEspecialista, especialidades);
	            registroPacientes.add(registroCliente);
	            return registroCliente.idPaciente;
		}

		/*Metodo que devuelve la posicion de un cliente por su dni*/
		private static int checkCliente(String dniCliente) {
		    for(int i=0; i<registroPacientes.size();i++) {
	        	if(registroPacientes.get(i).dni.equalsIgnoreCase(dniCliente)) {
	                    return i;
	        	}
	        }
	        return -1;
		}

		/*Metodo que comprueba si existe el registro de paciente del cliente*/
		private static boolean checkCliente(Persona cliente) {
			for(int i=0; i<registroPacientes.size();i++) {
				if(registroPacientes.get(i).equals(cliente)) {
					return true;
				}
			}
			return false;
		}
		
		/*Metodo de registro de Visita*/
		private static void registroVisita(int idCliente, Paciente paciente, int fecha) {
			LocalDate fechaVisita = generarFecha(fechaInicial, fecha);
			Visita visita = new Visita(paciente, fechaVisita);
			registroVisitas.add(visita);
		}

		/*Metodo de comprobación de dia festivo o libre*/
		public static boolean diaLibre(Profesional registroEspecialista, LocalDate fechaInicial, int fecha) {
            LocalDate dia = fechaInicial.plusDays(fecha-1);
            int diaSem=dia.getDayOfWeek().ordinal();
            	if ((int)registroEspecialista.diaLibre==diaSem||diaSem>4) {
            		return true;
            	} else {
            		return false;
            	}
		}

		public static void imprimirVisitas() {
			if(!(registroVisitas.size()==0)) {
				for(int i=0; i<registroVisitas.size();i++) {
					System.out.printf("Visita:%04d\t",i);
					System.out.printf(registroVisitas.get(i).toString()+"\n");
				}
			} else {
				System.out.println("El registro de visitas está vacío.");
			}
		}
		
		private static void imprimirEspecialistas() {
			if(!(registroEspecialistas.length==0)) {
				for(int i=0; i<registroEspecialistas.length;i++) {
					System.out.println(registroEspecialistas[i].toString());
				}
			} else {
				System.out.println("El registro de especialistas está vacío.");
			}
		}
		
		private static void imprimirClientes() {
			if(!(registroPacientes.size()==0)) {
				for(int i=0; i<registroPacientes.size();i++) {
					System.out.println(registroPacientes.get(i).toString());
				}
			} else {
				System.out.println("El registro de especialistas está vacío.");
			}
		}
		private static void imprimirFacturacion(LocalDate fechaFinal) {
			if (!(registroVisitas.size()==0)) {
				DateTimeFormatter shortFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		    	double efectivo = 0;
		    	double tarjeta = 0;
		    	double transferencia = 0;
				for (int i = 0; i<registroVisitas.size(); i++) {
			    	int idCliente = registroVisitas.get(i).idPaciente;
			    		if(registroPacientes.get(idCliente).formaPago.equalsIgnoreCase("efectivo")) {
			    			efectivo+=sumTarifa(registroVisitas.get(i));
			    		}
			    		else if (registroPacientes.get(idCliente).formaPago.equalsIgnoreCase("tarjeta")) {
			    			tarjeta+=sumTarifa(registroVisitas.get(i));
			    		} else {
			    			transferencia+=sumTarifa(registroVisitas.get(i));
			    		}
			    }
				System.out.println("FACTURACION:\t"+String.format("%-10s","(Periodo "+fechaInicial.format(shortFormat)+" - "+fechaFinal.format(shortFormat)+")"));
				separador();
				System.out.println(String.format("%-44s","Efectivo:")+String.format("%,.2f", efectivo)+"€");
		    	System.out.println(String.format("%-44s","Tarjeta:")+String.format("%,.2f", tarjeta)+"€");
		    	System.out.println(String.format("%-44s","Transferencia:")+String.format("%,.2f", transferencia)+"€");
		    	separador();
		    	System.out.println(String.format("%-44s", "TOTAL:")+String.format("%,.2f", efectivo+tarjeta+transferencia)+"€");
			} else {
				System.out.println("Aun no hay datos de generados. Seleccione la opcion 'Generacion de consultas' del menu antes realizar esta accion.");
			}
		}
		public static double sumTarifa (Visita registroVisita) {
			double cobroUrgencia = 1.20;
			double sumTarifa = 0;
			if(!(registroVisita.urgencia.equalsIgnoreCase("si"))) {
				sumTarifa+=registroVisita.tarifa;
			} else {
				sumTarifa+=(registroVisita.tarifa)*cobroUrgencia;
			}
			return sumTarifa;
		}
}