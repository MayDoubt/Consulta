package _CONSULTA;

import java.util.Objects;

public class Profesionales extends Persona {
	
	protected int idespecialista;
	protected String especialidad;
	protected int diasTrabajo;
	
	public Profesionales(String especialidad, int diasTrabajo) {
		super();
		this.idespecialista+=1;
		this.especialidad=especialidad;
		this.diasTrabajo=diasTrabajo;
	}
	
	public int getIdespecialista() {
		return idespecialista;
	}

	public void setIdespecialista(int idespecialista) {
		this.idespecialista = idespecialista;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public int getDiasTrabajo() {
		return diasTrabajo;
	}

	public void setDiasTrabajo(int diasTrabajo) {
		this.diasTrabajo = diasTrabajo;
	}

	@Override
	public String toString() {
		return "Profesionales [idespecialista=" + idespecialista + ", especialidad=" + especialidad + ", diasTrabajo="
				+ diasTrabajo + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(diasTrabajo, especialidad, idespecialista);
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
		Profesionales other = (Profesionales) obj;
		return diasTrabajo == other.diasTrabajo && Objects.equals(especialidad, other.especialidad)
				&& idespecialista == other.idespecialista;
	}

	
	
}
