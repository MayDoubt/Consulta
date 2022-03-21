package com.consulta;

import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.GUI.Menu;

public class Consulta {

	// Variables de registro y generales
	static ArrayList<Paciente> registroPacientes = new ArrayList<Paciente>();
	static Profesional[] registroEspecialistas;
	static ArrayList<Visita> registroVisitas = new ArrayList<Visita>();
	static ArrayList<Integer> festivos = new ArrayList<Integer>();
	static LocalDate fechaInicial = LocalDate.of(LocalDate.now().getYear(), Month.JANUARY, 1);

	public static void main(String[] args) {
		// Variables
		int opcion;
		LocalDate fechaFinal = LocalDate.of(LocalDate.now().getYear(), Month.DECEMBER, 31);

		// Variables de generacion
		int numeroEspecialistas = 6;
		int numeroInicialPacientes = 3000;
		int numeroDobleEsp = 4;
		int numeroDiasFijos = 3;

		// Variables de mensajes
		String opcion_Msj = "Seleccione una opción.";
		String salir_Msj = "Gracias por usar el programa.";
		String errorOpcion_Msj = "Esa opción no existe, por favor seleccione una opcion válida.";
		String volver_Msj = "Volviendo atrás";

		// Menu
		Menu starterMenu = new Menu();
		starterMenu.setLocationRelativeTo(null);
		starterMenu.setVisible(true);
		do {
			mostrarMenu();
			opcion = pedirNum(0, 9, opcion_Msj);
			switch (opcion) {
			case 1:// Opcion
				separador();
				generarConsultas(numeroEspecialistas, numeroInicialPacientes, numeroDobleEsp, numeroDiasFijos,
						fechaInicial, fechaFinal);
				separador();
				break;
			case 2:
				separador();
				menu2(opcion_Msj, volver_Msj, errorOpcion_Msj);
				separador();
				break;
			case 3:// Opcion facturacion
				separador();
				imprimirFacturacion(fechaFinal);
				separador();
				break;
			case 4:// Opcion Pacientes más jovenes
				separador();
				menu3(opcion_Msj, volver_Msj, errorOpcion_Msj);
				separador();
				break;
			case 9:// Exit Option
				separador();
				System.out.println(salir_Msj);
				separador();
				break;
			default:// Otra opcion error
				separador();
				System.out.println(errorOpcion_Msj);
				separador();
				break;
			}
		} while (opcion != 9);
	}

	// ==============METODOS==============//

	/* Metodos de interfaz de usuario */
	/* Metodo mostrar menú */
	public static void mostrarMenu() {// Muestra las opciones del menu
		System.out.println("MENU:\n");
		System.out.println("1. Generación de consultas");
		System.out.println("2. Consultar datos");
		System.out.println("3. Imprimir facturación anual");
		System.out.println("4. Imprimir consultas");
		System.out.println("9. Salir \n");
	}

	public static void mostrarMenu2() {// Muestra las opciones del menu
		System.out.println("MENU:\n");
		System.out.println("1. Imprimir visitas");
		System.out.println("2. Imprimir especialistas");
		System.out.println("3. Imprimir clientes");
		System.out.println("9. Volver atrás \n");
	}

	public static void menu2(String opcion_Msj, String volver_Msj, String errorOpcion_Msj) {
		if (!(registroVisitas.size() == 0)) {
			int opcion2;
			do {
				mostrarMenu2();
				opcion2 = pedirNum(0, 9, opcion_Msj);
				switch (opcion2) {
				case 1:// Opcion imprimir visitas
					separador();
					imprimirDatos(registroVisitas, registroEspecialistas);
					numUrgencias();
					separador();
					break;
				case 2:// Opcion imprimir profesionales
					separador();
					imprimirDatos(registroEspecialistas);
					separador();
					break;
				case 3:// Opcion imprimir registro clientes
					separador();
					imprimirDatos(registroPacientes);
					separador();
					break;
				case 9:// Exit Option
					separador();
					System.out.println(volver_Msj);
					separador();
					break;
				default:// Otra opcion error
					separador();
					System.out.println(errorOpcion_Msj);
					separador();
					break;
				}
			} while (opcion2 != 9);
		} else {
			System.out.println(
					"Aun no hay datos de generados. Seleccione la opcion 'Generacion de consultas' del menu antes "
							+ "realizar esta accion.");
		}
	}

