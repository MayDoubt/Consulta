package _CONSULTA;

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
		this.idPaciente=contador++;
		this.idEspecialista=idEspecialista;
		this.especialidad=especialidad;
		this.formaPago=generarFPago();
		
	}

	public Paciente(Persona persona, int idEspecialista, String especialidad) {
		super(persona);
		this.idPaciente=contador++;
		this.idEspecialista=idEspecialista;
		this.especialidad=especialidad;
		this.formaPago=generarFPago();
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
		return "idPaciente=" + idPaciente + ", idEspecialista=" + idEspecialista + ", especialidad="
				+ especialidad + ", nombre=" + nombre + ", apellidos=" + apellidos + ", fNacimiento=" + fNacimiento
				+ ", genero=" + genero + ", dni=" + dni + ", direccion=" + direccion + ", telefono=" + telefono + "]";
	}

	public String toStringIgnorePersonal() {
		return "idPaciente=" + idPaciente + ", idEspecialista=" + idEspecialista + ", especialidad="
				+ especialidad + "]";
	}

	public String generarFPago() {
		String [] listaFPago = {"Tarjeta","Efectivo","Transferencia"};
		int fPagoRandom= (int)Math.floor((int)(listaFPago.length)*Math.random());
		return listaFPago[fPagoRandom];
	}
		
}
