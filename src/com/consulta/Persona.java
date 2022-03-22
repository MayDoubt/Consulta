package com.consulta;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class Persona implements Comparable<Persona> {

	protected String nombre;
	protected String apellidos;
	protected LocalDate fNacimiento;
	protected String genero;
	protected String dni;
	protected String direccion;
	protected String telefono;

	public Persona() {
		this.genero = generarGenero();
		this.nombre = generarNombre();
		this.apellidos = generarApellidos();
		this.fNacimiento = generarFNacimiento();
		this.direccion = generarDireccion();
		this.telefono = generarTelefono();
		if ((LocalDate.now().getYear() - this.fNacimiento.getYear()) > 14)
			this.dni = generarDni();
	}

	public Persona(Persona persona) {
		this.genero = persona.genero;
		this.nombre = persona.nombre;
		this.apellidos = persona.apellidos;
		this.fNacimiento = persona.fNacimiento;
		this.direccion = persona.direccion;
		this.telefono = persona.telefono;
		if (persona.dni != null) {
			this.dni = persona.dni;
		}
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * @param apellidos the apellidos to set
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * @return the fNacimiento
	 */
	public LocalDate getfNacimiento() {
		return fNacimiento;
	}

	/**
	 * @param fNacimiento the fNacimiento to set
	 */
	public void setfNacimiento(LocalDate fNacimiento) {
		this.fNacimiento = fNacimiento;
	}

	/**
	 * @return the genero
	 */
	public String getGenero() {
		return genero;
	}

	/**
	 * @param genero the genero to set
	 */
	public void setGenero(String genero) {
		this.genero = genero;
	}

	/**
	 * @return the dni
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * @param dni the dni to set
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Nombre=" + nombre + ", Apellidos=" + apellidos + ", fNacimiento=" + fNacimiento + ", genero=" + genero
				+ ", dni=" + dni + ", direccion=" + direccion + ", telefono=" + telefono + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellidos, fNacimiento, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(apellidos, other.apellidos)
				&& ((int) ChronoUnit.YEARS.between(this.fNacimiento, other.fNacimiento) < 10)
				&& Objects.equals(nombre, other.nombre);
	}

	@Override
	public int compareTo(Persona o) {

		int resultado = 0;
		if (this.fNacimiento.compareTo(o.fNacimiento)>0) {
			resultado = 1;
		} else if (this.fNacimiento.compareTo(o.fNacimiento)<0) {
			resultado = -1;
		}else {
	
			if (this.apellidos.compareToIgnoreCase(o.apellidos)>0) {
				resultado = -1;
			} else if (this.apellidos.compareToIgnoreCase(o.apellidos)<0) {
				resultado = 1;
			}else {
				resultado=0;
				if (this.nombre.compareToIgnoreCase(o.nombre)>0) {
					resultado = -1;
				} else if (this.nombre.compareToIgnoreCase(o.nombre)<0) {
					resultado = 1;
				}else {
					resultado=0;
				}
			}
		}
		return resultado;
	}

	private String generarNombre() {
		// Metodo para una vez generado el genero, generar un nombre femenino o
		// masculino
		if (this.genero.equalsIgnoreCase("Hombre")) {
			String[] listaNombresHombres = { "Tomás", "Fausto", "Pablo", "Florencio", "Julio", "Aníbal", "Feliciano",
					"Fernando", "Antonio", "Mario", "Javier", "Mauricio", "Eustaquio", "Leopoldo", "Carlos", "Manolo",
					"Leandro", "Jaime", "Hector", "Manuel", "Alejandro", "Sandro", "Pepe", "Jose", "Marcelo", "Jorge",
					"Pascual", "Reinaldo", "Cayetano", "Daniel" };
			int nombre = (int) Math.floor((int) (listaNombresHombres.length) * Math.random());
			return listaNombresHombres[nombre];
		} else {
			String[] listaNombresMujeres = { "Cristina", "Luz", "Maria", "Luciana", "Mercedes", "Inés", "Soraya",
					"Marina", "Salma", "Beatriz", "Soledad", "Consuelo", "Martina", "Luisa", "Silvia", "Antonia",
					"Paula", "Blanca", "Aida", "Mariela", "Justina", "Andrea", "Sandra", "Nadia", "Rosario", "Eugenia",
					"Purita", "Elvira", "Ana", "Eva" };
			int nombre = (int) Math.floor((int) (listaNombresMujeres.length) * Math.random());
			return listaNombresMujeres[nombre];
		}
	}

	private String generarApellidos() {
		String[] listaApellidos = { "Velasco", "Molina", "Rodriguez", "Navarro", "Mora", "Ortega", "Andres", "Nunez",
				"Vicente", "Marquez", "Vidal", "Ibanez", "Gimenez", "Prieto", "Hernandez", "Romero", "Campos",
				"Alvarez", "Vicente", "Lorenzo", "Blanco", "Fernandez", "Ortiz", "Molina", "Ruiz", "Bravo", "Torres",
				"Mendez", "Saez", "Leon", "Dominguez", "Sanchez", "Mejias", "Serrano", "Gutierrez", "Santos", "Iba",
				"Flores", "Arias", "Medina", "Lozano", "Gomez", "Marin", "Fuentes", "Castillo", "Carmona", "Benjumea",
				"Iglesias", "Carrascosa", "Moreno" };
		int randomApellido = (int) Math.floor((int) (listaApellidos.length) * Math.random());
		int randomApellido2 = (int) Math.floor((int) (listaApellidos.length) * Math.random());
		return listaApellidos[randomApellido] + " " + listaApellidos[randomApellido2];
	}

	private LocalDate generarFNacimiento() {
		long fechaInicio = LocalDate.of(1917, 1, 1).toEpochDay();
		long fechaFinal = LocalDate.now().minusYears(8).toEpochDay();
		long fNacimiento = ThreadLocalRandom.current().nextLong(fechaInicio, fechaFinal);
		return LocalDate.ofEpochDay(fNacimiento);
	}

	private String generarGenero() {
		String[] generos = { "Hombre", "Mujer" };
		int randomGen = ((int) Math.floor((int) 101 * Math.random()) <= 45) ? 0 : 1;
		return generos[randomGen];
	}

	private String generarDni() {
		int dni = (int) Math.floor((int) 100000000 * Math.random());
		int indice = dni % 23;
		String letras = "TRWAGMYFPDXBNJZSQVHLCKET";
		return String.format("%08d", dni) + letras.toCharArray()[indice];
	}

	private String generarDireccion() {
		String[] direcciones = { ("Ap #660-6341 Nulla Street"), ("Ap #968-4392 Donec Road"),
				("Ap #110-7374 Orci Street"), ("4418 Aliquet Rd."), ("Ap #798-8817 Aliquam St."),
				("989-1308 Scelerisque Av."), ("Ap #386-7557 Tellus Road"), ("4716 Varius Road"),
				("295-3519 Gravida Street"), ("9012 Per Ave"), ("243-7371 Suspendisse Av."), ("689-8176 Eget Ave"),
				("8515 Ipsum Ave"), ("9537 Cras Avenue"), ("2507 Scelerisque, Av."), ("Ap #664-9229 Est. Av."),
				("P.O. Box 391, 3029 Eros. Rd."), ("P.O. Box 796, 8648 Elementum Avenue"),
				("P.O. Box 546, 5115 Et Avenue"), ("6900 Et Road"), ("910-7588 Nam Avenue"), ("742-1394 Libero Street"),
				("Ap #660-2367 Erat Street"), ("949-9200 Et St."), ("Ap #443-9408 Dictum Street"),
				("Ap #515-4764 Elementum, Street"), ("133-8728 Ornare Av."), ("621-5133 Ac St."), ("149-9455 Amet St."),
				("532-2603 Tempor Avenue"), ("Ap #529-9597 Conubia Street"), ("955-8192 Velit Street"),
				("P.O. Box 247, 6146 Pretium Avenue"), ("Ap #488-7607 Ultrices, Street"), ("3514 Praesent St."),
				("907-3065 Proin Road"), ("Ap #810-8544 Lectus. St."), ("P.O. Box 310, 8736 Lacinia Ave"),
				("P.O. Box 457, 4920 Amet Road"), ("Ap #861-483 Aliquet Av."), ("515-1792 Erat Rd."),
				("P.O. Box 407, 157 Mus. Rd."), ("989-1921 Mauris St."), ("1347 Etiam Av."), ("616-7005 Vitae Rd."),
				("Ap #530-3945 Donec Street"), ("243-8418 Cursus St."), ("Ap #255-2435 Ultricies Avenue"),
				("P.O. Box 905, 653 Interdum St."), ("Ap #468-5552 Amet, Road"), ("3419 At, Street"), ("4725 Et Rd."),
				("Ap #616-4790 Tristique St."), ("Ap #237-9207 Gravida Rd."), ("381-9812 Bibendum. Rd."),
				("Ap #275-3098 Faucibus Road"), ("P.O. Box 196, 9396 Egestas Street"), ("217-2587 Nisi. Road"),
				("970 Pede, Rd."), ("P.O. Box 841, 4621 Mauris St."), ("742-1541 Eleifend Av."),
				("3161 Hymenaeos. St."), ("P.O. Box 416, 8066 Sagittis Ave"), ("Ap #312-8131 Placerat Road"),
				("Ap #372-9576 Erat St."), ("630-6890 Accumsan Rd."), ("Ap #785-5668 Posuere Street"),
				("901-426 Urna. St."), ("7419 Neque Street"), ("428-2814 Pede Street"), ("Ap #379-507 Vitae Rd."),
				("Ap #645-4078 Tortor. St."), ("Ap #325-4227 Risus. Ave"), ("Ap #527-3294 Hendrerit Avenue"),
				("Ap #467-4194 Phasellus Rd."), ("745-5718 Proin Road"), ("Ap #461-7957 Lectus. Avenue"),
				("P.O. Box 159, 5816 Elit Rd."), ("1038 Lacus. Rd."), ("Ap #110-5574 Vitae St."),
				("P.O. Box 339, 7818 Non St."), ("5310 Cum St."), ("P.O. Box 435, 6269 Pede Rd."),
				("656-4488 Nonummy Av."), ("Ap #989-6980 Nibh Av."), ("740-1820 Sollicitudin Street"),
				("Ap #633-1815 Nullam Rd."), ("Ap #741-9326 Parturient Road"), ("7050 Consectetuer, St."),
				("608-8278 Tortor, Av."), ("490-4448 Ante St."), ("7187 Nibh. St."), ("P.O. Box 574, 4006 At, Ave"),
				("2991 Vulputate, Street"), ("Ap #460-3513 Nulla. St."), ("427-3096 Tellus. Ave"),
				("915-2597 Parturient Ave"), ("Ap #976-3443 Purus. Ave"), ("173-4503 Fusce Road"),
				("Ap #508-1714 Vulputate Avenue"), ("148-9520 Aliquet Street"), ("P.O. Box 979, 120 Cum Rd."),
				("728-6430 Cursus Road"), ("758-6518 Lacus. Rd."), ("Ap #273-4645 Risus Street"),
				("Ap #810-2832 Nisi Av."), ("303-9016 Sed Rd."), ("P.O. Box 309, 460 Vulputate, Ave"),
				("P.O. Box 733, 2396 Vitae, St."), ("937-5482 Donec Road"), ("447-3138 Lorem Av."),
				("Ap #937-260 Egestas Avenue"), ("490-3945 Euismod Street"), ("Ap #157-4728 Nisl Road"),
				("562-8106 Vestibulum Avenue"), ("997-9840 In Rd."), ("Ap #400-3170 Etiam St."), ("722-2665 Felis Rd."),
				("450-9666 Nec Rd."), ("6638 Donec St."), ("Ap #303-9147 Molestie St."), ("9854 Et Rd."),
				("801-903 Est. Ave"), ("Ap #957-3848 Justo. Street"), ("166-1246 Tellus St."),
				("538-796 Lobortis Road"), ("Ap #910-3954 Nec Av."), ("2564 Dolor. Ave"), ("Ap #208-2471 Id Avenue"),
				("Ap #135-5907 Nunc Rd."), ("Ap #905-1443 Nunc Av."), ("352 Quis Road"), ("4628 Praesent St."),
				("2283 Tristique St."), ("1659 Nullam Av."), ("251-258 Ipsum Rd."), ("P.O. Box 626, 853 Eu, St."),
				("219-7825 Metus Road"), ("P.O. Box 133, 3248 Mi St."), ("6917 Sem Rd."), ("720-3402 Vel Av."),
				("948-9629 Arcu. Av."), ("190-6286 Vel Av."), ("700-9650 Quis, Rd."), ("699-6113 Blandit Avenue"),
				("892-9943 Tincidunt Street"), ("260-6713 Rhoncus. Street"), ("3245 Morbi Street"),
				("134-3224 Nulla Avenue"), ("P.O. Box 739, 9721 Proin Rd."), ("Ap #489-9883 Eros Avenue"),
				("Ap #929-2553 Cursus, St."), ("Ap #557-146 Fringilla. Avenue"), ("795-1617 Quisque Ave"),
				("346-6741 Interdum. Av."), ("2425 Tortor, Rd."), ("Ap #690-1452 Cursus Rd."),
				("Ap #831-4923 Proin Rd."), ("894-7626 Mauris St."), ("Ap #219-8922 Ornare Road"),
				("P.O. Box 708, 5930 Mollis. Rd."), ("970-2286 Vivamus Road"), ("P.O. Box 633, 1696 Pellentesque Ave"),
				("P.O. Box 389, 2447 Neque. Road"), ("906-9912 Ipsum. Road"), ("Ap #296-4229 Nonummy Rd."),
				("Ap #550-8574 Malesuada Street"), ("8417 At, St."), ("Ap #921-6329 Amet Rd."), ("Ap #942-6657 At Av."),
				("Ap #190-8155 Metus Av."), ("5646 Pellentesque Ave"), ("671-4505 Donec Ave"), ("642-8070 Eu St."),
				("407-4239 Velit. Rd."), ("Ap #145-6328 Sed Avenue"), ("399-8179 Augue, Street"),
				("P.O. Box 167, 4352 Nunc Rd."), ("P.O. Box 253, 5818 Sed Rd."), ("1338 Sapien, Av."),
				("P.O. Box 693, 4699 Aliquet St."), ("Ap #188-7732 Eu Road"), ("Ap #551-8582 Tristique Av."),
				("3763 In Rd."), ("115-3395 Sed St."), ("Ap #567-1022 Scelerisque Avenue"), ("639-2405 Dui. Rd."),
				("2313 Sapien, St."), ("P.O. Box 523, 905 Nonummy Road"), ("806-221 Eget Rd."),
				("P.O. Box 683, 9698 Justo Street"), ("602-8077 Orci Av."), ("Ap #801-3895 Montes, Road"),
				("488-4357 Auctor, St."), ("902-3958 Ipsum St."), ("3099 Nunc Av."), ("560-7794 Urna. St."),
				("158-2483 Nec Ave"), ("277-9735 Leo. Ave"), ("362-2150 Nullam Rd."), ("928-9780 Turpis. Street"),
				("553-8486 Sapien. Rd."), ("Ap #597-7377 Aliquam St."), ("394-230 Ligula Av."), ("9065 Phasellus Road"),
				("879-1476 Orci Street"), ("547-3999 Montes, St."), ("979-5096 Feugiat. Street"),
				("Ap #807-3977 Erat. Street"), ("259-9019 A St."), ("731-9432 Quis, Rd."),
				("P.O. Box 132, 2188 A, Street"), ("Ap #783-229 Ultricies St."), ("P.O. Box 934, 3178 Eu Road"),
				("856-8950 Scelerisque Rd."), ("Ap #647-4603 Gravida Rd."), ("501-788 Libero Avenue"),
				("993-389 Molestie St."), ("P.O. Box 192, 2486 Dolor St."), ("Ap #426-8479 Suspendisse Rd."),
				("P.O. Box 875, 132 Montes, St."), ("337-4799 Et, St."), ("775 Mauris St."), ("240-8639 Dui. St."),
				("709 Sodales Av."), ("199-2383 Eleifend Rd."), ("4274 Dolor Ave"), ("Ap #892-9841 Ante Avenue"),
				("P.O. Box 335, 8636 Fusce Street"), ("Ap #692-5458 Id Street"), ("Ap #138-895 Non Av."),
				("420-690 Dolor, St."), ("2776 Lobortis Road"), ("Ap #278-9861 Tortor. Rd."), ("354-2033 Urna Ave"),
				("Ap #995-7410 Et Rd."), ("Ap #154-199 Aliquam Avenue"), ("5240 Magna Street"),
				("P.O. Box 866, 2020 Nulla Rd."), ("Ap #615-5318 Dui. Rd."), ("Ap #194-1694 Molestie Av."),
				("969-4439 Et, Avenue"), ("454-2488 Leo. Avenue"), ("Ap #741-1027 Dolor Rd."),
				("P.O. Box 151, 5218 Sapien. Road"), ("306-4747 Auctor, St."), ("Ap #859-8333 Venenatis Rd."),
				("6884 Nec Avenue"), ("822-449 Magna. St."), ("P.O. Box 389, 5136 Ante Rd."),
				("Ap #860-903 Libero. Rd."), ("Ap #839-5252 Elit Street"), ("7353 Ante Ave"),
				("Ap #934-9406 Mauris Avenue"), ("670-8140 Quisque Ave"), ("Ap #861-4417 Maecenas St."),
				("489-2780 Eu St."), ("910-508 Suspendisse St."), ("5498 Congue Av."), ("Ap #338-888 Vitae Ave"),
				("267-4005 Proin St."), ("Ap #822-7817 In Rd."), ("P.O. Box 140, 9774 Aliquam Avenue"),
				("7124 Tristique Street"), ("176-6319 Nibh. Ave"), ("P.O. Box 480, 4554 Pellentesque Rd."),
				("891-4631 Metus. Road"), ("4125 Risus. St."), ("5113 Nisl. Av."), ("525-5240 Lacus Street"),
				("964-563 Sed Rd."), ("6035 Dui. Rd."), ("Ap #157-4817 Ultricies Rd."), ("1188 Cras Road"),
				("Ap #592-5384 Purus, Street"), ("616-5046 Arcu Ave"), ("Ap #825-7890 Vivamus Rd."),
				("4800 Nec, Street"), ("Ap #101-8384 Dolor. Avenue"), ("760 Duis Rd."), ("934-7896 Turpis. Rd."),
				("748-3665 Tortor. St."), ("P.O. Box 385, 9393 Augue St."), ("Ap #849-3061 Nisi Rd."),
				("572-7022 Diam. Avenue"), ("456-7505 Nibh Rd."), ("909-9494 Etiam Rd."), ("206-8003 At, Road"),
				("Ap #237-7113 Eu, Road"), ("5418 Mauris Ave"), ("Ap #435-8536 Nulla Av."), ("611-4381 Sed St."),
				("Ap #559-2774 Vitae, Av."), ("632-9224 Erat Street"), ("P.O. Box 832, 5125 Vulputate, St."),
				("P.O. Box 567, 9756 Maecenas Avenue"), ("Ap #244-3673 Amet, Avenue"),
				("P.O. Box 232, 4009 Est Street"), ("P.O. Box 781, 2721 Nonummy St."), ("747-9604 Sed, St."),
				("Ap #261-7550 Sem St."), ("P.O. Box 413, 1038 At, St."), ("823-7934 Eleifend, Ave"),
				("211-1846 Neque Road"), ("1237 Et St."), ("3771 Nec, Street"), ("Ap #454-5550 Quam Road"),
				("P.O. Box 640, 5228 Auctor St."), ("Ap #321-3766 Aliquam St."), ("385-681 Aliquam Avenue"),
				("268-4901 Non Road"), ("P.O. Box 610, 8642 Mi. Ave"), ("Ap #788-152 Aliquam Street"),
				("Ap #488-6720 Metus Avenue"), ("P.O. Box 697, 3995 Quis, Street"), ("Ap #820-3525 Euismod St."),
				("321-2277 Egestas. Avenue"), ("P.O. Box 552, 1475 Orci, Rd."), ("P.O. Box 464, 1190 A, Street"),
				("974-447 Et Rd."), ("P.O. Box 566, 521 Eu, Avenue"), ("Ap #389-5551 Ipsum Avenue"),
				("338-982 Lobortis Rd."), ("Ap #465-7024 Enim St."), ("Ap #510-1021 Egestas St."),
				("Ap #670-7615 Lacus. Av."), ("Ap #926-2030 Non Street"), ("240-2514 Sem Av."), ("766-3220 Et Avenue"),
				("Ap #979-5531 Non Rd."), ("Ap #348-1425 Adipiscing Ave"), ("Ap #550-710 Quis Ave"),
				("277-630 Lorem Avenue"), ("198-207 Aliquet Avenue"), ("P.O. Box 312, 9481 Dui St."),
				("148-6751 Aenean Av."), ("109-7409 Nunc, St."), ("Ap #474-6846 Consectetuer Rd."),
				("6546 Vehicula Street"), ("947-4483 Pede Street"), ("2315 Pede Ave"), ("8529 Lectus. St."),
				("Ap #677-5271 Dui St."), ("235-8058 Amet, Av."), ("291-9885 Nibh Street"),
				("P.O. Box 904, 7426 Est St."), ("Ap #485-2454 Sem St."), ("5281 Nisl. Rd."), ("3683 Dignissim Avenue"),
				("P.O. Box 532, 7020 Posuere Ave"), ("545-6670 Sem Avenue"), ("490-8348 Pede Av."),
				("Ap #688-1151 Egestas. Rd."), ("657-3000 Pede. St."), ("Ap #781-4528 Tellus. Ave"),
				("430-8134 Pharetra. Avenue"), ("Ap #516-6415 Integer Street"), ("5086 At St."),
				("Ap #960-8583 Magna. Avenue"), ("Ap #128-2897 Mauris Av."), ("Ap #473-9036 Ipsum Road"),
				("2612 Orci Street"), ("532-6287 Mollis. Street"), ("Ap #193-9748 Eget Avenue"),
				("826-9085 Senectus Street"), ("Ap #987-630 Magna. Rd."), ("7277 Euismod Ave"),
				("P.O. Box 105, 375 Tristique Rd."), ("Ap #172-3745 Elementum Rd."), ("713 Consectetuer Rd."),
				("5685 A, Rd."), ("Ap #143-6164 Vehicula Rd."), ("248-9807 In, Avenue"),
				("Ap #272-3353 Ultricies Street"), ("932-7579 Elit, Ave"), ("892-3224 Urna St."),
				("Ap #879-2945 Et St."), ("908-5869 Diam Rd."), ("Ap #902-9797 Nec, Street"),
				("P.O. Box 903, 5943 Ac, Ave"), ("1947 Ipsum. St."), ("236-5818 Dui, Rd."),
				("P.O. Box 571, 1351 Enim. Av."), ("Ap #788-9165 Adipiscing Avenue"), ("P.O. Box 638, 7107 Quam Rd."),
				("Ap #421-9263 Elementum St."), ("1353 Enim St."), ("1330 Nec Ave"), ("966-2064 Placerat. Rd."),
				("406-2399 Elementum St."), ("P.O. Box 587, 9488 Sem Road"), ("Ap #619-238 Nulla St."),
				("308-1308 Parturient Avenue"), ("Ap #438-9589 Vestibulum, Road"), ("Ap #537-6612 Nec Av."),
				("799-8097 Justo Rd."), ("Ap #443-8758 Dictum St."), ("1314 Ullamcorper, Avenue"),
				("395-3094 Nunc St."), ("P.O. Box 809, 6023 Orci Rd."), ("P.O. Box 428, 155 Nulla. St."),
				("580-5945 Arcu. Av."), ("Ap #257-862 Sit Av."), ("7177 Rutrum. Ave"), ("Ap #304-334 Torquent Road"),
				("2961 Vehicula Ave"), ("Ap #678-5817 Ornare, Road"), ("170-7191 Neque Rd."),
				("628-9458 Molestie Street"), ("7150 Sociis Road"), ("Ap #704-2983 Cras Avenue"),
				("Ap #287-4496 Blandit. St."), ("8222 Est. Road"), ("Ap #518-7861 Ac St."), ("720-5891 Velit. Rd."),
				("772-4430 Enim Rd."), ("7881 Vel Ave"), ("2447 Iaculis Avenue"), ("356-1376 Ornare Street"),
				("Ap #798-2540 Molestie Rd."), ("Ap #386-8741 Est, St."), ("Ap #928-8792 Sed, Street"),
				("Ap #361-7474 Ornare. Road"), ("945-4330 Sit St."), ("P.O. Box 202, 6515 Quisque Rd."),
				("Ap #117-7040 Consequat Street"), ("6599 Mi, Ave"), ("Ap #688-6804 Pellentesque Rd."),
				("188-8428 Vel Street"), ("4711 Id Rd."), ("P.O. Box 427, 6971 Odio. St."), ("Ap #349-7421 Eu St."),
				("111-1703 Est Avenue"), ("Ap #443-9990 Vitae Ave"), ("P.O. Box 291, 7837 Sem Ave"),
				("6617 Leo Street"), ("Ap #125-6524 Accumsan Street"), ("Ap #124-6799 Mauris Rd."),
				("Ap #188-9942 A, Road"), ("672-6817 Nulla St."), ("8940 Placerat, St."), ("401-1152 Vestibulum St."),
				("5021 Quam. St."), ("772-4753 Vehicula Av."), ("892-6070 Duis Ave"), ("4534 Facilisi. Rd."),
				("P.O. Box 371, 258 Nec Rd."), ("589-6257 Non Rd."), ("Ap #784-223 Elit Rd."), ("4323 Nunc Avenue"),
				("Ap #374-1629 Egestas. Road"), ("6814 Neque. Rd."), ("Ap #771-8357 Ut, Avenue"),
				("448-7707 Purus. Ave"), ("Ap #294-6170 Nibh Ave"), ("514 Mauris Road"), ("845-1225 Leo. Rd."),
				("Ap #865-489 Lobortis St."), ("Ap #909-2400 Proin St."), ("P.O. Box 947, 5706 Donec Avenue"),
				("Ap #347-7896 Parturient Avenue"), ("Ap #512-6013 Pharetra, Street"), ("219-2803 Porttitor Rd."),
				("Ap #783-6518 Gravida. St."), ("Ap #714-7008 Nisi St."), ("Ap #886-2727 Eu Street"),
				("Ap #905-5366 Sem Street"), ("6707 Sed Ave"), ("Ap #650-7807 Risus. Rd."), ("584-4554 Tellus St."),
				("Ap #641-5534 Accumsan Rd."), ("868-470 Magna Ave"), ("P.O. Box 924, 8359 Velit Rd."),
				("230-7775 At Ave"), ("P.O. Box 484, 5212 Nibh. Road"), ("292-3794 Mollis. Road"),
				("Ap #266-2206 Nulla. Street"), ("Ap #110-3656 Etiam Ave"), ("636-3096 Pede, Street"),
				("P.O. Box 257, 3747 Dignissim Street"), ("221-8108 Consequat Rd."), ("7987 Condimentum. St."),
				("4996 Viverra. Rd."), ("958-3749 Iaculis St."), ("Ap #659-3781 Facilisis Rd."), ("347-4808 Et Street"),
				("P.O. Box 270, 9909 Quis St."), ("691-2669 Aliquam Rd."), ("Ap #377-4080 Aliquet. Ave"),
				("Ap #921-6512 Pede Rd."), ("278-404 Fusce Avenue"), ("7089 A, Rd."), ("754-8988 Nec, Rd."),
				("P.O. Box 842, 885 Placerat, Rd."), ("814-1765 Velit Rd."), ("293-3557 Quisque Avenue"),
				("419-7126 Vel Street"), ("9466 Diam Ave"), ("Ap #914-1179 Enim, Road"), ("932-1088 Nunc. Ave") };
		int randomDireccion = (int) Math.floor((int) (direcciones.length) * Math.random());
		return direcciones[randomDireccion];
	}

	private String generarTelefono() {
		int prefix = (int) Math.floor((int) 100 * Math.random());
		int body = (int) Math.floor((int) 1000000000 * Math.random());
		return ("+" + String.format("%03d", prefix) + " " + String.format("%09d", body));
	}
}