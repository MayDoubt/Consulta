package _CONSULTA;

import java.util.Objects;

public class Paciente extends Persona {
	
	protected static int id;
	protected int idPaciente;
	protected int idEspecialista;
	protected String especialidad;
	protected String formaPago;
	
	/**
	 * 
	 */
	public Paciente(int idEspecialista, String especialidad) {
		super();
		this.idPaciente+=1;
		this.idEspecialista=idEspecialista;
		this.especialidad=especialidad;
		this.formaPago=generarFPago();
		
	}

	/**
	 * @return the id
	 */
	public static int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public static void setId(int id) {
		Paciente.id = id;
	}

	/**
	 * @return the idPaciente
	 */
	public int getIdPaciente() {
		return idPaciente;
	}

	/**
	 * @param idPaciente the idPaciente to set
	 */
	public void setIdPaciente(int idPaciente) {
		this.idPaciente = idPaciente;
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
		return "idPaciente=" + idPaciente + ", idEspecialista=" + idEspecialista + ", especialidad="
				+ especialidad + ", nombre=" + nombre + ", apellidos=" + apellidos + ", fNacimiento=" + fNacimiento
				+ ", genero=" + genero + ", dni=" + dni + ", direccion=" + direccion + ", telefono=" + telefono + "]";
	}

	public String toStringIgnorePersonal() {
		return "idPaciente=" + idPaciente + ", idEspecialista=" + idEspecialista + ", especialidad="
				+ especialidad + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(idPaciente);
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
		Paciente other = (Paciente) obj;
		return idPaciente == other.idPaciente;
	}
	
	public String generarFPago() {
		String [] listaFPago = {"Tarjeta","Efectivo","Transferencia"};
		int fPagoRandom= (int)Math.floor((int)(listaFPago.length)*Math.random());
		return listaFPago[fPagoRandom];
	}
		
}
