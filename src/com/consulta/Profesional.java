package com.consulta;

import java.time.LocalDate;
import java.util.Objects;

public class Profesional extends Persona {

	private static int contador = 0;
	protected int idEspecialista;
	protected String[] especialidades;
	protected int diaLibre;
	protected String[] listaEspecialidades = { "Homeopatia", "Quiropraxia" };
	protected double[] listaTarifas = { 60.00, 65.25 };

	public Profesional(int diaLibre, int nEspecialidades) {
		super();
		this.idEspecialista = contador++;
		this.especialidades = generarEspecialidad(nEspecialidades);
		this.diaLibre = diaLibre;
	}

	public Profesional(int diaLibre, String... especialidad) {
		super();
		this.idEspecialista = contador++;
		for (String e : especialidad) {
			for (int i = 0; i < especialidad.length; i++) {
				this.especialidades[i] = e;
			}
		}
		this.diaLibre = diaLibre;
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
	 * @return the especialidades
	 */
	public String[] getEspecialidades() {
		return especialidades;
	}

	/**
	 * @param especialidades the especialidades to set
	 */
	public void setEspecialidades(String[] especialidades) {
		this.especialidades = especialidades;
	}

	/**
	 * @return the diaLibre
	 */
	public int getDiaLibre() {
		return diaLibre;
	}

	/**
	 * @param diaLibre the diaLibre to set
	 */
	public void setDiaLibre(int diaLibre) {
		this.diaLibre = diaLibre;
	}

	/**
	 * @return the listaEspecialidades
	 */
	public String[] getListaEspecialidades() {
		return listaEspecialidades;
	}

	/**
	 * @return the listaTarifas
	 */
	public double getListaTarifas(int especialidad) {
		return listaTarifas[especialidad];
	}

	@Override
	public String toString() {
		String[] dias = { "Lunes", "Martes", "Miercoles", "Jueves", "Viernes" };
		if (especialidades.length == 1) {
			return "Profesional: IdEspecialista=" + idEspecialista + "\t Nombre=" + String.format("%-10s", this.nombre)
					+ "\t Especialidad=" + String.format("%-20s", especialidades[0]) + "\t DiaLibre=" + dias[diaLibre];
		} else {
			return "Profesional: IdEspecialista=" + idEspecialista + "\t Nombre=" + String.format("%-10s", this.nombre)
					+ "\t Especialidad=" + especialidades[0] + " y " + especialidades[1] + "\t DiaLibre="
					+ dias[diaLibre];
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(idEspecialista);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profesional other = (Profesional) obj;
		return idEspecialista == other.idEspecialista;
	}

	public String[] generarEspecialidad(int nEspecialidades) {
		if (nEspecialidades == 2) {
			return listaEspecialidades;
		} else {
			String[] Special = new String[1];
			int Especialidad = (int) Math.floor((int) (listaEspecialidades.length) * Math.random());
			Special[0] = listaEspecialidades[Especialidad];
			return Special;
		}
	}

	/* Metodo de comprobación de dia festivo o libre */
	public boolean esDiaLibre(LocalDate fechaInicial, int fecha) {
		LocalDate dia = fechaInicial.plusDays(fecha);
		int diaSem = dia.getDayOfWeek().ordinal();
		if (this.diaLibre == diaSem || diaSem > 4) {
			return true;
		} else {
			return false;
		}
	}

}