package _CONSULTA;

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
	protected double [] listaTarifas = {60.00,65.25};
	private int probUrgencia=48;//Para cambiar la probabilidad de urgencia.
	
	public Visita(Paciente paciente, LocalDate fecha) {
		
		this.fecha=fecha;
		this.idEspecialista=paciente.idEspecialista;
		this.especialidad=paciente.especialidad;
		this.idPaciente=paciente.idPaciente;
		this.tarifa=generarTarifa((this.especialidad.equalsIgnoreCase(paciente.listaEspecialidades[0]))?0:1);
		this.formaPago=paciente.formaPago;
		this.urgencia=generarUrgencia();
	}

	@Override
	public String toString() {
		DateTimeFormatter shortFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return "tarifa=" + tarifa + "€,\t urgencia=" + urgencia + ",\t idEspecialista=" + idEspecialista
				+ ",\t especialidad=" + especialidad + ",\t idPaciente=" + idPaciente + ",\t fecha=" + fecha.format(shortFormat) + ", formaPago="
				+ formaPago + "]";
	}

	public double generarTarifa(int indice) {
		return listaTarifas[indice];
	}
	
    public String generarUrgencia(){
		String [] urgencias = {"Si", "No"};
		int RandomUrgencia = (int)Math.floor((int)this.probUrgencia*Math.random());
		return urgencias[(RandomUrgencia!=0)?1:0];
    }
}