	public static void menu3(String opcion_Msj, String volver_Msj, String errorOpcion_Msj) {
		int opcion3;
		if (!(registroVisitas.size() == 0)) {
			do {
				mostrarMenu3();
				opcion3 = pedirNum(0, 9, opcion_Msj);
				switch (opcion3) {
				case 1:// Opcion Pacientes más jovenes
					separador();
					Paciente.checkNacimiento(registroPacientes);
					separador();
					break;
				case 2:// Opcion Pacientes más jovenes
					separador();
					System.out.println("Mujeres:\n");
					Paciente.pacientesJovenes(registroPacientes, "mujer");
					separador();
					System.out.println("Hombres:\n");
					Paciente.pacientesJovenes(registroPacientes, "hombre");
					separador();
					break;
				case 3:// Opcion numero de nacimientos por fecha
					separador();
					maxNacimientos();
					separador();
					break;
				case 9:// Exit Option
					separador();
					System.out.println(volver_Msj);
					separador();
					break;
				default:// Otra opcion error
					separador();
					System.out.println(errorOpcion_Msj);
					separador();
					break;
				}
			} while (opcion3 != 9);
		} else {
			System.out.println(
					"Aun no hay datos de generados. Seleccione la opcion 'Generacion de consultas' del menu antes "
							+ "realizar esta accion.");
		}
	}

	public static void mostrarMenu3() {// Muestra las opciones del menu
		System.out.println("MENU:\n");
		System.out.println("1. Imprimir las personas nacidas un 29 de febrero");
		System.out.println("2. Imprimir las 10 mujeres y hombres mas jovenes");
		System.out.println("3. Imprimir que dias han nacido mas pacientes");
		System.out.println("9. Volver atrás \n");
	}

	public static void separador() {
		System.out.println("\n=======================================================\n");
	}

	@SuppressWarnings("resource")
	public static int pedirNum(int inicio, int fin, String mensaje) {
		int numero = 0;
		Scanner sc;
		sc = new Scanner(System.in);
		do {
			try {
				System.out.print(mensaje + " Introduce un número entre " + (inicio) + " y " + (fin) + ": ");
				numero = sc.nextInt();
			} catch (InputMismatchException | NumberFormatException ex) {
				System.err.println("\nIntroduzca un número no un caracter, por favor.");
				sc.next();
			}
		} while (numero < inicio || numero > fin);
		return numero;
	}

	/* Modulo generarEntidades */
	/* Metodo general de generación de entidades */
	public static void generarConsultas(int numeroEspecialistas, int numeroInicialPacientes, int numeroDobleEsp,
			int numeroDiasFijos, LocalDate fechaInicial, LocalDate fechaFinal) {

		generarFestivos();
		generarEntidades(numeroEspecialistas, numeroDobleEsp, numeroDiasFijos);
		registroInicial(numeroInicialPacientes);
		generarAgenda(fechaFinal);
		System.out.println("Se han generado las consultas correctamente.");

	}

	/* Metodo de generación de periodos de consulta */
	private static void generarAgenda(LocalDate fechaFinal) {
		int periodoConsultas = generarFecha(fechaInicial, fechaFinal) + 1;
		for (int dia = 0; dia < periodoConsultas; dia++) {
			generarDia(dia);
		}
	}

