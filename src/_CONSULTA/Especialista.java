package _CONSULTA;

public class Especialista {
	
	private String [] listaNombres = {"Rishbha","Handel","Milind","Pulkita","Arnurna","Mell","Trent","Kalantha","Upravda","Stacy","Kalantha","Lincoln","Ernest","Stamford","Pryderi","Pablo","Fernando","Grace","Fagan","Nesim","Lilah","Mayrah","Madelyn","Barlow","Ilka","Beryl","Onora","Edeline","Stratton","Beryl"};
	private String [] listaApellidos = {"Gladstone","Weeden","Sylvia","Utter","Lebron","Vicente","Weigand","Nelson","Lewallen","Brew","Mccombs","Rhee","William","Vierra","Kegley","Shears","Dann","Sparkle","Habib","Adcock","Sundberg","Elia","Hickok","Huertas", "Hodnett","Higgins","Klos","Junker","Enright"};
	private String nombre;
	private String apellidos;
	private String especialidad1;
	private String especialidad2;
	
	//Constructor
	public Especialista(String especialidad1, String especialidad2) {
		this.nombre=listaNombres[(int)(Math.random()*listaNombres.length)];
		this.apellidos=listaNombres[(int)(Math.random()*listaApellidos.length)]+" "+listaApellidos[(int)(Math.random()*listaApellidos.length)];
		this.especialidad1=especialidad1;
		this.especialidad2=especialidad2;
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

	public String getEspecialidad1() {
		return especialidad1;
	}

	public String getEspecialidad2() {
		return especialidad2;
	}
	
}
