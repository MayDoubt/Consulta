package com.consulta;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Visita {

	protected double tarifa;
	protected String urgencia;
	protected int idEspecialista;
	protected String especialidad;
	protected int idPaciente;
	protected LocalDate fecha;
	protected String formaPago;
	private int probUrgencia = 48;// Para cambiar la probabilidad de urgencia

	public Visita(Paciente paciente, Profesional especialista, int especialidad, LocalDate fecha) {

		this.fecha = fecha;
		this.idEspecialista = especialista.idEspecialista;
		this.especialidad = especialista.especialidades[especialidad];
		this.idPaciente = paciente.idPaciente;
		this.tarifa = especialista.getListaTarifas(especialidad);
		this.formaPago = paciente.formaPago;
		this.urgencia = generarUrgencia();
	}

	public String toString(Profesional[] registroEspecialistas) {
		DateTimeFormatter shortFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		if (urgencia.equals("Si")) {
			return "Tarifa=" + String.format("%.2f", tarifa) + " €\t Urgencia=" + urgencia + "\t IdEspecialista="
					+ idEspecialista + "\t NombreEsp="+ String.format("%-10s", registroEspecialistas[idEspecialista].nombre) 
					+ "\t Especialidad="+ especialidad + "\t IdPaciente=" + String.format("%04d", idPaciente) + "\t Fecha="
					+ fecha.format(shortFormat) + "\t FormaPago=" + formaPago;
		} else {
			return "Tarifa=" + String.format("%.2f", tarifa) + " €\t Urgencia=" + urgencia + "\t IdEspecialista="
					+ idEspecialista + "\t NombreEsp="+ String.format("%-10s", registroEspecialistas[idEspecialista].nombre) 
					+ "\t Especialidad="+ especialidad + "\t IdPaciente=" + String.format("%04d", idPaciente) + "\t Fecha="
					+ fecha.format(shortFormat) + "\t FormaPago=" + formaPago;
		}
	}

	public String generarUrgencia() {
		String[] urgencias = { "Si", "No" };
		int RandomUrgencia = (int) Math.floor((int) this.probUrgencia * Math.random());
		return urgencias[(RandomUrgencia != 0) ? 1 : 0];
	}
}