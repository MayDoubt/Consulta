package _CONSULTA;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Consultita {

	public static void main(String[] args) {
		
		// Variables
		int opcion;
		Locale espanolLocale = new Locale("es", "ES");
		LocalDate fechaInicial = LocalDate.of(LocalDate.now().getYear(),Month.MARCH,1);
		
		//Variables de generacion	
		int numeroEspecialistas = 3;
		String [] listaEspecialidad = {"Homeopatia","Quiropraxia"};
		String [] listaMetodoPago = {"Transferencia","Tarjeta","Efectivo"};
		double [] listaTarifas = {60.00,65.50};
		ArrayList <String> listaDni = new ArrayList <String>();
		ArrayList <String[]> listaClientes = new ArrayList <String[]>(); //
		
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
					generarEntidades(listaClientes, listaDni,10);
                                        generarEspecialistas(registroEspecialistas, listaEspecialidad, 3);
                                        imprimirPrueba(listaClientes);
                                        System.out.println("");
                                        imprimirEsp(registroEspecialistas);
					separador();
					break;
				case 2://Opcion
					separador();
					generarAgenda(fechaInicial,registroEspecialistas,listaEspecialidad, listaClientes, registroClientes,registroVisitas,listaMetodoPago,listaTarifas);
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
	
	/*Metodos de interfaz de usuario*/
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
	
	/*Modulo generarEntidades*/
	public static void generarEntidades(ArrayList <String[]> listaClientes, ArrayList <String> listaDni,int nEntidades) {
		
		String [] listaNombres = {"Rishbha","Handel","Milind","Pulkita","Yesus","Mell","Trent","Kalantha","Upravda","Stacy","Kalantha","Lincoln","Ernest","Stamford","Pryderi","Pablo","Fernando","Grace","Jaun","Nesim","Lilah","Mayrah","Madelyn","Barlow","Ilka","Beryl","Onora","Edeline","Stratton","Beryl"};
		String [] listaApellidos = {"Gladstone","Weeden","Sylvia","Utter","Lebron","Vicente","Weigand","Nelson","Lewallen","Brew","Mccombs","Rhee","William","Vierra","Kegley","Shears","Dann","Sparkle","Habib","Adcock","Sundberg","Elia","Hickok","Huertas", "Hodnett","Higgins","Klos","Junker","Enright"};
		generarDni(nEntidades, listaDni);
		for (int i=0; i<nEntidades; i++) {
			
			int randomDni = (int)Math.floor((int)(listaDni.size())*Math.random());
			int randomNom = (int)Math.floor((int)(listaNombres.length)*Math.random());
			int randomApe = (int)Math.floor((int)(listaApellidos.length)*Math.random());
			int randomApe2 = (int)Math.floor((int)(listaApellidos.length)*Math.random());
			String [] cliente = {listaDni.remove(randomDni),listaNombres[randomNom],listaApellidos[randomApe]+" "+listaApellidos[randomApe2]}; 
	
			listaClientes.add(cliente);
		}
	}
	public static void generarEspecialistas(ArrayList [] registroEspecialistas, String [] listaEspecialidad, int nEntidades) { //ToDo --Hacer que uno de ellos tenga dos especialidades y no se repitan.
            String [] listaNombres = {"Rishbha","Handel","Milind","Pulkita","Yesus","Mell","Trent","Kalantha","Upravda","Stacy","Kalantha","Lincoln","Ernest","Stamford","Pryderi","Pablo","Fernando","Grace","Jaun","Nesim","Lilah","Mayrah","Madelyn","Barlow","Ilka","Beryl","Onora","Edeline","Stratton","Beryl"};
            String [] listaApellidos = {"Gladstone","Weeden","Sylvia","Utter","Lebron","Vicente","Weigand","Nelson","Lewallen","Brew","Mccombs","Rhee","William","Vierra","Kegley","Shears","Dann","Sparkle","Habib","Adcock","Sundberg","Elia","Hickok","Huertas", "Hodnett","Higgins","Klos","Junker","Enright"};
            String [] dias = {"lunes","martes","miercoles","jueves","viernes"};

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
	
	/*Modulo generarAgenda*/
	public static void generarAgenda(LocalDate fechaInicial,ArrayList [] registroEspecialistas,String [] listaEspecialidad, ArrayList <String[]> listaClientes, ArrayList <ArrayList> registroClientes,ArrayList <int []> registroVisitas,String [] listaMetodoPago,double [] listaTarifas) {	//ToDo
	//para cada cliente,sacar con enteros el dia,especialista,especialidad,precio,cobro y urgencia	
                    for(int i=0;i<1;i++){//for para los 61 dias
                        generarVisitas(fechaInicial,registroEspecialistas,listaEspecialidad, listaClientes, registroClientes,registroVisitas,listaMetodoPago,listaTarifas);
                    }
        }
	public static void generarDia(){ //ToDo
		
	}
	public static void diaLibre() {	//ToDo
		
	}
	
	/*Modulo generarVisitas*/
	public static void generarVisitas(LocalDate fechaInicial,ArrayList [] registroEspecialistas,String [] listaEspecialidad, ArrayList <String[]> listaClientes, ArrayList <ArrayList> registroClientes,ArrayList <int []> registroVisitas,String [] listaMetodoPago,double [] listaTarifas) { //ToDo
            int n=(int)(Math.floor((15-10)*Math.random())+10);//random para ver cuantas visitas hay ese dia
                for(int i=0;i<n;i++){
                    int randomCli = (int)Math.floor((int)(listaClientes.size())*Math.random());//random para coger clientes al azar y registrarlos si es necesario
                    if(!registroClientes.contains(listaClientes.get(randomCli))){
                        registroClientes(fechaInicial,registroEspecialistas,listaEspecialidad, listaClientes, registroClientes,listaMetodoPago,listaTarifas,randomCli);
                        int pos=registroClientes.size();
                        registroVisita(registroClientes.get(pos),registroVisitas);
                    }else{
                        registroVisita(registroClientes.get(randomCli),registroVisitas);
                    }
                }
        }
	public static void registroClientes(LocalDate fechaInicial,ArrayList [] registroEspecialistas,String [] listaEspecialidad, ArrayList <String[]> listaClientes, ArrayList <ArrayList> registroClientes,String [] listaMetodoPago,double [] listaTarifas,int nCliente) { //ToDo
            
                        ArrayList cliente=new ArrayList();
                        for(int j=0; j<listaClientes.get(nCliente).length; j++) {
                            cliente.add(listaClientes.get(nCliente)[j]);
                        }
                        int randomEspecialidad = (int)Math.floor((int)(listaEspecialidad.length)*Math.random());//random para añadir la especialidad
                        int randomEsp = (int)Math.floor((int)(registroEspecialistas.length)*Math.random());//random para añadir especialista le atiende
                        int randomMP = (int)Math.floor((int)(listaMetodoPago.length)*Math.random());//random para añadir metodo de pago
                        int randomTar= (int)Math.floor((int)(listaTarifas.length)*Math.random());//random para añadir tarifa
                        cliente.add(randomEsp);
                        cliente.add(randomEspecialidad);
                        cliente.add(randomMP);
                        cliente.add(randomTar);
                        registroClientes=new ArrayList<>();
                        registroClientes=cliente;
                        System.out.println(registroClientes);
	}
	public static void registroVisita(ArrayList <Integer> registroClientes,ArrayList <int []> registroVisitas) { //ToDo
            System.out.println("");
            for(Integer i:registroClientes){
            int [] visita = new int [6];
            for(int j=0; j<visita.length;j++){
                if (j==0){
                    visita[j]=j;
                }
                visita[j]=registroClientes;
            }
            System.out.println(visita);
            }
           
            
	}
	
	/*Modulo de consultaDatos*/
	public static void imprimirPrueba(ArrayList <String[]> listaClientes) {
		for(String i [] : listaClientes) {
			System.out.println(Arrays.toString(i));
		}
        }
        public static void imprimirEsp(ArrayList [] registroEspecialistas) {
		for(int i=0;i<registroEspecialistas.length;i++) {
                    for(int j=0;j<registroEspecialistas[i].size();j++){
			System.out.print(registroEspecialistas[i].get(j)+",");
                    }
                    System.out.println("");
                }
	} 
        //Metodo para testeo de clientes.
	public static void imprimirVisitas(ArrayList <int []> registroVisitas) {  //ToDo
		//Habría que crear un método ya mostrando valores formateados y que se entiendan no con enteros.Para todas las visitas
	}
}
