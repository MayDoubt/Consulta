package _CONSULTA;

import java.util.Objects;

public class Profesional extends Persona {
	
	private static int contador = 0;
	protected int idEspecialista;
	protected String[] especialidades;
	protected int diaLibre;
	
	public Profesional(int nEspecialidades) {
		super();
		this.idEspecialista=contador++;
		this.especialidades=generarEspecialidad(super.listaEspecialidades, nEspecialidades);
		this.diaLibre=generarDiaLibre();
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

	@Override
	public String toString() {
		String [] diasLibres= {"Lunes","Martes","Miercoles","Jueves","Viernes"};
		if(especialidades.length==1) {
			return "Profesional: IdEspecialista=" + idEspecialista + "\t Nombre=" +String.format("%-15s",this.nombre)+ "\t Especialidad=" 
					+ String.format("%-20s",especialidades[0]) + "\t DiaLibre="+ diasLibres[diaLibre];
		}else {
			return "Profesional: IdEspecialista=" + idEspecialista + "\t Nombre=" +String.format("%-15s",this.nombre)+ "\t Especialidad=" 
					+ especialidades[0] +" y "+ especialidades[1] + "\t DiaLibre="+ diasLibres[diaLibre];
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

	public String[] generarEspecialidad(String[] listaEspecialidades, int nEspecialidades) {
		if(nEspecialidades==2) {
			return listaEspecialidades;
		}else {
			String[] Special = new String[1];
			int Especialidad = (int)Math.floor((int)(listaEspecialidades.length)*Math.random());
			Special[0] = listaEspecialidades[Especialidad];
			return Special;
		}
	}
	/*Este metodo está por si se quiere randomizar los dias libres de cada especialista*/
	public int generarDiaLibre() {
		int Dia = 4;
		return Dia;
	}
	
}