	/* Metodo de generación de dias particulares */
	public static void generarDia(int fecha) {
		if (!festivos.contains(fecha)) {
			for (int i = 0; i < registroEspecialistas.length; i++) {
				if (!registroEspecialistas[i].esDiaLibre(fechaInicial, fecha)) {
					generarVisitas(registroEspecialistas[i], fecha);
				}
			}
		}
	}

	/* Metodo de generación de visitas */
	private static void generarVisitas(Profesional profesional, int fecha) {
		// random para las visitas de ese dia y ese especialista
		int nVisitas = (int) (Math.floor(6 * Math.random()) + 10);
		for (int i = 0; i < nVisitas; i++) {
			// Random para coger clientes al azar y registrarlos si es necesario
			boolean randomRegistro = ((int) Math.floor((int) 201 * Math.random()) == 0) ? true : false;
			if (randomRegistro) {
				int idCliente = registroPaciente(profesional);
				registroVisita(idCliente, registroPacientes.get(idCliente), profesional, fecha);
			} else {
				int randomCliente;
				randomCliente = (int) Math.floor((int) (registroPacientes.size()) * Math.random());
				registroVisita(registroPacientes.get(randomCliente).idPaciente, registroPacientes.get(randomCliente),
						profesional, fecha);
			}
		}
	}

	/* Metodo de generación de especialistas */
	private static void generarEntidades(int numeroEntidades, int numeroDobleEsp, int numeroDiasFijos) {
		registroEspecialistas = new Profesional[numeroEntidades];
		Profesional[] listaEspecialistas = new Profesional[numeroEntidades];
		int randomDia;
		for (int i = 0; i < numeroEntidades; i++) {
			if (i < numeroDobleEsp) {
				randomDia = (int) Math.floor(5 * Math.random());
				Profesional especialista = new Profesional(randomDia, 2);
				listaEspecialistas[i] = especialista;
			} else {
				randomDia = (int) Math.floor(5 * Math.random());
				Profesional especialista = new Profesional(randomDia, 1);
				listaEspecialistas[i] = especialista;
			}
		}
		listaEspecialistas[0].setDiaLibre(4);
		listaEspecialistas[2].setDiaLibre(4);
		listaEspecialistas[5].setDiaLibre(4);
		registroEspecialistas = listaEspecialistas;
	}

	/* Metodo de generación de festivos */
	private static void generarFestivos() {
		LocalDate anioNuevo = LocalDate.of(LocalDate.now().getYear(), 1, 1);
		LocalDate dAndalucia = LocalDate.of(LocalDate.now().getYear(), 2, 28);
		LocalDate dTrabajador = LocalDate.of(LocalDate.now().getYear(), 5, 1);
		LocalDate Agosto15 = LocalDate.of(LocalDate.now().getYear(), 8, 15);
		LocalDate Oct12 = LocalDate.of(LocalDate.now().getYear(), 10, 12);
		LocalDate santos = LocalDate.of(LocalDate.now().getYear(), 11, 1);
		LocalDate independencia = LocalDate.of(LocalDate.now().getYear(), 12, 6);
		LocalDate navidad = LocalDate.of(LocalDate.now().getYear(), 12, 25);
		LocalDate[] fechasFestivos = { anioNuevo, dAndalucia, dTrabajador, Agosto15, Oct12, santos, independencia,
				independencia.plusDays(2), navidad };
		for (int i = 0; i < fechasFestivos.length; i++) {
			festivos.add(generarFecha(fechaInicial, fechasFestivos[i]));
		}
	}

	/* Metodo de generación de un entero de la diferencia entre dias */
	private static int generarFecha(LocalDate fechaInicial, LocalDate fecha) {
		int newFecha = (int) ChronoUnit.DAYS.between(fechaInicial, fecha);
		return newFecha;
	}

	/* Metodo de generación de una fecha del entero de la posicion */
	private static LocalDate generarFecha(LocalDate fechaInicial, int fecha) {
		return fechaInicial.plusDays(fecha);
	}

