package _CONSULTA;
import java.time.*;
import java.time.format.DateTimeFormatter;
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
		Locale espaniol = new Locale("es", "ES"); //Para posterior formateo de fechas
		LocalDate fechaInicial = LocalDate.of(LocalDate.now().getYear(),Month.MARCH,1);
		LocalDate fechaFinal = LocalDate.of(LocalDate.now().getYear(),Month.APRIL,30);
            
		//Variables de generacion	
		int numeroEspecialistas = 3;
		int numeroClientes = 600;
		String [] listaEspecialidad = {"Homeopatia","Quiropraxia","Sin especialidad"};
		String [] listaMetodoPago = {"Transferencia","Tarjeta","Efectivo"};
		double [] listaTarifas = {60.00,65.50};
		ArrayList <String> listaDni = new ArrayList <String>();
		ArrayList <String[]> listaClientes = new ArrayList <String[]>();
		ArrayList <Integer> festivos = new ArrayList <Integer>();
            
		//Variables de registro
        ArrayList <ArrayList> registroClientes = new ArrayList<ArrayList>();
        ArrayList [] registroEspecialistas = new ArrayList[numeroEspecialistas];
        ArrayList<int[]> registroVisitas = new ArrayList<int[]>();
            
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
           			generarConsultas(registroEspecialistas, registroClientes, registroVisitas, listaClientes, listaDni, numeroClientes, listaEspecialidad, numeroEspecialistas,fechaInicial, fechaFinal, festivos, listaMetodoPago);
           			separador();
           			break;
           		case 2://Opcion imprimir visitas
           			separador();
           			imprimirVisitas(fechaInicial, registroVisitas, registroClientes, registroEspecialistas, listaEspecialidad, listaTarifas, listaMetodoPago, fechaFinal);
            		separador();
            		break;
            	case 3://Opcion facturacion
            		separador();
            		imprimirFacturacion(registroVisitas, registroClientes,listaMetodoPago, listaTarifas, fechaInicial, fechaFinal);
            		separador();
            		break;
            	case 4://Opcion subMenu consultas generales
            		separador();
            		if (!(registroVisitas.size()==0)) {
                		mostrarSubMenu();
                		separador();
                		consultaGeneralMenu(opcion_Msj, errorOpcion_Msj, fechaInicial, registroVisitas, registroClientes, registroEspecialistas, listaEspecialidad, listaTarifas, listaMetodoPago);
					} else {
						System.out.println("Este menu no esta disponible puesto que aun no se han generado datos. Seleccione la opcion 'Generacion de consultas' del menu antes realizar esta accion.");
						
					}
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
	
	public static void mostrarSubMenu() {
		System.out.println ("MENU consultas generales:\n");
        System.out.println ("1. Consultas por idVisita/Especialista/IdCliente");
        System.out.println ("2. Facturacion por idVisita/Especialista/IdCliente");
        System.out.println ("3. Urgencias (Muestra por especialidad, total y su registro)");
        System.out.println ("9. Volver \n");
	}
	
	public static void showOptions(String ...options) {
		int n=1;
		System.out.println("Buscar por:\n");
		for(String i: options) {
			System.out.println(n+"."+i);
			n++;
		}
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
	public static void generarConsultas(ArrayList [] registroEspecialistas, ArrayList <ArrayList> registroClientes, ArrayList<int[]> registroVisitas, ArrayList <String[]> listaClientes, ArrayList <String> listaDni, int numeroClientes, String [] listaEspecialidad, int numeroEspecialistas, LocalDate fechaInicial, LocalDate fechaFinal, ArrayList<Integer> festivos, String [] listaMetodoPago) {
			generarEntidades(listaClientes, listaDni, numeroClientes);
			generarEntidades(registroEspecialistas,listaEspecialidad, numeroEspecialistas);
			generarFestivos(fechaInicial,festivos);
			generarAgenda(fechaInicial, fechaFinal, listaClientes, registroClientes, registroEspecialistas, registroVisitas, festivos, listaMetodoPago);
			System.out.println("Se han generado las consultas correctamente.");
	}
		
	
	/*El metodo generarEntidades(sobrecargado) genera tanto bolsa de clientes como el registro de especialistas.
	Utiliza unos arrays de nombres y apellidos. En el de especialistas tiene un if para asignar las especialidades.*/
	public static void generarEntidades(ArrayList <String[]> listaClientes, ArrayList <String> listaDni, int nEntidades) {
		
            String [] listaNombres = {"Rishbha","Handel","Milind","Pulkita","Yesus","Mell","Trent","Kalantha","Upravda","Stacy","Kalantha","Lincoln","Ernest","Stamford","Pryderi","Pablo","Fernando","Grace","Jaun","Nesim","Lilah","Mayrah","Madelyn","Barlow","Ilka","Beryl","Onora","Edeline","Stratton","Beryl"};
            String [] listaApellidos = {"Gladstone","Weeden","Sylvia","Utter","Lebron","Vicente","Weigand","Nelson","Lewallen","Brew","Mccombs","Rhee","William","Vierra","Kegley","Shears","Dann","Sparkle","Habib","Adcock","Sundberg","Elia","Hickok","Huertas", "Hodnett","Higgins","Klos","Junker","Enright"};
            generarDni(nEntidades, listaDni);
            for (int i=0; i<nEntidades; i++) {
		int randomDni = (int)Math.floor((int)(listaDni.size())*Math.random());
		int randomNombre = (int)Math.floor((int)(listaNombres.length)*Math.random());
		int randomApe = (int)Math.floor((int)(listaApellidos.length)*Math.random());
		int randomApe2 = (int)Math.floor((int)(listaApellidos.length)*Math.random());
		String [] cliente = {listaDni.remove(randomDni),listaNombres[randomNombre],listaApellidos[randomApe]+" "+listaApellidos[randomApe2]};
		listaClientes.add(cliente);
            }
	}
	
	public static void generarEntidades(ArrayList [] registroEspecialistas, String [] listaEspecialidad, int nEntidades) {
            String [] listaNombres = {"Rishbha","Handel","Milind","Pulkita","Yesus","Mell","Trent","Kalantha","Upravda","Stacy","Kalantha","Lincoln","Ernest","Stamford","Pryderi","Pablo","Fernando","Grace","Jaun","Nesim","Lilah","Mayrah","Madelyn","Barlow","Ilka","Beryl","Onora","Edeline","Stratton","Beryl"};
            String [] listaApellidos = {"Gladstone","Weeden","Sylvia","Utter","Lebron","Vicente","Weigand","Nelson","Lewallen","Brew","Mccombs","Rhee","William","Vierra","Kegley","Shears","Dann","Sparkle","Habib","Adcock","Sundberg","Elia","Hickok","Huertas", "Hodnett","Higgins","Klos","Junker","Enright"};

            for (int i=0; i<nEntidades; i++) {
                int randomNombre = (int)Math.floor((int)(listaNombres.length)*Math.random());
                int randomApe = (int)Math.floor((int)(listaApellidos.length)*Math.random());
                int randomApe2 = (int)Math.floor((int)(listaApellidos.length)*Math.random());
                int randomEspecialidad = (int)Math.floor((int)(listaEspecialidad.length)*Math.random());
                int randomDia = (int)Math.floor((int)5*Math.random());
                ArrayList especialista = new ArrayList();
                int[]especialidades = new int[2];
                if(i==0){
                    for(int j : especialidades) {
                    especialidades[j]=j;
                    }
                }else{
                    especialidades[0]=randomEspecialidad;
                }
                especialista.add(listaNombres[randomNombre]);
                especialista.add(listaApellidos[randomApe]);
                especialista.add(listaApellidos[randomApe2]);
                especialista.add(especialidades);
                especialista.add(randomDia);
                registroEspecialistas[i]=new ArrayList<>();
                registroEspecialistas[i] = especialista;
            }
        }
	
	/*Metodo para generar DNI para los clientes que no se repitan*/
	public static void generarDni(int nEntidades, ArrayList <String> listaDni) {
            String dni = "";
            for (int i=0; i<nEntidades; i++) {
		do {
                    dni=generarDatosDni();
		} while (listaDni.contains(dni));	
		listaDni.add(dni);
            }
	}
	
	/*Metodo para obtencion de letra del DNI*/
	public static String generarDatosDni() {
            int dni = (int)Math.floor((int)100000000*Math.random());
            int indice = dni % 23;
            String letras = "TRWAGMYFPDXBNJZSQVHLCKET";
            return String.format("%08d",dni)+letras.toCharArray()[indice];
	}
	
	/*Metodo que genera un array con las posiciones de los dias festivos*/
	public static void generarFestivos(LocalDate fechaInicial, ArrayList <Integer> festivos) {
            LocalDate feria = LocalDate.of(LocalDate.now().getYear(), 4, 13);
            int feriaDays = (int) ChronoUnit.DAYS.between(fechaInicial, feria);
            festivos.add(0);
            festivos.add(feriaDays);
            festivos.add(feriaDays+1);
	}
	
	/*Modulo generarAgenda*/
	/*Metodo que controla el tiempo de generacion de las consultas. Simplemente calcula la diferencia entre
	dos fechas y hace un for con ese rango*/
	public static void generarAgenda(LocalDate fechaInicial, LocalDate fechaFinal, ArrayList <String[]> listaClientes, ArrayList <ArrayList> registroClientes,  ArrayList [] registroEspecialistas, ArrayList<int[]> registroVisitas, ArrayList <Integer> festivos,  String[] listaMetodoPago) {	
		int periodoConsultas = ((int)ChronoUnit.DAYS.between(fechaInicial, fechaFinal))+1;
		for (int i=0; i<periodoConsultas; i++) {
                    generarDia(fechaInicial, listaClientes, registroClientes, registroEspecialistas, registroVisitas, festivos, listaMetodoPago, i);
		}
	}
	
	/*Metodo que controla todo los procesos de cada dia, desde llamar al metodo diaLibre o comprobar festivos
	para todos los especialistas*/
	public static void generarDia(LocalDate fechaInicial, ArrayList <String[]> listaClientes, ArrayList <ArrayList> registroClientes,  ArrayList [] registroEspecialistas, ArrayList<int[]> registroVisitas, ArrayList <Integer> festivos, String[] listaMetodoPago, int fecha ){
        if (!festivos.contains(fecha)) {
        	for (int i=0; i<registroEspecialistas.length; i++) {
        		if(!diaLibre(registroEspecialistas[i],fechaInicial,fecha)) {
        			generarVisitas(listaClientes, registroClientes, i, registroEspecialistas[i], registroVisitas, listaMetodoPago, fecha);
                }
        	}
        }
	}
	
	/*Metodo que comprueba si es el dia libre de algun especialista*/
	public static boolean diaLibre(ArrayList registroEspecialista, LocalDate fechaInicial, int fecha) {
            LocalDate dia = fechaInicial.plusDays(fecha-1);
            int diaSem=dia.getDayOfWeek().ordinal();
		if ((int)registroEspecialista.get(4)==diaSem||diaSem>4) {
                    return true;
		} else {
			return false;
		}
	}
	
	/*Modulo generarVisitas*/
	/*Metodo que genera las visitas diarias de un especialista y llama a registro de cliente y de visitas
	segun diga el metodo checkCliente*/
	public static void generarVisitas(ArrayList <String[]> listaClientes, ArrayList <ArrayList> registroClientes, int idEspecialista, ArrayList especialista, ArrayList<int[]> registroVisitas, String[] listaMetodoPago, int fecha) {
            int nVisitas=(int)(Math.floor(6*Math.random())+10);//random para las visitas de ese dia
            for(int i=0;i<nVisitas;i++){
                int randomCliente = (int)Math.floor((int)(listaClientes.size())*Math.random());//random para coger clientes al azar y registrarlos si es necesario
                if(!checkCliente(registroClientes, listaClientes.get(randomCliente))){
                    int [] especialidades = (int[]) especialista.get(3);//Lo fijo en otro array para poder usar el método length ya en este punto no sabe que tipo de objeto es el objeto de la posición 3 (int [] especialidades del Especialista).
                    int randomEspecialidad = (int)Math.floor((int)(especialidades.length)*Math.random());//random para generar una especialidad de las que posee el especialista.
                    registroClientes(registroClientes, randomEspecialidad, idEspecialista, listaClientes.get(randomCliente), listaMetodoPago);
                    registroVisita(registroVisitas, registroClientes.size()-1, registroClientes.get(registroClientes.size()-1),fecha);
                }else{
                    String dniCliente = listaClientes.get(randomCliente)[0]; 
                    int idCliente = checkCliente(registroClientes, dniCliente);
                    registroVisita(registroVisitas, idCliente, registroClientes.get(idCliente),fecha);
                }
            }
	}
	/*El metodo checkCliente (sobrecargado) checkea si el registro de clientes contiene el nuevo cliente
	comparando el dni y en su segunda versión dandole el dni te devuelve la id(posicion)*/
	public static boolean checkCliente (ArrayList <ArrayList> registroClientes, String[] cliente) {
		for(int i=0; i<registroClientes.size();i++) {
			if(registroClientes.get(i).contains(cliente[0])) {
				return true;
			}
		}
		return false;
	}
	public static int checkCliente (ArrayList <ArrayList> registroClientes, String dni) {
            for(int i=0; i<registroClientes.size();i++) {
		if(registroClientes.get(i).contains(dni)) {
                    return i;
		}
            }
            return -1;
	}
	
	/*Metodo que registra a un cliente de un String [] cliente sacado de la lista generada*/
	public static void registroClientes(ArrayList <ArrayList> registroClientes,int especialidad, int especialista, String[] cliente, String [] listaMetodoPago) {
            ArrayList registroCliente=new ArrayList();
            for(String i: cliente) {
                    registroCliente.add(i);
            }
            registroCliente.add(especialidad);
            registroCliente.add(especialista);
            int randomMP = (int)Math.floor((int)(listaMetodoPago.length)*Math.random());//random para añadir metodo de pago
            registroCliente.add(randomMP);
            registroClientes.add(registroCliente);
	}
	
	/*Metodo que registra los valores de la visita*/
	public static void registroVisita(ArrayList <int[]> registroVisitas, int idCliente, ArrayList cliente, int fecha) {
		int tipoVisita = generarUrgencia();//metodo para generar el tipo de visita 
		int [] visita = {idCliente,(int)cliente.get(4),(int)cliente.get(3),(int)cliente.get(3),tipoVisita, fecha};
		registroVisitas.add(visita);
	}
	
    public static int generarUrgencia(){
    	int urgencia=(int)Math.floor((int)48*Math.random());
        return (urgencia==0)?1:0;
    }
    
	/*Modulo de consultaDatos*/
    /*Controla que el registro de visitas no este vacio e imprime formateando los diferentes campos*/
	public static void imprimirVisitas(LocalDate fechaInicio,ArrayList <int[]> registroVisitas,ArrayList <ArrayList> registroClientes,ArrayList [] registroEspecialistas,String [] listaEspecialidad, double [] listaTarifas, String [] listaMetodoPago, LocalDate fechaFinal) {
		if (!(registroVisitas.size()==0)) {
			DateTimeFormatter shortFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			System.out.println("REGISTRO DE VISITAS: (Periodo "+fechaInicio.format(shortFormat)+" - "+fechaFinal.format(shortFormat)+")");
			separador();
			for (int i = 0; i<registroVisitas.size(); i++) {
		    	LocalDate fecha=fechaInicio.plusDays(registroVisitas.get(i)[5]);
		    	int idCliente = registroVisitas.get(i)[0];
		    	String urgencia = "";
		    	if(registroVisitas.get(i)[4]==1) {
		    		urgencia = "Si";
		    		System.out.printf("Visita:%04d\tDia:%s\tEspecialista:%-17s\tRama:%-11s\tCliente:%04d\tTarifa:%,.2f€ \tFCobro:%-13s\tUrgencia:%s\n", i, fecha.format(shortFormat), registroEspecialistas[registroVisitas.get(i)[1]].get(2)+", "+registroEspecialistas[registroVisitas.get(i)[1]].get(1),listaEspecialidad[registroVisitas.get(i)[2]],idCliente,listaTarifas[registroVisitas.get(i)[3]]*1.20,listaMetodoPago[(int)registroClientes.get(idCliente).get(5)], urgencia);
		    	} else {
		    	urgencia = "No";
		    	System.out.printf("Visita:%04d\tDia:%s\tEspecialista:%-17s\tRama:%-11s\tCliente:%04d\tTarifa:%,.2f€ \tFCobro:%-13s\tUrgencia:%s\n", i, fecha.format(shortFormat), registroEspecialistas[registroVisitas.get(i)[1]].get(2)+", "+registroEspecialistas[registroVisitas.get(i)[1]].get(1),listaEspecialidad[registroVisitas.get(i)[2]],idCliente,listaTarifas[registroVisitas.get(i)[3]],listaMetodoPago[(int)registroClientes.get(idCliente).get(5)], urgencia);
		    	}
		    }
		} else {
			System.out.println("Aun no hay datos de generados. Seleccione la opcion 'Generacion de consultas' del menu antes realizar esta accion.");
		}
		
	}
	public static void imprimirVisita(LocalDate fechaInicial,ArrayList <int[]> registroVisitas, ArrayList <ArrayList> registroClientes, ArrayList [] registroEspecialistas,String [] listaEspecialidad, double [] listaTarifas, String [] listaMetodoPago, int id) {
		DateTimeFormatter shortFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate fecha=fechaInicial.plusDays(registroVisitas.get(id)[5]);
	        int idCliente = registroVisitas.get(id)[0];
	        String urgencia = "";
	    	if(registroVisitas.get(id)[4]==1) {
	    		urgencia = "Si";
	    		System.out.printf("Visita:%04d\tDia:%s\tEspecialista:%-17s\tRama:%-11s\tCliente:%04d\tTarifa:%,.2f€ \tFCobro:%-13s\tUrgencia:%s\n", id, fecha.format(shortFormat), registroEspecialistas[registroVisitas.get(id)[1]].get(2)+", "+registroEspecialistas[registroVisitas.get(id)[1]].get(1),listaEspecialidad[registroVisitas.get(id)[2]],idCliente,listaTarifas[registroVisitas.get(id)[3]]*1.20,listaMetodoPago[(int)registroClientes.get(idCliente).get(5)], urgencia);
	    	} else {
	    	urgencia = "No";
	    	System.out.printf("Visita:%04d\tDia:%s\tEspecialista:%-17s\tRama:%-11s\tCliente:%04d\tTarifa:%,.2f€ \tFCobro:%-13s\tUrgencia:%s\n", id, fecha.format(shortFormat), registroEspecialistas[registroVisitas.get(id)[1]].get(2)+", "+registroEspecialistas[registroVisitas.get(id)[1]].get(1),listaEspecialidad[registroVisitas.get(id)[2]],idCliente,listaTarifas[registroVisitas.get(id)[3]],listaMetodoPago[(int)registroClientes.get(idCliente).get(5)], urgencia);
	    	}
	}
    /*Similar al de visitas pero para la subconsulta de urgencias*/
	public static void imprimirUrgencias(LocalDate fechaInicio,ArrayList <int[]> registroVisitas,ArrayList <ArrayList> registroClientes,ArrayList [] registroEspecialistas,String [] listaEspecialidad, double [] listaTarifas, String [] listaMetodoPago) {
		DateTimeFormatter shortFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println("Visitas de urgencias:");
		separador();
	    int contEsp1=0;
	    int contEsp2=0;
		for (int i = 0; i<registroVisitas.size(); i++) {
	    	LocalDate fecha=fechaInicio.plusDays(registroVisitas.get(i)[5]);
	    	int idCliente = registroVisitas.get(i)[0];
	    	String urgencia = "";
	    	if(registroVisitas.get(i)[4]==1) {
	    		urgencia = "Si";
	    		System.out.printf("Visita:%04d\tDia:%s\tEspecialista:%-17s\tRama:%-11s\tCliente:%04d\tTarifa:%,.2f€ \tFCobro:%-13s\tUrgencia:%s\n", i, fecha.format(shortFormat), registroEspecialistas[registroVisitas.get(i)[1]].get(2)+", "+registroEspecialistas[registroVisitas.get(i)[1]].get(1),listaEspecialidad[registroVisitas.get(i)[2]],idCliente,listaTarifas[registroVisitas.get(i)[3]]*1.20,listaMetodoPago[(int)registroClientes.get(idCliente).get(5)], urgencia);
	    		if(registroVisitas.get(i)[2]==0) {
	    			contEsp1++;
	    		}else {
	    			contEsp2++;
	    		}
	    	}
	    }
		separador();
		System.out.println("Número de visitas por especialidad:");
		separador();
        System.out.printf("%-11s:\t %5d\n",listaEspecialidad[0], contEsp1);
        System.out.printf("%-11s:\t %5d\n",listaEspecialidad[1], contEsp2);
        System.out.printf("Total:\t %13d\n", contEsp1+contEsp2);
	}
    /*Recorre el registro y va acumulando los diferentes importes (si son urgencia les añade el 20%)
     y los imprime formateados*/
	public static void imprimirFacturacion(ArrayList <int[]> registroVisitas,ArrayList <ArrayList> registroClientes, String [] listaMetodoPago, double [] listaTarifas, LocalDate fechaInicial, LocalDate fechaFinal) {
		if (!(registroVisitas.size()==0)) {
			DateTimeFormatter shortFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    	double metodo1 = 0;
	    	double metodo2 = 0;
	    	double metodo3 = 0;
			for (int i = 0; i<registroVisitas.size(); i++) {
		    	int idCliente = registroVisitas.get(i)[0];
		    		switch((int)registroClientes.get(idCliente).get(5)) {
		    		case 0:
		    			metodo1+=sumTarifa(listaTarifas,registroVisitas.get(i));
		    			break;
		    		case 1:
		    			metodo2+=sumTarifa(listaTarifas,registroVisitas.get(i));
		    			break;
		    		case 2:
		    			metodo3+=sumTarifa(listaTarifas,registroVisitas.get(i));
		    			break;
		    		}
		    }
			System.out.println("FACTURACION:\t"+String.format("%-10s","(Periodo "+fechaInicial.format(shortFormat)+" - "+fechaFinal.format(shortFormat)+")"));
			separador();
			System.out.println(String.format("%-44s","Efectivo:")+String.format("%,.2f", metodo3)+"€");
	    	System.out.println(String.format("%-44s","Tarjeta:")+String.format("%,.2f", metodo2)+"€");
	    	System.out.println(String.format("%-44s","Transferencia:")+String.format("%,.2f", metodo1)+"€");
	    	separador();
	    	System.out.println(String.format("%-44s", "TOTAL:")+String.format("%,.2f", metodo1+metodo2+metodo3)+"€");
		} else {
			System.out.println("Aun no hay datos de generados. Seleccione la opcion 'Generacion de consultas' del menu antes realizar esta accion.");
		}
	}
	/*Metodo que solventa el aumento por urgencia y el cobro para abstraerlo*/
	public static double sumTarifa (double [] listaTarifas, int[] registroVisita) {
		double cobroUrgencia = 1.20;
		double sumTarifa = 0;
		if(!(registroVisita[4]==0)) {
			sumTarifa+=listaTarifas[registroVisita[2]];
		} else {
			sumTarifa+=(listaTarifas[registroVisita[2]])*cobroUrgencia;
		}
		return sumTarifa;
	}
	/*Submenu con algunas subconsultas secundarias (En desarrollo)*/
	public static void consultaGeneralMenu(String opcion_Msj, String errorOpcion_Msj, LocalDate fechaInicial,ArrayList <int[]> registroVisitas,ArrayList <ArrayList> registroClientes,ArrayList [] registroEspecialistas,String [] listaEspecialidad,double [] listaTarifas, String[] listaMetodoPago) {
		int opcion;
		String volver_Msj="Volviendo al menu principal...";
		do{
			separador();
			mostrarSubMenu();
			opcion = pedirNum(0, 9, opcion_Msj);
			switch(opcion){
				case 1:
					separador();
					consultaGeneral(registroVisitas, fechaInicial, registroClientes, registroEspecialistas, listaEspecialidad, listaMetodoPago, listaTarifas, volver_Msj);
					separador();
					break;
				case 2:
					separador();
					consultaGeneral(registroVisitas, registroClientes, registroEspecialistas, listaTarifas);
					separador();
					break;
				case 3:
					separador();
					imprimirUrgencias(fechaInicial, registroVisitas, registroClientes, registroEspecialistas, listaEspecialidad, listaTarifas, listaMetodoPago);
					separador();
					break;
				default://Otra opcion error
	           		separador();
	           		System.out.println(errorOpcion_Msj);
	           		separador();
	           		break;	
				case 9:
					separador();
					System.out.println(volver_Msj);
					separador();
					break;
			}
		} while(opcion!=9);
	}
	/*Metodo de consulta de facturacion especifica por id (cliente, especialista o visita)*/	
	public static void consultaGeneral(ArrayList <int[]> registroVisitas, ArrayList<ArrayList> registroClientes, ArrayList[] registroEspecialistas, double [] listaTarifas) {
		int option;
		int id;
		double urgencia = 1.20;
		double total = 0.0;
		showOptions("IdEspecialista","IdCliente","IdVisita");
		option=pedirNum(1,3,"Escoja una opcion.")-1;
		switch(option) {
		case 0:
			id=pedirNum(1,registroEspecialistas.length,"Introduzca el Id de Especialista.")-1;
			for(int i=0; i<registroVisitas.size(); i++) {
				if(registroVisitas.get(i)[1]==id) {
					if(registroVisitas.get(i)[4]==1) {
						total+=listaTarifas[registroVisitas.get(i)[3]]*urgencia;
					} else { 
						total+=listaTarifas[registroVisitas.get(i)[3]];
					}
				}
			}
			System.out.println("El doctor "+registroEspecialistas[id].get(1)+", "+registroEspecialistas[id].get(0)+" ha facturado un total de "+String.format("%,.2f€", total));
			break;
		case 1:
			id=pedirNum(1,registroClientes.size(),"Introduzca el Id de Cliente.")-1;
			for(int i=0; i<registroVisitas.size(); i++) {
				if(registroVisitas.get(i)[0]==id) {
					if(registroVisitas.get(i)[4]==1) {
						total+=listaTarifas[registroVisitas.get(i)[3]]*urgencia;
					} else { 
						total+=listaTarifas[registroVisitas.get(i)[3]];
					}
				}
			}
			System.out.println("El cliente "+(id+1)+" nos ha facturado un total de "+String.format("%,.2f€", total));
			break;
		case 2:
			id=pedirNum(1,registroVisitas.size(),"Introduzca el Id de Visita.")-1;
				if(registroVisitas.get(id)[4]==1) {
					total+=listaTarifas[registroVisitas.get(id)[3]]*urgencia;
				} else {
					total+=listaTarifas[registroVisitas.get(id)[3]];
				}
			System.out.println("La visita se facturo a un total de "+String.format("%,.2f€", total));
			break;
		}
	}
	
    public static void consultaGeneral(ArrayList <int[]> registroVisitas,LocalDate fechaInicial,ArrayList <ArrayList> registroClientes,ArrayList [] registroEspecialistas,String [] listaEspecialidad,String [] listaMetodoPago,double [] listaTarifas,String volver_Msj) {
    int opcion;
    int idEntidad;
    int idVisita;
    opcion=pedirNum(1,3,"Buscar por IdEspecialista/IdCliente/IdVisita")-1;
        switch(opcion){
            case 0:
                idEntidad=pedirNum(1,3,"Buscar especialista")-1;
                consultaEsp(registroVisitas,idEntidad+1, fechaInicial,registroClientes,registroEspecialistas,listaEspecialidad,listaMetodoPago,listaTarifas);
                break;
            case 1:
            	idEntidad=pedirNum(1,registroClientes.size(),"Buscar cliente")-1;
                consultaCli(registroVisitas,idEntidad+1, fechaInicial,registroClientes,registroEspecialistas,listaEspecialidad,listaMetodoPago,listaTarifas);
                break;
            case 2:
                idVisita=pedirNum(1,registroVisitas.size(),"Buscar visita")-1;
                consultaVis(registroVisitas,idVisita+1,fechaInicial,registroClientes,registroEspecialistas,listaEspecialidad,listaMetodoPago,listaTarifas);
                break;
            case 9:
                System.out.println(volver_Msj);
                break;
        }
    }
    
    public static void consultaEsp(ArrayList <int[]> registroVisitas,int id,LocalDate fechaInicial,ArrayList <ArrayList> registroClientes,ArrayList [] registroEspecialistas,String [] listaEspecialidad,String [] listaMetodoPago,double [] listaTarifas){
        ArrayList <int []> consulta=new ArrayList<int[]>();
        for(int i=0;i<registroVisitas.size();i++){
            if(registroVisitas.get(i)[1]==id){
                consulta.add(registroVisitas.get(i));
                imprimirVisita(fechaInicial, registroVisitas, registroClientes, registroEspecialistas, listaEspecialidad, listaTarifas, listaMetodoPago, i);
            }
        }
        
    }
    
    public static void consultaCli(ArrayList <int[]> registroVisitas, int idCliente, LocalDate fechaInicial,ArrayList <ArrayList> registroClientes,ArrayList [] registroEspecialistas,String [] listaEspecialidad,String [] listaMetodoPago,double [] listaTarifas){
        ArrayList <int []> consulta=new ArrayList<int[]>();
        for(int i=0;i<registroVisitas.size();i++){
            if(registroVisitas.get(i)[0]==idCliente){
                consulta.add(registroVisitas.get(i));
                imprimirVisita(fechaInicial, registroVisitas, registroClientes, registroEspecialistas, listaEspecialidad, listaTarifas, listaMetodoPago, i);
            }
        }
         
    }
    public static void consultaVis(ArrayList <int[]> registroVisitas,int id,LocalDate fechaInicial,ArrayList <ArrayList> registroClientes,ArrayList [] registroEspecialistas,String [] listaEspecialidad,String [] listaMetodoPago,double [] listaTarifas){
        ArrayList <int []> Consulta=new ArrayList<int[]>();
        Consulta.add(registroVisitas.get(id));
        
        imprimirVisita(fechaInicial, registroVisitas, registroClientes, registroEspecialistas, listaEspecialidad, listaTarifas, listaMetodoPago,id);
    }
}