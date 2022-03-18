package _CONSULTA;

import java.util.ArrayList;
import java.util.Collections;

public class Paciente extends Persona {

	private static int contador = 0;
	protected int idPaciente;
	protected int idEspecialista;
	protected String especialidad;
	protected String formaPago;

	/**
	 * 
	 */
	public Paciente(int idEspecialista, String especialidad) {
		super();
		this.idPaciente = contador++;
		this.idEspecialista = idEspecialista;
		this.especialidad = especialidad;
		this.formaPago = generarFPago();

	}
	//TODO Retocar atributos y generacion
	public Paciente(Persona persona, int idEspecialista, String especialidad) {
		super(persona);
		this.idPaciente = contador++;
		this.idEspecialista = idEspecialista;
		this.especialidad = especialidad;
		this.formaPago = generarFPago();
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

	/**
	 * @return the especialidad
	 */
	public String getEspecialidad() {
		return especialidad;
	}

	/**
	 * @param especialidad the especialidad to set
	 */
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	@Override
	public String toString() {
		return "IdPaciente=" + idPaciente + "\t IdEspecialista=" + idEspecialista + "\t Especialidad=" + especialidad
				+ "\t Nombre=" + String.format("%-10s", nombre) + "\t Apellidos=" + String.format("%-15s", apellidos)
				+ "\t FNacimiento=" + String.format("%-10s", fNacimiento) + "\t Genero=" + genero + "\t DNI=" + dni
				+ "\t Direccion=" + String.format("%-30s", direccion) + "\t Telefono=" + telefono;
	}

	public String toStringIgnorePersonal() {
		return "IdPaciente=" + String.format("%04d", idPaciente) + "\t IdEspecialista=" + idEspecialista
				+ "\t Especialidad=" + especialidad;
	}

	public String toStringIgnoreEspecialidad() {
		return "IdPaciente=" + String.format("%04d", idPaciente) + "\t Nombre=" + String.format("%-10s", nombre)
				+ "\t Apellidos=" + String.format("%-15s", apellidos) + "\t FNacimiento="
				+ String.format("%-10s", fNacimiento) + "\t Genero=" + genero + "\t DNI=" + dni + "\t Direccion="
				+ String.format("%-30s", direccion) + "\t Telefono=" + telefono;
	}

	public String generarFPago() {
		String[] listaFPago = { "Tarjeta", "Efectivo", "Transferencia" };
		int fPagoRandom = (int) Math.floor((int) (listaFPago.length) * Math.random());
		return listaFPago[fPagoRandom];
	}

	public static void pacientesJovenes(ArrayList<Paciente> registroPacientes, String genero) { //TODO repensar
		ArrayList<Paciente> jovenes = new ArrayList<Paciente>();
		for (int i = 0; i < registroPacientes.size(); i++) {
			// Controla si el paciente es mujer/hombre y lo guarda
			if (registroPacientes.get(i).genero.equalsIgnoreCase(genero)) {
				jovenes.add(registroPacientes.get(i));
			}
		}
		printTop(jovenes, 10);
	}


}