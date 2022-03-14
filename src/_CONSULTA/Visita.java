package _CONSULTA;

public class Visita extends Paciente {

	
	protected double tarifa;
	protected String urgencia;
	private int probUrgencia=48;//Para cambiar la probabilidad de urgencia.
	
	
	
	public Visita(Paciente paciente) {
		super(paciente.idEspecialista, paciente.especialidad);
		this.tarifa=generarTarifa((super.especialidad.equalsIgnoreCase(super.listaEspecialidades[0]))?0:1);
		this.urgencia=generarUrgencia();
	}
	public double generarTarifa(int indice) {
		double [] listaTarifas = {60.00,65.25};
		return listaTarifas[indice];
	}
    public String generarUrgencia(){
		String [] urgencias = {"Si", "No"};
		int RandomUrgencia = (int)Math.floor((int)this.probUrgencia*Math.random());
		return urgencias[(RandomUrgencia!=0)?1:0];
    }
}