	/* Modulo de registro */
	private static void registroInicial(int numeroInicialPacientes) {
		for (int i = 0; i < numeroInicialPacientes; i++) {
			int randomEspecialista = (int) Math.floor((int) registroEspecialistas.length * Math.random());
			registroPaciente(registroEspecialistas[randomEspecialista]);
		}
	}

	/* Metodo de registro de pacientes */
	private static int registroPaciente(Profesional especialista) {
		Paciente registroCliente = new Paciente(especialista);
		registroPacientes.add(registroCliente);
		return registroCliente.idPaciente;
	}

	/* Metodo de registro de Visita */
	private static void registroVisita(int idCliente, Paciente paciente, Profesional especialista, int fecha) {
		LocalDate fechaVisita = generarFecha(fechaInicial, fecha);
		int randomEsp = ((int) Math.floor((int) especialista.especialidades.length * Math.random()));
		Visita visita = new Visita(paciente, especialista, randomEsp, fechaVisita);
		registroVisitas.add(visita);
	}

	/* Modulo de impresion de Datos */
	/* Metodo de impresion de Visitas */
	public static void imprimirDatos(ArrayList<Visita> registroVisitas, Profesional[] registroEspecialistas) {
		if (!(registroVisitas.size() == 0)) {
			for (int i = 0; i < registroVisitas.size(); i++) {
				System.out.printf("Visita:%05d\t", i);
				System.out.printf(registroVisitas.get(i).toString(registroEspecialistas) + "\n");
			}
		} else {
			System.out.println("El registro de visitas está vacío.");
		}
	}

	/* Metodo de impresion de Especialistas */
	private static void imprimirDatos(Profesional[] registroEspecialistas) {
		if (!(registroEspecialistas.length == 0)) {
			for (int i = 0; i < registroEspecialistas.length; i++) {
				System.out.println(registroEspecialistas[i].toString());
			}
		} else {
			System.out.println("El registro de especialistas está vacío.");
		}
	}

	/* Metodo de impresion de Pacientes */
	private static void imprimirDatos(ArrayList<Paciente> registroPacientes) {
		if (!(registroPacientes.size() == 0)) {
			for (int i = 0; i < registroPacientes.size(); i++) {
				System.out.println(registroPacientes.get(i).toString());
			}
		} else {
			System.out.println("El registro de especialistas está vacío.");
		}
	}

	/* Metodo de impresion de datos generales */
	@SuppressWarnings("unused")
	private static void imprimirDatos(ArrayList<Integer> lista, int tamaño) {
		if (!(lista.size() == 0)) {
			if (tamaño != 0 && lista.size() > tamaño) {
				for (int i = 0; i < tamaño; i++) {
					System.out.println(lista.get(i).toString());
				}
			} else {
				for (int i = 0; i < lista.size(); i++) {
					System.out.println(lista.get(i).toString());
				}
			}
		} else {
			System.out.println("La lista está vacía.");
		}
	}

	/* Metodo de impresion de fechas */
	private static void imprimirDatos(ArrayList<MonthDay> lista, ArrayList<Integer> indexOfAll, String masMenos,
			int maxMin) {
		if (!(lista.size() == 0 || indexOfAll.size() == 0)) {
			String fechas = "";
			DateTimeFormatter shortFormat = DateTimeFormatter.ofPattern("dd/MMMM");
			for (int i = 0; i < indexOfAll.size(); i++) {
				fechas += "el " + lista.get((int) indexOfAll.get(i)).format(shortFormat) + ", ";
			}
			System.out.println("Los días que " + masMenos + " nacimientos ha habido son " + fechas + " con " + maxMin
					+ " pacientes.");
		} else {
			System.out.println("No existen correspondencias.");
		}

	}

