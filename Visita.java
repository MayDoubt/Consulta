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

	public String toString(Profesional[] registroEspecialistas) {
		DateTimeFormatter shortFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		if(urgencia.equals("Si")) {
			return "Tarifa=" +String.format("%.2f", tarifa*1.2) + " €\t Urgencia=" + urgencia + "\t IdEspecialista=" + idEspecialista
					+"\t NombreEsp="+ String.format("%-10s",registroEspecialistas[idEspecialista].nombre) + "\t Especialidad=" 
					+ especialidad + "\t IdPaciente=" + idPaciente + "\t Fecha=" + fecha.format(shortFormat) + " FormaPago="+ formaPago;
		}else {
			return "Tarifa=" +String.format("%.2f", tarifa)+ " €\t Urgencia=" + urgencia + "\t IdEspecialista=" + idEspecialista
					+"\t NombreEsp="+ String.format("%-10s",registroEspecialistas[idEspecialista].nombre) + "\t Especialidad=" 
					+ especialidad + "\t IdPaciente=" +String.format("%-10d", idPaciente) + "\t Fecha=" + fecha.format(shortFormat) + " FormaPago="+ formaPago;
		}
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