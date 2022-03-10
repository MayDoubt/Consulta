package _CONSULTA;

public class Visita {

	protected int idCliente;
	protected int idEspecialista;
	protected String especialidad;
	protected double tarifa;
	protected String formaPago;
	protected String urgencia;
	private int probUrgencia=48;//Para cambiar la probabilidad de urgencia.
	
	public Visita(int idCliente, int idEspecialista, String especialidad, int tarifa, String formaPago, boolean urgencia) {
		this.idCliente=idCliente;
		this.idEspecialista=idEspecialista;
		this.especialidad=especialidad;
		this.tarifa=generarTarifa(tarifa);
		this.formaPago=formaPago;
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
