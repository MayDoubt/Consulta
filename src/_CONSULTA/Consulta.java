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
            Locale espaniol = new Locale("es", "ES"); //Para posterior formateo de fechas
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
			generarEntidades(listaClientes, listaDni, 600);
			generarEntidades(registroEspecialistas,listaEspecialidad, numeroEspecialistas);
			generarFestivos(fechaInicial,festivos);
			generarAgenda(fechaInicial, fechaFinal, listaClientes, registroClientes, registroEspecialistas, registroVisitas, festivos, listaMetodoPago);
			separador();
			break;
                    case 2://Opcion imprimir pruebas
			separador();
                        //imprimirPruebas(listaClientes);
			imprimirPrueba(registroEspecialistas);
			//imprimirClientes(registroClientes);
			//imprimirVisitasPrueba(registroVisitas);
			separador();
			break;
                    case 3://Opcion posteriores consultas
			separador();
                        imprimirVisitas(registroVisitas,registroClientes,registroEspecialistas,listaEspecialidad,listaMetodoPago,listaTarifas);
			facturacion(registroVisitas,registroClientes,listaTarifas);
                        //System.out.println("Seccion en proceso. Pruebe con otras.");
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
            System.out.println ("Menu:\n");
            System.out.println ("1. Generación de consultas");
            System.out.println ("2. Imprimir pruebas");
            System.out.println ("3. Posteriores consultas (en proceso)");
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
            int urgencia=(int)Math.floor((int)(1-0)*Math.random());
            return urgencia;
        }
	/*Modulo de consultaDatos*/
	public static void imprimirPruebas(ArrayList <String[]> listaClientes) { //Metodo para testeo bolsa de clientes
		for(String i [] : listaClientes) {
			System.out.println(Arrays.toString(i));
		}
              
	}
	public static void imprimirPrueba(ArrayList [] listaEspecialistas) { //Metodo para testeo de especialistas.
		for(ArrayList i : listaEspecialistas) {
			System.out.println(i.toString());
		}
	}  
	public static void imprimirClientes(ArrayList <ArrayList> registroClientes) { //Metodo para testeo registro de clientes
		System.out.println(registroClientes.size());
		for(ArrayList i : registroClientes) {
				System.out.println(i);
		}
	}
	public static void imprimirVisitasPrueba(ArrayList <int[]> registroVisitas) { //Metodo para testeo registro de visitas
            System.out.println(registroVisitas.size());
            for(int[] i : registroVisitas) {
		for(int j : i) {
                    System.out.print(j+" ");
		}
		System.out.println("");
            }
	}
	public static void imprimirVisitas(ArrayList <int[]> registroVisitas,ArrayList <ArrayList> registroClientes,ArrayList [] registroEspecialistas,String [] listaEspecialidad,String [] listaMetodoPago,double [] listaTarifas) {  //ToDo
            //Habria que crear un metodo ya mostrando valores formateados y que se entiendan no con enteros. Borra los de prueba conforme los actualices.
            /*ArrayList de array Visitas(numvisita,fecha,nombre especialista,especialidad,idcliente,precio,metodopago,urgencia)*/
            ArrayList <ArrayList> Visitas=new ArrayList();
            ArrayList visita=new ArrayList();
            //for(int i=0;i<registroVisitas.size();i++){//for para generar la lista con todas las visitas,se desmadra al activarlo
                int idvisita=3;//i
                visita.add(idvisita);
                int [] id=registroVisitas.get(3);//i
                int fecha=id[5];
                visita.add(fecha);
                int [] especialista=registroVisitas.get(3);//i
                if(especialista[1]==0){//controlamos que dependiendo del numero que salga es un especialista e introducimos el nombre del especialista y de la especialidad correspondiente
                    ArrayList <String> espe=registroEspecialistas[0];
                    String especialistas=espe.get(0);
                    String especialidad=espe.get(2);
                    visita.add(especialistas);
                visita.add(especialidad);
                }else if(especialista[1]==1){
                    ArrayList <String> espe=registroEspecialistas[1];
                    String especialistas=espe.get(0);
                    String especialidad=espe.get(2);
                    visita.add(especialistas);
                    visita.add(especialidad);
                }else{
                    ArrayList <String> espe=registroEspecialistas[2];
                    String especialistas=espe.get(0);
                    visita.add(especialistas);
                    if(especialista[2]==0){//controlamos el tercer especialista que tiene 2 especialidades
                        String especialidad=espe.get(2);
                        visita.add(especialidad);
                    }else{
                        String especialidad=espe.get(3);
                        visita.add(especialidad);
                    }
                }
                int idcliente= id[0];
                visita.add(idcliente);
                if(id[3]==0){//controlamos que tarifa paga dependiendo del numero que aparezca e introducimos el digito de la tarifa
                    double tarifa=listaTarifas[0];
                    visita.add(tarifa);
                }else{
                    double tarifa=listaTarifas[1];
                    visita.add(tarifa);
                }
                if((int)registroClientes.get(3).get(5)==0){//i en el primer get,controlamos que metodo de pago utiliza dependiendo del numero que aparezca e introducimos el nombre del pago
                    String pago=listaMetodoPago[0];
                    visita.add(pago);
                }else if((int)registroClientes.get(0).get(5)==1){
                    String pago=listaMetodoPago[1];
                    visita.add(pago);
                }else{
                    String pago=listaMetodoPago[2];
                    visita.add(pago);
                }
                if(id[4]==0){//Controlamos que tipo de visita es y mandamos un no o un si depende del caso
                    String urgencia="NO";
                    visita.add(urgencia);
                }else{
                    String urgencia="SI";
                    visita.add(urgencia);
                }
                Visitas.add(visita);
            //}
            for(ArrayList v:Visitas){
                System.out.println(v.toString());
                }
                System.out.println("");
            
        }
        
        public static void facturacion(ArrayList <int[]> registroVisitas,ArrayList <ArrayList> registroClientes,double [] listaTarifas){
            double efectivo=0;
            double tarjeta=0;
            double transferencia=0;
            double total=0;
            //for(int i=0;i<registroVisitas.size();i++){//al meter el for se desmadra
                if((int)registroClientes.get(3).get(5)==0){//i en el primer get,controlamos el metodo de pago en registroVisitas y dependiendo del numero lo guardamos en un tipo de pago
                    int [] pago=registroVisitas.get(3);//creamos y controlamos el tipo de tarifa, la que nos salga la sumamos en la variable que diga el anterior if
                    if(pago[3]==0){
                        transferencia+=listaTarifas[0];
                    }else{
                        transferencia+=listaTarifas[1];
                    }
                
                }else if((int)registroClientes.get(3).get(5)==1){
                    int [] pago=registroVisitas.get(3);
                    if(pago[3]==0){
                        tarjeta+=listaTarifas[0];
                    }else{
                        tarjeta+=listaTarifas[1];
                    }
                }else{
                    int [] pago=registroVisitas.get(3);
                    if(pago[3]==0){
                        efectivo+=listaTarifas[0];
                    }else{
                        efectivo+=listaTarifas[1];
                    }
                }
            //}
            total=efectivo+tarjeta+transferencia;
            System.out.println("La facturacion es la siguiente: \n"
                        + "Efectivo: "+efectivo+"\n"
                        + "Tarjeta: "+tarjeta+"\n"
                        + "Transferencia: "+transferencia+"\n"
                        + "Total: "+total);
        }
}
