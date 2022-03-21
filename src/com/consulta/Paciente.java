package com.consulta;

import java.time.MonthDay;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;

public class Paciente extends Persona {

	private static int contador = 0;
	protected int idPaciente;
	protected int idEspecialista;
	protected String formaPago;

	public Paciente(Profesional especialista) {
		super();
		this.idPaciente = contador++;
		this.idEspecialista = especialista.idEspecialista;
		this.formaPago = generarFPago();
	}

	public Paciente(int idEspecialista, String fPago) {
		super();
		this.idPaciente = contador++;
		this.idEspecialista = idEspecialista;
		this.formaPago = fPago;
	}

	/**
	 * @return the idPaciente
	 */
	public int getIdPaciente() {
		return idPaciente;
	}

	/**
	 * @return the idEspecialista
	 */
	public int getIdEspecialista() {
		return idEspecialista;
	}

	/**
	 * @param idEspecialista the idEspecialista to set
	 */
	public void setIdEspecialista(int idEspecialista) {
		this.idEspecialista = idEspecialista;
	}

	@Override
	public String toString() {
		return "IdPaciente=" + String.format("%04d", idPaciente) + "\t IdEspecialista=" + idEspecialista + "\t Nombre="
				+ String.format("%-10s", nombre) + "\t Apellidos=" + String.format("%-15s", apellidos)
				+ "\t FNacimiento=" + String.format("%10s", fNacimiento) + "\t Genero=" + genero + "\t DNI=" + dni
				+ "\t Direccion=" + String.format("%-30s", direccion) + "\t Telefono=" + telefono;
	}

	public String toStringIgnorePersonal() {
		return "IdPaciente=" + String.format("%04d", idPaciente) + "\t IdEspecialista=" + idEspecialista;
	}

	public String toStringIgnoreEspecialidad() {
		return "IdPaciente=" + String.format("%04d", idPaciente) + "\t Nombre=" + String.format("%-10s", nombre)
				+ "\t Apellidos=" + String.format("%-15s", apellidos) + "\t FNacimiento="
				+ String.format("%10s", fNacimiento) + "\t Genero=" + genero + "\t DNI=" + dni + "\t Direccion="
				+ String.format("%-30s", direccion) + "\t Telefono=" + telefono;
	}

	public String generarFPago() {
		String[] listaFPago = { "Tarjeta", "Efectivo", "Transferencia" };
		int fPagoRandom = (int) Math.floor((int) (listaFPago.length) * Math.random());
		return listaFPago[fPagoRandom];
	}

	public static void pacientesJovenes(ArrayList<Paciente> registroPacientes, String genero) {
		ArrayList<Paciente> jovenes = new ArrayList<Paciente>();
		for (int i = 0; i < registroPacientes.size(); i++) {
			// Controla si el paciente es mujer u hombre y lo guarda
			if (registroPacientes.get(i).genero.equalsIgnoreCase(genero)) {
				jovenes.add(registroPacientes.get(i));
			}
		}
		// Ordena de joven a mayor y printea los 10 primeros
		Collections.sort(jovenes, Collections.reverseOrder());
		for (int i = 0; i < 10; i++) {
			System.out.println(jovenes.get(i).toStringIgnoreEspecialidad());
		}
	}

	public static void checkNacimiento(ArrayList<Paciente> registroPacientes) {
		MonthDay feb29 = MonthDay.of(2, 29);
		DateTimeFormatter diaMes = DateTimeFormatter.ofPattern("dd/MMMM");
		if (Paciente.numNacimientos(registroPacientes, feb29) > 1) {
			System.out.println("\nHan nacido " + Paciente.numNacimientos(registroPacientes, feb29) + " pacientes el "
					+ diaMes.format(feb29) + "\n");
		} else if (Paciente.numNacimientos(registroPacientes, feb29) == 0) {
			System.out.println("No ha nacido ningun paciente el " + diaMes.format(feb29) + "\n");
		} else {
			System.out.println("\nHa nacido " + Paciente.numNacimientos(registroPacientes, feb29) + " paciente el "
					+ diaMes.format(feb29) + "\n");
		}
		for (int i = 0; i < registroPacientes.size(); i++) {
			// Controla que el año de nacimiento sea bisiesto
			if (registroPacientes.get(i).fNacimiento.isLeapYear()) {
				MonthDay mdFNacimiento = MonthDay.from(registroPacientes.get(i).fNacimiento);
				if (feb29.equals(mdFNacimiento)) {
					System.out.println(registroPacientes.get(i).toStringIgnoreEspecialidad());
				}
			}
		}
	}

	public static int numNacimientos(ArrayList<Paciente> registroPacientes, MonthDay mdFecha) {
		int dias = 0;
		for (int i = 0; i < registroPacientes.size(); i++) {
			MonthDay mdFNacimiento = MonthDay.from(registroPacientes.get(i).fNacimiento);
			if (mdFNacimiento.equals(mdFecha)) {
				dias++;
			}
		}
		return dias;
	}
}