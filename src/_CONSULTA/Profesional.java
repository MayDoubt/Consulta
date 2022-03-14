package _CONSULTA;

import java.util.Objects;

public class Profesional extends Persona {
	
	protected static int id;
	protected int idEspecialista;
	protected String[] especialidades;
	protected int diaLibre;
	
	public Profesional(int nEspecialidades) {
		super();
		this.idEspecialista+=1;
		this.especialidades=generarEspecialidad(super.listaEspecialidades, nEspecialidades);
		this.diaLibre=generarDiaLibre();
	}
	
	public static int getId() {
		return id;
	}

	public static void setId(int id) {
		Profesional.id = id;
	}

	public int getIdEspecialista() {
		return idEspecialista;
	}

	public void setIdEspecialista(int idEspecialista) {
		this.idEspecialista = idEspecialista;
	}

	public String[] getEspecialidad() {
		return especialidades;
	}

	public void setEspecialidad(String [] especialidades) {
		this.especialidades = especialidades;
	}

	public int getDiaLibre() {
		return diaLibre;
	}

	public void setDiaLibre(int diaLibre) {
		this.diaLibre = diaLibre;
	}

	@Override
	public String toString() {
		String [] diasLibres= {"Lunes","Martes","Miercoles","Jueves","Viernes"};
		if(especialidades.length==1) {
			return "Profesional [idespecialista=" + idEspecialista + ", especialidad=" + especialidades[0] + ", diaLibre="
				+ diasLibres[diaLibre] + "]";
		}else {
			return "Profesional [idespecialista=" + idEspecialista + ", especialidad=" + especialidades[0] +","
					+ especialidades[1] +", diaLibre="+ diasLibres[diaLibre] + "]";
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

	public int generarDiaLibre() {
		
		String [] diasLibres= {"Lunes","Martes","Miercoles","Jueves","Viernes"};
		int Dia = (int)Math.floor((int)(diasLibres.length)*Math.random());
		
		return Dia;
	}
	
}
