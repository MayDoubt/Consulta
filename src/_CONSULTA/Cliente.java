package _CONSULTA;

public class Cliente {
	
	private String [] listaNombres = {"Rishbha","Handel","Milind","Pulkita","Arnurna","Mell","Trent","Kalantha","Upravda","Stacy","Kalantha","Lincoln","Ernest","Stamford","Pryderi","Pablo","Fernando","Grace","Fagan","Nesim","Lilah","Mayrah","Madelyn","Barlow","Ilka","Beryl","Onora","Edeline","Stratton","Beryl"};
	private String [] listaApellidos = {"Gladstone","Weeden","Sylvia","Utter","Lebron","Vicente","Weigand","Nelson","Lewallen","Brew","Mccombs","Rhee","William","Vierra","Kegley","Shears","Dann","Sparkle","Habib","Adcock","Sundberg","Elia","Hickok","Huertas", "Hodnett","Higgins","Klos","Junker","Enright"};
	private String nombre;
	private String apellidos;
	private String dniCliente;
	
	
	
	//Constructor
	public Cliente(String dniCliente) {
		this.dniCliente=dniCliente; //El único atributo que nos interesa no generar del todo aleatoriamente.
		this.nombre=listaNombres[(int)(Math.random()*listaNombres.length)];
		this.apellidos=listaNombres[(int)(Math.random()*listaApellidos.length)]+" "+listaApellidos[(int)(Math.random()*listaApellidos.length)];
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDniCliente() {
		return dniCliente;
	}

	public void setDniCliente(String dniCliente) {
		this.dniCliente = dniCliente;
	}
	
}
