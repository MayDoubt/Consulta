package _CONSULTA;
import java.util.ArrayList;

import clases.Cliente;

public class Consulta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList <Cliente> visitasDiarias = new ArrayList<Cliente>();
		int maxVisitas=15;
		int minVisitas=10;
		
		for (int i=((int)Math.random()*(maxVisitas-minVisitas+1)+minVisitas); i<maxVisitas;i++) {
			visitasDiarias.add(new Cliente());
		}
		for(int i=0; i<visitasDiarias.size();i++) {
			System.out.printf(visitasDiarias.get(i).getNombre()+" ");
			System.out.println(visitasDiarias.get(i).getApellidos());
		}

	}

}