	/* Metodo de impresion de Facturacion por periodos */
	private static void imprimirFacturacion(LocalDate fechaFinal) {
		if (!(registroVisitas.size() == 0)) {
			DateTimeFormatter shortFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			double efectivo = 0;
			double tarjeta = 0;
			double transferencia = 0;
			for (int i = 0; i < registroVisitas.size(); i++) {
				int idCliente = registroVisitas.get(i).idPaciente;
				if (registroPacientes.get(idCliente).formaPago.equalsIgnoreCase("efectivo")) {
					efectivo += sumTarifa(registroVisitas.get(i));
				} else if (registroPacientes.get(idCliente).formaPago.equalsIgnoreCase("tarjeta")) {
					tarjeta += sumTarifa(registroVisitas.get(i));
				} else {
					transferencia += sumTarifa(registroVisitas.get(i));
				}
			}
			System.out.println("FACTURACION:\t" + String.format("%-10s",
					"(Periodo " + fechaInicial.format(shortFormat) + " - " + fechaFinal.format(shortFormat) + ")"));
			separador();
			System.out.println(String.format("%-44s", "Efectivo:") + String.format("%,.2f", efectivo) + "€");
			System.out.println(String.format("%-44s", "Tarjeta:") + String.format("%,.2f", tarjeta) + "€");
			System.out.println(String.format("%-44s", "Transferencia:") + String.format("%,.2f", transferencia) + "€");
			separador();
			System.out.println(String.format("%-44s", "TOTAL:")
					+ String.format("%,.2f", efectivo + tarjeta + transferencia) + "€");
		} else {
			System.out.println(
					"Aun no hay datos de generados. Seleccione la opcion 'Generacion de consultas' del menu antes "
							+ "realizar esta accion.");
		}
	}

	/* Metodo de sumatorio de ingresos */
	public static double sumTarifa(Visita registroVisita) {
		double cobroUrgencia = 1.20;
		double sumTarifa = 0;
		if (!(registroVisita.urgencia.equalsIgnoreCase("si"))) {
			sumTarifa += registroVisita.tarifa;
		} else {
			sumTarifa += (registroVisita.tarifa) * cobroUrgencia;
		}
		return sumTarifa;
	}

	/* Metodo de sumatorio de urgencias */
	public static void numUrgencias() {
		int cont = 0;
		for (int i = 0; i < registroVisitas.size(); i++) {
			if (registroVisitas.get(i).urgencia.equalsIgnoreCase("si")) {
				cont++;
			}
		}
		System.out.println("\nNúmero de consultas de urgencias: " + cont + "\n");
	}

	/* Metodo de sumatorio de nacimientos por dia del año */
	public static void maxNacimientos() {
		ArrayList<MonthDay> fechasDeNacimiento = new ArrayList<MonthDay>();
		ArrayList<Integer> contadores = new ArrayList<Integer>();
		int max = 0;
		int min = 1;
		for (int i = 0; i < registroPacientes.size(); i++) {
			MonthDay mdFNacimiento = MonthDay.from(registroPacientes.get(i).fNacimiento);
			if (!fechasDeNacimiento.contains(mdFNacimiento)) {
				fechasDeNacimiento.add(mdFNacimiento);
				contadores.add(1);
			} else {
				int index = fechasDeNacimiento.indexOf(mdFNacimiento);
				contadores.set(index, contadores.get(index) + 1);
			}
		}
		min = Collections.min(contadores);
		max = Collections.max(contadores);
		imprimirDatos(fechasDeNacimiento, indexOfAll(max, contadores), "más", max);
		imprimirDatos(fechasDeNacimiento, indexOfAll(min, contadores), "menos", min);

	}
	/* Metodo de extraccion de todos los index de una correspondencia */
	public static ArrayList<Integer> indexOfAll(int objToCompare, ArrayList<Integer> contadores) {

		ArrayList<Integer> indexLista = new ArrayList<Integer>();
		Integer obj = objToCompare;
		for (int i = 0; i < contadores.size(); i++) {
			if (obj.equals(contadores.get(i))) {
				indexLista.add(i);
			}
		}
		return indexLista;
	}
}